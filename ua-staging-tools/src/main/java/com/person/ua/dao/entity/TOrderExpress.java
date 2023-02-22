package com.person.ua.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_order_express（订单快递表）
 * @TableName t_order_express
 */
@TableName(value ="t_order_express")
@Data
public class TOrderExpress implements Serializable {
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
     * Order express code
     */
    @TableField(value = "ORDER_EXPRESS_CODE")
    private String orderExpressCode;

    /**
     * Express code
     */
    @TableField(value = "EXPRESS_CODE")
    private String expressCode;

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
     * Delivery code
     */
    @TableField(value = "SUB_ORDER_CODE")
    private String subOrderCode;

    /**
     * Experss status： 1：Shaped 2：Received 3: Received failed
     */
    @TableField(value = "EXPRESS_STATUS")
    private String expressStatus;

    /**
     * Company code
     */
    @TableField(value = "COMPANY_CODE")
    private String companyCode;

    /**
     * Company name
     */
    @TableField(value = "COMPANY_NAME")
    private String companyName;

    /**
     * Delivery time
     */
    @TableField(value = "SEND_TIME")
    private Date sendTime;

    /**
     * User code
     */
    @TableField(value = "USER_NAME")
    private String userName;

    /**
     * User code
     */
    @TableField(value = "USER_CODE")
    private String userCode;

    /**
     * Length
     */
    @TableField(value = "LENGTH")
    private BigDecimal length;

    /**
     * Width
     */
    @TableField(value = "WIDTH")
    private BigDecimal width;

    /**
     * Height
     */
    @TableField(value = "HEIGHT")
    private BigDecimal height;

    /**
     * Weight
     */
    @TableField(value = "WEIGHT")
    private BigDecimal weight;

    /**
     * Volume
     */
    @TableField(value = "VOLUME")
    private BigDecimal volume;

    /**
     * Received failed reason
     */
    @TableField(value = "DELIVERY_FAIL_REASON")
    private String deliveryFailReason;

    /**
     * 物流面单
     */
    @TableField(value = "SHIPING_LABEL")
    private String shipingLabel;

    /**
     * Is valid : 1 Yes,0 No
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