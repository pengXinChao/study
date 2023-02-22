package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.TOrderProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_order_product(订单商品明细表)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:13
* @Entity com.person.ua.dao.entity.TOrderProduct
*/
public interface TDeliveryOrderItemMapper extends BaseMapper<TOrderProduct> {

    List<Long> selectId(@Param("orderCodes")List<String> orderCodes);

    void deleteByIds(@Param("ids")List<Long> paymentIds);

}




