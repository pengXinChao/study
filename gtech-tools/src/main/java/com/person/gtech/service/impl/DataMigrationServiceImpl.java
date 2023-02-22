package com.person.gtech.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.person.gtech.dao.entity.DataValidationResult;
import com.person.gtech.dao.entity.TOrderOrder;
import com.person.gtech.dao.mapper.TOrderOrderMapper;
import com.person.gtech.service.DataMigrationService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 彭心潮
 * @date 2022/12/15 20:09
 */
@Service
public class DataMigrationServiceImpl implements DataMigrationService {

    @Resource
    private TOrderOrderMapper orderMapper;

    @Override
    public void dataValidation() {
    }



    private void orderTabValidation() {
        int pageNo = 1;
        int size = 1000;
        Page<TOrderOrder> orderPage = new Page<>(pageNo, size, Boolean.FALSE);
        TOrderOrder condition = new TOrderOrder();
        while (Boolean.TRUE) {
            orderPage.setPages(pageNo);
            Wrapper<TOrderOrder> orderQueryWrapper = new QueryWrapper<>(condition);
            Page<TOrderOrder> orderPageData = this.orderMapper.selectPage(orderPage, orderQueryWrapper);
            List<TOrderOrder> orderList = orderPageData.getRecords();
            if (CollectionUtils.isEmpty(orderList)) {
                break;
            }


        }
    }


    /**
     * 订单表(t_order_order)数据校验
     *
     * 1. 订单金额校验, product_amount + freight - discount = amount
     * 2. 订单折后金额amount与t_order_product数据校验, sum(order_item.amount) + freight = amount
     * 3. 订单折前金额与t_order_product数据校验, sum(order_item.sale_price * count) = product_amount
     */
    private List<DataValidationResult> orderValidation(TOrderOrder order) {
        return null;
    }

//    private DataValidationResult
}
