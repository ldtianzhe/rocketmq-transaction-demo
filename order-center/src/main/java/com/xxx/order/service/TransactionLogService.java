package com.xxx.order.service;

import com.xxx.order.dao.TransactionLogMapper;
import com.xxx.common.domain.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 事务日志
 */
@Service
public class TransactionLogService {

    @Autowired
    private TransactionLogMapper transactionLogMapper;

    public int insert(TransactionLog transactionLog){
        return transactionLogMapper.insertTransactionLog(transactionLog);
    }

    public TransactionLog getById(String transId) {
        return transactionLogMapper.selectTransactionLogById(transId);
    }
}
