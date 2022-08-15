package com.personInfo.service;

import com.personInfo.bean.VipPackage;
import com.personInfo.util.PageQueryUtil;

import java.util.List;

public interface VipPackageService {

    List<VipPackage> findRecordList(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Integer id);

    int insert(VipPackage record);

    int insertSelective(VipPackage record);

    VipPackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VipPackage record);

    int updateByPrimaryKey(VipPackage record);

}
