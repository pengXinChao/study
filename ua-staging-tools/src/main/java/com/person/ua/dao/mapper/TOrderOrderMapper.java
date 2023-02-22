package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.TOrderOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_order_order(订单表)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:13
* @Entity com.person.ua.dao.entity.TOrderOrder
*/
public interface TOrderOrderMapper extends BaseMapper<TOrderOrder> {

    List<String> selectAllByMemberCode(String memberCode);

    void deleteByOrderCodes(@Param("orderCodes") List<String> orderCodes);
}



