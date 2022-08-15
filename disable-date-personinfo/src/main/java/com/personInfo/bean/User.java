package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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

    Integer sex;

    Integer age;

    Integer isVip;

    Integer love;

    Integer likes;

    Integer sorts;

    String disableNumber;

    String headPicPath;

    String onlineTime;

    Integer isDeleted;

    Integer lockedFlag;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date lastTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date expirationTime;

    public User() {
    }

    public User(Integer userId, String nickName, String loginName, String passwordMd5, Integer sex, Integer age, Integer isVip, Integer love, Integer likes, Integer sorts, String disableNumber, String headPicPath, String onlineTime, Integer isDeleted, Integer lockedFlag, Date createTime, Date updateTime, Date lastTime, Date expirationTime) {
        this.userId = userId;
        this.nickName = nickName;
        this.loginName = loginName;
        this.passwordMd5 = passwordMd5;
        this.sex = sex;
        this.age = age;
        this.isVip = isVip;
        this.love = love;
        this.likes = likes;
        this.sorts = sorts;
        this.disableNumber = disableNumber;
        this.headPicPath = headPicPath;
        this.onlineTime = onlineTime;
        this.isDeleted = isDeleted;
        this.lockedFlag = lockedFlag;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastTime = lastTime;
        this.expirationTime = expirationTime;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public String getDisableNumber() {
        return disableNumber;
    }

    public void setDisableNumber(String disableNumber) {
        this.disableNumber = disableNumber;
    }

    public String getHeadPicPath() {
        return headPicPath;
    }

    public void setHeadPicPath(String headPicPath) {
        this.headPicPath = headPicPath;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passwordMd5='" + passwordMd5 + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", isVip=" + isVip +
                ", love=" + love +
                ", likes=" + likes +
                ", sorts=" + sorts +
                ", disableNumber='" + disableNumber + '\'' +
                ", headPicPath='" + headPicPath + '\'' +
                ", onlineTime='" + onlineTime + '\'' +
                ", isDeleted=" + isDeleted +
                ", lockedFlag=" + lockedFlag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastTime=" + lastTime +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
