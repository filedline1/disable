package com.date.admin.common;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据的对象
 * @author Mr.Jiang
 * @version 1.0
 **/
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result success(Map<String, Object> map) {
        Result resule = new Result();
        resule.putAll(map);
        return resule;
    }

    public static Result success() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
