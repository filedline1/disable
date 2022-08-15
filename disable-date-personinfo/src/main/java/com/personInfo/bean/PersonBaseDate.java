package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class PersonBaseDate {

    private Integer personId;

    private String nickName;

    private String headPicPath;

    private Integer attentionCount;

    private Integer fanCount;

    private Integer like;

    private Integer love;

    private Integer sorts;

    private Boolean isSignIn;

    private Byte isModify;

    private Integer isVip;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationTime;

    public PersonBaseDate() {
    }

    public PersonBaseDate(Integer personId, String nickName, String headPicPath, Integer attentionCount, Integer fanCount, Integer like, Integer love, Integer sorts, Boolean isSignIn, Byte isModify, Integer isVip, Date expirationTime) {
        this.personId = personId;
        this.nickName = nickName;
        this.headPicPath = headPicPath;
        this.attentionCount = attentionCount;
        this.fanCount = fanCount;
        this.like = like;
        this.love = love;
        this.sorts = sorts;
        this.isSignIn = isSignIn;
        this.isModify = isModify;
        this.isVip = isVip;
        this.expirationTime = expirationTime;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPicPath() {
        return headPicPath;
    }

    public void setHeadPicPath(String headPicPath) {
        this.headPicPath = headPicPath;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public Integer getFanCount() {
        return fanCount;
    }

    public void setFanCount(Integer fanCount) {
        this.fanCount = fanCount;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public Boolean getSignIn() {
        return isSignIn;
    }

    public void setSignIn(Boolean signIn) {
        isSignIn = signIn;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Byte getIsModify() {
        return isModify;
    }

    public void setIsModify(Byte isModify) {
        this.isModify = isModify;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return "PersonBaseDate{" +
                "personId=" + personId +
                ", nickName='" + nickName + '\'' +
                ", headPicPath='" + headPicPath + '\'' +
                ", attentionCount=" + attentionCount +
                ", fanCount=" + fanCount +
                ", like=" + like +
                ", love=" + love +
                ", sorts=" + sorts +
                ", isSignIn=" + isSignIn +
                ", isModify=" + isModify +
                ", isVip=" + isVip +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
