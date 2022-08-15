package com.gateway.util;

import com.gateway.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;


@Configuration
public class GetUserFromRedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public User getUserFromRedis(String token) throws IOException {
        Object user_str = redisTemplate.opsForValue().get(token);
        User user = (User)JsonUtil.jsonToObj((String) user_str, User.class);
        System.out.println(user);
        return user;
    }
}
