package com.person.gtech.dao.entity;

import lombok.Data;

/**
 * @author 彭心潮
 * @date 2022/11/6 21:02
 */
@Data
public class K8sServerVersion {

    private String serverName;

    private String version;

    private String env;
}
