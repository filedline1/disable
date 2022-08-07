package com.personInfo.service.impl;


import com.personInfo.bean.Requirement;
import com.personInfo.mapper.RequirementsMapper;
import com.personInfo.service.RequirementService;
import com.personInfo.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementsMapper requirementsMapper;

    @Override
    public List<Requirement> findRecordList(PageQueryUtil pageUtil) {
        return requirementsMapper.findRecordList(pageUtil);
    }

    @Override
    public int updateByPrimaryKeySelective(Requirement requirement) {
        return requirementsMapper.updateByPrimaryKeySelective(requirement);
    }

    @Override
    public int insert(Requirement requirement) {
        return requirementsMapper.insert(requirement);
    }

    @Override
    public int update(Requirement requirement) {
        return requirementsMapper.update(requirement);
    }

    @Override
    public int insertBatch(List<Requirement> recordItems) {
        return requirementsMapper.insertBatch(recordItems);
    }

    @Override
    public int insertSelective(Requirement requirement) {
        return requirementsMapper.insertSelective(requirement);
    }

    @Override
    public Requirement selectByPrimaryKey(Integer personId) {
        return requirementsMapper.selectByPrimaryKey(personId);
    }

    @Override
    public int delete(Integer id) {
        return requirementsMapper.delete(id);
    }
}
