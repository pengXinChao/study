package com.person.ua.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 促销信息表
 * @TableName t_order_activityinfo
 */
@TableName(value ="t_order_activityinfo")
@Data
public class TOrderActivityinfo implements Serializable {
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
     * Sponsors
     */
    @TableField(value = "SPONSORS")
    private String sponsors;

    /**
     * Activity code
     */
    @TableField(value = "ACTIVITY_CODE")
    private String activityCode;

    /**
     * Activity name
     */
    @TableField(value = "ACTIVITY_NAME")
    private String activityName;

    /**
     * Activity type code
     */
    @TableField(value = "ACTIVITY_TYPE_CODE")
    private String activityTypeCode;

    /**
     * Activity type name
     */
    @TableField(value = "ACTIVITY_TYPE_NAME")
    private String activityTypeName;

    /**
     * Coupon code (券码)
     */
    @TableField(value = "COUPON_CODE")
    private String couponCode;

    /**
     * Price
     */
    @TableField(value = "PRICE")
    private BigDecimal price;

    /**
     * Externant code
     */
    @TableField(value = "EXTERNAL_CODE")
    private String externalCode;

    /**
     * Valid or not 1 is valid, 0 is invalid
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * Input time the time when this record is inserted into the database can also be regarded as the time of placing an order
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * Editing time initial update time = create time
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