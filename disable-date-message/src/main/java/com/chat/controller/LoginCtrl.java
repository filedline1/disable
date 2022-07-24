package com.chat.controller;

import com.chat.bean.Login;
import com.chat.service.LoginService;
import com.chat.util.Md5Util;
import com.chat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginCtrl {

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String tologin(){
        return "user/login";
    }
    /**
     * 登陆
     * */
    @PostMapping("/justlogin")
    @ResponseBody
    public Result login(@RequestBody Login login, HttpSession session){
        login.setPassword(Md5Util.StringInMd5(login.getPassword()));
        System.out.println(login);
        String userid = loginService.justLogin(login);
        if(userid == null){
            return Result.error().message("账号或者密码错误");
        }
        session.setAttribute("userid",userid);
        return Result.ok().message("登录成功");
    }
}
