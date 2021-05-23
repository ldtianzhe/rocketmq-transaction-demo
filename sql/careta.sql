-- 积分系统
CREATE DATABASE rocketmq-demo-points;
DROP TABLE IF EXISTS `t_points`;
CREATE TABLE `t_points` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `user_id` bigint(20) NOT NULL COMMENT '用户ID',
                            `order_no` bigint(20) NOT NULL COMMENT '订单编号',
                            `points` int(5) NOT NULL COMMENT '积分',
                            `remarks` varchar(128) NOT NULL DEFAULT '无' COMMENT '备注',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='积分表';

SET FOREIGN_KEY_CHECKS = 1;

-- 订单系统
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
                           `order_id` bigint(20) NOT NULL COMMENT '订单编号',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `user_id` bigint(20) NOT NULL COMMENT '用户ID',
                           `amount` decimal(18,2) NOT NULL COMMENT '订单金额',
                           PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE `transaction_log` (
                                   `id` varchar(32) NOT NULL COMMENT '事务ID',
                                   `business` varchar(32) NOT NULL COMMENT '业务标识',
                                   `foreign_key` varchar(32) NOT NULL COMMENT '对应业务表中的主键',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='事务日志表';

SET FOREIGN_KEY_CHECKS = 1;

