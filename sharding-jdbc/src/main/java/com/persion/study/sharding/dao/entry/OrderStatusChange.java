package com.persion.study.sharding.dao.entry;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 彭心潮
 * @date 2022/12/31 22:48
 */
@Data
@Table(name = "t_order_status_change")
public class OrderStatusChange {

    @Id
    private Long id;

    private String domainCode;

    private String tenantCode;

    private String orgCode;

    private String orderCode;

    private String bizDocNo;

    private String type;

    private String operatorCode;

    private String remark;

    private String exStatus;

    private String status;

    private String userCode;

    private String userName;

    private String isValid;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;
}
