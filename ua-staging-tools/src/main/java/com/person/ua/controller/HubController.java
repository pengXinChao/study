package com.person.ua.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gtech.cloud.hub.client.ApiClient;
import com.gtech.cloud.hub.client.Request;
import com.gtech.cloud.hub.client.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 彭心潮
 * @date 2022/12/29 22:33
 */
@RestController
@Slf4j
public class HubController {

    @Resource
    private ApiClient apiClient;

    @PostMapping("/hub")
    public void hub() {
        JSONObject orderIn = this.getOrderIn();
        long start = System.currentTimeMillis();
        Request.Builder builder = new Request.Builder()
                .apiName("titan.fulfill.order.create")
                .version("1")
                .payload(orderIn.toString());
//        if (StringUtils.isNoneBlank(appId)){
            builder.header("X-Application", "fulfill");
//        }
        Request request = builder.build();
        Response<Object> resp = apiClient.execute(request, Object.class);
        log.info("创单结果:{}, 耗时:{}ms", resp.isSuccess(), System.currentTimeMillis() - start);
    }

    public JSONObject getOrderIn() {
        String orderIn = "{\n" +
                "\t\"orderPaymentIns\": [{\n" +
                "\t\t\"price\": 10.01,\n" +
                "\t\t\"payChannel\": \"支付宝\",\n" +
                "\t\t\"payMentType\": \"online\",\n" +
                "\t\t\"allComplete\": false,\n" +
                "\t\t\"payMent\": \"支付宝\",\n" +
                "\t\t\"currencyCode\": \"CNY\",\n" +
                "\t\t\"isSucceed\": \"1\"\n" +
                "\t}],\n" +
                "\t\"orderType\": \"11\",\n" +
                "\t\"domainCode\": \"DC0005\",\n" +
                "\t\"distributionType\": \"11\",\n" +
                "\t\"freight\": 10.00,\n" +
                "\t\"discount\": 119.99,\n" +
                "\t\"memberName\": \"晨阳0309\",\n" +
                "\t\"orderProductInList\": [{\n" +
                "\t\t\"skuName\": \"UA电子计数跳绳【兑】\",\n" +
                "\t\t\"image\": \"https://img.alicdn.com/bao/uploaded/i4/1940724523/O1CN011YoaV91jHaBUWASaO_!!0-item_pic.jpg\",\n" +
                "\t\t\"amount\": 0.01,\n" +
                "\t\t\"salePrice\": 120.00,\n" +
                "\t\t\"count\": 2,\n" +
                "\t\t\"orderItemCode\": \"1660138790614693702\",\n" +
                "\t\t\"isGift\": \"0\",\n" +
                "\t\t\"parentOrderItemCode\": \"1660138790614693702\",\n" +
                "\t\t\"skuCode\": \"191169560594\"\n" +
                "\t}],\n" +
                "\t\"payMentType\": \"online\",\n" +
                "\t\"appCode\": \"channel-qimen\",\n" +
                "\t\"tenantCode\": \"200005\",\n" +
                "\t\"orgCode\": \"10000036\",\n" +
                "\t\"tradeSource\": \"11\",\n" +
                "\t\"channelCode\": \"TMALL\",\n" +
                "\t\"memberCode\": \"AAHY6pZTAGx8JHtHtyXCiZlL\",\n" +
                "\t\"shopCode\": \"10000036\",\n" +
                "\t\"amount\": 10.01,\n" +
                "\t\"coupon\": 0,\n" +
                "\t\"crmMemberCode\": \"AAHY6pZTAGx8JHtHtyXCiZlL\",\n" +
                "\t\"orderReceiveInfoIn\": {\n" +
                "\t\t\"desensitizationName\": \"哪**\",\n" +
                "\t\t\"lastName\": \"哪**\",\n" +
                "\t\t\"address\": \"佘*镇青**路**弄佘**园茸达苑\",\n" +
                "\t\t\"cityName\": \"上海市\",\n" +
                "\t\t\"districtName\": \"松江区\",\n" +
                "\t\t\"desensitizationAddress\": \"佘*镇青**路**弄佘**园茸达苑\",\n" +
                "\t\t\"mobile\": \"*******5211\",\n" +
                "\t\t\"name\": \"哪**\",\n" +
                "\t\t\"desensitizationMobile\": \"*******5211\",\n" +
                "\t\t\"countryName\": \"中国\",\n" +
                "\t\t\"provinceName\": \"上海\",\n" +
                "\t\t\"addressId\": \"1Wkg4Lo7ufaS87UQ6CibZhEvibn4HqeiaUCt5oMpj97ibTh1hgf583sKmyEmfQebnjRUibKiarh35\"\n" +
                "\t},\n" +
                "\t\"tax\": 0,\n" +
                "\t\"payMent\": \"支付宝\",\n" +
                "\t\"orderActivityinfoInList\": [{\n" +
                "\t\t\"activityCode\": \"1\",\n" +
                "\t\t\"price\": 119.99,\n" +
                "\t\t\"sponsors\": \"SBU\",\n" +
                "\t\t\"activityTypeName\": \"品牌积分\",\n" +
                "\t\t\"activityName\": \"品牌积分\",\n" +
                "\t\t\"activityTypeCode\": \"1\"\n" +
                "\t}],\n" +
                "\t\"productAmount\": 240.00,\n" +
                "\t\"orderCode\": \"166013879061469380\",\n" +
                "\t\"currencyCode\": \"CNY\",\n" +
                "\t\"orderDate\": 1655295377000\n" +
                "}";

        return JSON.parseObject(orderIn);
    }
}
