package com.xxx.common.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 订单DAO
 */
@Data
public class TOrder implements Serializable {

    private Long orderId;

    private LocalDateTime createTime;

    private Long userId;

    private BigDecimal amount;
}
