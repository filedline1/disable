package com.date.admin.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mr.Jiang
 * @version 1.0
 * 配置信息表
 * 对接 tb_disable_date_index_config
 **/

@Data
@TableName("tb_disable_date_index_config")
@NoArgsConstructor
@AllArgsConstructor
public class IndexConfig {

    private Integer configId;

    private String configName;

    private String configType;

    private Integer recommendId;

    private Integer backgroundColorType;

    private String backgroundImagePath;

    private String redirectUrl;
}
