package com.personInfo.controller;

import com.personInfo.bean.VipPermission;
import com.personInfo.service.VipPermissionService;
import com.personInfo.util.PageQueryUtil;
import com.personInfo.util.Result;
import com.personInfo.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
@Controller
public class VipPermissionController {

    @Autowired
    private VipPermissionService vipPermissionService;

    /**
     * 获取权限信息的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/vipPermission/list", method = RequestMethod.GET)
    @ResponseBody
    public Result findRecordList(@Param("start")int start, @Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        final List<VipPermission> recordList = vipPermissionService.findRecordList(params);
        return ResultGenerator.genSuccessResult(recordList);
    }

    /**
     * 根据配置id删除对应会员权限信息（注销账号时使用）
     * @param configId
     * @return
     */
    @RequestMapping(value = "/vipPermission/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteByPrimaryKey(Long configId) {
        int delete = vipPermissionService.deleteByPrimaryKey(configId);
        if (delete > 0){
            return ResultGenerator.genSuccessResult("删除成功");
        }
        return ResultGenerator.genSuccessResult("删除失败");
    }

    /**
     * 插入会员权限信息
     * @param record
     * @return
     */
    @RequestMapping(value = "/vipPermission/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(VipPermission record) {
        int insert = vipPermissionService.insertSelective(record);
        if (insert > 0){
            return ResultGenerator.genSuccessResult("新增成功");
        }
        return ResultGenerator.genFailResult("新增失败");
    }

    /**
     * 根据配置id查找会员权限信息
     * @param configId
     * @return
     */
    @RequestMapping(value = "/vipPermission/configId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByPrimaryKey(@RequestParam("configId") Long configId) {
        final VipPermission vipPermission = vipPermissionService.selectByPrimaryKey(configId);
        if (vipPermission == null){
            return ResultGenerator.genFailResult("该用户不存在");
        }
        return ResultGenerator.genSuccessResult(vipPermission);
    }

    /**
     * 根据UserId查找会员权限信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/vipPermission/userId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByUserId(@RequestParam("userId")Long userId) {
        VipPermission vipPermission = vipPermissionService.selectByUserId(userId);
        if (vipPermission == null){
            return ResultGenerator.genFailResult("该用户不存在");
        }
        return ResultGenerator.genSuccessResult(vipPermission);
    }

    /**
     * 更新会员权益配置
     * @param record
     * @return
     */
    @RequestMapping(value = "/vipPermission/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateByPrimaryKeySelective(VipPermission record) {
        int update = vipPermissionService.updateByPrimaryKeySelective(record);
        if (update > 0){
            return ResultGenerator.genSuccessResult("更新成功");
        }
        return ResultGenerator.genFailResult("更新失败");
    }


}
