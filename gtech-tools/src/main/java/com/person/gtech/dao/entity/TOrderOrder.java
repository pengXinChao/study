package com.person.gtech.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName t_order_order
 */
@TableName(value ="t_order_order")
@Data
public class TOrderOrder implements Serializable {
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
     * Channel code
     */
    @TableField(value = "CHANNEL_CODE")
    private String channelCode;

    /**
     * Order code
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * External order code
     */
    @TableField(value = "EXTERNAL_ORDER_CODE")
    private String externalOrderCode;

    /**
     * Member org code
     */
    @TableField(value = "MEMBER_ORG_CODE")
    private String memberOrgCode;

    /**
     * Member name
     */
    @TableField(value = "MEMBER_NAME")
    private String memberName;

    /**
     * Member code
     */
    @TableField(value = "MEMBER_CODE")
    private String memberCode;

    /**
     * External member code
     */
    @TableField(value = "EXTERNAL_MEMBER_CODE")
    private String externalMemberCode;

    /**
     * User code
     */
    @TableField(value = "USER_NAME")
    private String userName;

    /**
     * User name
     */
    @TableField(value = "USER_CODE")
    private String userCode;

    /**
     * Order date format:YYYYMMDD
     */
    @TableField(value = "ORDER_DATE")
    private Integer orderDate;

    /**
     * Pay date format:YYYYMMDD
     */
    @TableField(value = "PAY_DATE")
    private Integer payDate;

    /**
     * Order type
     */
    @TableField(value = "ORDER_TYPE")
    private String orderType;

    /**
     * 渠道订单类型， UA项目用于记录官网订单类型。
1.O2O门店用户
2.ua员工渠道
3.企业用户
4.大客户渠道
5.招行用户
6.浦发用户
7.门店APP
8.affiliate
9.零售员工
10.Marketing订单
11.CRM正常兑换订单
12.CRM批量兑换订单
13.官网券-亲友券(FFS)
14.官网券-CPS券(UAA,UAK)
15.官网券-CNJEGP券
16.游客
     */
    @TableField(value = "CHANNEL_ORDER_TYPE")
    private String channelOrderType;

    /**
     * Order status:11 waiting for confirmation; 21 waiting for payment; 31 waiting for delivery (waiting for store acceptance); 41 waiting for receiving (received order); 42 processing; 51 order completion; 61 manual cancellation; 62 automatic cancellation
     */
    @TableField(value = "ORDER_STATUS")
    private String orderStatus;

    /**
     * Terminal:Single terminal 11pc, 21web, 31 android app, 41iosapp, 51: ministore
     */
    @TableField(value = "TERMINAL")
    private String terminal;

    /**
     * AMOUNT=PRODUCTAMOUNT-DISCOUNT-COUPON-USED_POINT_AMOUNT+FREIGHT+TAX+SERVICE_AMOUNT
     */
    @TableField(value = "AMOUNT")
    private BigDecimal amount;

    /**
     * Currency code
     */
    @TableField(value = "CURRENCY_CODE")
    private String currencyCode;

    /**
     * Product amount
     */
    @TableField(value = "PRODUCT_AMOUNT")
    private BigDecimal productAmount;

    /**
     * Discount
     */
    @TableField(value = "DISCOUNT")
    private BigDecimal discount;

    /**
     * Product discount(商品折扣)
     */
    @TableField(value = "PRODUCT_DISCOUNT")
    private BigDecimal productDiscount;

    /**
     * Freight
     */
    @TableField(value = "FREIGHT")
    private BigDecimal freight;

    /**
     * 运费扩展金额字段， UA项目用于记录官网礼品卡支付的运费金额
     */
    @TableField(value = "FREIGHT_EXT_AMOUNT")
    private BigDecimal freightExtAmount;

    /**
     * Discount amount of freight
     */
    @TableField(value = "FREIGHT_DISCOUNT")
    private BigDecimal freightDiscount;

    /**
     * Tax
     */
    @TableField(value = "TAX")
    private BigDecimal tax;

    /**
     * COD amount
     */
    @TableField(value = "COD_AMOUNT")
    private BigDecimal codAmount;

    /**
     * Coupon
     */
    @TableField(value = "COUPON")
    private BigDecimal coupon;

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
     * Service amount
     */
    @TableField(value = "SERVICE_AMOUNT")
    private BigDecimal serviceAmount;

    /**
     * Received amount
     */
    @TableField(value = "RECEIVED_AMOUNT")
    private BigDecimal receivedAmount;

    /**
     * IsInvoice:1 Yes,0 No
     */
    @TableField(value = "IS_INVOICE")
    private String isInvoice;

    /**
     * IsValid:1 Yes,0 No
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * IsFrozen:1 Yes,0 No
     */
    @TableField(value = "IS_FROZEN")
    private String isFrozen;

    /**
     * IsComment:1 Yes,0 No
     */
    @TableField(value = "IS_COMMENT")
    private String isComment;

    /**
     * Remark buyer
     */
    @TableField(value = "REMARK_BUYER")
    private String remarkBuyer;

    /**
     * Remark tenant
     */
    @TableField(value = "REMARK_TENANT")
    private String remarkTenant;

    /**
     * Expect time
     */
    @TableField(value = "EXPECT_TIME")
    private Date expectTime;

    /**
     * Cancel time
     */
    @TableField(value = "CANCEL_TIME")
    private Date cancelTime;

    /**
     * Split order flag:1 Yes, 0 No
     */
    @TableField(value = "SPLIT_ORDER_FLAG")
    private String splitOrderFlag;

    /**
     * Package type
     */
    @TableField(value = "PACKAGE_TYPE")
    private String packageType;

    /**
     * Pay operation amount
     */
    @TableField(value = "PAY_OPERATION_AMOUNT")
    private BigDecimal payOperationAmount;

    /**
     * Package amount
     */
    @TableField(value = "PACKAGE_AMOUNT")
    private BigDecimal packageAmount;

    /**
     * Pay time
     */
    @TableField(value = "PAY_TIME")
    private Date payTime;

    /**
     * Pay ment type online,offline
     */
    @TableField(value = "PAY_MENT_TYPE")
    private String payMentType;

    /**
     * Pay ment
     */
    @TableField(value = "PAY_MENT")
    private String payMent;

    /**
     * Pay channel
     */
    @TableField(value = "PAY_CHANNEL")
    private String payChannel;

    /**
     * Pay ext props
     */
    @TableField(value = "PAY_EXT_PROPS")
    private String payExtProps;

    /**
     * Bank code
     */
    @TableField(value = "BANK_CODE")
    private String bankCode;

    /**
     * Bank brand
     */
    @TableField(value = "BANK_BRAND")
    private String bankBrand;

    /**
     * Pay status
     */
    @TableField(value = "PAY_STATUS")
    private String payStatus;

    /**
     * Is omni channel:1 Yes, 0 No
     */
    @TableField(value = "IS_OMNI_CHANNEL")
    private String isOmniChannel;

    /**
     * Is guest order. 1:yes  0:no
     */
    @TableField(value = "IS_GUEST")
    private String isGuest;

    /**
     * Logo: 11 white, 12 green, 13 blue, 14 yellow, 15 red
     */
    @TableField(value = "TAG")
    private String tag;

    /**
     * App code
     */
    @TableField(value = "APP_CODE")
    private String appCode;

    /**
     * Source
     */
    @TableField(value = "SOURCE")
    private String source;

    /**
     * Trade source(sub order type)
     */
    @TableField(value = "TRADE_SOURCE")
    private String tradeSource;

    /**
     * Distribution type
     */
    @TableField(value = "DISTRIBUTION_TYPE")
    private String distributionType;

    /**
     * Mobile
     */
    @TableField(value = "MOBILE")
    private String mobile;

    /**
     * Email
     */
    @TableField(value = "EMAIL")
    private String email;

    /**
     * Cancel code
     */
    @TableField(value = "CANCEL_CODE")
    private String cancelCode;

    /**
     * Cancel remark
     */
    @TableField(value = "CANCEL_REMARK")
    private String cancelRemark;

    /**
     * Frozen reason code
     */
    @TableField(value = "FROZEN_REASON_CODE")
    private String frozenReasonCode;

    /**
     * Order ext props
     */
    @TableField(value = "EXT_PROPS")
    private String extProps;

    /**
     * External create time
     */
    @TableField(value = "EXTERNAL_CREATE_TIME")
    private Date externalCreateTime;

    /**
     * 尾款支付时间
     */
    @TableField(value = "BALANCE_PAYMENT_TIME")
    private Date balancePaymentTime;

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
     * Is can route node:1 Yes, 0 No
     */
    @TableField(value = "CAN_ROUTE_NODE")
    private String canRouteNode;

    /**
     * External pay time
     */
    @TableField(value = "EXTERNAL_COMPLETE_TIME")
    private Date externalCompleteTime;

    /**
     * Org that place an order
     */
    @TableField(value = "PLACE_ORDER_ORG_CODE")
    private String placeOrderOrgCode;

    /**
     * CRM会员编码
     */
    @TableField(value = "CRM_MEMBER_CODE")
    private String crmMemberCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}