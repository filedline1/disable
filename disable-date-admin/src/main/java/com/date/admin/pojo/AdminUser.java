package com.date.admin.pojo;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 对接tb_disable_date_admin_user 后台管理员表
 * 对接
 * @author Mr.Jiang
 */

@Data
@TableName("tb_disable_date_admin_user")
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser implements Serializable {

    private static final long serialVersionUID = 7354577179243196657L;

    private Integer adminId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Integer locked;

    private Integer level;


}
