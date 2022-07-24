package com.personInfo.bean;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/
public class PersonDetailInfo {

    private Integer personId;

    private String disableType;

    private Integer disableLevel;

    private Integer isProvide;

    private String auxiliaryTool;

    private String cause;

    private Integer isGenetic;

    private String parentStatus;

    private Integer brotherNumber;

    private Integer livingWill;

    private Integer isSmoking;

    private Integer marryForm;

    private Integer isDrinking;

    private String fertilityStatus;

    private String keepingStatus;

    private String hobby;

    private Integer bloodType;

    private String habit;

    private Integer companyType;

    private String companyName;

    private String workIndustry;

    private String housingLocation;

    private String personTag;

    public PersonDetailInfo() {
    }

    public PersonDetailInfo(Integer personId, String disableType, Integer disableLevel, Integer isProvide, String auxiliaryTool, String cause, Integer isGenetic, String parentStatus, Integer brotherNumber, Integer livingWill, Integer isSmoking, Integer marryForm, Integer isDrinking, String fertilityStatus, String keepingStatus, String hobby, Integer bloodType, String habit, Integer companyType, String companyName, String workIndustry, String housingLocation, String personTag) {
        this.personId = personId;
        this.disableType = disableType;
        this.disableLevel = disableLevel;
        this.isProvide = isProvide;
        this.auxiliaryTool = auxiliaryTool;
        this.cause = cause;
        this.isGenetic = isGenetic;
        this.parentStatus = parentStatus;
        this.brotherNumber = brotherNumber;
        this.livingWill = livingWill;
        this.isSmoking = isSmoking;
        this.marryForm = marryForm;
        this.isDrinking = isDrinking;
        this.fertilityStatus = fertilityStatus;
        this.keepingStatus = keepingStatus;
        this.hobby = hobby;
        this.bloodType = bloodType;
        this.habit = habit;
        this.companyType = companyType;
        this.companyName = companyName;
        this.workIndustry = workIndustry;
        this.housingLocation = housingLocation;
        this.personTag = personTag;
    }

    @Override
    public String toString() {
        return "PersonDetailInfo{" +
                "personId=" + personId +
                ", disableType='" + disableType + '\'' +
                ", disableLevel=" + disableLevel +
                ", isProvide=" + isProvide +
                ", auxiliaryTool='" + auxiliaryTool + '\'' +
                ", cause='" + cause + '\'' +
                ", isGenetic=" + isGenetic +
                ", parentStatus='" + parentStatus + '\'' +
                ", brotherNumber=" + brotherNumber +
                ", livingWill=" + livingWill +
                ", isSmoking=" + isSmoking +
                ", marryForm=" + marryForm +
                ", isDrinking=" + isDrinking +
                ", fertilityStatus='" + fertilityStatus + '\'' +
                ", keepingStatus='" + keepingStatus + '\'' +
                ", hobby='" + hobby + '\'' +
                ", bloodType=" + bloodType +
                ", habit='" + habit + '\'' +
                ", companyType=" + companyType +
                ", companyName='" + companyName + '\'' +
                ", workIndustry='" + workIndustry + '\'' +
                ", housingLocation='" + housingLocation + '\'' +
                ", personTag='" + personTag + '\'' +
                '}';
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getDisableType() {
        return disableType;
    }

    public void setDisableType(String disableType) {
        this.disableType = disableType;
    }

    public Integer getDisableLevel() {
        return disableLevel;
    }

    public void setDisableLevel(Integer disableLevel) {
        this.disableLevel = disableLevel;
    }

    public Integer getIsProvide() {
        return isProvide;
    }

    public void setIsProvide(Integer isProvide) {
        this.isProvide = isProvide;
    }

    public String getAuxiliaryTool() {
        return auxiliaryTool;
    }

    public void setAuxiliaryTool(String auxiliaryTool) {
        this.auxiliaryTool = auxiliaryTool;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getIsGenetic() {
        return isGenetic;
    }

    public void setIsGenetic(Integer isGenetic) {
        this.isGenetic = isGenetic;
    }

    public String getParentStatus() {
        return parentStatus;
    }

    public void setParentStatus(String parentStatus) {
        this.parentStatus = parentStatus;
    }

    public Integer getBrotherNumber() {
        return brotherNumber;
    }

    public void setBrotherNumber(Integer brotherNumber) {
        this.brotherNumber = brotherNumber;
    }

    public Integer getLivingWill() {
        return livingWill;
    }

    public void setLivingWill(Integer livingWill) {
        this.livingWill = livingWill;
    }

    public Integer getIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(Integer isSmoking) {
        this.isSmoking = isSmoking;
    }

    public Integer getMarryForm() {
        return marryForm;
    }

    public void setMarryForm(Integer marryForm) {
        this.marryForm = marryForm;
    }

    public Integer getIsDrinking() {
        return isDrinking;
    }

    public void setIsDrinking(Integer isDrinking) {
        this.isDrinking = isDrinking;
    }

    public String getFertilityStatus() {
        return fertilityStatus;
    }

    public void setFertilityStatus(String fertilityStatus) {
        this.fertilityStatus = fertilityStatus;
    }

    public String getKeepingStatus() {
        return keepingStatus;
    }

    public void setKeepingStatus(String keepingStatus) {
        this.keepingStatus = keepingStatus;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkIndustry() {
        return workIndustry;
    }

    public void setWorkIndustry(String workIndustry) {
        this.workIndustry = workIndustry;
    }

    public String getHousingLocation() {
        return housingLocation;
    }

    public void setHousingLocation(String housingLocation) {
        this.housingLocation = housingLocation;
    }

    public String getPersonTag() {
        return personTag;
    }

    public void setPersonTag(String personTag) {
        this.personTag = personTag;
    }
}
