package com.xxx.points.dao;

import com.xxx.common.domain.TPoints;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 积分DAO
 */
@Mapper
public interface TPointsMapper {
    /**
     * 插入积分
     *
     * @param tPoints 积分实体
     * @return 结果
     */
    int insertTPoints(TPoints tPoints);

    /**
     * 根据订单查积分记录
     *
     * @param orderNo
     * @return 结果
     */
    TPoints selectTPointsById(Long orderNo);
}
