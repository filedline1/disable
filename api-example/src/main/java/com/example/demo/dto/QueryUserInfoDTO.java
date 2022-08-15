package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TODO 说明DTO类用途，属性都要加上注释，如果接口提供Swagger文档声明 ApiModel、ApiModelProperty
 *
 * <p>
 * 查询用户信息参数
 *
 * @author Chunming Liu In 2022/07/28
 */
@Data
@ApiModel("查询用户信息参数")
public class QueryUserInfoDTO {
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
}
