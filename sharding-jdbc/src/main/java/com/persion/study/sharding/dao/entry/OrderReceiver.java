package com.persion.study.sharding.dao.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author 彭心潮
 * @date 2022/10/15 16:23
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderReceiver {

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人手机号
     */
    private String mobile;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String districtName;

    /**
     * 街道
     */
    private String streetName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
