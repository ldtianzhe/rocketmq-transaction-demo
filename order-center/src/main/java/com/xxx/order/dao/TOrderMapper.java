package com.xxx.order.dao;

import com.xxx.common.domain.TOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description:
 */
@Mapper
public interface TOrderMapper {

    /**
     * 创建订单
     *
     * @param order 订单实体
     * @return 结果
     */
    int insertOrder(TOrder order);

    /**
     * 查询详情
     * @param orderId
     * @return
     */
    TOrder getOrderById(long orderId);
}
