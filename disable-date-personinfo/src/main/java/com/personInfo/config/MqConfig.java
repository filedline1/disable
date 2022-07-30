package com.personInfo.config;

import com.personInfo.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Jiang
 * @version 1.0
 **/

@Configuration
public class MqConfig {
    //实现交换机的定义
    @Bean
    public TopicExchange RequirementTopicExchange(){
        //true:持久化
        return new TopicExchange(MqConstants.REQUIREMENT_EXCHANGE,true,false);
    }

    //定义两个队列
    @Bean
    public Queue RequirementInsertQueue(){
        return new Queue(MqConstants.REQUIREMENT_INSERT_QUEUE,true);
    }

    @Bean
    public Queue RequirementDeleteQueue(){
        return new Queue(MqConstants.REQUIREMENT_DELETE_QUEUE,true);
    }

    //定义绑定关系
    @Bean
    public Binding RequirementInsertQueueBinding(){
//                            绑定     队列         到    交换机                        用的RoutingKey
        return BindingBuilder.bind(RequirementInsertQueue()).to(RequirementTopicExchange()).with(MqConstants.REQUIREMENT_INSERT_KEY);
    }

    @Bean
    public Binding RequirementDeleteQueueBinding(){
//                            绑定     队列         到    交换机                        用的RoutingKey
        return BindingBuilder.bind(RequirementDeleteQueue()).to(RequirementTopicExchange()).with(MqConstants.REQUIREMENT_DELETE_KEY);
    }

    //实现交换机的定义
    @Bean
    public TopicExchange PersonBasicInfoTopicExchange(){       //             true:持久化
        return new TopicExchange(MqConstants.PERSON_BASIC_INFO_EXCHANGE,true,false);
    }

    //定义两个队列
    @Bean
    public Queue PersonBasicInfoTopicInsertQueue(){
        return new Queue(MqConstants.PERSON_BASIC_INFO_INSERT_QUEUE,true);
    }

    @Bean
    public Queue PersonBasicInfoTopicDeleteQueue(){
        return new Queue(MqConstants.PERSON_BASIC_INFO_DELETE_QUEUE,true);
    }

    //定义绑定关系
    @Bean
    public Binding PersonBasicInfoTopicInsertQueueBinding(){
        return BindingBuilder.bind(PersonBasicInfoTopicInsertQueue()).to(PersonBasicInfoTopicExchange()).with(MqConstants.PERSON_BASIC_INFO_INSERT_KEY);
    }

    @Bean
    public Binding PersonBasicInfoTopicDeleteQueueBinding(){
        return BindingBuilder.bind(PersonBasicInfoTopicDeleteQueue()).to(PersonBasicInfoTopicExchange()).with(MqConstants.PERSON_BASIC_INFO_DELETE_KEY);
    }



    //实现交换机的定义
    @Bean
    public TopicExchange PersonDetailInfoTopicExchange(){       //             true:持久化
        return new TopicExchange(MqConstants.PERSON_DETAIL_INFO_EXCHANGE,true,false);
    }

    //定义两个队列
    @Bean
    public Queue PersonDetailInfoInsertQueue(){
        return new Queue(MqConstants.PERSON_DETAIL_INFO_INSERT_QUEUE,true);
    }

    @Bean
    public Queue PersonDetailInfoDeleteQueue(){
        return new Queue(MqConstants.PERSON_DETAIL_INFO_DELETE_QUEUE,true);
    }

    //定义绑定关系
    @Bean
    public Binding PersonDetailInfoInsertQueueBinding(){
        return BindingBuilder.bind(PersonDetailInfoInsertQueue()).to(PersonDetailInfoTopicExchange()).with(MqConstants.PERSON_DETAIL_INFO_INSERT_KEY);
    }

    @Bean
    public Binding PersonDetailInfoDeleteQueueBinding(){
        return BindingBuilder.bind(PersonDetailInfoDeleteQueue()).to(PersonDetailInfoTopicExchange()).with(MqConstants.PERSON_DETAIL_INFO_DELETE_KEY);
    }


}
