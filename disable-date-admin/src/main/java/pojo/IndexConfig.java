package pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Mr.Jiang
 * @version 1.0
 * 配置信息表
 * 对接 tb_disable_date_index_config
 **/

@Data
@TableName("tb_disable_date_index_config")
public class IndexConfig {

    private Integer configId;

    private String configName;

    private String configType;

    private Integer recommendId;

    private Integer backgroundColorType;

    private String backgroundImagePath;

    private String redirectUrl;



}
