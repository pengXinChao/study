package com.persion.study.sharding.dao.entry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 彭心潮
 * @date 2022/10/15 16:13
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 会员编码
     */
    private String memberId;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 店铺ID
     */
    private String shopId;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 订单折后总金额
     */
    private BigDecimal orderAmountAfterDiscount;

    /**
     * 订单折前总金额
     */
    private BigDecimal orderAmountBeforeDiscount;

    /**
     * 商品总金额
     */
    private BigDecimal productTotalAmount;

    /**
     * 折后运费
     */
    private BigDecimal shippingFeeAfterDiscount;

    /**
     * 折前运费
     */
    private BigDecimal shippingFeeBeforeDiscount;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 取消时间
     */
    private Date cancelTime;

    /**
     * 订单完成时间
     */
    private Date completeTime;
}
