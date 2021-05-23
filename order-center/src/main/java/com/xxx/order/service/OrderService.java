package com.xxx.order.service;

import com.alibaba.fastjson.JSON;
import com.xxx.order.dao.TOrderMapper;
import com.xxx.order.dao.TransactionLogMapper;
import com.xxx.common.domain.TOrder;
import com.xxx.common.domain.TransactionLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 订单
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private TransactionLogMapper transactionLogMapper;

    @Autowired
    private TransactionProducer producer;


    /**
     * 前端接口触发插入订单的方法
     * @param order
     * @return
     */
    public void insertOrder(TOrder order) throws MQClientException {
        producer.send(JSON.toJSONString(order), "order");
    }

    /**
     * 本地事务插入方法
     * @param order
     * @param transId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertOrder(TOrder order, String transId)  {
        // 插入订单
        orderMapper.insertOrder(order);
        // 插入事务日志
        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setId(transId);
        transactionLog.setBusiness("order");
        transactionLog.setForeignKey(String.valueOf(order.getOrderId()));
        transactionLogMapper.insertTransactionLog(transactionLog);
        log.info("订单创建完成: {}", order.toString());
    }

    /**
     * 根据订单ID查询详情
     * @param orderId
     * @return
     */
    public TOrder getOrderById(long orderId) {
        return orderMapper.getOrderById(orderId);
    }
}
