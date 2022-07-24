package com.personInfo.bean;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class Requirement {

    private Integer personId;

    private String ageRange;

    private String heightRange;

    private String marryStatus;

    private String educationBackground;

    private String income;

    private String housingStatus;

    private String carStatus;

    private String otherRequirements;

    public Requirement() {
    }

    public Requirement(Integer personId, String ageRange, String heightRange, String marryStatus, String educationBackground, String income, String housingStatus, String carStatus, String otherRequirements) {
        this.personId = personId;
        this.ageRange = ageRange;
        this.heightRange = heightRange;
        this.marryStatus = marryStatus;
        this.educationBackground = educationBackground;
        this.income = income;
        this.housingStatus = housingStatus;
        this.carStatus = carStatus;
        this.otherRequirements = otherRequirements;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getHeightRange() {
        return heightRange;
    }

    public void setHeightRange(String heightRange) {
        this.heightRange = heightRange;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
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

    public String getOtherRequirements() {
        return otherRequirements;
    }

    public void setOtherRequirements(String otherRequirements) {
        this.otherRequirements = otherRequirements;
    }

    @Override
    public String toString() {
        return "Requirements{" +
                "personId=" + personId +
                ", ageRange='" + ageRange + '\'' +
                ", heightRange='" + heightRange + '\'' +
                ", marryStatus='" + marryStatus + '\'' +
                ", educationBackground='" + educationBackground + '\'' +
                ", income='" + income + '\'' +
                ", housingStatus='" + housingStatus + '\'' +
                ", carStatus='" + carStatus + '\'' +
                ", otherRequirements='" + otherRequirements + '\'' +
                '}';
    }
}
