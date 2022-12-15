package com.person.gtech.service.impl;

import com.person.gtech.dao.entity.K8sServerVersion;
import com.person.gtech.dao.mapper.K8sServerVersionMapper;
import com.person.gtech.service.K8sServerVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 彭心潮
 * @date 2022/11/6 21:10
 */
@Service
public class K8sServerVersionServiceImpl implements K8sServerVersionService {

    @Resource
    private K8sServerVersionMapper k8sServerVersionMapper;

    @Override
    public void save(K8sServerVersion serverVersionEntity) {
        this.k8sServerVersionMapper.insert(serverVersionEntity);
    }
}
