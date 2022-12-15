package com.person.gtech.service;

import com.person.gtech.dao.entity.K8sServerVersion;

/**
 * @author 彭心潮
 * @date 2022/11/6 21:10
 */
public interface K8sServerVersionService {

    /**
     * 数据保存
     *
     * @param serverVersionEntity com.person.gtech.dao.entity.K8sServerVersionEntity
     */
    void save(K8sServerVersion serverVersionEntity);
}
