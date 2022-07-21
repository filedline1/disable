package com.date.admin.controller;

import com.date.admin.pojo.User;
import com.date.admin.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
@RequestMapping("/admin/user")
public class AdminControllerUserApi {

    /**
     * 根据id查找用户信息
     * @param id
     * @return 待查询的user信息
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public User queryUserById(@RequestParam("id") Integer id){
        return null;
    }

    /**
     * 分页列出用户列表
     * @return pageUtils类型的数据-将数据全部封装到pageUtils中
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list(@RequestBody User user,@RequestParam("page") Integer page,@RequestParam("size") Integer size){
        return null;
    }

    /**
     * 删除某个用户的id 假删除 将数据库中的isDelelte字段设置成3 - 尽可能使用Constant里面定义好的常量
     * @param id
     * @return 返回处理结果 success or fail
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestParam("id") Integer id){
        return null;
    }

    /**+
     * 选择性更新记录
     * @param user 待更新消息的对象
     * @return 返回 success or fail
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(@RequestBody User user) {
        return null;
    }


}
