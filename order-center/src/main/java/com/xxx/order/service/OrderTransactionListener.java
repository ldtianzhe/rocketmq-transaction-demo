package com.xxx.order.service;

import com.alibaba.fastjson.JSONObject;
import com.xxx.common.domain.TOrder;
import com.xxx.common.domain.TransactionLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 订单事务监听类
 */
@Component
@Slf4j
public class OrderTransactionListener implements TransactionListener {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TransactionLogService transactionLogService;

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("开始执行本地事务....");
        LocalTransactionState state = null;
        try {
            String body = new String(message.getBody());
            TOrder tOrder = JSONObject.parseObject(body, TOrder.class);
            // 执行本地事务
            orderService.insertOrder(tOrder, message.getTransactionId());
            state = LocalTransactionState.COMMIT_MESSAGE;
            log.info("本地事务已提交。{}", message.getTransactionId());
        }catch (Exception e){
            log.error("执行本地事务失败。{}", e.getMessage());
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        log.info("开始回查本地事务....");
        LocalTransactionState state = null;
        String transId = messageExt.getTransactionId();
        // 如果本地事务存在，则事务提交成功
        TransactionLog transactionLog = transactionLogService.getById(transId);
        if (null != transactionLog){
            state = LocalTransactionState.COMMIT_MESSAGE;
        }else{
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }
}
