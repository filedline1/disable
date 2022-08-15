package com.personInfo.service.impl;

import com.personInfo.bean.VipPackage;
import com.personInfo.mapper.VipPackageMapper;
import com.personInfo.service.VipPackageService;
import com.personInfo.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class VipPackageServiceImpl implements VipPackageService {


    @Autowired
    VipPackageMapper vipPackageMapper;

    public List<VipPackage> findRecordList(PageQueryUtil pageUtil){
        return vipPackageMapper.findRecordList(pageUtil);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return vipPackageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(VipPackage record) {
        return vipPackageMapper.insert(record);
    }

    @Override
    public int insertSelective(VipPackage record) {
        return vipPackageMapper.insertSelective(record);
    }

    @Override
    public VipPackage selectByPrimaryKey(Integer id) {
        return vipPackageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(VipPackage record) {
        return vipPackageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(VipPackage record) {
        return vipPackageMapper.updateByPrimaryKey(record);
    }
}
