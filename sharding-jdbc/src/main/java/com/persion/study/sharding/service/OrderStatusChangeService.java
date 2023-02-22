package com.persion.study.sharding.service;

import com.persion.study.sharding.dao.entry.OrderStatusChange;

/**
 * @author 彭心潮
 * @date 2023/1/1 0:31
 */
public interface OrderStatusChangeService {

    void save(OrderStatusChange orderStatusLog);
}
