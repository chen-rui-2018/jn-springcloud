package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyControlTarget;
import com.jn.park.electricmeter.entity.TbElectricEnergyControlTargetCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyControlTargetMapper {
    long countByExample(TbElectricEnergyControlTargetCriteria example);

    int deleteByExample(TbElectricEnergyControlTargetCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyControlTarget record);

    int insertSelective(TbElectricEnergyControlTarget record);

    List<TbElectricEnergyControlTarget> selectByExample(TbElectricEnergyControlTargetCriteria example);

    TbElectricEnergyControlTarget selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyControlTarget record, @Param("example") TbElectricEnergyControlTargetCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyControlTarget record, @Param("example") TbElectricEnergyControlTargetCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyControlTarget record);

    int updateByPrimaryKey(TbElectricEnergyControlTarget record);
}