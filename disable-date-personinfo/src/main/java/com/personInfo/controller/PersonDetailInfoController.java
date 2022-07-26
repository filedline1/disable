package com.personInfo.controller;


import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.service.PersonDetailInfoService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
public class PersonDetailInfoController {

    @Autowired
    PersonDetailInfoService personDetailInfoService;

    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/list", method = RequestMethod.GET)
    @ResponseBody
    List<PersonDetailInfo> findCommunityList(@Param("start")int start, @Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return null;
        }
        List<PersonDetailInfo> recordList = personDetailInfoService.findRecordList(params);
        return recordList;
    }

    /**+
     * 选择性更新记录
     * @param personDetailInfo
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(PersonDetailInfo personDetailInfo) {
        if (personDetailInfo.getPersonId() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        int i = personDetailInfoService.updateByPrimaryKeySelective(personDetailInfo);
        if (i > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("更新个人详细信息失败");
        }
    }


    /**
     * 插入择偶要求
     * @param personDetailInfo
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInfo(PersonDetailInfo personDetailInfo){
        System.out.println(personDetailInfo);
        int insert = personDetailInfoService.insertSelective(personDetailInfo);
        if (insert > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("新增失败");
        }
    }


    @RequestMapping(value = "/personDetailInfo/insertBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBatch(List<PersonDetailInfo> personDetailInfos){
        int i = personDetailInfoService.insertBatch(personDetailInfos);
        if (i > 0){
            return ResultGenerator.genSuccessResult("批量插入成功");
        } else {
            return ResultGenerator.genFailResult("批量插入失败");
        }
    }


    /**
     * 选择性插入记录
     * @param personDetailInfo 记录对象
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(PersonDetailInfo personDetailInfo){
        int i = personDetailInfoService.insertSelective(personDetailInfo);
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
    @RequestMapping(value = "/personDetailInfo/personId", method = RequestMethod.GET)
    @ResponseBody
    PersonDetailInfo selectByPrimaryKey(Integer personId){
        PersonDetailInfo requirement = personDetailInfoService.selectByPrimaryKey(personId);
        return requirement;
    }


    /**
     * 删除信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(Integer personId){
        int deleteBatch = personDetailInfoService.delete(personId);
        if (deleteBatch > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        }
        return ResultGenerator.genFailResult("删除失败");
    }


}
