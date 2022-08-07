package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VipPermission {

    private Long configId;

    private Long userId;

    private Byte isView;

    private Integer likes;

    private Integer albumCount;

    private Integer diaryPicCount;

    private Byte isBack;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer updateAdmin;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getIsView() {
        return isView;
    }

    public void setIsView(Byte isView) {
        this.isView = isView;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public Integer getDiaryPicCount() {
        return diaryPicCount;
    }

    public void setDiaryPicCount(Integer diaryPicCount) {
        this.diaryPicCount = diaryPicCount;
    }

    public Byte getIsBack() {
        return isBack;
    }

    public void setIsBack(Byte isBack) {
        this.isBack = isBack;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateAdmin() {
        return updateAdmin;
    }

    public void setUpdateAdmin(Integer updateAdmin) {
        this.updateAdmin = updateAdmin;
    }
}