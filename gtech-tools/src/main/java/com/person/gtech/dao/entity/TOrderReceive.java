package com.person.gtech.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.persistence.Column;

/**
 * 订单收件人表
 * @TableName t_order_receive
 */
@TableName(value ="t_order_receive")
@Data
public class TOrderReceive implements Serializable {
    /**
     * Tenant code
     */
//    @Column(name = "TENANT_CODE")
    @Column(name = "TENANT_CODE")
    private String tenantCode;

    /**
     * Domain code
     */
    @Column(name = "DOMAIN_CODE")
    private String domainCode;

    /**
     * Org code
     */
    @Column(name = "ORG_CODE")
    private String orgCode;

    /**
     * Order code
     */
    @Column(name = "ORDER_CODE")
    private String orderCode;

    /**
     * Last name
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * First name
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * Name
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Mobile
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * Country
     */
    @Column(name = "COUNTRY")
    private String country;

    /**
     * Country name
     */
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    /**
     * Province
     */
    @Column(name = "PROVINCE")
    private String province;

    /**
     * Province name
     */
    @Column(name = "PROVINCE_NAME")
    private String provinceName;

    /**
     * City
     */
    @Column(name = "CITY")
    private String city;

    /**
     * City name
     */
    @Column(name = "CITY_NAME")
    private String cityName;

    /**
     * District
     */
    @Column(name = "DISTRICT")
    private String district;

    /**
     * District name
     */
    @Column(name = "DISTRICT_NAME")
    private String districtName;

    /**
     * Street name
     */
    @Column(name = "STREET_NAME")
    private String streetName;

    /**
     * Address
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 地址 OAID
     */
    @Column(name = "ADDRESS_ID")
    private String addressId;

    /**
     * Telephone
     */
    @Column(name = "TELEPHONE")
    private String telephone;

    /**
     * IdCode
     */
    @Column(name = "ID_CODE")
    private String idCode;

    /**
     * Mail
     */
    @Column(name = "MAIL")
    private String mail;

    /**
     * Zip
     */
    @Column(name = "ZIP_CODE")
    private String zipCode;

    /**
     * Distribution type
     */
    @Column(name = "DISTRIBUTION_TYPE")
    private String distributionType;

    /**
     * Store name
     */
    @Column(name = "STORE_NAME")
    private String storeName;

    /**
     * Store code
     */
    @Column(name = "STORE_CODE")
    private String storeCode;

    /**
     * Receiver address latitude
     */
    @Column(name = "LATITUDE")
    private String latitude;

    /**
     * Receiver address longitude
     */
    @Column(name = "LONGITUDE")
    private String longitude;

    /**
     * Store confirm code
     */
    @Column(name = "STORE_CONFIRM_CODE")
    private String storeConfirmCode;

    /**
     * Logistics type
     */
    @Column(name = "LOGISTICS_TYPE")
    private String logisticsType;

    /**
     * Logistics trans type
     */
    @Column(name = "LOGISTICS_TRANS_TYPE")
    private String logisticsTransType;

    /**
     * Logistics code
     */
    @Column(name = "LOGISTICS_CODE")
    private String logisticsCode;

    /**
     * Logistics name
     */
    @Column(name = "LOGISTICS_NAME")
    private String logisticsName;

    /**
     * Create time
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * Update time
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * Delete time
     */
    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    /**
     * Create user name
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * Update user name
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "DESENSITIZATION_NAME")
    private String desensitizationName;

    @Column(name = "DESENSITIZATION_MOBILE")
    private String desensitizationMobile;

    @Column(name = "DESENSITIZATION_TELEPHONE")
    private String desensitizationTelephone;

    @Column(name = "DESENSITIZATION_ADDRESS")
    private String desensitizationAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}