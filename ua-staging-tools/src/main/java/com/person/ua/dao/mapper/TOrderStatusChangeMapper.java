
package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.TOrderInterfaceSendRecord;
import com.person.ua.dao.entity.TOrderStatusChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_fulfill_delivery_order_item(t_fulfill_delivery_order_item（发货单行表）)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:12
* @Entity com.person.ua.dao.entity.TFulfillDeliveryOrderItem
*/
public interface TOrderStatusChangeMapper extends BaseMapper<TOrderStatusChange> {

    List<Long> selectId(@Param("orderCodes")List<String> orderCodes);

    void deleteByIds(@Param("ids")List<Long> paymentIds);
}




