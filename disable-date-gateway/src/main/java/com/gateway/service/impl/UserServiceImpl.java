package com.gateway.service.impl;

import com.gateway.bean.User;
import com.gateway.mapper.UserMapper;
import com.gateway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    public List<User> selectBatch(List<Integer> recordItems) {
        final List<User> users = userMapper.selectBatch(recordItems);
        return users;
    }

    
    public User selectUserByLoginName(String loginName) {
        return userMapper.selectUserByLoginName(loginName);
    }
    
    /**
     * @param userId
     * @return
     */
    public User selectByPrimaryKey(Integer userId) {
        final User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }






}
