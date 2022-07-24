package com.chat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ChatFriends {
    private Integer id;

    private String userid;

    private String fuserid;

    private String nickname;

    private String uimg;
}