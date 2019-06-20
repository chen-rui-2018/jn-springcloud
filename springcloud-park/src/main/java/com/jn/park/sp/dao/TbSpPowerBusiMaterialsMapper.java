package com.jn.park.sp.dao;

import com.jn.park.sp.entity.TbSpPowerBusiMaterials;
import com.jn.park.sp.entity.TbSpPowerBusiMaterialsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpPowerBusiMaterialsMapper {
    long countByExample(TbSpPowerBusiMaterialsCriteria example);

    int deleteByExample(TbSpPowerBusiMaterialsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbSpPowerBusiMaterials record);

    int insertSelective(TbSpPowerBusiMaterials record);

    List<TbSpPowerBusiMaterials> selectByExample(TbSpPowerBusiMaterialsCriteria example);

    TbSpPowerBusiMaterials selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSpPowerBusiMaterials record, @Param("example") TbSpPowerBusiMaterialsCriteria example);

    int updateByExample(@Param("record") TbSpPowerBusiMaterials record, @Param("example") TbSpPowerBusiMaterialsCriteria example);

    int updateByPrimaryKeySelective(TbSpPowerBusiMaterials record);

    int updateByPrimaryKey(TbSpPowerBusiMaterials record);
}