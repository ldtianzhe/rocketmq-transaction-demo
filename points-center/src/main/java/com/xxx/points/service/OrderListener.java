package com.xxx.points.service;

import com.alibaba.fastjson.JSONObject;
import com.xxx.common.domain.TOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 订单监听器
 */
@Component
@Slf4j
public class OrderListener implements MessageListenerConcurrently {

    @Autowired
    private PointsService pointsService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        log.info("消费者线程监听到消息。");
        for (MessageExt messageExt: list){
            if (!processor(messageExt)){
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    /**
     * 消息处理，第3次处理失败后，发送邮件通知人工介入
     * @param messageExt
     * @return
     */
    private boolean processor(MessageExt messageExt){
        String body = new String(messageExt.getBody());
        try{
            log.info("消息处理...{}", body);
            log.info("开始处理订单数据，准备增加积分....");
            TOrder order  = JSONObject.parseObject(body, TOrder.class);
            pointsService.insert(order);
            // 模拟异常
            //int k = 1/0;
            return true;
        }catch (Exception e){
            if (messageExt.getReconsumeTimes() >= 3){
                log.error("消息重试已达最大次数，将通知业务人员排查问题。{}",messageExt.getMsgId());
                // 发送邮件或者报警
                // sendMail(messageExt);
                return true;
            }
            return false;
        }

    }
}
