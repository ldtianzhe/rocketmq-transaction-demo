package com.xxx.points.service;

import com.xxx.common.domain.TOrder;
import com.xxx.common.domain.TPoints;
import com.xxx.points.dao.TPointsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 积分业务
 */
@Service
@Slf4j
public class PointsService {

    @Autowired
    private TPointsMapper tPointsMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(TOrder order){
        //入库之前先查询，实现幂等
        TPoints tPoints = getPointsByOrderId(order.getOrderId());
        if (null != tPoints){
            log.info("积分添加完成，订单已处理。{}", order.getOrderId());
        }else{
            tPoints = new TPoints();
            tPoints.setOrderNo(order.getOrderId());
            tPoints.setUserId(order.getUserId());
            BigDecimal amount = order.getAmount();
            tPoints.setPoints((amount.intValue() * 10));
            tPoints.setRemarks("商品消费共【"+order.getAmount()+"】元，获得积分"+tPoints.getPoints());
            tPointsMapper.insertTPoints(tPoints);
            log.info("已为订单号码{}增加积分。",tPoints.getOrderNo());
        }

    }

    public TPoints getPointsByOrderId(long orderId) {
        return tPointsMapper.selectTPointsById(orderId);
    }
}
