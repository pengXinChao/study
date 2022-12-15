package com.person.gtech.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.person.gtech.dto.HubRequest;
import com.person.gtech.service.OrderService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 彭心潮
 * @date 2022/12/4 23:28
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private DefaultMQProducer defaultMQProducer;

    @Override
    public void createOrder(JSONObject orderIn) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        String orderCode = orderIn.getString("orderCode");

        HubRequest hubRequest = new HubRequest();
        hubRequest.setApiName("titan.fulfill.order.create");
        hubRequest.setPayload(JSON.toJSONString(orderIn));
        String requestJson = JSON.toJSONString(hubRequest);
        Message message = new Message("titan_fulfill_hub", null, orderCode, requestJson.getBytes());
        this.defaultMQProducer.send(message);
    }
}
