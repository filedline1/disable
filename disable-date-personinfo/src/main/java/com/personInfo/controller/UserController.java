package com.personInfo.controller;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.personInfo.VO.UserVO;
import com.personInfo.bean.ApiResult;
import com.personInfo.bean.User;
import com.personInfo.common.ServiceResultEnum;
import com.personInfo.service.UserService;
import com.personInfo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
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
    private GetUserFromRedisUtil userUtil;

    private static String rightCode;

    @PostMapping("/login")
    public ApiResult login(@RequestParam("loginName") String loginName, @RequestParam("password")String password){
        try {
            User user = userService.login(loginName, password);
            System.out.println(user);
            if (user != null && user.getIsDeteled() == 1){
                Map<String,String> map = new HashMap<>();
                map.put("userId",user.getUserId().toString());
                map.put("nickName",user.getNickName());
                map.put("loginName",user.getLoginName());
                map.put("passwordMd5",user.getPasswordMd5());
                //生成令牌
                String token = JWTUtil.getToken(map);
                System.out.println("token:"+token);
                String user_str = JsonUtil.objToJson(user);
                //token 与user 绑定存入redis
                redisTemplate.opsForValue().set(token,user_str);
                UserVO userVO = new UserVO();
                BeanUtil.copyProperties(user,userVO);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token",token);
                jsonObject.put("user",userVO);
                return ApiResultHandler.buildApiResult(200,"登录成功",jsonObject);
            }else if (user.getIsDeteled() == 2) {
                return ApiResultHandler.buildApiResult(401,"账号已注册，正在等待审核",null);
            }
            else {
                return ApiResultHandler.buildApiResult(404,"账号或密码错误",null);
            }
        }catch (Exception e){
            return ApiResultHandler.buildApiResult(404,"登录失败",null);
        }
    }

    /**
     * @Description: 用户注册
     * @param user
     * @return ApiResult
     **/
    @PostMapping("/register")
    public ApiResult register(@RequestBody User user) throws ParseException {

        //返回注入结果
        String result = userService.register(user);
        if (result.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ApiResultHandler.success();
        }
        if (result.equals(ServiceResultEnum.USER_IS_EXIST.getResult())){
            return ApiResultHandler.buildApiResult(404, ServiceResultEnum.USER_IS_EXIST.getResult(), null);
        }
        return ApiResultHandler.buildApiResult(404, ServiceResultEnum.ERROR.getResult(),result);
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
    public ApiResult updatePassword(@RequestParam("loginName") String loginName,
                                    @RequestParam("oldPassword") String oldPassword,
                                    @RequestParam("newPassword") String newPassword)
            throws IOException {
        if(userService.updatePassword(loginName,oldPassword,newPassword).equals(ServiceResultEnum.SUCCESS.getResult())){
            return ApiResultHandler.buildApiResult(200,"修改成功",ServiceResultEnum.SUCCESS.getResult());
        }
        return ApiResultHandler.buildApiResult(404,"修改失败",ServiceResultEnum.ERROR.getResult());

    }

    @PostMapping("/updateNickName")
    public ApiResult updateNickName(@RequestParam("loginName") String loginName,
                                    @RequestParam("nickName") String nickName)
            throws IOException {
        if(userService.updateNickName(loginName,nickName).equals(ServiceResultEnum.SUCCESS.getResult())){
            return ApiResultHandler.buildApiResult(200,"修改成功",ServiceResultEnum.SUCCESS.getResult());
        }
        return ApiResultHandler.buildApiResult(404,"修改失败",ServiceResultEnum.ERROR.getResult());

    }


}
