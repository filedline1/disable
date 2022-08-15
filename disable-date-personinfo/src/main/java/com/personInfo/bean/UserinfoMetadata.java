package com.personInfo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户信息元数据
 *
 * @author chunming
 * @date 2022-08-07 20:57:38
 */
@Data
@TableName("tb_disable_date_userinfo_metadata")
public class UserinfoMetadata {
    /**
     * 姓名
     */
    private String name;
    /**
     * 残疾证号
     */
    private String disabilityCardNumber;
    /**
     * 残疾类型
     */
    private String disabilityType;
    /**
     * 残疾等级
     */
    private String disabilityLevel;
    /**
     * 年龄
     */
    private String age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 户口性质
     */
    private String householdNature;
    /**
     * R3 婚姻状况
     */
    private String r3;
    /**
     * R4 联系人姓名
     */
    private String r4;
    /**
     * 手机
     */
    private String cellPhone;
    /**
     * R6 是否在敬（养）老院、福利院、荣军院居住
     */
    private String r6;
    /**
     * R7 家庭住房状况
     */
    private String r7;
    /**
     * R7 4.1 农村危房
     */
    private String r741;
    /**
     * R8 受教育程度
     */
    private String r8;
    /**
     * R9 是否就业
     */
    private String r9;
    /**
     * R10 未就业主要生活来源
     */
    private String r10;
    /**
     * R11 目前就业帮扶需求
     */
    private String r11;
    /**
     * R12 参加职工社会保险情况
     */
    private String r12;
    /**
     * R13 是否参加城乡居民基本医疗保险
     */
    private String r13;
    /**
     * R14 是否享受基本医疗保险个人缴费补贴
     */
    private String r14;
    /**
     * R15 过去一年内社会救助及住房改善情况
     */
    private String r15;
    /**
     * R16 目前托养服务需求
     */
    private String r16;
    /**
     * R17 残疾人养老服务—服务现状
     */
    private String r17;
    /**
     * R18 残疾人养老服务—服务需求
     */
    private String r18;
    /**
     * R19 以老养残家庭基本情况1-2
     */
    private String r19;
    /**
     * R19 以老养残家庭基本情况3-4
     */
    private String r193;
    /**
     * R20 个人或家庭是否签订家庭医生服务协议
     */
    private String r20;
    /**
     * R21 针对自身残疾，过去一年内是否得到过以下服务
     */
    private String r21;
    /**
     * R22 针对自身残疾，目前是否还需要以下服务
     */
    private String r22;
    /**
     * R23 过去一年内您家是否进行过无障碍改造
     */
    private String r23;
    /**
     * R24 过去一年内您家进行过的无障碍改造项目
     */
    private String r24;
    /**
     * R25 目前您家有哪些无障碍改造需求
     */
    private String r25;
    /**
     * R26 过去一年内是否经常参加文化体育活动
     */
    private String r26;
    /**
     * R27 不能经常参加文化体育活动的原因
     */
    private String r27;
    /**
     * 户主姓名
     */
    private String householder;
    /**
     * 户主身份证号
     */
    private String headOfHouseholdIdNumber;
    /**
     * 申报人
     */
    private String declarer;
    /**
     * 信息采集员
     */
    private String informationCollector;
    /**
     * 填表日期
     */
    private String dateOfFillingOutTheForm;
    /**
     * 区划地址
     */
    private String districtAddress;
    /**
     * 街道
     */
    private String street;
}
