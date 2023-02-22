package com.person.ua.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单商品明细表
 * @TableName t_order_product
 */
@TableName(value ="t_order_product")
@Data
public class TOrderProduct implements Serializable {
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
     * Org code
     */
    @TableField(value = "ORG_CODE")
    private String orgCode;

    /**
     * Order code
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * Product type
     */
    @TableField(value = "PRODUCT_TYPE")
    private String productType;

    /**
     * Fulfill type,  1:SALE  2:EXCHANGE
     */
    @TableField(value = "FULFILL_TYPE")
    private String fulfillType;

    /**
     * SKU code
     */
    @TableField(value = "SKU_CODE")
    private String skuCode;

    /**
     * SKU name
     */
    @TableField(value = "SKU_NAME")
    private String skuName;

    /**
     * Node code
     */
    @TableField(value = "NODE_CODE")
    private String nodeCode;

    /**
     * SPU code
     */
    @TableField(value = "PRODUCT_CODE")
    private String productCode;

    /**
     * Order item code
     */
    @TableField(value = "ORDER_ITEM_CODE")
    private String orderItemCode;

    /**
     * Origin order item code
     */
    @TableField(value = "ORIGIN_ORDER_ITEM_CODE")
    private String originOrderItemCode;

    /**
     * Parent order item code
     */
    @TableField(value = "PARENT_ORDER_ITEM_CODE")
    private String parentOrderItemCode;

    /**
     * External order item code
     */
    @TableField(value = "EXTERNAL_ORDER_ITEM_CODE")
    private String externalOrderItemCode;

    /**
     * Parent external order item code
     */
    @TableField(value = "PARENT_EXTERNAL_ORDER_ITEM_CODE")
    private String parentExternalOrderItemCode;

    /**
     * Product org code
     */
    @TableField(value = "PRODUCT_ORG_CODE")
    private String productOrgCode;

    /**
     * External sku code
     */
    @TableField(value = "EXTERNAL_SKU_CODE")
    private String externalSkuCode;

    /**
     * Brand'SKU code
     */
    @TableField(value = "BRAND_SKU_CODE")
    private String brandSkuCode;

    /**
     * Category code ,Separate with ","
     */
    @TableField(value = "CATEGORY_CODE")
    private String categoryCode;

    /**
     * Category name ,Separate with ","
     */
    @TableField(value = "CATEGORY_NAME")
    private String categoryName;

    /**
     * Brand code
     */
    @TableField(value = "BRAND_CODE")
    private String brandCode;

    /**
     * Brand name
     */
    @TableField(value = "BRAND_NAME")
    private String brandName;

    /**
     * Attribute
     */
    @TableField(value = "ATTRIBUTE")
    private String attribute;

    /**
     * 商品关键属性
     */
    @TableField(value = "KEY_ATTRIBUTE")
    private String keyAttribute;

    /**
     * Barcode
     */
    @TableField(value = "BAR_CODE")
    private String barCode;

    /**
     * Product price
     */
    @TableField(value = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    /**
     * Sale price
     */
    @TableField(value = "SALE_PRICE")
    private BigDecimal salePrice;

    /**
     * Sell price
     */
    @TableField(value = "SELL_PRICE")
    private BigDecimal sellPrice;

    /**
     * Count
     */
    @TableField(value = "COUNT")
    private Integer count;

    /**
     * Return count
     */
    @TableField(value = "RETURN_COUNT")
    private Integer returnCount;

    /**
     * Status: SelfChannelStatus(0 Wait send，1Wait Received，2Canceled) OmniChannelStatus(Like the orderStatus)
     */
    @TableField(value = "STATUS")
    private String status;

    /**
     * Used point
     */
    @TableField(value = "USED_POINT")
    private BigDecimal usedPoint;

    /**
     * Used point amount
     */
    @TableField(value = "USED_POINT_AMOUNT")
    private BigDecimal usedPointAmount;

    /**
     * Actual price
     */
    @TableField(value = "ACTUAL_PRICE")
    private BigDecimal actualPrice;

    /**
     * Amount
     */
    @TableField(value = "AMOUNT")
    private BigDecimal amount;

    /**
     * 平台补贴金额
     */
    @TableField(value = "PF_DISCOUNT")
    private BigDecimal pfDiscount;

    /**
     * Ext Amount 1
     */
    @TableField(value = "EXT_AMOUNT_1")
    private BigDecimal extAmount1;

    /**
     * Ext Amount 2
     */
    @TableField(value = "EXT_AMOUNT_2")
    private BigDecimal extAmount2;

    /**
     * Ext Amount 3
     */
    @TableField(value = "EXT_AMOUNT_3")
    private BigDecimal extAmount3;

    /**
     * Tax
     */
    @TableField(value = "TAX")
    private BigDecimal tax;

    /**
     * IsGift: 1 Yes，0 No
     */
    @TableField(value = "IS_GIFT")
    private String isGift;

    /**
     * Gift type. PLATFORM, FULFILL
     */
    @TableField(value = "GIFT_TYPE")
    private String giftType;

    /**
     * Main sku Code for Gift
     */
    @TableField(value = "MAIN_SKU_CODE")
    private String mainSkuCode;

    /**
     * Group Code
     */
    @TableField(value = "GROUP_CODE")
    private String groupCode;

    /**
     * Group count
     */
    @TableField(value = "GROUP_COUNT")
    private Integer groupCount;

    /**
     * Acitity code
     */
    @TableField(value = "ACTIVITY_CODE")
    private String activityCode;

    /**
     * External actity code
     */
    @TableField(value = "EXTERNAL_ACTIVITY_CODE")
    private String externalActivityCode;

    /**
     * Return type :11 supports return and exchange, 12 only supports return, 13 only supports exchange, 14 does not support
     */
    @TableField(value = "RETURN_TYPE")
    private String returnType;

    /**
     * Image
     */
    @TableField(value = "IMAGE")
    private String image;

    /**
     * Package type
     */
    @TableField(value = "PACKAGE_TYPE")
    private String packageType;

    /**
     * Package amount
     */
    @TableField(value = "PACKAGE_AMOUNT")
    private BigDecimal packageAmount;

    /**
     * Custom request image
     */
    @TableField(value = "CUSTOM_REQ_IMAGE")
    private String customReqImage;

    /**
     * Custom request description
     */
    @TableField(value = "CUSTOM_REQ_DESC")
    private String customReqDesc;

    /**
     * Cancel reason code
     */
    @TableField(value = "CANCEL_REASON_CODE")
    private String cancelReasonCode;

    /**
     * Cancel reason text desc
     */
    @TableField(value = "CANCEL_REASON_DESC")
    private String cancelReasonDesc;

    /**
     * IsValid:1 Yes,0 No
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

    /**
     * Order item ext props
     */
    @TableField(value = "EXT_PROPS")
    private String extProps;

    /**
     * sku no
     */
    @TableField(value = "SKU_NO")
    private String skuNo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}