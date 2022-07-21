package com.date.admin.pojo;

import com.date.admin.VO.UserVO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Mr.Jiang
 * @version 1.0
 * 对接 tb_disable_date_user
 **/
@Data
@TableName("tb_disable_date_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;

    private String nickName;

    private String loginName;

    private String passwordMD5;

    private Integer isDeleted;

    private Integer lockedFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public void VOTransformToUser(UserVO userVO) {
        this.userId = userVO.getUserId();
        this.nickName = userVO.getNickName();
        this.loginName = userVO.getLoginName();
    }
}
