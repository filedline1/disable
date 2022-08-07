package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiration_time;

    public PersonBaseDate() {
    }

    public PersonBaseDate(Integer personId, String nickName, String headPicPath, Integer attentionCount, Integer fanCount, Integer like, Integer love, Integer sorts, Boolean isSignIn, Date expiration_time) {
        this.personId = personId;
        this.nickName = nickName;
        this.headPicPath = headPicPath;
        this.attentionCount = attentionCount;
        this.fanCount = fanCount;
        this.like = like;
        this.love = love;
        this.sorts = sorts;
        this.isSignIn = isSignIn;
        this.expiration_time = expiration_time;
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

    public Date getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(Date expiration_time) {
        this.expiration_time = expiration_time;
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
                ", expiration_time=" + expiration_time +
                '}';
    }
}
