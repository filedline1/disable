package com.personInfo.mapper;

import com.personInfo.bean.VipPermission;
import com.personInfo.bean.VipPackage;
import java.util.List;

import com.personInfo.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface VipPackageMapper {
    /**
     * 获取记录的分页列表
     *
     * @param pageUtil
     * @return
     */
    List<VipPackage> findRecordList(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Integer id);

    int insert(VipPackage record);

    int insertSelective(VipPackage record);

    VipPackage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VipPackage record);

    int updateByPrimaryKey(VipPackage record);
}