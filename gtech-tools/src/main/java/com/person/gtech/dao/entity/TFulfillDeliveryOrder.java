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
 * t_fulfill_delivery_order（发货单表）
 * @TableName t_fulfill_delivery_order
 */
@TableName(value ="t_fulfill_delivery_order")
@Data
public class TFulfillDeliveryOrder implements Serializable {
    /**
     * 发货单编号
     */
    @TableField(value = "DELIVERY_CODE")
    private String deliveryCode;

    /**
     * 订单号
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * 外部平台订单号
     */
    @TableField(value = "EXTERNAL_ORDER_CODE")
    private String externalOrderCode;

    /**
     * 仓库发货单号
     */
    @TableField(value = "NODE_DOC_NO")
    private String nodeDocNo;

    /**
     * 是否可路由仓库（0：不可路由仓库，1：可路由仓库）
     */
    @TableField(value = "CAN_ROUTE_NODE")
    private String canRouteNode;

    /**
     * 指定过仓仓库编号
     */
    @TableField(value = "ASS_NODE_CODE")
    private String assNodeCode;

    /**
     * 路由仓库编号
     */
    @TableField(value = "ROUTE_NODE_CODE")
    private String routeNodeCode;

    /**
     * 路由仓类型 10：虚拟仓  20：BlueTab
     */
    @TableField(value = "ROUTE_NODE_TYPE")
    private String routeNodeType;

    /**
     * 实际仓库编号
     */
    @TableField(value = "ACTUAL_NODE_CODE")
    private String actualNodeCode;

    /**
     * 发货单状态（11待路由，12路由中，13路由失败，14待过仓，15过仓完成，16配货中，17准备发货，18在途，19配货失败，20取消，21投递失败，22作废，23完成）
     */
    @TableField(value = "STATUS")
    private String status;

    /**
     * 物流公司编码
     */
    @TableField(value = "TRANS_CODE")
    private String transCode;

    /**
     * 货币代码
     */
    @TableField(value = "CURRENCY_CODE")
    private String currencyCode;

    /**
     * 订单类型 普通订单、活动订单、其他
     */
    @TableField(value = "ORDER_TYPE")
    private String orderType;

    /**
     * 发货单类型 1.销售单 2.换货单
     */
    @TableField(value = "DELIVERY_ORDER_TYPE")
    private String deliveryOrderType;

    /**
     * 订单金额 订单实际需要支付的金额AMOUNT=PRODUCTAMOUNT-DISCOUNT-COUPON-USED_POINT_AMOUNT+FREIGHT+TAX+SERVICE_AMOUNT
     */
    @TableField(value = "AMOUNT")
    private BigDecimal amount;

    /**
     * 商品总额 订单商品总额
     */
    @TableField(value = "PRODUCT_AMOUNT")
    private BigDecimal productAmount;

    /**
     * 税前金额(开票金额) SELL_AMOUNT - USED_POINT_AMOUNT
     */
    @TableField(value = "ACTUAL_AMOUNT")
    private BigDecimal actualAmount;

    /**
     * 折后金额(包含积分抵扣金额) SUM(每行SELL_PRICE*COUNT)
     */
    @TableField(value = "SELL_AMOUNT")
    private BigDecimal sellAmount;

    /**
     * 订单实收金额
     */
    @TableField(value = "RECEIVED_AMOUNT")
    private BigDecimal receivedAmount;

    /**
     * 虚拟币总抵用积分
     */
    @TableField(value = "USED_POINT")
    private BigDecimal usedPoint;

    /**
     * 虚拟币总积分抵用金额
     */
    @TableField(value = "USED_POINT_AMOUNT")
    private BigDecimal usedPointAmount;

    /**
     * 服务费
     */
    @TableField(value = "SERVICE_AMOUNT")
    private BigDecimal serviceAmount;

    /**
     * 税
     */
    @TableField(value = "TAX")
    private BigDecimal tax;

    /**
     * 运费
     */
    @TableField(value = "FREIGHT")
    private BigDecimal freight;

    /**
     * 运费扩展金额字段， UA项目用于记录官网礼品卡支付的运费金额
     */
    @TableField(value = "FREIGHT_EXT_AMOUNT")
    private BigDecimal freightExtAmount;

    /**
     * 优惠总额 所有促销所带来的优惠总额
     */
    @TableField(value = "DISCOUNT")
    private BigDecimal discount;

    /**
     * 优惠券 优惠券抵扣的金额
     */
    @TableField(value = "COUPON")
    private BigDecimal coupon;

    /**
     * 取消原因
     */
    @TableField(value = "CANCEL_CODE")
    private String cancelCode;

    /**
     * 取消备注
     */
    @TableField(value = "CANCEL_REMARK")
    private String cancelRemark;

    /**
     * 订单来源类型 1. 平台接入 2. 人工录入
     */
    @TableField(value = "SOURCE_TYPE")
    private String sourceType;

    /**
     * 下单账户
     */
    @TableField(value = "MEMBER_NAME")
    private String memberName;

    /**
     * 下单账户编号
     */
    @TableField(value = "MEMBER_CODE")
    private String memberCode;

    /**
     * CRM会员编码
     */
    @TableField(value = "CRM_MEMBER_CODE")
    private String crmMemberCode;

    /**
     * 过仓时间
     */
    @TableField(value = "COMMIT_NODE_TIME")
    private Date commitNodeTime;

    /**
     * 出仓时间
     */
    @TableField(value = "OUTBOUND_NODE_TIME")
    private Date outboundNodeTime;

    /**
     * 接收在途通知时间
     */
    @TableField(value = "RECEIVE_OUTBOUND_TIME")
    private Date receiveOutboundTime;

    /**
     * 取消时间
     */
    @TableField(value = "CANCEL_TIME")
    private Date cancelTime;

    /**
     * 完成时间
     */
    @TableField(value = "FINISHED_TIME")
    private Date finishedTime;

    /**
     * 签收时间
     */
    @TableField(value = "SIGNED_TIME")
    private Date signedTime;

    /**
     * 卖家备注
     */
    @TableField(value = "REMARK_TENANT")
    private String remarkTenant;

    /**
     * 买家备注
     */
    @TableField(value = "REMARK_BUYER")
    private String remarkBuyer;

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
     * 删除时间
     */
    @TableField(value = "DELETE_TIME")
    private Date deleteTime;

    /**
     * 业务异常信息（IM，WMS等返回）
     */
    @TableField(value = "ERROR_MESSAGE")
    private String errorMessage;

    /**
     * 业务异常编码（IM，WMS等返回）
     */
    @TableField(value = "ERROR_CODE")
    private String errorCode;

    /**
     * 订单支付时间
     */
    @TableField(value = "PAY_TIME")
    private Date payTime;

    /**
     * 外部订单下单时间
     */
    @TableField(value = "EXTERNAL_ORDER_CREATE_TIME")
    private Date externalOrderCreateTime;

    /**
     * 配送方式（1.快递 2.自提 3.商家配送）
     */
    @TableField(value = "DISTRIBUTION_TYPE")
    private String distributionType;

    /**
     * 物流时效（1工作日,2节假日,3当日达,4次晨达,5次日达,6预约达,7普通,8即时达）
     */
    @TableField(value = "TRANS_TIME_TYPE")
    private String transTimeType;

    /**
     * 运送方式(1普通 2空运 3陆运)
     */
    @TableField(value = "TRANS_SERVICE_TYPE")
    private String transServiceType;

    /**
     * 是否到付
     */
    @TableField(value = "IS_COD")
    private String isCod;

    /**
     * 是否开票  0：不开票 1：开票
     */
    @TableField(value = "IS_INVOICE")
    private String isInvoice;

    /**
     * 到付金额
     */
    @TableField(value = "COD_AMOUNT")
    private BigDecimal codAmount;

    /**
     * 线上店CODE
     */
    @TableField(value = "SHOP_CODE")
    private String shopCode;

    /**
     * 指定过仓仓库名称
     */
    @TableField(value = "ASS_NODE_NAME")
    private String assNodeName;

    /**
     * 路由仓库名称
     */
    @TableField(value = "ROUTE_NODE_NAME")
    private String routeNodeName;

    /**
     * 实际仓库名称
     */
    @TableField(value = "ACTUAL_NODE_NAME")
    private String actualNodeName;

    /**
     * 路由节点黑名单
     */
    @TableField(value = "ROUTE_NODE_BLACKLIST")
    private String routeNodeBlacklist;

    /**
     * OMS订单下单时间
     */
    @TableField(value = "ORDER_CREATE_TIME")
    private Date orderCreateTime;

    /**
     * 预约时间
     */
    @TableField(value = "EXPECT_TIME")
    private Date expectTime;

    /**
     * 是否包含服务 null或0：不包含 1:包含
     */
    @TableField(value = "IS_CONTAIN_SERVICE")
    private String isContainService;

    /**
     * 是否使用路由
     */
    @TableField(value = "USE_ROUTING")
    private String useRouting;

    /**
     * 拆单类型1：创单拆单 2：取消拆单 3：路由拆单 4：缺货拆单 5：部分发货拆单
     */
    @TableField(value = "SPLIT_ORDER_TYPE")
    private String splitOrderType;

    /**
     * 原始发货单号
     */
    @TableField(value = "ORIGINAL_ORDER_CODE")
    private String originalOrderCode;

    /**
     * 履约换货编号
     */
    @TableField(value = "FULFILL_EXCHANGE_CODE")
    private String fulfillExchangeCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}