package com.person.gtech.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author 彭心潮
 * @date 2022/12/4 23:28
 */
public interface OrderService {

    void createOrder(JSONObject orderIn) throws MQBrokerException, RemotingException, InterruptedException, MQClientException;
}
