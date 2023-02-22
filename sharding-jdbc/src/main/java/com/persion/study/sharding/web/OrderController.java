package com.persion.study.sharding.web;

import com.persion.study.sharding.dao.entry.OrderStatusChange;
import com.persion.study.sharding.service.OrderStatusChangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 彭心潮
 * @date 2022/10/15 16:10
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderStatusChangeService orderStatusChangeService;

    @PostMapping("/log/save")
    public OrderStatusChange save() {
        OrderStatusChange orderStatusChange = new OrderStatusChange();
        orderStatusChange.setDomainCode("DC0005");
        orderStatusChange.setTenantCode("200005");
        orderStatusChange.setOrgCode("1000001");
        orderStatusChange.setOrderCode("order_code");
        orderStatusChange.setBizDocNo(String.valueOf(System.currentTimeMillis()));
        orderStatusChange.setType("11");
        orderStatusChange.setExStatus("0");
        orderStatusChange.setStatus("1");
        orderStatusChange.setIsValid("1");
        orderStatusChange.setUserCode("user");
        orderStatusChange.setUserName("user");
        this.orderStatusChangeService.save(orderStatusChange);
        return orderStatusChange;
    }
}
