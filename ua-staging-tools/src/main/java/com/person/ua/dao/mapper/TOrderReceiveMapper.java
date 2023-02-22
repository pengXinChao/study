package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.TOrderReceive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_order_receive(订单收件人表)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:13
* @Entity com.person.ua.dao.entity.TOrderReceive
*/
@Mapper
public interface TOrderReceiveMapper extends BaseMapper<TOrderReceive> {

    List<TOrderReceive> queryList(@Param("start")int startIdx, @Param("size") int pageSize);

    void updateReceive(TOrderReceive receive);

    List<Long> selectId(@Param("orderCodes")List<String> orderCodes);

    void deleteByIds(@Param("ids")List<Long> paymentIds);
}




