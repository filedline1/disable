package com.personInfo.constants;

/**
 * @author Mr.Jiang
 * @version 1.0
 * 定义交换机的常量
 **/
public class MqConstants {

    /**
     * 交换机
     */
    public final static String REQUIREMENT_EXCHANGE = "requirement.topic";

    /**
     * 监听新增和修改的队列
     */
    public final static String REQUIREMENT_INSERT_QUEUE = "requirement.insert.queue";

    /**
     * 监听删除的队列
     */
    public final static String REQUIREMENT_DELETE_QUEUE = "requirement.delete.queue";

    /**
     * 新增或修改的RoutingKey
     */
    public final static String REQUIREMENT_INSERT_KEY = "requirement.insert";

    /**
     * 删除的RoutingKey
     */
    public final static String REQUIREMENT_DELETE_KEY = "requirement.delete";


    /**
     * 交换机
     */
    public final static String PERSON_BASIC_INFO_EXCHANGE = "personbasicinfo.topic";

    /**
     * 监听新增和修改的队列
     */
    public final static String PERSON_BASIC_INFO_INSERT_QUEUE = "personbasicinfo.insert.queue";

    /**
     * 监听删除的队列
     */
    public final static String PERSON_BASIC_INFO_DELETE_QUEUE = "personbasicinfo.delete.queue";

    /**
     * 新增或修改的RoutingKey
     */
    public final static String PERSON_BASIC_INFO_INSERT_KEY = "personbasicinfo.insert";

    /**
     * 删除的RoutingKey
     */
    public final static String PERSON_BASIC_INFO_DELETE_KEY = "personbasicinfo.delete";

    /**
     * 交换机
     */
    public final static String PERSON_DETAIL_INFO_EXCHANGE = "persondetailinfo.topic";

    /**
     * 监听新增和修改的队列
     */
    public final static String PERSON_DETAIL_INFO_INSERT_QUEUE = "persondetailinfo.insert.queue";

    /**
     * 监听删除的队列
     */
    public final static String PERSON_DETAIL_INFO_DELETE_QUEUE = "persondetailinfo.delete.queue";

    /**
     * 新增或修改的RoutingKey
     */
    public final static String PERSON_DETAIL_INFO_INSERT_KEY = "persondetailinfo.insert";

    /**
     * 删除的RoutingKey
     */
    public final static String PERSON_DETAIL_INFO_DELETE_KEY = "persondetailinfo.delete";


}
