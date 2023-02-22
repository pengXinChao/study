package com.person.ua.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * t_fulfill_return（退换货单主表）
 * @TableName t_fulfill_return
 */
@TableName(value ="t_fulfill_return")
@Data
public class TFulfillReturn implements Serializable {
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
     * 渠道编号
     */
    @TableField(value = "CHANNEL_CODE")
    private String channelCode;

    /**
     * 退换货处理单编号
     */
    @TableField(value = "FULFILL_RETURN_CODE")
    private String fulfillReturnCode;

    /**
     * 换货记录编码
     */
    @TableField(value = "FULFILL_EXCHANGE_CODE")
    private String fulfillExchangeCode;

    /**
     * 原始退货申请单编号
     */
    @TableField(value = "RETURN_CODE")
    private String returnCode;

    /**
     * External return code（平台售后单号）
     */
    @TableField(value = "EXTERNAL_RETURN_CODE")
    private String externalReturnCode;

    /**
     * 原始订单编号
     */
    @TableField(value = "ORDER_CODE")
    private String orderCode;

    /**
     * 外部渠道订单号
     */
    @TableField(value = "EXTERNAL_ORDER_CODE")
    private String externalOrderCode;

    /**
     * 订单拆单对应的出库单编号
     */
    @TableField(value = "DELIVERY_CODE")
    private String deliveryCode;

    /**
     * 子单类型， DELIVERY:发货单  WORK:工单
     */
    @TableField(value = "SUB_ORDER_TYPE")
    private String subOrderType;

    /**
     * 子单号
     */
    @TableField(value = "SUB_ORDER_CODE")
    private String subOrderCode;

    /**
     * 仓库作业单号
     */
    @TableField(value = "NODE_DOC_CODE")
    private String nodeDocCode;

    /**
     * 下单成员组织CODE
     */
    @TableField(value = "MEMBER_ORG_CODE")
    private String memberOrgCode;

    /**
     * 下单成员编号
     */
    @TableField(value = "MEMBER_CODE")
    private String memberCode;

    /**
     * CRM会员编码
     */
    @TableField(value = "CRM_MEMBER_CODE")
    private String crmMemberCode;

    /**
     * 下单成员名称
     */
    @TableField(value = "MEMBER_NAME")
    private String memberName;

    /**
     * 运营成员编号
     */
    @TableField(value = "USER_CODE")
    private String userCode;

    /**
     * 运营成员名称
     */
    @TableField(value = "USER_NAME")
    private String userName;

    /**
     * 退换货方式 11退货21换货31返修41未发货取消
     */
    @TableField(value = "RETURN_MODE")
    private String returnMode;

    /**
     * 0Created 11Submitted 21Waiting for Return Inbound 31Canceled 41QC Completed 51Completed
     */
    @TableField(value = "STATUS")
    private String status;

    /**
     * 0: Not create refund   1: created refund
     */
    @TableField(value = "REFUND_STATUS")
    private String refundStatus;

    /**
     * 取件方式 11上门取件21寄送仓库31寄送自提点
     */
    @TableField(value = "PICKUP_MODE")
    private String pickupMode;

    /**
     * 退款方式 11原路退回21退回余额31其他
     */
    @TableField(value = "REFUND_MODE")
    private String refundMode;

    /**
     * 退货类型 2101:平台退货 2102:到店退货 2103:门店退门店
     */
    @TableField(value = "after_sale_sub_type")
    private String afterSaleSubType;

    /**
     * 创建门店code
     */
    @TableField(value = "create_return_node")
    private String createReturnNode;

    /**
     * 货币代码
     */
    @TableField(value = "CURRENCY_CODE")
    private String currencyCode;

    /**
     * 退款金额(审核时，有管理员填写)
     */
    @TableField(value = "AMOUNT")
    private BigDecimal amount;

    /**
     * 退换货备注
     */
    @TableField(value = "DESCRIPTION")
    private String description;

    /**
     * 退款原因
     */
    @TableField(value = "REASON")
    private String reason;

    /**
     * 运费
     */
    @TableField(value = "FREIGHT")
    private BigDecimal freight;

    /**
     * 运费
     */
    @TableField(value = "IS_FREIGHT")
    private String isFreight;

    /**
     * 入库仓编号
     */
    @TableField(value = "IN_NODE_CODE")
    private String inNodeCode;

    /**
     * 仓库WMS系统类型
     */
    @TableField(value = "NODE_TYPE")
    private String nodeType;

    /**
     * 承运商编码
     */
    @TableField(value = "COMPANY_CODE")
    private String companyCode;

    /**
     * 承运商
     */
    @TableField(value = "COMPANY_NAME")
    private String companyName;

    /**
     * 快递单号
     */
    @TableField(value = "EXPRESS_CODE")
    private String expressCode;

    /**
     * 实际入库仓编号
     */
    @TableField(value = "ACTUAL_IN_NODE_CODE")
    private String actualInNodeCode;

    /**
     * 承运商编码
     */
    @TableField(value = "ACTUAL_COMPANY_CODE")
    private String actualCompanyCode;

    /**
     * 承运商
     */
    @TableField(value = "ACTUAL_COMPANY_NAME")
    private String actualCompanyName;

    /**
     * 快递单号
     */
    @TableField(value = "ACTUAL_EXPRESS_CODE")
    private String actualExpressCode;

    /**
     * 实际入仓时间
     */
    @TableField(value = "ACTUAL_IN_TIME")
    private Date actualInTime;

    /**
     * Image
     */
    @TableField(value = "IMAGE")
    private String image;

    /**
     * 是否有发票 1为有发票，0为没发票
     */
    @TableField(value = "IS_INVOICE")
    private String isInvoice;

    /**
     * 是否有检测报告 1为有报告，0为没报告
     */
    @TableField(value = "IS_TESTREPORT")
    private String isTestreport;

    /**
     * Email. copy order info email
     */
    @TableField(value = "EMAIL")
    private String email;

    /**
     * Mobile. copy order info mobile
     */
    @TableField(value = "MOBILE")
    private String mobile;

    /**
     * 来源1平台，2人工创建
     */
    @TableField(value = "SOURCE")
    private String source;

    /**
     * 交易来源(订单子类型)
     */
    @TableField(value = "TRADE_SOURCE")
    private String tradeSource;

    /**
     * 退货单处理扩展字段
     */
    @TableField(value = "EXT_PROPS")
    private String extProps;

    /**
     * 取消原因编码
     */
    @TableField(value = "CANCEL_CODE")
    private String cancelCode;

    /**
     * 取消失败原因
     */
    @TableField(value = "CANCEL_ERROR_REASON")
    private String cancelErrorReason;

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