package com.personInfo.controller;


import com.personInfo.bean.Requirement;
import com.personInfo.common.RequirementRestClient;
import com.personInfo.common.ServiceResultEnum;
import com.personInfo.service.RequirementService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    /**
//     * 获取记录的分页列表
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/requirements/list", method = RequestMethod.GET)
//    @ResponseBody
//    List<Requirement> findCommunityList(@Param("start")int start,@Param("limit")int limit){
//        PageQueryUtil params = new PageQueryUtil(start,limit);
//        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
//            return null;
//        }
//        List<Requirement> recordList = requirementService.findRecordList(params);
//        return recordList;
//    }

    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/requirements/list", method = RequestMethod.GET)
    @ResponseBody
    List<Requirement> findCommunityList(@Param("start")int start,@Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return null;
        }
        List<Requirement> recordList = requirementRestClient.findRecordListFromIndex(params);
        return recordList;
    }

    /**+
     * 选择性更新记录
     * @param requirement
     * @return
     */
    @RequestMapping(value = "/requirements/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(Requirement requirement) {
        if (requirement.getPersonId() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        int i = requirementService.updateByPrimaryKeySelective(requirement);
        if (i > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("更新择偶要求信息失败");
        }
    }


    /**
     * 插入择偶要求
     * @param requirement
     * @return
     */
    @RequestMapping(value = "/requirements/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInfo(Requirement requirement) throws Exception{
        System.out.println(requirement);
        int insertDB = requirementService.insertSelective(requirement);
        int insertES = requirementRestClient.InsertRequirementToIndexByPersonId(requirement.getPersonId());
        if (insertDB > 0){
            log.println("mysql成功添加personId为" + requirement.getPersonId() + "的择偶记录");
        }
        if (insertDB > 0){
            log.println("es成功添加personId为" + requirement.getPersonId() + "的择偶记录");
        }
        if (insertDB > 0 && insertES > 0){
            return ResultGenerator.genSuccessResult();
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
    Requirement selectByPrimaryKey(Integer personId) throws Exception{
        Requirement requirement = requirementRestClient.MatchByPersonId(personId);
        return requirement;
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
        int deleteES = requirementRestClient.deleteDiaryFromIndexById(id);
        if (deleteDB > 0){
            log.println("mysql成功删除personId为" + id + "的择偶记录");
        }
        if (deleteES > 0){
            log.println("es成功删除personId为" + id + "的择偶记录");
        }
        if (deleteDB > 0 && deleteES > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }


}
