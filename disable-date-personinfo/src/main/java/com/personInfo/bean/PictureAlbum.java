package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PictureAlbum {

    private Long id;

    private Long userId;

    private String picDesc;

    private String picPath;

    private Long likeCounts;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getPicDesc() {
        return picDesc;
    }


    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc == null ? null : picDesc.trim();
    }


    public String getPicPath() {
        return picPath;
    }


    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }


    public Long getLikeCounts() {
        return likeCounts;
    }


    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PictureAlbum{" +
                "id=" + id +
                ", userId=" + userId +
                ", picDesc='" + picDesc + '\'' +
                ", picPath='" + picPath + '\'' +
                ", likeCounts=" + likeCounts +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}