package com.date.admin.controller;

import com.date.admin.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
@RequestMapping("/admin")
public class AdminControllerApi {

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result login(@RequestParam("username") String username,@RequestParam("password") String password){
        return null;
    }

    /**
     * 锁定管理员身份
     * @param id
     * @return
     */
    @RequestMapping(value = "/locked", method = RequestMethod.PUT)
    @ResponseBody
    public Result locked(@RequestParam("id") Integer id){
        return null;
    }

    /**
     * 更改管理员等级
     * @param id 更改的管理员的id
     * @param level 想要更改的等级
     * @return
     */
    @RequestMapping(value = "/updateLevel", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateLevel(@RequestParam("id") Integer id, @RequestParam("level") Integer level){
        return null;
    }

}
