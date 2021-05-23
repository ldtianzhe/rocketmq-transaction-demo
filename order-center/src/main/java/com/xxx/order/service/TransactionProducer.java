package com.xxx.order.service;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 事务生产
 */
@Component
public class TransactionProducer {

    private static final String GROUP_NAME = "order_trans_group";

    private TransactionMQProducer producer;

    @Autowired
    private OrderTransactionListener orderTransactionListener;

    //执行任务的线程池
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));

    @PostConstruct
    public void init(){
        producer = new TransactionMQProducer(GROUP_NAME);
        producer.setNamesrvAddr("192.168.2.132:9876;192.168.2.133:9876");
        producer.setSendMsgTimeout(100);
        producer.setExecutorService(executor);
        producer.setTransactionListener(orderTransactionListener);
        this.start();
    }

    private void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务消息发送
     * @param data
     * @param topic
     * @return
     */
    public TransactionSendResult send(String data, String topic) throws MQClientException {
        Message message = new Message(topic, data.getBytes());
        return producer.sendMessageInTransaction(message, null);
    }

}
