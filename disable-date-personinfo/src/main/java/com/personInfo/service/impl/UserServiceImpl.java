package com.personInfo.service.impl;

import com.personInfo.bean.User;
import com.personInfo.common.ServiceResultEnum;
import com.personInfo.mapper.UserMapper;
import com.personInfo.service.UserService;
import com.personInfo.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String loginName, String password) throws ParseException {
        User user = userMapper.selectUserByLoginName(loginName);
        System.out.println(user);
        String passwordMD5 = MD5Util.MD5Encode(password, "UTF-8");
        if (user == null)
        {
            return null;
        }
        else if (passwordMD5.equals(user.getPasswordMd5())){
            //登录后执行业务层操作...
            return user;
        }
        return null;
    }

    @Override
    public String register(User user) throws ParseException {
        /**
         * 判断账号是否重复
         */
        if (userMapper.selectUserByLoginName(user.getLoginName()) != null){
            return ServiceResultEnum.USER_IS_EXIST.getResult();
        }
        String passwordMD5 = MD5Util.MD5Encode(user.getPasswordMd5(), "UTF-8");
        user.setPasswordMd5(passwordMD5);
        user.setCreateTime(new Date());
        //账号初始状态设置为锁定和未认证
        user.setLockedFlag(1);
        user.setIsDeleted(2);
        if (userMapper.insertUser(user) > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 修改密码 判断账号是否存在-》核对旧密码-》修改新密码
     * @param loginName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public String updatePassword(String loginName,String oldPassword,String newPassword) {
        User user = userMapper.selectUserByLoginName(loginName);
        if (user == null){
            return ServiceResultEnum.USER_NOT_EXIST.getResult();
        }
        //核对旧密码
        String oldPasswordMD5 = MD5Util.MD5Encode(oldPassword, "UTF-8");
        if (oldPasswordMD5.equals(user.getPasswordMd5())){
            String newPasswordMD5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            user.setPasswordMd5(newPasswordMD5);
            if (userMapper.updatePassword(loginName,newPassword) > 0){
                return ServiceResultEnum.SUCCESS.getResult();
            }
        } else {
            return ServiceResultEnum.PASSWORD_ERROR.getResult();
        }
        return ServiceResultEnum.ERROR.getResult();
    }

    @Override
    public String updateNickName(String loginName,String nickName) {
        User user = userMapper.selectUserByLoginName(loginName);
        if (user == null){
            return ServiceResultEnum.USER_NOT_EXIST.getResult();
        }
        if (userMapper.updateNickName(loginName,nickName) > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.ERROR.getResult();
    }

    @Override
    public String delete(Integer userId) {
        int delete = userMapper.delete(userId);
        if (delete > 0){
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String signIn(Integer reward,String loginName){
        User userTemp = userMapper.selectUserByLoginName(loginName);
        Date lastTime = userTemp.getLastTime();
        System.out.println(userTemp);
        Date date = new Date();
        int insert;
        int currentTimeYear = lastTime.getYear();
        int currentTimeMonth = lastTime.getMonth();
        int currentTimeDay = lastTime.getDate();
        if (currentTimeYear < date.getYear()){
            insert = userMapper.signIn(reward, loginName);
            System.out.println("lastTimeYear " + currentTimeYear);
            System.out.println("date.getYear() " + date.getYear());
            if (insert > 0) {
                return ServiceResultEnum.SUCCESS_SIGN_IN.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        else if (currentTimeMonth < date.getMonth()){
            insert = userMapper.signIn(reward, loginName);
            System.out.println("lastTimeMonth " + currentTimeMonth);
            System.out.println("date.getMonth() " + date.getMonth());
            if (insert > 0) {
                return ServiceResultEnum.SUCCESS_SIGN_IN.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        else if (currentTimeDay < date.getDate()){
            insert = userMapper.signIn(reward, loginName);
            System.out.println("lastTimeDay " + currentTimeDay);
            System.out.println("date.getDate() " + date.getDate());
            if (insert > 0) {
                return ServiceResultEnum.SUCCESS_SIGN_IN.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        else if (currentTimeDay == date.getDate()){
            return ServiceResultEnum.ALREADY_SIGN_IN.getResult();
        }
        return ServiceResultEnum.ERROR.getResult();
    }

    @Override
    public int openVip(String loginName, Integer month){
        return userMapper.openVip(loginName, month);
    }

    @Override
    public int renewalVip(@Param("loginName") String loginName, @Param("month")Integer month){
        return userMapper.renewalVip(loginName, month);
    }


    public User selectUserByLoginName(String loginName){
        return userMapper.selectUserByLoginName(loginName);
    }

}
