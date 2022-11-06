package com.persion.study.sharding.dao.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 彭心潮
 * @date 2022/10/15 16:19
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderLine {

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * Sku编码
     */
    private String skuCode;

    /**
     * 商品条码
     */
    private String barCode;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 商品主图
     */
    private String skuMainImage;

    /**
     * 购买数量
     */
    private Integer qty;

    /**
     * 折前单价
     */
    private BigDecimal priceBeforeDiscount;

    /**
     * 折后单价
     */
    private BigDecimal priceAfterDiscount;

    /**
     * 行折后总金额
     */
    private BigDecimal totalAmountAfterDiscount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
