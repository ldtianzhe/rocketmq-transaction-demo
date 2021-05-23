package com.xxx.points.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 积分消费者
 */
@Component
public class PointsConsumer {

    private static final String GROUP_NAME = "points-consumer-center";

    @Autowired
    private OrderListener orderListener;

    @PostConstruct
    public void init() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP_NAME);
        consumer.setNamesrvAddr("192.168.2.132:9876;192.168.2.133:9876");
        consumer.subscribe("order","*");
        consumer.registerMessageListener(orderListener);
        consumer.start();
    }

}
