package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class PictureAlbum {

    private Integer id;

    private Integer userId;

    private String picDesc;

    private String picPath;

    private Integer likeCounts;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public PictureAlbum() {
    }

    public PictureAlbum(Integer id, Integer userId, String picDesc, String picPath, Integer likeCounts, Integer status, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.picDesc = picDesc;
        this.picPath = picPath;
        this.likeCounts = likeCounts;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Integer getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Integer likeCounts) {
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
