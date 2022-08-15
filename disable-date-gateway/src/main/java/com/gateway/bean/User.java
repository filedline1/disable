package com.gateway.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(ignoreUnknown = true)
    Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnoreProperties(ignoreUnknown = true)
    Date updateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnoreProperties(ignoreUnknown = true)
    Date lastTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null) return false;
        if (loginName != null ? !loginName.equals(user.loginName) : user.loginName != null) return false;
        if (passwordMd5 != null ? !passwordMd5.equals(user.passwordMd5) : user.passwordMd5 != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (isVip != null ? !isVip.equals(user.isVip) : user.isVip != null) return false;
        if (love != null ? !love.equals(user.love) : user.love != null) return false;
        if (likes != null ? !likes.equals(user.likes) : user.likes != null) return false;
        if (sorts != null ? !sorts.equals(user.sorts) : user.sorts != null) return false;
        if (disableNumber != null ? !disableNumber.equals(user.disableNumber) : user.disableNumber != null)
            return false;
        if (headPicPath != null ? !headPicPath.equals(user.headPicPath) : user.headPicPath != null) return false;
        if (onlineTime != null ? !onlineTime.equals(user.onlineTime) : user.onlineTime != null) return false;
        if (isDeleted != null ? !isDeleted.equals(user.isDeleted) : user.isDeleted != null) return false;
        if (lockedFlag != null ? !lockedFlag.equals(user.lockedFlag) : user.lockedFlag != null) return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(user.updateTime) : user.updateTime != null) return false;
        if (lastTime != null ? !lastTime.equals(user.lastTime) : user.lastTime != null) return false;
        return expirationTime != null ? expirationTime.equals(user.expirationTime) : user.expirationTime == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (passwordMd5 != null ? passwordMd5.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (isVip != null ? isVip.hashCode() : 0);
        result = 31 * result + (love != null ? love.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (sorts != null ? sorts.hashCode() : 0);
        result = 31 * result + (disableNumber != null ? disableNumber.hashCode() : 0);
        result = 31 * result + (headPicPath != null ? headPicPath.hashCode() : 0);
        result = 31 * result + (onlineTime != null ? onlineTime.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (lockedFlag != null ? lockedFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        return result;
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
