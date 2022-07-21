package com.chat.util;

import com.chat.util.exception.ResultCodeEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一结果类
 * **/
@Data
public class Result {
    private Boolean success;

    private Integer status;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    // 构造器私有
    private Result(){}

    // 通用返回成功
    public static Result ok() {
        Result r = new Result();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setStatus(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    // 通用返回失败，未知错误
    public static Result error() {
        Result r = new Result();
        r.setSuccess(ResultCodeEnum.ERROR.getSuccess());
        r.setStatus(ResultCodeEnum.ERROR.getCode());
        r.setMessage(ResultCodeEnum.ERROR.getMessage());
        return r;
    }

    // 设置结果，形参为结果枚举
    public static Result setResult(ResultCodeEnum result) {
        Result r = new Result();
        r.setSuccess(result.getSuccess());
        r.setStatus(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    /**------------使用链式编程，返回类本身-----------**/

    // 自定义返回数据
    public Result data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }

    // 通用设置data
    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    // 自定义状态信息
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public Result code(Integer code) {
        this.setStatus(code);
        return this;
    }

    // 自定义返回结果
    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
}