package com.personInfo.mapper;

import com.personInfo.bean.VipPermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VipPermissionMapper {

    int deleteByPrimaryKey(Long configId);

    int insert(VipPermission record);

    int insertSelective(VipPermission record);

    VipPermission selectByPrimaryKey(Long configId);

    int updateByPrimaryKeySelective(VipPermission record);

    int updateByPrimaryKey(VipPermission record);
}