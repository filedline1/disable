package com.personInfo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class PersonBasicInfo {

    private Integer personId;

    private String personName;

    private Integer isVip;

    private Integer sorts;

    private Integer sex;

    private Integer age;

    private String phone;

    private String imagePath;

    private String disableNumber;

    private String workAddr;

    private String householdAddr;

    private String maritalStatus;

    private Integer height;

    private Integer weight;

    private String degree;

    private Integer income;

    private String occupation;

    private String housingStatus;

    private String carStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expectedMarryTime;

    private String personIntro;

    private String personSign;

    private String longitude;

    private String latitude;

    private String wechat;

    private String wechatCodeImagesPath;

    private String qq;

    private String email;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDisableNumber() {
        return disableNumber;
    }

    public void setDisableNumber(String disableNumber) {
        this.disableNumber = disableNumber;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }

    public String getHouseholdAddr() {
        return householdAddr;
    }

    public void setHouseholdAddr(String householdAddr) {
        this.householdAddr = householdAddr;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHousingStatus() {
        return housingStatus;
    }

    public void setHousingStatus(String housingStatus) {
        this.housingStatus = housingStatus;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Date getExpectedMarryTime() {
        return expectedMarryTime;
    }

    public void setExpectedMarryTime(Date expectedMarryTime) {
        this.expectedMarryTime = expectedMarryTime;
    }

    public String getPersonIntro() {
        return personIntro;
    }

    public void setPersonIntro(String personIntro) {
        this.personIntro = personIntro;
    }

    public String getPersonSign() {
        return personSign;
    }

    public void setPersonSign(String personSign) {
        this.personSign = personSign;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechatCodeImagesPath() {
        return wechatCodeImagesPath;
    }

    public void setWechatCodeImagesPath(String wechatCodeImagesPath) {
        this.wechatCodeImagesPath = wechatCodeImagesPath;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public PersonBasicInfo(Integer personId, String personName, Integer sex, Integer age, String phone, String imagePath, String disableNumber, String workAddr, String householdAddr, String maritalStatus, Integer height, Integer weight, String degree, Integer income, String occupation, String housingStatus, String carStatus, Date expectedMarryTime, String personIntro, String personSign, String longitude, String latitude, String wechat, String wechatCodeImagesPath, String qq, String email) {
        this.personId = personId;
        this.personName = personName;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.imagePath = imagePath;
        this.disableNumber = disableNumber;
        this.workAddr = workAddr;
        this.householdAddr = householdAddr;
        this.maritalStatus = maritalStatus;
        this.height = height;
        this.weight = weight;
        this.degree = degree;
        this.income = income;
        this.occupation = occupation;
        this.housingStatus = housingStatus;
        this.carStatus = carStatus;
        this.expectedMarryTime = expectedMarryTime;
        this.personIntro = personIntro;
        this.personSign = personSign;
        this.longitude = longitude;
        this.latitude = latitude;
        this.wechat = wechat;
        this.wechatCodeImagesPath = wechatCodeImagesPath;
        this.qq = qq;
        this.email = email;
    }

    public PersonBasicInfo() {
    }

    @Override
    public String toString() {
        return "PersonBasicInfo{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", disableNumber='" + disableNumber + '\'' +
                ", workAddr='" + workAddr + '\'' +
                ", householdAddr='" + householdAddr + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", degree='" + degree + '\'' +
                ", income=" + income +
                ", occupation='" + occupation + '\'' +
                ", housingStatus='" + housingStatus + '\'' +
                ", carStatus='" + carStatus + '\'' +
                ", expectedMarryTime=" + expectedMarryTime +
                ", personIntro='" + personIntro + '\'' +
                ", personSign='" + personSign + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", wechat='" + wechat + '\'' +
                ", wechatCodeImagesPath='" + wechatCodeImagesPath + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
