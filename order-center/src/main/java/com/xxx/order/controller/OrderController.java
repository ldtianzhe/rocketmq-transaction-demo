package com.xxx.order.controller;

import com.xxx.common.domain.TOrder;
import com.xxx.common.utils.RandomValueUtils;
import com.xxx.common.utils.SnowFlakeIdWorker;
import com.xxx.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 订单入口
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public void createOrder(@RequestBody TOrder order) throws MQClientException {
        // 模拟压测
        SnowFlakeIdWorker idWorker = new SnowFlakeIdWorker(0, 0);
        long id = idWorker.nextId();
        order.setOrderId(id);
        order.setCreateTime(LocalDateTime.now());
        order.setUserId(2020L);
        order.setAmount(RandomValueUtils.randomPrice());
        log.info("接收到订单数据：{}",order.toString());
        orderService.insertOrder(order);
    }

    @GetMapping("/{orderId}")
    public TOrder getOrderById(@PathVariable String orderId) {
        return  orderService.getOrderById(Long.parseLong(orderId));
    }
}
