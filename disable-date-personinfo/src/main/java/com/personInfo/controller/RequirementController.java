package com.personInfo.controller;


import com.personInfo.bean.Requirement;
import com.personInfo.service.RequirementService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
public class RequirementController {

    @Autowired
    RequirementService requirementService;

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
        List<Requirement> recordList = requirementService.findRecordList(params);
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
    public Result insertInfo(Requirement requirement){
        System.out.println(requirement);
        int insert = requirementService.insertSelective(requirement);
        if (insert > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("新增失败");
        }
    }


    @RequestMapping(value = "/requirements/insertBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBatch(List<Requirement> requirements){
        int i = requirementService.insertBatch(requirements);
        if (i > 0){
            return ResultGenerator.genSuccessResult("批量插入成功");
        } else {
            return ResultGenerator.genFailResult("批量插入失败");
        }
    }


    /**
     * 选择性插入记录
     * @param requirement 记录对象
     * @return
     */
    @RequestMapping(value = "/requirements/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(Requirement requirement){
        int i = requirementService.insertSelective(requirement);
        if (i > 0){
            return ResultGenerator.genSuccessResult("插入信息成功");
        } else {
            return ResultGenerator.genFailResult("插入信息失败");
        }
    }

    /**
     * 根据personId查找Requirement对象
     * @param personId
     * @return
     */
    @RequestMapping(value = "/requirements/personId", method = RequestMethod.GET)
    @ResponseBody
    Requirement selectByPrimaryKey(Integer personId){
        Requirement requirement = requirementService.selectByPrimaryKey(personId);
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
        int deleteBatch = requirementService.delete(id);
        if (deleteBatch > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        }
        return ResultGenerator.genFailResult("删除失败");
    }


}
