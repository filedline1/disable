package com.chat.mapper;

import com.chat.bean.ChatMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatMsgMapper {
    //插入聊天记录
    void InsertChatMsg(ChatMsg chatMsg);

    //查询聊天记录
    List<ChatMsg>  LookTwoUserMsg(@Param("chatMsg") ChatMsg chatMsg);

    //查询聊天记录
    List<ChatMsg>  LookPersonUserMsg(@Param("chatMsg") ChatMsg chatMsg);

    //将消息设置为已读
    int alreadyRead(ChatMsg chatMsg);

    //获取指定收信人的未读信息
    List<ChatMsg> unreadMessages(@Param("senduserid") Integer senduserid,@Param("reciveuserid") Integer reciveuserid);

}