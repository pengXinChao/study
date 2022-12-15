package com.person.gtech.test;

import com.person.gtech.dao.entity.K8sServerVersion;
import com.person.gtech.service.K8sServerVersionService;
import com.person.gtech.test.common.CommonTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭心潮
 * @date 2022/11/6 21:12
 */
@Slf4j
public class K8sServerVersionTest extends CommonTest {

    @Resource
    private K8sServerVersionService k8sServerVersionService;

    public static String VERSION_STR = "      1 registry.cn-hangzhou.aliyuncs.com/gtech/apollo-admin-server:v1.0.0\n" +
            "      1 registry.cn-hangzhou.aliyuncs.com/gtech/apollo-portal-server:v1.0.0\n" +
            "      3 registry.cn-hangzhou.aliyuncs.com/gtech/eureka:85a9b66\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/cloud-titan-task-admin:3b271e8\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/cloud-titan-task-executor:fb38853\n" +
            "      3 registry.cn-hangzhou.aliyuncs.com/gtech/elastic-ik:7.7.0\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/gateway:cadf6e5\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/hub:81f108f\n" +
            "      1 registry.cn-hangzhou.aliyuncs.com/gtech/monitor-titan-bootadmin:1.0.0\n" +
            "      2 docker.io/seataio/seata-server:1.4.1\n" +
            "      3 registry.cn-hangzhou.aliyuncs.com/gtech/apollo-config-server:v1.0.0\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-codex-flinkadmin:230af71\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-codex-udo:f86287f\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-catalog:bafe8e1\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-data-sync:29b7d0d\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-datacenter:cfb1df6\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-delivery:bad47b1\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-filecloud:ee4fb4e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-fulfill:7bc30cd\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-gateway-meta:0311d44\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-idm:4c1668b\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-inventory:6f7ecd0\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-invtask:529655a\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-logistics:dcc9e45\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-martech:f7c0e61\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-masterdata:7e9f6cd\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-member:172daa3\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-message:b5ef76c\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-notify:ba58e30\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-openapi:70583fb\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-order:7bc30cd\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-order-routing:d99ceb8\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-payadmin:a1887ec\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-payment:ccb83dc\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-pim:9d44419\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-promotion:9cb6ec8\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-search:c253ded\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-searchop:c253ded\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-store:3c99d66\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-trade:8219511\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-wallet:6f6a86e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/svc-titan-wcm:728446f\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-douyin:1df81ce\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-erp:db2c9c2\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-jdl:26f9fc2\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-lazada:26ff4d9\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-martech:daa0f99\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-taobao:557448f\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-adapter-vip:6bc1ece\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-b2b:0bfbfd9\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-bluetab:0c4aeb5\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-canali:261f634\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-commerce:39e9ee4\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-commercial-tire:c1257c0\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-content:50ad9b8\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-control-tower:23f9f9e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-devadmin:4b66cc1\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-developer:8e1deec\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-b2b-mall:5205c6e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-b2b-manager:f0267c1\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-bluebox:6cf12cb\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-bluetab-b-h5:95b6fb2\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-bluetab:e92424a\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-commerce:246cd8b\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-control-tower:c71eda8\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-control-tower-bff:7665338\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-devadmin:63bf095\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-flink-admin:91041a4\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-governor-platform-bff:1d12bc6\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-gtech-web:1620df9\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-gtech-web-en:bacd42a\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-jiasumai:70a2e92\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-k-one-cn:f518380\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-k-one-frontend:2cd18fb\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-k-one-tbr:e4eede0\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-k-one-web:2facc87\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-member:90c82df\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-message:7fdaf5d\n" +
            "      1 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-oa-qiankun-main-app:19909e1\n" +
            "      1 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-oa-qiankun-micro-sop:dbab526\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-oms:1c6cc0c\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-open-api:e9b6a22\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-open-management-system:f179448\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-pcr-mini-manager:e568f25\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-pim:ef5da2f\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-portal:5794acd\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-promotion:33c677e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-scrm:9d6d308\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedb2b-h5:22f19a4\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedb2b-manager:9a4802a\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedbiz:7ad1799\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedbiz-h5:0d04fc4\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedbiz-operation:a1ea13b\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedshop-martech:4341f1e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedshop-ow:512e0ed\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedtbr:5fa3985\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedwork-manager-cn:89047ae\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedwork-official-website:731f59b\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-speedwork-ow-cn:ccbc040\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-store-erp:945866e\n" +
            "      1 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-store-erp-h5:011658f\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-store-erp-operation:4ad972b\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-store-manager:202a090\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-tbr-mini:d631c81\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-tbr-mini-manager:6859c1f\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-totb-manager:34aed64\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-totb-web:44d87ca\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-udo:0a862d1\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-wcm:7317297\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-win-together-tbr:7734040\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-wintogether-big-china-h5:68d09d3\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-wintogether-china-h5:ad047b3\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-wintogether-cn:e6dce78\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-wintogether-cn:d2a8a50\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-frontend-k-one-cn:c921177\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-k-one:e9c6b89\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-member:328ec4f\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-message:142b330\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-oms:73fee2d\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-operation:4a0da6e\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-pcr-mini:47b9bd0\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-pim:a3e2090\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-promotion:fc7e54d\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-sop:c4abdd7\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedb2b:dfa5673\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedbiz:01385ad\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedbiz-operation:24ed132\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedshop:68589db\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedtbr:a4ec8d2\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedtbr-operation:8cc3109\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-speedwork:9cd5173\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-store:d904143\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-totb:29af2b9\n" +
            "      4 registry.cn-hangzhou.aliyuncs.com/gtech/web-wintogether:d9899cd\n" +
            "      2 registry.cn-hangzhou.aliyuncs.com/gtech/web-wintogether-tbr:51e4f29";

    @Test
    public void saveK8sVersionTest() {

        String[] splitResult = StringUtils.split(VERSION_STR, "\n");
        List<K8sServerVersion> serverVersionEntities = new ArrayList<>(splitResult.length);
        for (String serverVersionStr : splitResult) {
            int mhIdx = StringUtils.lastIndexOf(serverVersionStr, ":");
            int xgIdx = StringUtils.lastIndexOf(serverVersionStr, "/") + 1;
            String serverName = StringUtils.substring(serverVersionStr, xgIdx, mhIdx);
            String version = StringUtils.substring(serverVersionStr, mhIdx + 1);
            K8sServerVersion serverVersionEntity = new K8sServerVersion();
            serverVersionEntity.setServerName(serverName);
            serverVersionEntity.setVersion(version);
            serverVersionEntities.add(serverVersionEntity);
        }

        for (K8sServerVersion serverVersionEntity : serverVersionEntities) {
            serverVersionEntity.setEnv("CN");
            this.k8sServerVersionService.save(serverVersionEntity);
        }
        log.info("拆分结果:{}", splitResult);
    }



}
