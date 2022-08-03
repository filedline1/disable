package com.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.chat.bean.ChatFriends;
import com.chat.bean.ChatMsg;
import com.chat.bean.Userinfo;
import com.chat.common.PersonBasicInfoRestClient;
import com.chat.service.ChatFriendsService;
import com.chat.service.ChatMsgService;
import com.chat.service.LoginService;
import com.chat.util.CompressImage;
import com.chat.util.Constants;
import com.chat.util.EmojiFilter;
import com.chat.util.Result;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chat.controller.ChatWebSocket.webSocketSet;

@Controller
public class ChatCtrl {
    @Autowired
    ChatFriendsService chatFriendsService;
    @Autowired
    ChatMsgService chatMsgService;
    @Autowired
    LoginService loginService;

    @Autowired
    PersonBasicInfoRestClient client;

    @Autowired
    ChatWebSocket chatWebSocket;

    /**
     * 上传聊天图片
     * **/
    @PostMapping(value = "/chat/upimg")
    @ResponseBody
    public JSONObject upImg(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        LocalDate today = LocalDate.now();
        Instant timestamp = Instant.now();
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String filenames = today + String.valueOf(timestamp.toEpochMilli()) + "." + ext;
        final File imageFile = new File(Constants.IMAGE_PATH + filenames);
        file.transferTo(imageFile);
        CompressImage.compressImage(imageFile);
        resUrl.put("src", "/pic/" + filenames);
        res.put("msg", "");
        res.put("code", 0);
        res.put("data", resUrl);
        return res;
    }

    /**
     * 添加聊天好友模块：查询用户
     * */
    @PostMapping("/chat/lkuser/{username}")
    @ResponseBody public Result lookUser(@PathVariable("username")String username){
        username= EmojiFilter.filterEmoji(username);
        String uid = loginService.lkUseridByUsername(username);
        if(uid==null){
            return Result.error().message("未查询到此用户");
        }
        Map<String,Object> map = new HashMap<>();
        return Result.ok().data(map).message("用户信息");
    }

    /**
     * 添加聊天好友
     * */
    @PostMapping("/chat/adduser/{fuserid}")
    @ResponseBody public Result toFriendUserIdChat(@PathVariable("fuserid")String fuserid, HttpSession session){
        String userid=(String)session.getAttribute("userid");
        if(userid.equals(fuserid)){
            return Result.error().message("不能添加自己为好友");
        }
        ChatFriends chatFriends=new ChatFriends();
        chatFriends.setUserid(userid).setFuserid(fuserid);
        Integer integer = chatFriendsService.JustTwoUserIsFriend(chatFriends);
        if(integer == null){
            //如果不存在好友关系插入好友关系
            chatFriendsService.InsertUserFriend(chatFriends);
            chatFriendsService.InsertUserFriend(new ChatFriends().setFuserid(userid).setUserid(fuserid));
        }
        return Result.ok().message("添加成功");
    }

    /**
     * 跳转到聊天
     * */
    @GetMapping("/chat/ct")
    public String toChat(){
        return "/chat/chats";
    }

    /***
     * 查询用户的好友
     * */
    @PostMapping("/chat/lkfriends")
    @ResponseBody public List<ChatFriends> lookFriends(HttpSession session){
        String userid=(String)session.getAttribute("userid");
        return chatFriendsService.LookUserAllFriends(userid);
    }


    /***
     * 查询两个用户之间的聊天记录
     * */
    @PostMapping("/chat/lkuschatmsg/{reviceuserid}")
    @ResponseBody public List<ChatMsg> lookFriendsMessage(HttpSession session, @PathVariable("reviceuserid")String reviceuserid){
        String userid = (String)session.getAttribute("userid");
        return chatMsgService.LookTwoUserMsg(new ChatMsg().setSenduserid(userid).setReciveuserid(reviceuserid));
    }

    /***
     * 查询与某个用户的聊天记录
     * */
    @PostMapping("/chat/lookPersonMessage/{reviceuserid}")
    @ResponseBody public List<ChatMsg> lookPersonMessage(HttpSession session, @PathVariable("reviceuserid")String reviceuserid){
        String userid=(String)session.getAttribute("userid");
        return chatMsgService.LookTwoUserMsg(new ChatMsg().setSenduserid(userid).setReciveuserid(reviceuserid));
    }


    /***
     * Ajax上传web界面js录制的音频数据
     * */
    @PostMapping("/chat/audio")
    @ResponseBody
    public JSONObject upAudio(@RequestParam(value = "file") MultipartFile file) throws IOException {
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        LocalDate today = LocalDate.now();
        Instant timestamp = Instant.now();
        String filenames = today  + String.valueOf(timestamp.toEpochMilli()) + ".mp3";
        String pathname = "D:\\chat\\" + filenames;
        file.transferTo(new File(pathname));
        resUrl.put("src", "/pic/"+filenames);
        res.put("msg", "");
        res.put("data", resUrl);
        return res;
    }

    @PostMapping("/chat/unreadMessage")
    @ResponseBody
    //获取指定收信人的未读信息
    List<ChatMsg> unreadMessages(@RequestParam("senduserid") Integer senduserid,@RequestParam("reciveuserid") Integer reciveuserid){
        final List<ChatMsg> chatMsgs = chatMsgService.unreadMessages(senduserid, reciveuserid);
        return chatMsgs;
    }

    @PostMapping("/chat/alreadyRead")
    @ResponseBody
    //将消息设置为已读
    public Result alreadyRead(ChatMsg chatMsg){
        final int i = chatMsgService.alreadyRead(chatMsg);
        if (i > 0){
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/chat/websocketIsOnline")
    @ResponseBody
    //判断websocket连接是否在线
    public Result websocketIsOnline(@Param("userno") String userno){
        if (webSocketSet.containsKey(userno)){
            Result result = new Result();
            result.setMessage(userno + "用户websocket在线");
            return result;
        } else {
            Result result = new Result();
            result.setMessage(userno + "用户websocket不在线");
            return result;
        }
    }

    //推荐列表
    @PostMapping("/chat/recommendList")
    @ResponseBody
    public Result recommendList(@RequestParam("userId")Integer userId) throws Exception{
        final List<Userinfo> recommendBeforeList = client.getRecommendList(userId);
        //筛选在线的人数
        List<Userinfo> recommendAfterList = new ArrayList<>();
        for (Userinfo userinfo : recommendBeforeList){
            String userno = userinfo.getUserid();
            if (chatWebSocket.isClose(userno) == false){
                recommendAfterList.add(userinfo);
            }
        }
        Result result = new Result();
        result.setData(recommendAfterList);
        result.setSuccess(true);
        return result;
    }

}
