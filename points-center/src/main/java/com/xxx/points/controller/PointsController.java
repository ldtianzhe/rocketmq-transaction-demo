package com.xxx.points.controller;

import com.xxx.common.domain.TPoints;
import com.xxx.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author: ldtianzhe
 * @CreateTime: 2021-05-22
 * @Description: 积分入口
 */
@RestController
@RequestMapping("/points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @GetMapping("/{orderId}")
    public TPoints getPointsByOrderId(@PathVariable String orderId) {
        return pointsService.getPointsByOrderId(Long.parseLong(orderId));
    }
}
