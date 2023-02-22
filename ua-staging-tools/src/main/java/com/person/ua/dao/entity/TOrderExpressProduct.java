package com.person.ua.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_order_express_product（快递对应的包裹明细）
 * @TableName t_order_express_product
 */
@TableName(value ="t_order_express_product")
@Data
public class TOrderExpressProduct implements Serializable {
    /**
     * Tenant code
     */
    @TableField(value = "TENANT_CODE")
    private String tenantCode;

    /**
     * Domain code
     */
    @TableField(value = "DOMAIN_CODE")
    private String domainCode;

    /**
     * Channel code
     */
    @TableField(value = "CHANNEL_CODE")
    private String channelCode;

    /**
     * Org code
     */
    @TableField(value = "ORG_CODE")
    private String orgCode;

    /**
     * Express code
     */
    @TableField(value = "EXPRESS_CODE")
    private String expressCode;

    /**
     * Express order code
     */
    @TableField(value = "ORDER_EXPRESS_CODE")
    private String orderExpressCode;

    /**
     * Express product code
     */
    @TableField(value = "EXPRESS_PRODUCT_CODE")
    private String expressProductCode;

    /**
     * Order code
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * Order Item code
     */
    @TableField(value = "ORDER_ITEM_CODE")
    private String orderItemCode;

    /**
     * External order item code
     */
    @TableField(value = "EXTERNAL_ORDER_ITEM_CODE")
    private String externalOrderItemCode;

    /**
     * Delivery item code
     */
    @TableField(value = "SUB_ORDER_ITEM_CODE")
    private String subOrderItemCode;

    /**
     * Delivery code
     */
    @TableField(value = "SUB_ORDER_CODE")
    private String subOrderCode;

    /**
     * Sku code
     */
    @TableField(value = "SKU_CODE")
    private String skuCode;

    /**
     * Count
     */
    @TableField(value = "COUNT")
    private Integer count;

    /**
     * IsValid: 1 Yes,0 No
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * Create time
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * Update time
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * Delete time
     */
    @TableField(value = "DELETE_TIME")
    private Date deleteTime;

    /**
     * Create user name
     */
    @TableField(value = "CREATE_USER")
    private String createUser;

    /**
     * Update user name
     */
    @TableField(value = "UPDATE_USER")
    private String updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}