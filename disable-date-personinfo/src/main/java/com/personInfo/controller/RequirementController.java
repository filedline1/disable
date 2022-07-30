package com.personInfo.controller;


import com.personInfo.bean.Requirement;
import com.personInfo.common.RequirementRestClient;
import com.personInfo.constants.MqConstants;
import com.personInfo.service.RequirementService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.personInfo.constants.MqConstants.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
public class RequirementController {

    @Autowired
    RequirementService requirementService;

    @Autowired
    RequirementRestClient requirementRestClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/requirements/list", method = RequestMethod.GET)
    @ResponseBody
    Result findCommunityList(@Param("start")int start,@Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        List<Requirement> recordList = requirementRestClient.findRecordListFromIndex(params);
        return ResultGenerator.genSuccessResult(recordList);
    }

//    /**+
//     * 同步更新记录
//     * @param requirement
//     * @return
//     */
//    @RequestMapping(value = "/requirements/update", method = RequestMethod.PUT)
//    @ResponseBody
//    public Result updateInfo(Requirement requirement){
//        if (requirement.getPersonId() == null) {
//            return ResultGenerator.genFailResult("参数异常！");
//        }
//        int updateDB = requirementService.updateByPrimaryKeySelective(requirement);
//        int updateES;
//        try {
//            updateES = requirementRestClient.InsertRequirementToIndexByPersonId(requirement.getPersonId());
//        } catch (Exception e){
//            return ResultGenerator.genErrorResult(500,"服务器异常，用户修改失败，请及时联系管理员！");
//        }
//        if (updateDB > 0){
//            log.println("mysql成功修改personId为" + requirement.getPersonId() + "的择偶记录");
//        }
//        if (updateES > 0){
//            log.println("es成功添加personId为" + requirement.getPersonId() + "的择偶记录");
//        }
//        if (updateDB > 0 && updateES > 0){
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("添加失败");
//        }
//    }

    /**+
     * 异步更新记录
     * @param requirement
     * @return
     */
    @RequestMapping(value = "/requirements/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(Requirement requirement){
        if (requirement.getPersonId() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        int updateDB = requirementService.updateByPrimaryKeySelective(requirement);
        if (updateDB > 0){
            log.println("mysql成功修改personId为" + requirement.getPersonId() + "的择偶记录");
        }
        rabbitTemplate.convertAndSend(REQUIREMENT_EXCHANGE,REQUIREMENT_INSERT_KEY,requirement.getPersonId());
        if (updateDB > 0 ){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }


//    /**
//     * 同步插入择偶要求
//     * @param requirement
//     * @return
//     */
//    @RequestMapping(value = "/requirements/insertInfo", method = RequestMethod.POST)
//    @ResponseBody
//    public Result insertInfo(Requirement requirement) {
//        System.out.println(requirement);
//        int insertDB = requirementService.insertSelective(requirement);
//        int insertES;
//        try {
//            insertES = requirementRestClient.InsertRequirementToIndexByPersonId(requirement.getPersonId());
//        }  catch (Exception e){
//            return ResultGenerator.genErrorResult(500,"服务器异常，用户新增失败，请及时联系管理员！");
//        }
//        if (insertDB > 0){
//            log.println("mysql成功添加personId为" + requirement.getPersonId() + "的择偶记录");
//        }
//        if (insertDB > 0){
//            log.println("es成功添加personId为" + requirement.getPersonId() + "的择偶记录");
//        }
//        if (insertDB > 0 && insertES > 0){
//            return ResultGenerator.genSuccessResult("添加成功");
//        } else {
//            return ResultGenerator.genFailResult("添加失败");
//        }
//    }



    /**
     * 异步插入择偶要求
     * @param requirement
     * @return
     */
    @RequestMapping(value = "/requirements/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInfo(Requirement requirement) {
        System.out.println(requirement);
        int insertDB = requirementService.insertSelective(requirement);
        if (insertDB > 0){
            log.println("mysql成功添加personId为" + requirement.getPersonId() + "的择偶记录");
        }
        rabbitTemplate.convertAndSend(REQUIREMENT_EXCHANGE, REQUIREMENT_INSERT_KEY,requirement.getPersonId());
        if (insertDB > 0){
            return ResultGenerator.genSuccessResult("添加成功");
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 根据personId查找Requirement对象
     * @param personId
     * @return
     */
    @RequestMapping(value = "/requirements/personId", method = RequestMethod.GET)
    @ResponseBody
    Result selectByPrimaryKey(Integer personId) {
        Requirement requirement;
        try {
            requirement = requirementRestClient.MatchByPersonId(personId);
        } catch (Exception e){
            return ResultGenerator.genSuccessResult("查询用户不存在或者系统异常，请及时联系管理员");
        }
        if (requirement == null){
            return ResultGenerator.genSuccessResult("查询的用户信息不存在");
        }
        return ResultGenerator.genSuccessResult(requirement);
    }


    /**
     * 删除信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/requirements/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(Integer id){
        int deleteDB = requirementService.delete(id);
        rabbitTemplate.convertAndSend(REQUIREMENT_EXCHANGE,REQUIREMENT_DELETE_KEY,id);
        if (deleteDB > 0){
            log.println("mysql成功删除personId为" + id + "的择偶记录");
        }
        if (deleteDB > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }


}
