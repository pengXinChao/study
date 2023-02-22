package com.person.ua.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 彭心潮
 * @date 2022/12/16 19:41
 */
@Data
public class DataValidationResult {

    private String batchNo;

    private String mainTable;

    private String orgCode;

    private String orderCode;

    private String documentNo;

    private String errorMessage;

    private Date createTime;
}
