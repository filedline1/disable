package com.personInfo.service.impl;

import com.personInfo.bean.VipPermission;
import com.personInfo.mapper.VipPermissionMapper;
import com.personInfo.service.VipPermissionService;
import com.personInfo.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class VipPermissionServiceImpl implements VipPermissionService {


    @Autowired
    private VipPermissionMapper vipPermissionMapper;

    @Override
    public List<VipPermission> findRecordList(PageQueryUtil pageUtil){
        return vipPermissionMapper.findRecordList(pageUtil);
    }

    @Override
    public int deleteByPrimaryKey(Long configId) {
        return vipPermissionMapper.deleteByPrimaryKey(configId);
    }

    @Override
    public int insert(VipPermission record) {
        return vipPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(VipPermission record) {
        return vipPermissionMapper.insertSelective(record);
    }

    @Override
    public VipPermission selectByPrimaryKey(Long configId) {
        return vipPermissionMapper.selectByPrimaryKey(configId);
    }

    @Override
    public VipPermission selectByUserId(Long userId) {
        return vipPermissionMapper.selectByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(VipPermission record) {
        return vipPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(VipPermission record) {
        return vipPermissionMapper.updateByPrimaryKey(record);
    }
}
