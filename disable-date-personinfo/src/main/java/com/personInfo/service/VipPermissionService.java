package com.personInfo.service;

import com.personInfo.bean.VipPermission;
import com.personInfo.util.PageQueryUtil;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public interface VipPermissionService {

    List<VipPermission> findRecordList(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Long configId);

    int insert(VipPermission record);

    int insertSelective(VipPermission record);

    VipPermission selectByPrimaryKey(Long configId);

    VipPermission selectByUserId(Long userId);

    int updateByPrimaryKeySelective(VipPermission record);

    int updateByPrimaryKey(VipPermission record);


}
