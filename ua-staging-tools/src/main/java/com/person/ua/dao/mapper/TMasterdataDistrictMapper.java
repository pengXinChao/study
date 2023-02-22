package com.person.ua.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.person.ua.dao.entity.TMasterdataDistrict;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_masterdata_district(地区维护表)】的数据库操作Mapper
* @createDate 2022-12-22 15:45:33
* @Entity com.person.ua.dao.entity.TMasterdataDistrict
*/
public interface TMasterdataDistrictMapper extends BaseMapper<TMasterdataDistrict> {

    List<TMasterdataDistrict> queryAll();
}




