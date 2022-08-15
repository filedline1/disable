package com.personInfo.mapper;

import com.personInfo.bean.UserinfoMetadata;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chunming
 * @date 2022-08-07 20:35:41
 */
@Mapper
public interface UserinfoMetadataMapper {

    void insert(UserinfoMetadata userinfoMetadata);
}
