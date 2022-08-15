package com.personInfo.controller;

import com.personInfo.bean.VipPackage;
import com.personInfo.service.VipPackageService;
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
public class VipPackageContrller {

    @Autowired
    private VipPackageService vipPackageService;

    /**
     * 获取套餐信息的分页列表
     * @param
     * @return
     */
    @RequestMapping(value = "/vipPackage/list", method = RequestMethod.GET)
    @ResponseBody
    public Result findRecordList(@Param("start")int start, @Param("limit")int limit){
        PageQueryUtil params = new PageQueryUtil(start,limit);
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        final List<VipPackage> recordList = vipPackageService.findRecordList(params);
        return ResultGenerator.genSuccessResult(recordList);
    }

    /**
     * 插入会员套餐信息
     * @param record
     * @return
     */
    @RequestMapping(value = "/vipPackage/insertInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSelective(VipPackage record) {
        VipPackage vipPackage = vipPackageService.selectByPrimaryKey(record.getId());
        if (vipPackage == null){
            int insert = vipPackageService.insertSelective(record);
            if (insert > 0){
                return ResultGenerator.genSuccessResult("新增套餐成功");
            }
        } else {
            int update = vipPackageService.updateByPrimaryKeySelective(record);
            if (update > 0){
                return ResultGenerator.genSuccessResult("新增套餐成功");
            }
        }
        return ResultGenerator.genFailResult("新增套餐失败");
    }

    /**
     * 根据userId查找会员权限信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/vipPackage/userId", method = RequestMethod.POST)
    @ResponseBody
    public Result selectByUserId(@RequestParam("userId")Integer userId) {
        VipPackage vipPackage = vipPackageService.selectByPrimaryKey(userId);
        if (vipPackage == null){
            return ResultGenerator.genFailResult("该用户没有开通套餐记录");
        }
        return ResultGenerator.genSuccessResult(vipPackage);
    }


}
