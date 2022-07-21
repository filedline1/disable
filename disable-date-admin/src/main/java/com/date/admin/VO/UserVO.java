package com.date.admin.VO;

import com.date.admin.pojo.User;
import lombok.Data;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Data
public class UserVO {

    private Integer userId;

    private String nickName;

    private String loginName;

    private Integer page;

    private Integer size;

    public User VOTransformTOUser() {
        User user = new User();
        this.userId = user.getUserId();
        this.nickName = user.getNickName();
        this.loginName = user.getLoginName();
        return user;
    }
}
