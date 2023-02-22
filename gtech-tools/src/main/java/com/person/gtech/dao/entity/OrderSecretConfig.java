package com.person.gtech.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 彭心潮
 * @date 2022/11/14 17:48
 */
@Data
public class OrderSecretConfig {

    private Long id;

    /**
     * 渠道编码
     */
    private String tenantCode;

    /**
     * 秘钥
     */
    private String secret;

    /**
     * 秘钥类型
     */
    private String secretType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public static OrderSecretConfig init() {
        OrderSecretConfig orderSecretConfig = new OrderSecretConfig();
        orderSecretConfig.setSecret("FNZonnhATcAN5AmlG4WMvI51nBqqkeBf");
        return orderSecretConfig;
    }
}
