package com.xxx.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 积分实体
 */
@Data
public class TPoints implements Serializable {

    private Long id;

    private Long userId;

    private Long orderNo;

    private Integer points;

    private String remarks;
}
