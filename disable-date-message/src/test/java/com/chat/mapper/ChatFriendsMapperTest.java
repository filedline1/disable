package com.chat.mapper;

import com.chat.bean.ChatFriends;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChatFriendsMapperTest extends TestCase {

    @Autowired
    ChatFriendsMapper chatFriendsMapper;

    @Test
    public void test1(){
        System.out.println(chatFriendsMapper);
        final List<ChatFriends> chatFriends = chatFriendsMapper.LookUserAllFriends("1");
        System.out.println(chatFriends);
    }

}