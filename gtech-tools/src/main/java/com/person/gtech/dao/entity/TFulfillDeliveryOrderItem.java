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
 * t_fulfill_delivery_order_item（发货单行表）
 * @TableName t_fulfill_delivery_order_item
 */
@TableName(value ="t_fulfill_delivery_order_item")
@Data
public class TFulfillDeliveryOrderItem implements Serializable {
    /**
     * 发货单编号
     */
    @TableField(value = "DELIVERY_CODE")
    private String deliveryCode;

    /**
     * 发货单行编号
     */
    @TableField(value = "DELIVERY_ITEM_CODE")
    private String deliveryItemCode;

    /**
     * 订单号
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * 外部订单行号
     */
    @TableField(value = "EXTERNAL_ORDER_ITEM_CODE")
    private String externalOrderItemCode;

    /**
     * OMS订单行号
     */
    @TableField(value = "ORDER_ITEM_CODE")
    private String orderItemCode;

    /**
     * 商品类型
     */
    @TableField(value = "PRODUCT_TYPE")
    private String productType;

    /**
     * SKU编号
     */
    @TableField(value = "SKU_CODE")
    private String skuCode;

    /**
     * SKU名称
     */
    @TableField(value = "SKU_NAME")
    private String skuName;

    /**
     * 商品编号
     */
    @TableField(value = "PRODUCT_CODE")
    private String productCode;

    /**
     * 商品数量
     */
    @TableField(value = "COUNT")
    private Integer count;

    /**
     * 商品行总金额
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
     * 商品实际成交金额
     */
    @TableField(value = "ACTUAL_PRICE")
    private BigDecimal actualPrice;

    /**
     * 售价（不含优惠）
     */
    @TableField(value = "SALE_PRICE")
    private BigDecimal salePrice;

    /**
     * 售价 包含优惠的商品售价
     */
    @TableField(value = "SELL_PRICE")
    private BigDecimal sellPrice;

    /**
     * 商品行总抵用积分
     */
    @TableField(value = "USED_POINT")
    private BigDecimal usedPoint;

    /**
     * 商品行总积分抵用金额
     */
    @TableField(value = "USED_POINT_AMOUNT")
    private BigDecimal usedPointAmount;

    /**
     * 税
     */
    @TableField(value = "TAX")
    private BigDecimal tax;

    /**
     * 是否为赠品 1为赠品，0为非赠品
     */
    @TableField(value = "IS_GIFT")
    private String isGift;

    /**
     * Gift type. PLATFORM, FULFILL
     */
    @TableField(value = "GIFT_TYPE")
    private String giftType;

    /**
     * 组合商品的组合ID 当前商品为组合商品中时，记录组合ID
     */
    @TableField(value = "GROUP_CODE")
    private String groupCode;

    /**
     * 组合商品套数
     */
    @TableField(value = "GROUP_COUNT")
    private Integer groupCount;

    /**
     * 活动CODE
     */
    @TableField(value = "ACTIVITY_CODE")
    private String activityCode;

    /**
     * 品牌编号
     */
    @TableField(value = "BRAND_CODE")
    private String brandCode;

    /**
     * 品牌名称
     */
    @TableField(value = "BRAND_NAME")
    private String brandName;

    /**
     * 是否有效 1为有效，0为无效，此处无效订单为在系统中进行逻辑删除的订单；
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * 租户号
     */
    @TableField(value = "TENANT_CODE")
    private String tenantCode;

    /**
     * 业务域
     */
    @TableField(value = "DOMAIN_CODE")
    private String domainCode;

    /**
     * 组织CODE（SHOPCODE）
     */
    @TableField(value = "ORG_CODE")
    private String orgCode;

    /**
     * 渠道CODE
     */
    @TableField(value = "CHANNEL_CODE")
    private String channelCode;

    /**
     * 录入时间 此条记录插入数据库的时间，也可视为下单时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "CREATE_USER")
    private String createUser;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "UPDATE_USER")
    private String updateUser;

    /**
     * ERP SKU CODE
     */
    @TableField(value = "BRAND_SKU_CODE")
    private String brandSkuCode;

    /**
     * 条形码
     */
    @TableField(value = "BAR_CODE")
    private String barCode;

    /**
     * 商品外部编号
     */
    @TableField(value = "EXTERNAL_SKU_CODE")
    private String externalSkuCode;

    /**
     * SKU属性 将主要销售SKU属性拼接成一个字段进行显示
     */
    @TableField(value = "ATTRIBUTE")
    private String attribute;

    /**
     * 商品关键属性
     */
    @TableField(value = "KEY_ATTRIBUTE")
    private String keyAttribute;

    /**
     * 保存URL
     */
    @TableField(value = "IMAGE")
    private String image;

    /**
     * 吊牌价
     */
    @TableField(value = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    /**
     * 取消原因编码
     */
    @TableField(value = "CANCEL_REASON_CODE")
    private String cancelReasonCode;

    /**
     * 取消原因文本描述
     */
    @TableField(value = "CANCEL_REASON_DESC")
    private String cancelReasonDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}