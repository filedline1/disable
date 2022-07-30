package com.personInfo.controller;


import com.personInfo.bean.PersonDetailInfo;
import com.personInfo.common.PersonDetailInfoRestClient;
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

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Controller
public class PersonDetailInfoController {

    @Autowired
    PersonDetailInfoService personDetailInfoService;

    @Autowired
    PersonDetailInfoRestClient personDetailInfoRestClient;

    /**
     * 获取记录的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/list", method = RequestMethod.GET)
    @ResponseBody
    Result findCommunityList(@Param("start")int start, @Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        List<PersonDetailInfo> recordList = personDetailInfoRestClient.findRecordListFromIndex(params);
        if (recordList == null){
            return ResultGenerator.genSuccessResult("分页记录不存在");
        }
        Result result = ResultGenerator.genSuccessResult(recordList);
        return result;
    }

    /**+
     * 选择性更新记录
     * @param personDetailInfo
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateInfo(PersonDetailInfo personDetailInfo){
        if (personDetailInfo.getPersonId() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        System.out.println(personDetailInfo);
        int updateDB = personDetailInfoService.updateByPrimaryKeySelective(personDetailInfo);
        int updateES;
        try {
            updateES = personDetailInfoRestClient.InsertPersonDetailInfoToIndexByPersonId(personDetailInfo.getPersonId());
        } catch (Exception e){
            return ResultGenerator.genErrorResult(500,"服务器异常，用户修改失败，请及时联系管理员！");
        }
        if (updateDB > 0){
            log.println("mysql成功修改personId为" + personDetailInfo.getPersonId() + "的详细信息");
        }
        if (updateES > 0){
            log.println("es成功修改personId为" + personDetailInfo.getPersonId() + "的详细信息");
        }
        if (updateDB > 0 && updateES > 0){
            return ResultGenerator.genSuccessResult("添加成功");
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }


    /**
     * 插入详细
     * @param personDetailInfo
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInfo(PersonDetailInfo personDetailInfo) {
        System.out.println(personDetailInfo);
        int insertES;
        int insertDB = personDetailInfoService.insert(personDetailInfo);
        try {
            insertES = personDetailInfoRestClient.InsertPersonDetailInfoToIndexByPersonId(personDetailInfo.getPersonId());
        } catch (Exception e){
            Result result = new Result(500,"服务器异常，用户新增失败，请及时联系管理员！");
            return result;
        }
        if (insertDB > 0){
            log.println("mysql成功添加personId为" + personDetailInfo.getPersonId() + "的详细信息");
        }
        if (insertES > 0){
            log.println("es成功添加personId为" + personDetailInfo.getPersonId() + "的详细信息");
        }
        if (insertDB > 0 && insertES > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
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
    Result selectByPrimaryKey(Integer personId) {
        try {
            PersonDetailInfo personDetailInfo = personDetailInfoRestClient.MatchByPersonId(personId);
            if (personDetailInfo == null){
                return ResultGenerator.genSuccessResult("查询的用户信息不存在");
            }
            Result result = ResultGenerator.genSuccessResult(personDetailInfo);
            return result;
        } catch (Exception e){
            return ResultGenerator.genErrorResult(500,"查询用户不存在或者系统异常，请及时联系管理员");
        }
    }


    /**
     * 删除信息
     * @param personId
     * @return
     */
    @RequestMapping(value = "/personDetailInfo/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(Integer personId){
        int deleteDB = personDetailInfoService.delete(personId);
        int deleteES = personDetailInfoRestClient.deletePersonBasicInfoFromIndexById(personId);
        if (deleteDB > 0){
            log.println("mysql成功删除personId为" + personId + "的详细信息");
        }
        if (deleteES > 0){
            log.println("es成功删除personId为" + personId + "的详细信息");
        }
        if (deleteDB > 0 && deleteES > 0){
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }


}
