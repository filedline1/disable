package com.personInfo.controller;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.personInfo.VO.UserVO;
import com.personInfo.bean.*;
import com.personInfo.common.ServiceResultEnum;
import com.personInfo.service.*;
import com.personInfo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PersonDetailInfoService personDetailInfoService;

    @Autowired
    private PersonBasicInfoService personBasicInfoService;

    @Autowired
    private RequirementService requirementService;

    @Autowired
    private GetUserFromRedisUtil userUtil;

    @Autowired
    private FanService fanService;

    @Autowired
    private FollowService followService;

    @Autowired
    private VipPermissionService vipPermissionService;

    private static String rightCode;

    @PostMapping("/login")
    public Result login(@RequestParam("loginName") String loginName, @RequestParam("password")String password) throws Exception{
            User user = userService.login(loginName, password);
            System.out.println(user);
            if (user != null && user.getIsDeleted() == 1){
                Map<String,String> map = new HashMap<>();
                map.put("userId",user.getUserId().toString());
                map.put("loginName",user.getLoginName());
                map.put("passwordMd5",user.getPasswordMd5());
                //生成令牌
                String token = JWTUtil.getToken(map);
                System.out.println("token:" + token);
                String user_str = JsonUtil.objToJson(user);
                //token 与user 绑定存入redis
                redisTemplate.opsForValue().set(token,user_str);
                UserVO userVO = new UserVO();
                BeanUtil.copyProperties(user,userVO);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token",token);
                jsonObject.put("user",userVO);
                return ResultGenerator.genResult(200,"登录成功",jsonObject);
            }else if (user.getIsDeleted() == 2) {
                return ResultGenerator.genResult(401,"账号已注册，正在等待审核",null);
            } else {
                return ResultGenerator.genResult(404,"账号或密码错误",null);
            }
    }

    /**
     * @Description: 用户注册
     * @param user
     * @return ApiResult
     **/
    @PostMapping("/register")
    @Transactional(rollbackFor = Exception.class)
    public synchronized Result register(User user) throws ParseException {
//        System.out.println(user);
        //返回注入结果
        String result = userService.register(user);
        if (result.equals(ServiceResultEnum.SUCCESS.getResult())){
            try {
                personBasicInfoService.insertSelective(new PersonBasicInfo());
                requirementService.insert(new Requirement());
                personDetailInfoService.insert(new PersonDetailInfo());
                return ResultGenerator.genSuccessResult("注册成功");
            } catch (Exception e){
                System.out.println("方法出现异常：" + e);
                //实现手动回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        if (result.equals(ServiceResultEnum.USER_IS_EXIST.getResult())){
            return ResultGenerator.genResult(404, ServiceResultEnum.USER_IS_EXIST.getResult(), null);
        }
        return ResultGenerator.genResult(404, ServiceResultEnum.ERROR.getResult(),result);
    }

    @GetMapping("/showCode")
    public void showVerify(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        //验证码验证，防止恶意注册
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        String right_code = verifyCodeUtil.generatorVCode();
        response.setHeader("code",right_code);
        session.removeAttribute("code");
        session.setAttribute("code",right_code);
        Cookie cookie = new Cookie("code",right_code);
        response.addCookie(cookie);
        BufferedImage image = verifyCodeUtil.rotatePicture(right_code);
        System.out.println(right_code);
        rightCode = right_code;
        try {
            ImageIO.write(image,"JPG",response.getOutputStream());
//            response.getWriter().print(right_code);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/getRightCode")
    public String getRightCode(){
        return rightCode;
    }

    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestParam("loginName") String loginName,
                                    @RequestParam("oldPassword") String oldPassword,
                                    @RequestParam("newPassword") String newPassword)
            throws IOException {
        if(userService.updatePassword(loginName,oldPassword,newPassword) > 0){
            return ResultGenerator.genResult(200,"修改成功",ServiceResultEnum.SUCCESS.getResult());
        }
        return ResultGenerator.genResult(404,"修改失败",ServiceResultEnum.ERROR.getResult());

    }

    @PostMapping("/updateNickName")
    public Result updateNickName(@RequestParam("loginName") String loginName,
                                    @RequestParam("nickName") String nickName,HttpServletRequest request)
            throws IOException {
        //令牌检验
        String token = request.getHeader("token");
        User userFromRedis = userUtil.getUserFromRedis(token);
        if (userFromRedis.getLoginName().equals(loginName)){
            if(userService.updateNickName(loginName,nickName).equals(ServiceResultEnum.SUCCESS.getResult())){
                return ResultGenerator.genResult(200,"修改成功",ServiceResultEnum.SUCCESS.getResult());
            }
        }
        return ResultGenerator.genResult(404,"修改失败",ServiceResultEnum.ERROR.getResult());

    }


    @PostMapping("/getAllData")
    public Result getAllData(@RequestParam("personId") Integer personId)
            throws IOException {
        final PersonBasicInfo personBasicInfo = personBasicInfoService.selectByPrimaryKey(personId);
        final PersonDetailInfo personDetailInfo = personDetailInfoService.selectByPrimaryKey(personId);
        final Requirement requirement = requirementService.selectByPrimaryKey(personId);
        Result result = new Result();
        Map<String,Object> resMap = new HashMap();
        resMap.put("requirement",requirement);
        resMap.put("personBasicInfo",personBasicInfo);
        resMap.put("personDetailInfo",personDetailInfo);
        if (resMap != null){
            result.setResultCode(200);
            result.setMessage("查询成功！");
        } else {
            result.setResultCode(500);
            result.setMessage("查询失败！");
        }
        result.setData(resMap);
        return result;
    }

    @PutMapping("/signIn")
    public synchronized Result signIn(@RequestParam("reward") Integer reward,@RequestParam("loginName") String loginName){
        String message = userService.signIn(reward, loginName);
        System.out.println(message);
        if (message.equals(ServiceResultEnum.ALREADY_SIGN_IN.getResult())){
            return ResultGenerator.genFailResult("今日已签到");
        }
        if (message.equals(ServiceResultEnum.DB_ERROR.getResult())){
            return ResultGenerator.genErrorResult(500,"签到服务出错，请及时联系客服！");
        }
        return ResultGenerator.genSuccessResult("签到成功");
    }




    @PostMapping("/openVip")
    public synchronized Result openVip(@RequestParam("loginName") String loginName,@RequestParam("month") Integer month){
        final Date date = userService.openVip(loginName, month);
        if (date != null){
            return ResultGenerator.genResult(200,"开通成功！",date);
        } else {
            return ResultGenerator.genSuccessResult("开通失败！ 请及时与管理员联系!");
        }
    }

    @PostMapping("/renewalVip")
    public synchronized Result renewalVip(@RequestParam("loginName") String loginName,@RequestParam("month") Integer month){
        final Date date = userService.renewalVip(loginName, month);
        if (date != null){
            return ResultGenerator.genResult(200,"续费成功！",date);
        } else {
            return ResultGenerator.genSuccessResult("续费失败！ 请及时与管理员联系!");
        }
    }

    @PostMapping("/getInfo")
    public synchronized Result getInfo(@RequestParam("loginName") String loginName){
        User user = userService.selectUserByLoginName(loginName);
        if (user != null){
            return ResultGenerator.genSuccessResult(user);
        } else {
            return ResultGenerator.genFailResult("用户不存在");
        }
    }

    @PostMapping("/getBaseData")
    public Result getBaseData(@RequestParam ("personId") Integer personId){
        int fanCount = fanService.selectFollowerCountByUserId(personId);
        int attentionCount = followService.selectAttentionCountByUserId(personId);
        User user = userService.selectByPrimaryKey(personId);
        Integer likes = user.getLikes();
        Integer love = user.getLove();
        PersonBaseDate personBaseDate = new PersonBaseDate();
        VipPermission vipPermission = vipPermissionService.selectByUserId(personId.longValue());
        personBaseDate.setPersonId(personId);
        personBaseDate.setAttentionCount(attentionCount);
        personBaseDate.setFanCount(fanCount);
        personBaseDate.setLike(likes);
        personBaseDate.setLove(love);
        personBaseDate.setNickName(user.getNickName());
        personBaseDate.setHeadPicPath(user.getHeadPicPath());
        personBaseDate.setSorts(user.getSorts());
        personBaseDate.setIsVip(user.getIsVip());
        personBaseDate.setExpirationTime(user.getExpirationTime());
        if (vipPermission != null){
            personBaseDate.setIsModify(vipPermission.getIsModify());
        } else {
            personBaseDate.setIsModify((byte) 0);
        }
        Date lastTime = user.getLastTime();
        System.out.println(user);
        Date date = new Date();
        int currentTimeYear = lastTime.getYear();
        int currentTimeMonth = lastTime.getMonth();
        int currentTimeDay = lastTime.getDate();
        if (currentTimeYear < date.getYear()){
            personBaseDate.setSignIn(false);
        }
        else if (currentTimeMonth < date.getMonth()){
            personBaseDate.setSignIn(false);
        }
        else if (currentTimeDay < date.getDate()){
            personBaseDate.setSignIn(false);
        }
        else if (currentTimeDay == date.getDate()){
            personBaseDate.setSignIn(true);
        }
        return ResultGenerator.genSuccessResult(personBaseDate);
    }


    @PostMapping("/addLove")
    public synchronized Result addLove(@RequestParam("userId") Integer userId){
        int i = userService.addLoveCount(userId);
        if (i > 0){
            return ResultGenerator.genSuccessResult("喜欢成功");
        } else {
            return ResultGenerator.genFailResult("服务失败，请联系管理员！");
        }
    }

    @PostMapping("/addLike")
    public synchronized Result addLike(@RequestParam("userId") Integer userId){
        int i = userService.addLoveCount(userId);
        if (i > 0){
            return ResultGenerator.genSuccessResult("点赞成功");
        } else {
            return ResultGenerator.genFailResult("服务失败，请联系管理员！");
        }
    }

    @PostMapping("/updateHeadPicPath")
    public Result updateHeadPicPath(@RequestParam("loginName") String loginName, @RequestParam("headPicPath") String headPicPath){
        final int i = userService.updateHeadPicPath(loginName, headPicPath);
        if (i > 0){
            return ResultGenerator.genSuccessResult("更新头像成功");
        } else {
            return ResultGenerator.genFailResult("更新头像失败");
        }
    }



}
