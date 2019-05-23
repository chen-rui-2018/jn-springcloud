package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyDayLog;
import com.jn.park.electricmeter.entity.TbElectricEnergyDayLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyDayLogMapper {
    long countByExample(TbElectricEnergyDayLogCriteria example);

    int deleteByExample(TbElectricEnergyDayLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyDayLog record);

    int insertSelective(TbElectricEnergyDayLog record);

    List<TbElectricEnergyDayLog> selectByExample(TbElectricEnergyDayLogCriteria example);

    TbElectricEnergyDayLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyDayLog record, @Param("example") TbElectricEnergyDayLogCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyDayLog record, @Param("example") TbElectricEnergyDayLogCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyDayLog record);

    int updateByPrimaryKey(TbElectricEnergyDayLog record);
}