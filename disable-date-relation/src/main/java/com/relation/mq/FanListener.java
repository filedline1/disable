package com.relation.mq;

import com.relation.common.FanRestClient;
import com.relation.constants.MqConstants;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 用 Work queue（设置两个队），工作队列，可以提高消息处理速度，避免队列消息堆积
 */
@Component
public class FanListener {

    @Autowired
    private FanRestClient fanRestClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 异步处理&MQ监听整合
     * @param Id
     */
    @RabbitListener(queues = MqConstants.FAN_INSERT_QUEUE)
    @Async
    public void listenRequirementInsertOrUpdate1(Integer Id) {
        if (Id != null){
            try {
                fanRestClient.InsertFanToIndexById(Integer.valueOf(Id));
            } catch (Exception e){
                logger.info("FanInsert Insert MQ 队列1 MQ出现异常异常！");
            }
            System.out.println("[FAN_INSERT_QUEUE队列1] 根据Id找出Fan并新增到索引库--->" + LocalTime.now());
            logger.info("Token时效队列 监听1（String） {} 中消息： {}",MqConstants.FAN_INSERT_QUEUE,Id);
        }
    }

    @RabbitListener(queues = MqConstants.FAN_INSERT_QUEUE)
    @Async
    public void listenRequirementInsertOrUpdate2(Integer Id) {
        if (Id != null){
            try {
                fanRestClient.InsertFanToIndexById(Integer.valueOf(Id));
            } catch (Exception e){
                logger.info("FanInsert Insert MQ 队列2 MQ出现异常异常！");
            }
            System.out.println("[FAN_INSERT_QUEUE队列1] 根据Id找出Fan并新增到索引库--->" + LocalTime.now());
            logger.info("Token时效队列 监听1（String） {} 中消息： {}",MqConstants.FAN_INSERT_QUEUE,Id);
        }
    }


    /**
     * 监听 动态的 删除 的业务
     * @param id
     */
    @RabbitListener(queues = MqConstants.FAN_DELETE_QUEUE)
    public void listenRequirementDelete1(Integer id){
        fanRestClient.deleteFanFromIndexById(id);
        System.out.println("[REQUIREMENT_INSERT_QUEUE队列1] 根据personId找出Requirement并从索引库删除--->" + LocalTime.now());
        logger.info("Token时效队列 监听1（String） {} 中消息： {}",MqConstants.FAN_DELETE_KEY,id);
    }

    /**
     * 监听 动态的 删除 的业务
     * @param id
     */
    @RabbitListener(queues = MqConstants.FAN_DELETE_QUEUE)
    public void listenRequirementDelete2(Integer id){
        fanRestClient.deleteFanFromIndexById(id);
        System.out.println("[REQUIREMENT_INSERT_QUEUE队列2] 根据personId找出Requirement并从索引库删除--->" + LocalTime.now());
        logger.info("Token时效队列 监听2（String） {} 中消息： {}",MqConstants.FAN_DELETE_KEY,id);
    }



}
