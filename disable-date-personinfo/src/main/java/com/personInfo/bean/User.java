package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class User {

    Integer userId;

    String nickName;

    String loginName;

    String passwordMd5;

    Integer isDeleted;

    Integer lockedFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date createTime;

    public User() {
    }

    public User(Integer userId, String nickName, String loginName, String passwordMd5, Integer isDeleted, Integer lockedFlag, Date createTime) {
        this.userId = userId;
        this.nickName = nickName;
        this.loginName = loginName;
        this.passwordMd5 = passwordMd5;
        this.isDeleted = isDeleted;
        this.lockedFlag = lockedFlag;
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getLockedFlag() {
        return lockedFlag;
    }

    public void setLockedFlag(Integer lockedFlag) {
        this.lockedFlag = lockedFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passwordMd5='" + passwordMd5 + '\'' +
                ", isDeleted=" + isDeleted +
                ", lockedFlag=" + lockedFlag +
                ", createTime=" + createTime +
                '}';
    }
}
