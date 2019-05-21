package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyControlPersonConfig;
import com.jn.park.electricmeter.entity.TbElectricEnergyControlPersonConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyControlPersonConfigMapper {
    long countByExample(TbElectricEnergyControlPersonConfigCriteria example);

    int deleteByExample(TbElectricEnergyControlPersonConfigCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyControlPersonConfig record);

    int insertSelective(TbElectricEnergyControlPersonConfig record);

    List<TbElectricEnergyControlPersonConfig> selectByExample(TbElectricEnergyControlPersonConfigCriteria example);

    TbElectricEnergyControlPersonConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyControlPersonConfig record, @Param("example") TbElectricEnergyControlPersonConfigCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyControlPersonConfig record, @Param("example") TbElectricEnergyControlPersonConfigCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyControlPersonConfig record);

    int updateByPrimaryKey(TbElectricEnergyControlPersonConfig record);
}