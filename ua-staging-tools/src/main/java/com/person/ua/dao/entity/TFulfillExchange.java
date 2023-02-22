package com.person.ua.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Fulfill return exchange info table (履约退换信息表)
 * @TableName t_fulfill_exchange
 */
@TableName(value ="t_fulfill_exchange")
@Data
public class TFulfillExchange implements Serializable {
    /**
     * 业务域
     */
    @TableField(value = "DOMAIN_CODE")
    private String domainCode;

    /**
     * 租户号
     */
    @TableField(value = "TENANT_CODE")
    private String tenantCode;

    /**
     * 渠道编号
     */
    @TableField(value = "CHANNEL_CODE")
    private String channelCode;

    /**
     * 组织CODE
     */
    @TableField(value = "ORG_CODE")
    private String orgCode;

    /**
     * 履约退换编码
     */
    @TableField(value = "FULFILL_EXCHANGE_CODE")
    private String fulfillExchangeCode;

    /**
     * 退换货申请编号
     */
    @TableField(value = "RETURN_CODE")
    private String returnCode;

    /**
     * External return code（平台售后单号）
     */
    @TableField(value = "EXTERNAL_RETURN_CODE")
    private String externalReturnCode;

    /**
     * 订单编号
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * 渠道订单号
     */
    @TableField(value = "EXTERNAL_ORDER_CODE")
    private String externalOrderCode;

    /**
     * 账户编号
     */
    @TableField(value = "MEMBER_CODE")
    private String memberCode;

    /**
     * 用户账号
     */
    @TableField(value = "MEMBER_NAME")
    private String memberName;

    /**
     * 国家
     */
    @TableField(value = "COUNTRY")
    private String country;

    /**
     * 收货地址国家名称
     */
    @TableField(value = "COUNTRY_NAME")
    private String countryName;

    /**
     * 收货地址所在省代码
     */
    @TableField(value = "PROVINCE")
    private String province;

    /**
     * 收货地址省名称
     */
    @TableField(value = "PROVINCE_NAME")
    private String provinceName;

    /**
     * 收货地址所在市代码
     */
    @TableField(value = "CITY")
    private String city;

    /**
     * 收货地址市名称
     */
    @TableField(value = "CITY_NAME")
    private String cityName;

    /**
     * 收货地址所在区/县代码
     */
    @TableField(value = "DISTRICT")
    private String district;

    /**
     * 收货地址区名称
     */
    @TableField(value = "DISTRICT_NAME")
    private String districtName;

    /**
     * 收货地址
     */
    @TableField(value = "ADDRESS")
    private String address;

    /**
     * 地址id
     */
    @TableField(value = "ADDRESS_ID")
    private String addressId;

    /**
     * 姓
     */
    @TableField(value = "LAST_NAME")
    private String lastName;

    /**
     * 名
     */
    @TableField(value = "FIRST_NAME")
    private String firstName;

    /**
     * 客户名称
     */
    @TableField(value = "NAME")
    private String name;

    /**
     * 联系电话
     */
    @TableField(value = "MOBILE")
    private String mobile;

    /**
     * 固定电话
     */
    @TableField(value = "TELEPHONE")
    private String telephone;

    /**
     * 邮箱
     */
    @TableField(value = "MAIL")
    private String mail;

    /**
     * 邮编
     */
    @TableField(value = "ZIP_CODE")
    private String zipCode;

    /**
     * 是否有效 1为有效，0为无效
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

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
     * 街道名称
     */
    @TableField(value = "STREET_NAME")
    private String streetName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}