package com.xxx.order.dao;

import com.xxx.common.domain.TransactionLog;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 事务日志表
 */
@Mapper
public interface TransactionLogMapper {

    /**
     * 插入事务日志
     *
     * @param transactionLog 事务日志实体
     * @return 结果
     */
    int insertTransactionLog(TransactionLog transactionLog);

    /**
     * 查询事务日志
     * @param transId 事务ID
     * @return
     */
    TransactionLog selectTransactionLogById(String transId);
}
