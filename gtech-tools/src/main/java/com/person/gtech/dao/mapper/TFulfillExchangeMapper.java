package com.person.gtech.dao.mapper;

import com.person.gtech.dao.entity.TFulfillExchange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_fulfill_exchange(Fulfill return exchange info table (履约退换信息表))】的数据库操作Mapper
* @createDate 2022-12-15 20:04:12
* @Entity com.person.gtech.dao.entity.TFulfillExchange
*/
public interface TFulfillExchangeMapper extends BaseMapper<TFulfillExchange> {

    List<TFulfillExchange> queryList(@Param("start")int startIdx, @Param("size") int pageSize);

    void updateReceive(TFulfillExchange receive);

}




