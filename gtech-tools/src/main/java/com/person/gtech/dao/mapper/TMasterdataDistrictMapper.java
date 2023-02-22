package com.person.gtech.dao.mapper;

import com.person.gtech.dao.entity.TMasterdataDistrict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author pxc16
* @description 针对表【t_masterdata_district(地区维护表)】的数据库操作Mapper
* @createDate 2022-12-22 15:45:33
* @Entity com.person.gtech.dao.entity.TMasterdataDistrict
*/
public interface TMasterdataDistrictMapper extends BaseMapper<TMasterdataDistrict> {

    List<TMasterdataDistrict> queryAll();
}




