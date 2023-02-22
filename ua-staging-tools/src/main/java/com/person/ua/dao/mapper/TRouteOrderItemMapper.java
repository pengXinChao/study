package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.BaseTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_fulfill_delivery_order(t_fulfill_delivery_order（发货单表）)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:12
* @Entity com.person.ua.dao.entity.TFulfillDeliveryOrder
*/
public interface TRouteOrderItemMapper extends BaseMapper<BaseTable> {


    List<Long> queryIdList(int size);

    void deleteByIds(@Param("ids") List<Long> ids);
}




