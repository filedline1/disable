package com.relation.controller;


import com.relation.bean.Fan;
import com.relation.bean.Follow;
import com.relation.common.FanRestClient;
import com.relation.common.FollowRestClient;
import com.relation.common.ServiceResultEnum;
import com.relation.service.FanService;
import com.relation.service.FollowService;
import com.relation.utils.PageQueryUtil;
import com.relation.utils.Result;
import com.relation.utils.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.relation.constants.MqConstants.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@RestController
@CrossOrigin
@RequestMapping("/fan")
public class FanController {

    @Autowired
    FanService fanService;

    @Autowired
    FollowService followService;

    /**
     * 分页查询粉丝对象
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    @RequestMapping(value = "/searchFan", method = RequestMethod.POST)
    @ResponseBody
    public Result selectFollowerByUserId(@Param("userId")Integer userId,@Param("start")Integer start,@Param("limit")Integer limit){
        if (limit == null || start == null) {
            return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
        }
        PageQueryUtil params = new PageQueryUtil(start, limit);
        List<Fan> fans = fanService.selectFollowerByUserId(userId, start, limit);
        return ResultGenerator.genSuccessResult(fans);
    }

    /**
     * 查询该用户关注列表
     * @param userId
     * @param start
     * @param limit
     * @return
     **/
     @RequestMapping(value = "/searchAttention", method = RequestMethod.POST)
     @ResponseBody
    public Result selectAttentionByUserId(@Param("userId") Integer userId, @Param("start")Integer start, @Param("limit")Integer limit){
         if (limit == null || start == null) {
             return ResultGenerator.genErrorResult(400,"参数传递格式有误！");
         }
         PageQueryUtil params = new PageQueryUtil(start, limit);
         List<Follow> follows = followService.selectAttentionByUserId(userId, start, limit);
         return ResultGenerator.genSuccessResult(follows);
     }

    /**
     * 查找该用户的粉丝数
     * @param userId
     * @return
     */
    @RequestMapping(value = "/searchFanCount", method = RequestMethod.POST)
    @ResponseBody
    public Result selectFollowerCountByUserId(Integer userId){
        int count;
        try {
            count = fanService.selectFollowerCountByUserId(userId);
        } catch (Exception e){
            return ResultGenerator.genErrorResult(500,"服务器错误请及时联系管理员");
        }
        return ResultGenerator.genSuccessResult(count);
    }

    /**
     * 查询该用户关注数量
     * @param userId
     * @return
     */
    @RequestMapping(value = "/searchAttentionCount", method = RequestMethod.POST)
    @ResponseBody
    public Result selectAttentionCountByUserId(Integer userId){
        int count;
        try {
            count = followService.selectAttentionCountByUserId(userId);
        } catch (Exception e){
            return ResultGenerator.genErrorResult(500,"服务器错误请及时联系管理员");
        }
        return ResultGenerator.genSuccessResult(count);
    }

    /**
     * 查询两个人之间的关注情况
     * @param firstUserId
     * @param secondUserId
     * @return
     */
    @RequestMapping(value = "/searchStatus", method = RequestMethod.POST)
    @ResponseBody
    public List<Fan> selectStatusBetweenTwoUser(Integer firstUserId, Integer secondUserId){
        List<Fan> fans = fanService.selectStatusBetweenTwoUser(firstUserId, secondUserId);
        return fans;
    }

    /**
     * 增加关注记录
     * @param fan
     * @return
     */
    @RequestMapping(value = "/addAttention", method = RequestMethod.POST)
    @ResponseBody
    public Result addAttention(Fan fan){
        if (fan.getUserId() == null || fan.getFollower() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        System.out.println(fan);
        String message = fanService.addAttention(fan);
        if (!message.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genErrorResult(500,"服务器错误，请及时联系管理员！");
        }
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 取消关注记录
     * @param fan
     * @return
     */
    @RequestMapping(value = "/cancelAttention", method = RequestMethod.POST)
    @ResponseBody
    public Result cancelAttention(Fan fan){
        if (fan.getUserId() == null || fan.getFollower() == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        System.out.println(fan);
        String message = fanService.cancelAttention(fan);
        if (!message.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genErrorResult(500,"服务器错误，请及时联系管理员！");
        }
        return ResultGenerator.genSuccessResult();
    }


    /**
     * 删除改用户的所有关注信息（注销账号时使用）
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteRecord", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteRecord(Integer userId){
        String message = fanService.deleteRecord(userId);
        System.out.println(message);
        if (message.equals(ServiceResultEnum.SUCCESS.getResult())){
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除失败！");
    }

}
