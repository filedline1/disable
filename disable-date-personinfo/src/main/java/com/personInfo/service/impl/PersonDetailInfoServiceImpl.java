package com.personInfo.service.impl;


import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.mapper.PersonDetailInfoMapper;
import com.personInfo.service.PersonDetailInfoService;
import com.personInfo.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Service
public class PersonDetailInfoServiceImpl implements PersonDetailInfoService {

    @Autowired
    private PersonDetailInfoMapper personDetailInfoMapper;

    @Override
    public List<PersonDetailInfo> findRecordList(PageQueryUtil pageUtil) {
        return personDetailInfoMapper.findRecordList(pageUtil);
    }

    @Override
    public int updateByPrimaryKeySelective(PersonDetailInfo personDetailInfo) {
        return personDetailInfoMapper.updateByPrimaryKeySelective(personDetailInfo);
    }

    @Override
    public int insert(PersonDetailInfo personDetailInfo) {
        return personDetailInfoMapper.insert(personDetailInfo);
    }

    @Override
    public int update(PersonDetailInfo personBasicInfo) {
        return personDetailInfoMapper.update(personBasicInfo);
    }

    @Override
    public int insertBatch(List<PersonDetailInfo> recordItems) {
        return personDetailInfoMapper.insertBatch(recordItems);
    }

    @Override
    public int insertSelective(PersonDetailInfo personDetailInfo) {
        return personDetailInfoMapper.insertSelective(personDetailInfo);
    }

    @Override
    public PersonDetailInfo selectByPrimaryKey(Integer personId) {
        return personDetailInfoMapper.selectByPrimaryKey(personId);
    }

    @Override
    public int delete(Integer id) {
        return personDetailInfoMapper.delete(id);
    }
}
