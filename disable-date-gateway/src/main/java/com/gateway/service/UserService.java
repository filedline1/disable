package com.gateway.service;

import com.gateway.bean.User;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface UserService {


    /**
     * 根据用户手机号查询用户信息
     * @param loginName
     * @return
     */
    public User selectUserByLoginName(String loginName);

    /**
     *
     * @param userId
     * @return
     */
    public User selectByPrimaryKey(Integer userId);


}
