package com.example.demo.controller;

import com.example.demo.common.request.PageParam;
import com.example.demo.common.response.JsonResult;
import com.example.demo.common.response.PageJsonResult;
import com.example.demo.dto.QueryUserInfoDTO;
import com.example.demo.vo.UserInfoVo;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * todo API 请求参数对象 DTO，相应参数对象 Vo，接口 统一JSON 数据结构传输
 * RestController 等于 Controller + ResponseBody
 *
 * @author Chunming Liu In 2022/07/28
 */
@RestController
public class ExampleController {

    @GetMapping("queryUserInfoOne")
    public JsonResult<UserInfoVo> queryUserInfoOne(@RequestParam("id") Integer id) {
        // TODO: 2022/7/28 假设查到用户
        UserInfoVo userInfoVo = new UserInfoVo ( 1L, 18, "张三", "篮球" );
        return JsonResult.success ( userInfoVo );
    }

    @PostMapping("queryUserInfo")
    public JsonResult<List<UserInfoVo>> queryUserInfo(@RequestBody QueryUserInfoDTO param) {
        // TODO: 2022/7/28 假设查到了2个用户
        List<UserInfoVo> userInfoVos = new ArrayList<> ( 2 );
        userInfoVos.add ( new UserInfoVo ( 1L, 18, "张三", "篮球" ) );
        userInfoVos.add ( new UserInfoVo ( 2L, 20, "王五", "爬山" ) );

        return JsonResult.success ( userInfoVos );
    }


    @PostMapping("queryUserInfoPage")
    public PageJsonResult<List<UserInfoVo>> queryUserInfoPage(@RequestBody PageParam<QueryUserInfoDTO> param) {
        // TODO: 2022/7/28 假设查到了2个用户
        List<UserInfoVo> userInfoVos = new ArrayList<> ( 2 );
        userInfoVos.add ( new UserInfoVo ( 1L, 18, "张三", "篮球" ) );
        userInfoVos.add ( new UserInfoVo ( 2L, 20, "王五", "爬山" ) );

        return PageJsonResult.success ( param.getPageIndex (), param.getPageSize (), 2L, userInfoVos );
    }


    @GetMapping("testError")
    public JsonResult<Map<String, Integer>> testError(@RequestParam("id") Integer id) {
        // TODO: 2022/7/28 假设只接受大于100的数字，
        // TODO： 异常会thr IllegalStateException 异常被 com.example.demo.advise.AdviseController.handleIllegalStateException catch并且相应
        Assert.state ( id > 100, "只接受大于100的数" );
        return JsonResult.success ( Collections.singletonMap ( "inputValue", id ) );
    }
}
