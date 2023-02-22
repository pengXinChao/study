package com.persion.study.sharding.service.impl;

import com.persion.study.sharding.dao.entry.OrderStatusChange;
import com.persion.study.sharding.dao.mapper.OrderStatusChangeMapper;
import com.persion.study.sharding.service.OrderStatusChangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 彭心潮
 * @date 2023/1/1 0:32
 */
@Service
public class OrderStatusChangeServiceImpl implements OrderStatusChangeService {

    @Resource
    private OrderStatusChangeMapper orderStatusChangeMapper;
    @Override
    public void save(OrderStatusChange orderStatusLog) {
        this.orderStatusChangeMapper.insert(orderStatusLog);
    }
}
