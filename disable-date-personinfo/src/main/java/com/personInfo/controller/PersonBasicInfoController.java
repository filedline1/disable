package com.personInfo.controller;


import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.common.PersonBasicInfoDoc;
import com.personInfo.common.PersonBasicInfoRestClient;
import com.personInfo.service.PersonBasicInfoService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.personInfo.constants.MqConstants.*;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
public class PersonBasicInfoController {

    @Autowired
    PersonBasicInfoService personBasicInfoService;

    @Autowired
    PersonBasicInfoRestClient personBasicInfoRestClient;

    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/list", method = RequestMethod.GET)
    @ResponseBody
        Result findCommunityList(@Param("start")Integer start, @Param("limit")Integer limit){
        if (limit == null || start == null) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        PageQueryUtil params = new PageQueryUtil(start,limit);
        List<PersonBasicInfoDoc> recordList = personBasicInfoRestClient.findRecordListFromIndex(params);
        return ResultGenerator.genSuccessResult(recordList);
    }

//    /**+
//     * 同步选择性更新记录
//     * @param personBasicInfo
//     * @return
//     */
//    @RequestMapping(value = "/personBasicInfo/update", method = RequestMethod.PUT)
//    @ResponseBody
//    public Result updateInfo(PersonBasicInfo personBasicInfo) {
//        if (personBasicInfo.getPersonId() == null) {
//            return ResultGenerator.genFailResult("参数异常！");
//        }
//        System.out.println(personBasicInfo);
//        int updateDB = personBasicInfoService.updateByPrimaryKeySelective(personBasicInfo);
//        int updateES;
//        try {
//            updateES = personBasicInfoRestClient.InsertPersonBasicInfoToIndexByPersonId(personBasicInfo.getPersonId());
//        } catch (Exception e){
//            return ResultGenerator.genErrorResult(500,"服务器异常，用户修改失败，请及时联系管理员！");
//        }
//
//        if (updateDB > 0){
//            log.println("mysql成功修改personId为" + personBasicInfo.getPersonId() + "的基本信息");
//        }
//        if (updateES > 0){
//            log.println("es成功修改personId为" + personBasicInfo.getPersonId() + "的基本信息");
//        }
//        if (updateDB > 0 && updateES > 0){
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("添加失败");
//        }
//    }

    /**+
     * 异步选择性更新记录
     * @param personBasicInfo
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(PersonBasicInfo personBasicInfo) {
        if (personBasicInfo.getPersonId() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        System.out.println(personBasicInfo);
        int updateDB = personBasicInfoService.updateByPrimaryKeySelective(personBasicInfo);
        rabbitTemplate.convertAndSend(PERSON_BASIC_INFO_EXCHANGE,PERSON_BASIC_INFO_INSERT_KEY,personBasicInfo.getPersonId());
        if (updateDB > 0){
            log.println("mysql成功修改personId为" + personBasicInfo.getPersonId() + "的基本信息");
        }
        if (updateDB > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }


//    /**
//     * 同步插入基本信息
//     * @param personBasicInfo
//     * @return
//     */
//    @RequestMapping(value = "/personBasicInfo/insertInfo", method = RequestMethod.POST)
//    @ResponseBody
//    public Result insertInfo(PersonBasicInfo personBasicInfo){
//        System.out.println(personBasicInfo);
//        int insertDB = personBasicInfoService.insert(personBasicInfo);
//        int insertES;
//        try {
//            insertES = personBasicInfoRestClient.InsertPersonBasicInfoToIndexByPersonId(personBasicInfo.getPersonId());
//        } catch (Exception e){
//            return ResultGenerator.genErrorResult(500,"服务器异常，用户新增失败，请及时联系管理员！");
//        }
//        if (insertDB > 0){
//            log.println("mysql成功添加personId为" + personBasicInfo.getPersonId() + "的择偶记录");
//        }
//        if (insertES > 0){
//            log.println("es成功添加personId为" + personBasicInfo.getPersonId() + "的择偶记录");
//        }
//        if (insertDB > 0 && insertES > 0){
//            return ResultGenerator.genSuccessResult("添加成功");
//        } else {
//            return ResultGenerator.genFailResult("添加失败");
//        }
//    }

    /**
     * 异步插入基本信息
     * @param personBasicInfo
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInfo(PersonBasicInfo personBasicInfo){
        System.out.println(personBasicInfo);
        int insertDB = personBasicInfoService.insert(personBasicInfo);
        rabbitTemplate.convertAndSend(PERSON_BASIC_INFO_EXCHANGE,PERSON_BASIC_INFO_INSERT_KEY,personBasicInfo.getPersonId());
        if (insertDB > 0){
            log.println("mysql成功添加personId为" + personBasicInfo.getPersonId() + "的个人信息");
        }
        if (insertDB > 0){
            return ResultGenerator.genSuccessResult("添加成功");
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }


    /**
     * 根据personId查找PersonBasicInfo对象
     * @param personId
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/personId", method = RequestMethod.GET)
    @ResponseBody
    Result selectByPrimaryKey(Integer personId){
        PersonBasicInfoDoc personBasicInfoDoc;
        try {
            personBasicInfoDoc = personBasicInfoRestClient.MatchByPersonId(personId);
        } catch (Exception e){
            return ResultGenerator.genSuccessResult("查询用户不存在或者系统异常，请及时联系管理员");
        }
        if (personBasicInfoDoc == null){
            return ResultGenerator.genSuccessResult("查询的用户信息不存在");
        }
        return ResultGenerator.genSuccessResult(personBasicInfoDoc);
    }


    /**
     * 删除信息
     * @param personId
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(Integer personId){
        int deleteDB = personBasicInfoService.delete(personId);
        rabbitTemplate.convertAndSend(PERSON_BASIC_INFO_EXCHANGE,PERSON_BASIC_INFO_DELETE_KEY,personId);
        if (deleteDB > 0){
            log.println("mysql成功删除personId为" + personId + "的择偶记录");
        }
        if (deleteDB > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }


}
