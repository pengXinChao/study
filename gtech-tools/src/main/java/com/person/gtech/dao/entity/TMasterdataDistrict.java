package com.person.gtech.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 地区维护表
 * @TableName t_masterdata_district
 */
@TableName(value ="t_masterdata_district")
@Data
public class TMasterdataDistrict implements Serializable {
    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 地区代码
     */
    @TableField(value = "DISTRICT_CODE")
    private String districtCode;

    /**
     * 父及地区关系
     */
    @TableField(value = "DISTRICT_PCODE")
    private String districtPcode;

    /**
     * 地区名称
     */
    @TableField(value = "DISTRICT_NAME")
    private String districtName;

    /**
     * 子属级别关系
     */
    @TableField(value = "LEVEL")
    private Integer level;

    /**
     * 租户代码
     */
    @TableField(value = "TENANT_CODE")
    private String tenantCode;

    /**
     * 状态1启用0停用
     */
    @TableField(value = "STATE")
    private Integer state;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 
     */
    @TableField(value = "UPDATE_USER")
    private String updateUser;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 
     */
    @TableField(value = "CREATE_USER")
    private String createUser;

    /**
     * 
     */
    @TableField(value = "DISTRICT_MATCH")
    private String districtMatch;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}