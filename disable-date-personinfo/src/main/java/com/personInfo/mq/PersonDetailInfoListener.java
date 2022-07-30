package com.personInfo.mq;

import com.personInfo.common.PersonDetailInfoRestClient;
import com.personInfo.constants.MqConstants;
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
public class PersonDetailInfoListener {

    @Autowired
    private PersonDetailInfoRestClient personDetailInfoRestClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 异步处理&MQ监听整合
     * @param personId
     */
    @RabbitListener(queues = MqConstants.PERSON_DETAIL_INFO_INSERT_QUEUE)
    @Async
    public void listenRequirementInsertOrUpdate1(Integer personId) {          //队列1
        if (personId != null){
            try {
                personDetailInfoRestClient.InsertPersonDetailInfoToIndexByPersonId(personId);
            } catch (Exception e){
                logger.info("PersonDetailInfo Insert MQ 队列1 MQ出现异常异常！");
            }
            System.out.println("[PERSON_DETAIL_INFO_INSERT_QUEUE队列1] 根据personId找出PersonDetailInfo并新增到索引库--->" + LocalTime.now());
            logger.info("Token时效队列 监听1（Integer） {} 中消息： {}",MqConstants.PERSON_DETAIL_INFO_INSERT_QUEUE,personId);
        }
    }

    @RabbitListener(queues = MqConstants.PERSON_DETAIL_INFO_INSERT_QUEUE)
    @Async
    public void listenRequirementInsertOrUpdate2(Integer personId) {          //队列1
        if (personId != null){
            try {
                personDetailInfoRestClient.InsertPersonDetailInfoToIndexByPersonId(personId);
            } catch (Exception e){
                logger.info("PersonDetailInfo Insert MQ 队列2 MQ出现异常异常！");
            }
            System.out.println("[PERSON_DETAIL_INFO_INSERT_QUEUE队列2] 根据personId找出PersonDetailInfo并新增到索引库--->" + LocalTime.now());
            logger.info("Token时效队列 监听1（Integer） {} 中消息： {}",MqConstants.PERSON_DETAIL_INFO_INSERT_QUEUE,personId);
        }
    }


    /**
     * 监听 动态的 删除 的业务
     * @param id
     */
    @RabbitListener(queues = MqConstants.PERSON_DETAIL_INFO_DELETE_QUEUE)
    public void listenRequirementDelete1(Integer id){
        personDetailInfoRestClient.deletePersonBasicInfoFromIndexById(id);
        System.out.println("[PERSON_DETAIL_INFO_DELETE_QUEUE队列1] 根据personId找出personBasicInfo并从索引库删除--->" + LocalTime.now());
        logger.info("Token时效队列 监听1（String） {} 中消息： {}",MqConstants.PERSON_DETAIL_INFO_DELETE_QUEUE,id);
    }

    /**
     * 监听 动态的 删除 的业务
     * @param id
     */
    @RabbitListener(queues = MqConstants.PERSON_DETAIL_INFO_DELETE_QUEUE)
    public void listenRequirementDelete2(Integer id){
        personDetailInfoRestClient.deletePersonBasicInfoFromIndexById(id);
        System.out.println("[PERSON_DETAIL_INFO_DELETE_QUEUE队列2] 根据personId找出personBasicInfo并从索引库删除--->" + LocalTime.now());
        logger.info("Token时效队列 监听2（String） {} 中消息： {}",MqConstants.PERSON_DETAIL_INFO_DELETE_QUEUE,id);
    }



}
