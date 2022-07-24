package com.personinfo;

import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.bean.Requirement;
import com.personInfo.mapper.PersonBasicInfoMapper;
import com.personInfo.mapper.PersonDetailInfoMapper;
import com.personInfo.mapper.RequirementsMapper;
import com.personInfo.util.PageQueryUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@SpringBootTest
public class PersonInfoApplicationTests {

    @Autowired
    RequirementsMapper requirementsMapper;

    @Autowired
    PersonBasicInfoMapper personBasicInfoMapper;

    @Autowired
    PersonDetailInfoMapper personDetailInfoMapper;

    @Test
    void contextLoads() {

//        final Requirement requirement = requirementsMapper.selectByPrimaryKey(4);
//        System.out.println(requirement);
//
//        PageQueryUtil pageQueryUtil = new PageQueryUtil(1,10);
//        PageQueryUtil pageQueryUtil1 = new PageQueryUtil(2,10);
//
//        final List<Requirement> recordList = requirementsMapper.findRecordList(pageQueryUtil);
//        System.out.println(recordList);
//
//        requirement.setCarStatus("修改无车");
//        requirementsMapper.updateByPrimaryKeySelective(requirement);

//        requirement.setPersonId(4);
//        requirement.setHeightRange("170~180");
//        requirementsMapper.insert(requirement);

//        requirement.setEducationBackground("学士学位");
//        requirementsMapper.update(requirement);
//
//        Requirement requirement1 = new Requirement();
//        requirement1.setAgeRange("18~25");
//        requirementsMapper.insertSelective(requirement1);

//        List<Requirement> requirementList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Requirement requirement2 = new Requirement();
//            requirement2.setPersonId(6 + i);
//            requirement2.setEducationBackground("批量插入");
//            requirementList.add(requirement2);
//        }
//
//        final int i = requirementsMapper.insertBatch(requirementList);
//        System.out.println(i);


//        PageQueryUtil pageQueryUtil = new PageQueryUtil(1,10);

//        final List<PersonBasicInfo> recordList = personBasicInfoMapper.findRecordList(pageQueryUtil);
//        System.out.println(recordList);
//
//        final PersonBasicInfo personBasicInfo = personBasicInfoMapper.selectByPrimaryKey(1);
//        System.out.println(personBasicInfo);

//        personBasicInfo.setPersonId(3);
//        final int insert = personBasicInfoMapper.insert(personBasicInfo);
//        System.out.println(insert);

//        personBasicInfo.setPersonIntro("修改");
//        personBasicInfoMapper.update(personBasicInfo);
//
//        personBasicInfo.setAge(18);
//        personBasicInfoMapper.updateByPrimaryKeySelective(personBasicInfo);

//        personBasicInfo.setPersonId(4);
//        final int i = personBasicInfoMapper.insertSelective(personBasicInfo);
//        System.out.println(i);

//        List<PersonBasicInfo> personBasicInfos = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            final PersonBasicInfo personBasicInfo1 = new PersonBasicInfo();
//            personBasicInfo1.setPersonId(5 + i);
//            personBasicInfo1.setPersonName("批量插入测试" + i);
//            personBasicInfo1.setSex(1);
//            personBasicInfo1.setAge(1);
//            personBasicInfo1.setPhone("1301234567");
//            personBasicInfos.add(personBasicInfo1);
//        }
//
//        final int i = personBasicInfoMapper.insertBatch(personBasicInfos);
//        System.out.println(i);

//        final List<PersonDetailInfo> recordList = personDetailInfoMapper.findRecordList(pageQueryUtil);
//        System.out.println(recordList);


//        List<PersonDetailInfo> personDetailInfos  = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            PersonDetailInfo personDetailInfo = new PersonDetailInfo();
//            personDetailInfo.setPersonId(4 + i);
//            personDetailInfo.setAuxiliaryTool("批量测试" + i);
//            personDetailInfos.add(personDetailInfo);
//        }

//        final int i = personDetailInfoMapper.insertBatch(personDetailInfos);
//        System.out.println(i);

//        final PersonDetailInfo personDetailInfo = personDetailInfoMapper.selectByPrimaryKey(11);
//        System.out.println(personDetailInfo);
//        personDetailInfo.setPersonId(10);
//        final int insert = personDetailInfoMapper.insert(personDetailInfo);
//        System.out.println(insert);

//        personDetailInfo.setCause("修改测试");
//        final int update = personDetailInfoMapper.update(personDetailInfo);
//        System.out.println(update);

//        personDetailInfo.setPersonId(11);
//        final int i1 = personDetailInfoMapper.insertSelective(personDetailInfo);

//        personDetailInfo.setPersonTag("选择修改测试");
//        personDetailInfoMapper.updateByPrimaryKeySelective(personDetailInfo);

//        List<Integer> ids = new ArrayList<>();
//        ids.add(11);
//        ids.add(10);
//        ids.add(9);
//        final int i = personDetailInfoMapper.deleteBatch(ids);
//        System.out.println(i);




    }

}
