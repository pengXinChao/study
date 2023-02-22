package com.person.ua.dao.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 彭心潮
 * @date 2022/11/12 18:38
 */
@Data
public class BaseReceiver {

    @ApiModelProperty(value = "tenantCode", notes = "Tenant code. (租户号)")
    private String tenantCode;

    @ApiModelProperty(value = "name", notes = "Receiver name. (收件人姓名)")
    private String name;

    @ApiModelProperty(value = "mail", notes = "Receiver mail. (收件人邮箱)")
    private String mail;

    @ApiModelProperty(value = "mobile", notes = "Receiver mobile. (收件人电话)")
    private String mobile;

    @ApiModelProperty(value = "telephone", notes = "Receiver telephone. (收件人手机)")
    private String telephone;

    @ApiModelProperty(value = "address", notes = "Receiver address. (收件人地址)")
    private String address;

    @ApiModelProperty(value = "desensitizationName", notes = "Desensitization receiver name。(收件人名称-脱敏)")
    private String desensitizationName;

    @ApiModelProperty(value = "desensitizationMobile", notes = "Desensitization receiver mobile。(收件人手机-脱敏)")
    private String desensitizationMobile;

    @ApiModelProperty(value = "desensitizationTelephone", notes = "Desensitization receiver telephone。(收件人电话-脱敏)")
    private String desensitizationTelephone;

    @ApiModelProperty(value = "desensitizationEmail", notes = "Desensitization receiver email。(收件人邮箱-脱敏)")
    private String desensitizationEmail;

    @ApiModelProperty(value = "desensitizationAddress", notes = "Desensitization receiver address。(收件人地址-脱敏)")
    private String desensitizationAddress;
}
