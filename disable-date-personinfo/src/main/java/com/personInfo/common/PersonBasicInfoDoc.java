package com.personInfo.common;

import com.personInfo.bean.PersonBasicInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonBasicInfoDoc {

    private Integer personId;

    private String personName;

    private Integer sex;

    private Integer age;

    private String phone;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectedMarryTime;

    private String personIntro;

    private String personSign;

    private String location;

    private String wechat;

    private String wechatCodeImagesPath;

    private String qq;

    private String email;

    public PersonBasicInfoDoc(PersonBasicInfo personBasicInfo) {
        this.personId = personBasicInfo.getPersonId();
        this.personName = personBasicInfo.getPersonName();
        this.sex = personBasicInfo.getSex();
        this.age = personBasicInfo.getAge();
        this.phone = personBasicInfo.getPhone();
        this.workAddr = personBasicInfo.getWorkAddr();
        this.householdAddr = personBasicInfo.getHouseholdAddr();
        this.maritalStatus = personBasicInfo.getMaritalStatus();
        this.height = personBasicInfo.getHeight();
        this.weight = personBasicInfo.getWeight();
        this.degree = personBasicInfo.getDegree();
        this.income = personBasicInfo.getIncome();
        this.occupation = personBasicInfo.getOccupation();
        this.housingStatus = personBasicInfo.getHousingStatus();
        this.carStatus = personBasicInfo.getCarStatus();
        this.expectedMarryTime = personBasicInfo.getExpectedMarryTime();
        this.personIntro = personBasicInfo.getPersonIntro();
        this.personSign = personBasicInfo.getPersonSign();
        this.location = personBasicInfo.getLatitude() + ", " + personBasicInfo.getLongitude();
        this.wechat = personBasicInfo.getWechat();
        this.wechatCodeImagesPath = personBasicInfo.getWechatCodeImagesPath();
        this.qq = personBasicInfo.getQq();
        this.email = personBasicInfo.getEmail();
    }
}
