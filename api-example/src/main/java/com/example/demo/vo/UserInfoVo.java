package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Chunming Liu In 2022/07/28
 */
@AllArgsConstructor
@Data
public class UserInfoVo {
    private Long id;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 爱好
     */
    @ApiModelProperty("爱好")
    private String ability;
}
