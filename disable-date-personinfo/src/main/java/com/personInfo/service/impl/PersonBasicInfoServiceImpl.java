package com.personInfo.service.impl;


import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.mapper.PersonBasicInfoMapper;
import com.personInfo.service.PersonBasicInfoService;
import com.personInfo.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class PersonBasicInfoServiceImpl implements PersonBasicInfoService {

    @Autowired
    private PersonBasicInfoMapper personBasicInfoMapper;

    @Override
    public List<PersonBasicInfo> findRecordList(PageQueryUtil pageUtil) {
        return personBasicInfoMapper.findRecordList(pageUtil);
    }

    @Override
    public int updateByPrimaryKeySelective(PersonBasicInfo personBasicInfo) {
        return personBasicInfoMapper.updateByPrimaryKeySelective(personBasicInfo);
    }

    @Override
    public int insert(PersonBasicInfo personBasicInfo) {
        return personBasicInfoMapper.insert(personBasicInfo);
    }

    @Override
    public int update(PersonBasicInfo personBasicInfo) {
        return personBasicInfoMapper.update(personBasicInfo);
    }

    @Override
    public int insertBatch(List<PersonBasicInfo> recordItems) {
        return personBasicInfoMapper.insertBatch(recordItems);
    }

    @Override
    public int insertSelective(PersonBasicInfo personBasicInfo) {
        return personBasicInfoMapper.insertSelective(personBasicInfo);
    }

    @Override
    public PersonBasicInfo selectByPrimaryKey(Integer personId) {
        return personBasicInfoMapper.selectByPrimaryKey(personId);
    }

    @Override
    public int delete(Integer id) {
        return personBasicInfoMapper.delete(id);
    }
}
