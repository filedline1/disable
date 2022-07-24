package com.personInfo.controller;


import com.personInfo.bean.PersonBasicInfo;
import com.personInfo.service.PersonBasicInfoService;
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
public class PersonBasicInfoController {

    @Autowired
    PersonBasicInfoService personBasicInfoService;

    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/list", method = RequestMethod.GET)
    @ResponseBody
    List<PersonBasicInfo> findCommunityList(@Param("start")int start, @Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return null;
        }
        List<PersonBasicInfo> recordList = personBasicInfoService.findRecordList(params);
        return recordList;
    }

    /**+
     * 选择性更新记录
     * @param personBasicInfo
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(PersonBasicInfo personBasicInfo) {
        if (personBasicInfo.getPersonId() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        int i = personBasicInfoService.updateByPrimaryKeySelective(personBasicInfo);
        if (i > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("更新择偶要求信息失败");
        }
    }


    /**
     * 插入基本信息
     * @param personBasicInfo
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInfo(PersonBasicInfo personBasicInfo){
        System.out.println(personBasicInfo);
        int insert = personBasicInfoService.insert(personBasicInfo);
        if (insert > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("新增失败");
        }
    }


    @RequestMapping(value = "/personBasicInfo/insertBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result insertBatch(List<PersonBasicInfo> personBasicInfos){
        int i = personBasicInfoService.insertBatch(personBasicInfos);
        if (i > 0){
            return ResultGenerator.genSuccessResult("批量插入成功");
        } else {
            return ResultGenerator.genFailResult("批量插入失败");
        }
    }


    /**
     * 选择性插入记录
     * @param personBasicInfo 记录对象
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/insertSelective", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(PersonBasicInfo personBasicInfo){
        int i = personBasicInfoService.insertSelective(personBasicInfo);
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
    @RequestMapping(value = "/personBasicInfo/personId", method = RequestMethod.GET)
    @ResponseBody
    PersonBasicInfo selectByPrimaryKey(Integer personId){
        PersonBasicInfo personBasicInfo = personBasicInfoService.selectByPrimaryKey(personId);
        return personBasicInfo;
    }


    /**
     * 删除信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/personBasicInfo/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(Integer id){
        int deleteBatch = personBasicInfoService.delete(id);
        if (deleteBatch > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        }
        return ResultGenerator.genFailResult("删除失败");
    }


}
