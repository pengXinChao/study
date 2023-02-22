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
 * t_fulfill_return_product（退换货处理商品表）
 * @TableName t_fulfill_return_product
 */
@TableName(value ="t_fulfill_return_product")
@Data
public class TFulfillReturnProduct implements Serializable {
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
     * 组织CODE
     */
    @TableField(value = "ORG_CODE")
    private String orgCode;

    /**
     * 退货处理单编号
     */
    @TableField(value = "FULFILL_RETURN_CODE")
    private String fulfillReturnCode;

    /**
     * 订单拆单对应的出库单编号
     */
    @TableField(value = "DELIVERY_CODE")
    private String deliveryCode;

    /**
     * 退货处理单行号
     */
    @TableField(value = "FULFILL_RETURN_ITEM_CODE")
    private String fulfillReturnItemCode;

    /**
     * 退货申请单行编号
     */
    @TableField(value = "RETURN_ITEM_CODE")
    private String returnItemCode;

    /**
     * 订单行编号
     */
    @TableField(value = "ORDER_ITEM_CODE")
    private String orderItemCode;

    /**
     * 外部订单行编号
     */
    @TableField(value = "EXTERNAL_ORDER_ITEM_CODE")
    private String externalOrderItemCode;

    /**
     * 商品编号
     */
    @TableField(value = "SKU_CODE")
    private String skuCode;

    /**
     * 商品名称
     */
    @TableField(value = "SKU_NAME")
    private String skuName;

    /**
     * 外部商品编号
     */
    @TableField(value = "EXTERNAL_SKU_CODE")
    private String externalSkuCode;

    /**
     * ERP Sku Code
     */
    @TableField(value = "BRAND_SKU_CODE")
    private String brandSkuCode;

    /**
     * SPU编号
     */
    @TableField(value = "PRODUCT_CODE")
    private String productCode;

    /**
     * 类目编号 多个用分号（,）分割
     */
    @TableField(value = "CATEGORY_CODE")
    private String categoryCode;

    /**
     * 类目 多个用分号（;）分割
     */
    @TableField(value = "CATEGORY_NAME")
    private String categoryName;

    /**
     * 品牌编号
     */
    @TableField(value = "BRAND_CODE")
    private String brandCode;

    /**
     * 品牌
     */
    @TableField(value = "BRAND_NAME")
    private String brandName;

    /**
     * 商品类型 11位良品21位残品 （默认11良品）
     */
    @TableField(value = "COMMODITY_TYPE")
    private String commodityType;

    /**
     * 商品退换货原因
     */
    @TableField(value = "DESCRIPTION")
    private String description;

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
     * 条形码
     */
    @TableField(value = "BAR_CODE")
    private String barCode;

    /**
     * Image
     */
    @TableField(value = "IMAGE")
    private String image;

    /**
     * 是否为赠品 1为赠品，0为非赠品
     */
    @TableField(value = "IS_GIFT")
    private String isGift;

    /**
     * 主商品ID 针对该商品为赠品时的主商品ID
     */
    @TableField(value = "MAIN_SKU_CODE")
    private String mainSkuCode;

    /**
     * 包装清单
     */
    @TableField(value = "PACKAGE_LIST")
    private String packageList;

    /**
     * 吊牌价
     */
    @TableField(value = "PRODUCT_PRICE")
    private BigDecimal productPrice;

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
     * 商品实际成交金额
     */
    @TableField(value = "ACTUAL_PRICE")
    private BigDecimal actualPrice;

    /**
     * 商品实际成交行总金额
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
     * 税
     */
    @TableField(value = "TAX")
    private BigDecimal tax;

    /**
     * 报退数量 商品数量
     */
    @TableField(value = "COUNT")
    private Integer count;

    /**
     * 仓库实际收货商品数量
     */
    @TableField(value = "ACTUAL_COUNT")
    private Integer actualCount;

    /**
     * 退货原因编码
     */
    @TableField(value = "REASON_CODE")
    private String reasonCode;

    /**
     * 退货原因
     */
    @TableField(value = "REASON_DESC")
    private String reasonDesc;

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
     * 是否有效 1为有效，0为无效
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * 录入时间 此条记录插入数据库的时间，也可视为下单时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 编辑时间 初始编辑时间=录入时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 删除时间
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