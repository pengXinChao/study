package com.person.ua.controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.person.ua.dao.mapper.InventoryStockMapper;
import com.person.ua.dao.mapper.TDeliveryOrderItemMapper;
import com.person.ua.dao.mapper.TDeliveryOrderMapper;
import com.person.ua.dao.mapper.TDeliveryOrderNotifyMapper;
import com.person.ua.dao.mapper.TDeliveryOrderReceiverMapper;
import com.person.ua.dao.mapper.TFulfillDeliveryOrderItemMapper;
import com.person.ua.dao.mapper.TFulfillDeliveryOrderMapper;
import com.person.ua.dao.mapper.TOrderInterfaceSendRecordMapper;
import com.person.ua.dao.mapper.TOrderOrderMapper;
import com.person.ua.dao.mapper.TOrderPaymentMapper;
import com.person.ua.dao.mapper.TOrderProductMapper;
import com.person.ua.dao.mapper.TOrderReceiveMapper;
import com.person.ua.dao.mapper.TOrderStatusChangeMapper;
import com.person.ua.dao.mapper.TRouteOrderItemMapper;
import com.person.ua.dao.mapper.TRouteOrderMapper;
import com.person.ua.utils.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 彭心潮
 * @date 2022/12/28 17:38
 */
@RestController
@Slf4j
public class YcDataController {

    @Resource
    private TOrderOrderMapper orderMapper;

    @Resource
    private TFulfillDeliveryOrderMapper deliveryOrderMapper;

    @Resource
    private TFulfillDeliveryOrderItemMapper deliveryOrderItemMapper;

    @Resource
    private TOrderPaymentMapper orderPaymentMapper;

    @Resource
    private TOrderReceiveMapper orderReceiveMapper;

    @Resource
    private TOrderProductMapper orderProductMapper;

    @Resource
    private TOrderInterfaceSendRecordMapper orderInterfaceSendRecordMapper;

    @Resource
    private TOrderStatusChangeMapper orderStatusChangeMapper;

    @Resource
    private TRouteOrderMapper routeOrderMapper;

    @Resource
    private TRouteOrderItemMapper routeOrderItemMapper;

    private static final ThreadPoolExecutor HANDLE_TASK_POOL_EXECUTOR;

    static {
        ThreadFactory handleTaskThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("handle-task-pool-%d")
                .build();
        HANDLE_TASK_POOL_EXECUTOR = new ThreadPoolExecutor(4, 20,
                120L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10), handleTaskThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void main(String[] args) {
        System.out.println("#2xN1EeUigvi5iw5xOVO8BVRnrx0kYoE+YmvsHzLo#vZXlfQBiX1GgS5UfFqIkI2ckp+gwaKCyuDzIm7tlyOBBuTSgrWiU+JB+xeHTMqiAwEN6IIR/BzwIG+Q6/Qns04GLeytJXJjIsmYe8KHIkzNf0rTuqe9xJUhgOWI9aLT0Kjp5IYo=*CgkIARCtHCABKAESPgo8DN4o8oX5dEf6g3EL1ULC8XYDyKtx00ByjTmHmfS+qyYi0PI6sx8kjTVgpXo7f2Wpt3dK4APcMHkXs3q6GgA=#1##".length());
    }

    @PostMapping("/yc/delete")
    public void deleteYcData() {
        String memberCode = "AAFu6pZTAGx8JHlHtyaNEXYy";
        List<String> orderCodeList = this.orderMapper.selectAllByMemberCode(memberCode);
        List<List<String>> orderCodeGroupList = ListUtil.splitList(orderCodeList, 1000);

        System.out.println(orderCodeGroupList.size());

        int i = 1;
        for (List<String> orderCodes : orderCodeGroupList) {
            log.info("开始删除第{}批数据", i);
            HANDLE_TASK_POOL_EXECUTOR.execute(() -> this.deleteByOrderCodes(orderCodes));
            i++;
        }
    }

    @PostMapping("/yc/pos/delete")
    public void deleteYcPosData() {
        List<String> memberCodes = Arrays.asList("10200714101043", "jd_7b4beb925f97e");

        for (String memberCode : memberCodes) {
            List<String> orderCodeList = this.posOrderMapper.selectAllByMemberCode(memberCode);
            List<List<String>> orderCodeGroupList = ListUtil.splitList(orderCodeList, 1000);

            System.out.println(orderCodeGroupList.size());

            int i = 1;
            for (List<String> orderCodes : orderCodeGroupList) {
                log.info("开始删除第{}批数据", i);
                HANDLE_TASK_POOL_EXECUTOR.execute(() ->
                        this.deletePosByOrderCodes(orderCodes)
                );
                i++;
            }
        }

    }

    @PostMapping("deleteRouteOrder")
    public void deleteRouteData() {
        HANDLE_TASK_POOL_EXECUTOR.execute(this::deleteRouteOrder);
        HANDLE_TASK_POOL_EXECUTOR.execute(this::deleteRouteOrderItem);
    }

    @Resource
    private InventoryStockMapper inventoryStockMapper;

    @PostMapping("deleteSkuStock")
    public void deleteSkuStock() throws IOException {
        File file = new File("D:\\Person Develop\\study\\ua-staging-tools\\src\\main\\resources\\sku.txt");

        if (file.isFile() && file.exists()) {

            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");

            BufferedReader bufferedReader = new BufferedReader(read);

            String lineTxt;

            while ((lineTxt = bufferedReader.readLine()) != null) {

                System.out.println("删除" + lineTxt);
                this.inventoryStockMapper.deleteBySku(lineTxt);

            }

            read.close();

        } else {

            System.out.println("找不到指定的文件");

        }
    }

    private void deleteRouteOrder() {
        boolean hasMore = true;
        int pageNo = 1;
        do {
            log.info("开始查询并删除routeOrder, pageNo:{}", pageNo);
            List<Long> ids = this.routeOrderMapper.queryIdList(1000);
            this.routeOrderMapper.deleteByIds(ids);
            pageNo++;
            if (ids.size() != 1000) {
                hasMore = false;
            }
        } while (hasMore);
    }

    private void deleteRouteOrderItem() {
        boolean hasMore = true;
        int pageNo = 1;
        do {
            log.info("开始查询并删除routeOrder明细, pageNo:{}", pageNo);
            List<Long> itemIds = this.routeOrderItemMapper.queryIdList(1000);
            this.routeOrderItemMapper.deleteByIds(itemIds);
            pageNo++;
            if (itemIds.size() != 1000) {
                hasMore = false;
            }
        } while (hasMore);
    }

    @Resource
    private TDeliveryOrderMapper posOrderMapper;
    @Resource
    private TDeliveryOrderItemMapper posItemMapper;
    @Resource
    private TDeliveryOrderNotifyMapper posNotifyMapper;
    @Resource
    private TDeliveryOrderReceiverMapper posReceiverMapper;

    private void deletePosByOrderCodes(List<String> orderCodes) {
        List<Long> receiverIds = this.posReceiverMapper.selectId(orderCodes);
        List<Long> doItemIds = this.posItemMapper.selectId(orderCodes);
        List<Long> logIds = this.posNotifyMapper.selectId(orderCodes);


        if (!CollectionUtils.isEmpty(receiverIds)) {
            this.posReceiverMapper.deleteByIds(receiverIds);
        }

        if (!CollectionUtils.isEmpty(doItemIds)) {
            this.posItemMapper.deleteByIds(doItemIds);
        }

        if (!CollectionUtils.isEmpty(logIds)) {
            this.posNotifyMapper.deleteByIds(logIds);
        }

        if (!CollectionUtils.isEmpty(orderCodes)) {
            this.posOrderMapper.deleteByOrderCodes(orderCodes);
        }
    }

    private void deleteByOrderCodes(List<String> orderCodes) {
        List<Long> paymentIds = this.orderPaymentMapper.selectId(orderCodes);
        List<Long> receiverIds = this.orderReceiveMapper.selectId(orderCodes);
        List<Long> productIds = this.orderProductMapper.selectId(orderCodes);
        List<Long> sendRecordIds = this.orderInterfaceSendRecordMapper.selectId(orderCodes);
        List<Long> doIds = this.deliveryOrderMapper.selectId(orderCodes);
        List<Long> doItemIds = this.deliveryOrderItemMapper.selectId(orderCodes);
        List<Long> logIds = this.orderStatusChangeMapper.selectId(orderCodes);

        if (!CollectionUtils.isEmpty(paymentIds)) {
            orderPaymentMapper.deleteByIds(paymentIds);
        }

        if (!CollectionUtils.isEmpty(receiverIds)) {
            this.orderReceiveMapper.deleteByIds(receiverIds);
        }
        if (!CollectionUtils.isEmpty(productIds)) {
            this.orderProductMapper.deleteByIds(productIds);
        }

        if (!CollectionUtils.isEmpty(sendRecordIds)) {
            this.orderInterfaceSendRecordMapper.deleteByIds(sendRecordIds);
        }

        if (!CollectionUtils.isEmpty(doIds)) {
            this.deliveryOrderMapper.deleteByIds(doIds);
        }

        if (!CollectionUtils.isEmpty(doItemIds)) {
            this.deliveryOrderItemMapper.deleteByIds(doItemIds);
        }

        if (!CollectionUtils.isEmpty(logIds)) {
            this.orderStatusChangeMapper.deleteByIds(logIds);
        }

        if (!CollectionUtils.isEmpty(orderCodes)) {
            this.orderMapper.deleteByOrderCodes(orderCodes);
        }
    }

}
