package com.person.gtech.dao.mapper;

import com.person.gtech.dao.entity.TOrderReceive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_order_receive(订单收件人表)】的数据库操作Mapper
* @createDate 2022-12-15 20:04:13
* @Entity com.person.gtech.dao.entity.TOrderReceive
*/
@Mapper
public interface TOrderReceiveMapper extends BaseMapper<TOrderReceive> {

    List<TOrderReceive> queryList(@Param("start")int startIdx, @Param("size") int pageSize);

    void updateReceive(TOrderReceive receive);
}




