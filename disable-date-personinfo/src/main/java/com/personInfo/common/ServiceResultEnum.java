
package com.personInfo.common;


public enum ServiceResultEnum {
    ERROR("error"),

    SUCCESS("success"),

    USER_IS_EXIST("账号已存在"),

    USER_NOT_EXIST("账号不存在"),

    DATA_NOT_EXIST("未查询到记录！"),

    SAME_CATEGORY_EXIST("已存在同级同名的分类！"),

    LOGIN_NAME_NULL("请输入登录名！"),

    LOGIN_PASSWORD_NULL("请输入密码！"),

    PASSWORD_ERROR("密码错误！"),

    LOGIN_VERIFY_CODE_NULL("请输入验证码！"),

    LOGIN_VERIFY_CODE_ERROR("验证码错误！"),

    MATERIALS_COUNT_ERROR("库存不足！"),

    OPERATE_ERROR("操作失败！"),

    NO_PERMISSION_ERROR("无权限！"),

    DB_ERROR("数据库异常");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}