package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class VipPackage {

    private Integer id;

    private String name;

    private Integer time;

    private Double price;

    private Double totalPrice;

    private Integer packageStatus;

    private Integer adviceFirst;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public VipPackage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(Integer packageStatus) {
        this.packageStatus = packageStatus;
    }

    public Integer getAdviceFirst() {
        return adviceFirst;
    }

    public void setAdviceFirst(Integer adviceFirst) {
        this.adviceFirst = adviceFirst;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "vipPackage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", packageStatus=" + packageStatus +
                ", adviceFirst=" + adviceFirst +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}