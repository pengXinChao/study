package com.person.gtech.controller;

import com.alibaba.fastjson.JSONObject;
import com.person.gtech.dto.CreateOrderDTO;
import com.person.gtech.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭心潮
 * @date 2022/12/4 23:29
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody CreateOrderDTO createParam) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        List<String> orderCodes = this.getOrderCodes(createParam.getCreateQty());
        JSONObject orderIn = createParam.getOrderIn();
        long startTime = System.currentTimeMillis();
        for (String orderCode : orderCodes) {
            orderIn.put("orderCode", orderCode);
            this.orderService.createOrder(orderIn);
        }
        log.info("发送{}个创单MQ消息耗时:{}ms", createParam.getCreateQty(), System.currentTimeMillis() - startTime);
    }

    private List<String> getOrderCodes(int qty) {
        long timestamp = System.currentTimeMillis();
        List<String> result = new ArrayList<>(qty);
        for (int i = 0; i < qty; i++) {
            timestamp = timestamp + 1;
            result.add(timestamp + "");
        }
        return result;
    }
}
