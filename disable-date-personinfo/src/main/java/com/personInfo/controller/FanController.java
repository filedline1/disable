package com.personInfo.controller;

import com.personInfo.VO.FanVO;
import com.personInfo.VO.FollowVO;
import com.personInfo.bean.Fan;
import com.personInfo.bean.Follow;
import com.personInfo.bean.User;
import com.personInfo.common.PersonBasicInfoDoc;
import com.personInfo.common.PersonBasicInfoRestClient;
import com.personInfo.common.ServiceResultEnum;
import com.personInfo.service.FanService;
import com.personInfo.service.FollowService;
import com.personInfo.service.UserService;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/fan")
public class FanController {

    @Autowired
    FanService fanService;

    @Autowired
    FollowService followService;

    @Autowired
    PersonBasicInfoRestClient basicInfoRestClient;

    @Autowired
    UserService userService;

    /**
     * 分页查询关注对象
     * @param follower
     * @param start
     * @param limit
     * @return
     */
    @RequestMapping(value = "/searchFan", method = RequestMethod.POST)
    @ResponseBody
    public Result selectFollowerByUserId(@Param("follower")Integer follower, @Param("start")Integer start, @Param("limit")Integer limit) throws Exception{
        if (limit == null || start == null) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        System.out.println(follower);
        List<Fan> fans = fanService.selectFollowerByUserId(follower, start, limit);
        List<Integer> usersId = new ArrayList<>();
        for (Fan fan : fans){
            Integer userId = fan.getUserId();
            usersId.add(userId);
        }
        System.out.println(usersId);
        final List<PersonBasicInfoDoc> personBasicInfoDocs = basicInfoRestClient.selectByPersonIds(usersId);
        final List<User> users = userService.selectBatch(usersId);
        Iterator var16 = personBasicInfoDocs.iterator();

        while(var16.hasNext()) {
            PersonBasicInfoDoc personBasicInfoDoc = (PersonBasicInfoDoc)var16.next();
            System.out.println(personBasicInfoDoc);
        }
        List<FanVO> fanVOS = new ArrayList<>();
        for (int i = 0; i < fans.size(); i++) {
            FanVO fanVO = new FanVO();
            Fan fan = fans.get(i);
            PersonBasicInfoDoc personBasicInfoDoc = personBasicInfoDocs.get(i);
            User user = users.get(i);
            fanVO.setUserId(fan.getUserId());
            fanVO.setStatus(fan.getStatus());
            fanVO.setPersonSign(personBasicInfoDoc.getPersonSign());
            fanVO.setNickName(user.getNickName());
            fanVO.setHeadPicPath(user.getHeadPicPath());
            fanVOS.add(fanVO);
        }
        return ResultGenerator.genSuccessResult(fanVOS);
    }


    /**
     * 查询该用户关注列表
     * @param userId
     * @param start
     * @param limit
     * @return
     **/
    @RequestMapping(value = "/searchAttention", method = RequestMethod.POST)
    @ResponseBody
    public Result selectAttentionByUserId(@Param("userId") Integer userId, @Param("start")Integer start, @Param("limit")Integer limit) throws Exception{
        if (limit == null || start == null) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        System.out.println(userId);
        List<Follow> follows = followService.selectAttentionByUserId(userId, start, limit);
        List<Integer> usersId = new ArrayList<>();
        for (Follow follow : follows){
            Integer id = follow.getUserId();
            usersId.add(id);
        }
        System.out.println(usersId);
        final List<User> users;
        final List<PersonBasicInfoDoc> personBasicInfoDocs = basicInfoRestClient.selectByPersonIds(usersId);
        try {
            users = userService.selectBatch(usersId);
        } catch (Exception e){
            return ResultGenerator.genFailResult("好难过！，你没有粉丝！");
        }
        System.out.println(personBasicInfoDocs);
        List<FollowVO> followVOS = new ArrayList<>();
        for (int i = 0; i < follows.size(); i++) {
            FollowVO followVO = new FollowVO();
            Follow follow = follows.get(i);
            PersonBasicInfoDoc personBasicInfoDoc = personBasicInfoDocs.get(i);
            User user = users.get(i);
            followVO.setUserId(follow.getUserId());
            followVO.setStatus(follow.getStatus());
            followVO.setPersonSign(personBasicInfoDoc.getPersonSign());
            followVO.setNickName(user.getNickName());
            followVO.setHeadPicPath(user.getHeadPicPath());
            followVOS.add(followVO);
        }
        return ResultGenerator.genSuccessResult(followVOS);
    }

    /**
     * 查找该用户的粉丝数
     * @param userId
     * @return
     */
    @RequestMapping(value = "/searchFanCount", method = RequestMethod.POST)
    @ResponseBody
    public Result selectFollowerCountByUserId(Integer userId){
        int count;
        try {
            count = fanService.selectFollowerCountByUserId(userId);
        } catch (Exception e){
            return ResultGenerator.genErrorResult(500,"服务器错误请及时联系管理员");
        }
        return ResultGenerator.genSuccessResult(count);
    }

    /**
     * 查询该用户关注数量
     * @param userId
     * @return
     */
    @RequestMapping(value = "/searchAttentionCount", method = RequestMethod.POST)
    @ResponseBody
    public Result selectAttentionCountByUserId(Integer userId){
        int count;
        try {
            count = followService.selectAttentionCountByUserId(userId);
        } catch (Exception e){
            return ResultGenerator.genErrorResult(500,"服务器错误请及时联系管理员");
        }
        return ResultGenerator.genSuccessResult(count);
    }

    /**
     * 查询两个人之间的关注情况
     * @param firstUserId
     * @param secondUserId
     * @return
     */
    @RequestMapping(value = "/searchStatus", method = RequestMethod.POST)
    @ResponseBody
    public List<Fan> selectStatusBetweenTwoUser(Integer firstUserId, Integer secondUserId){
        List<Fan> fans = fanService.selectStatusBetweenTwoUser(firstUserId, secondUserId);
        return fans;
    }

    /**
     * 增加关注记录
     * @param fan
     * @return
     */
    @RequestMapping(value = "/addAttention", method = RequestMethod.POST)
    @ResponseBody
    public Result addAttention(Fan fan){
        if (fan.getUserId() == null || fan.getFollower() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        System.out.println(fan);
        String message = fanService.addAttention(fan);
        if (!message.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genErrorResult(500,"服务器错误，请及时联系管理员！");
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 取消关注记录
     * @param fan
     * @return
     */
    @RequestMapping(value = "/cancelAttention", method = RequestMethod.POST)
    @ResponseBody
    public Result cancelAttention(Fan fan){
        if (fan.getUserId() == null || fan.getFollower() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        System.out.println(fan);
        String message = fanService.cancelAttention(fan);
        if (!message.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genErrorResult(500,"服务器错误，请及时联系管理员！");
        }
        return ResultGenerator.genSuccessResult();
    }


    /**
     * 删除改用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteRecord", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteRecord(Integer userId){
        String message = fanService.deleteRecord(userId);
        System.out.println(message);
        if (message.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除失败！");
    }

}
