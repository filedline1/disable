package com.relation.constants;

/**
 * @author Mr.Jiang
 * @version 1.0
 * 定义交换机的常量
 **/
public class MqConstants {

    /**
     * 交换机
     */
    public final static String FAN_EXCHANGE = "fan.topic";

    /**
     * 监听新增和修改的队列
     */
    public final static String FAN_INSERT_QUEUE = "fan.insert.queue";

    /**
     * 监听删除的队列
     */
    public final static String FAN_DELETE_QUEUE = "fan.delete.queue";

    /**
     * 新增或修改的RoutingKey
     */
    public final static String FAN_INSERT_KEY = "fan.insert";

    /**
     * 删除的RoutingKey
     */
    public final static String FAN_DELETE_KEY = "fan.delete";


    /**
     * 交换机
     */
    public final static String FOLLOW_EXCHANGE = "follow.topic";

    /**
     * 监听新增和修改的队列
     */
    public final static String FOLLOW_INSERT_QUEUE = "follow.insert.queue";

    /**
     * 监听删除的队列
     */
    public final static String FOLLOW_DELETE_QUEUE = "follow.delete.queue";

    /**
     * 新增或修改的RoutingKey
     */
    public final static String FOLLOW_INSERT_KEY = "follow.insert";

    /**
     * 删除的RoutingKey
     */
    public final static String FOLLOW_DELETE_KEY = "follow.delete";


}
