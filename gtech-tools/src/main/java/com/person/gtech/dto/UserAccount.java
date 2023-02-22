package com.person.gtech.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 彭心潮
 * @date 2023/2/10 19:26
 */
@Data
public class UserAccount {

    private String domainCode;

    private String tenantCode;

    private String account;

    private String email;

    private String emailVerified;

    private String firstName;

    private String lastName;

    private List<String> roleCodeList;

    private String mobile;

    private String orgCode;

    private String password;

    private String userType;
}
