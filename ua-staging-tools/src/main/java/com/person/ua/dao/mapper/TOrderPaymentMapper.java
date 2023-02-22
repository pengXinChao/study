package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.TOrderPayment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_order_payment('test_order_db.sw_report' is not BASE TABLE)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:13
* @Entity com.person.ua.dao.entity.TOrderPayment
*/
public interface TOrderPaymentMapper extends BaseMapper<TOrderPayment> {

    List<Long> selectId(@Param("orderCodes") List<String> orderCodes);

    void deleteByIds(@Param("ids") List<Long> paymentIds);
}




