package com.chat.service;

import com.chat.bean.ChatMsg;
import com.chat.mapper.ChatMsgMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMsgService {
    @Autowired
    ChatMsgMapper chatMsgMapper;
    @Async
    public void InsertChatMsg(ChatMsg chatMsg){
        chatMsgMapper.InsertChatMsg(chatMsg);
    }

    public List<ChatMsg> LookTwoUserMsg(ChatMsg chatMsg){
        return chatMsgMapper.LookTwoUserMsg(chatMsg);
    }

    public List<ChatMsg> LookPersonUserMsg(ChatMsg chatMsg){
        return chatMsgMapper.LookTwoUserMsg(chatMsg);
    }

    //将消息设置为已读
    public int alreadyRead(ChatMsg chatMsg){
        final int i = chatMsgMapper.alreadyRead(chatMsg);
        return i;
    }

    //获取指定收信人的未读信息
    public List<ChatMsg> unreadMessages(Integer senduserid,Integer reciveuserid) {
        final List<ChatMsg> chatMsgs = chatMsgMapper.unreadMessages(senduserid, reciveuserid);
        return chatMsgs;
    }

}
