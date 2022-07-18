package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Mr.Jiang
 * @version 1.0
 * 对接 tb_disable_date_user
 **/
@Data
@TableName("tb_disable_date_user")
public class User {

    private Integer userId;

    private String nickName;

    private String loginName;

    private String passwordMd5;

    private String isDeleted;

    private String lockedFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
