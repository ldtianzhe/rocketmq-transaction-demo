# rocketmq-transaction-demo

#### 介绍
基于RocketMQ实现分布式事务 - 完整示例代码

#### 软件架构
• 核心框架：Spring Boot v2.1.17.RELEASE, Spring v5.1.18.RELEASE
• 持久层框架：MyBatis 1.3.2
• 分页插件：Pagehelper 5.1.4
• JSON框架：Alibaba Fastjson 1.2.73


#### 事务流程
以经典的下单增加积分的场景为例子做分布式事务。
不只是简单的demo，考虑到一些异常情况、幂等性消费和死信队列等情况，尽量向可靠业务场景靠拢。

### 分布式事务流程
2PC方式达到最终一致性，同时提供人工干预处理。


