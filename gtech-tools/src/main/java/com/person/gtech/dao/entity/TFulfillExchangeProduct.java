package com.person.gtech.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 履约换货明细表
 * @TableName t_fulfill_exchange_product
 */
@TableName(value ="t_fulfill_exchange_product")
@Data
public class TFulfillExchangeProduct implements Serializable {
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
     * 履约换货编码
     */
    @TableField(value = "FULFILL_EXCHANGE_CODE")
    private String fulfillExchangeCode;

    /**
     * 订单行号
     */
    @TableField(value = "ORDER_ITEM_CODE")
    private String orderItemCode;

    /**
     * 发货单号
     */
    @TableField(value = "DELIVERY_CODE")
    private String deliveryCode;

    /**
     * 原始商品编号
     */
    @TableField(value = "ORIGIN_SKU_CODE")
    private String originSkuCode;

    /**
     * 原始商品编号
     */
    @TableField(value = "ORIGIN_SKU_NAME")
    private String originSkuName;

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
     * 商品外部编号
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
     * 类目编号  多个用分号（,）分割
     */
    @TableField(value = "CATEGORY_CODE")
    private String categoryCode;

    /**
     * 类目  多个用分号（;）分割
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
     * SKU属性 将主要销售SKU属性拼接成一个字段进行显示
     */
    @TableField(value = "ATTRIBUTE")
    private String attribute;

    /**
     * 条形码
     */
    @TableField(value = "BAR_CODE")
    private String barCode;

    /**
     * 保存URL
     */
    @TableField(value = "IMAGE")
    private String image;

    /**
     * 换货商品数量
     */
    @TableField(value = "COUNT")
    private Integer count;

    /**
     * 退货原因
     */
    @TableField(value = "REASON_DESC")
    private String reasonDesc;

    /**
     * 退货原因编码
     */
    @TableField(value = "REASON_CODE")
    private String reasonCode;

    /**
     * 是否有效 1为有效，0为无效
     */
    @TableField(value = "IS_VALID")
    private String isValid;

    /**
     * 创建人
     */
    @TableField(value = "CREATE_USER")
    private String createUser;

    /**
     * 修改人
     */
    @TableField(value = "UPDATE_USER")
    private String updateUser;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}