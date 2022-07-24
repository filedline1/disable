package com.personInfo.service;

import com.personInfo.bean.User;

import java.text.ParseException;

public interface UserService {

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     * @throws ParseException
     */
    public User login(String loginName, String password) throws ParseException;

    /**
     * 注册
     * @param user
     * @return
     * @throws ParseException
     */
    public String register(User user) throws ParseException;

    /**
     * 修改账号密码
     * @param loginName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public String updatePassword(String loginName,String oldPassword,String newPassword);

    /**
     * 修改用户昵称
     * @param oldName
     * @param newName
     * @return
     */
    public String updateNickName(String oldName,String newName);

    /**
     * 注销账号
     * @param userId
     * @return
     */
    public String delete(Integer userId);


}
