package com.xxx.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 事务日志DAO
 */
@Data
public class TransactionLog implements Serializable {

    private String id;

    private String business;

    private String foreignKey;
}
