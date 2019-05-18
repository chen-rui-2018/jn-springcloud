package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyGroupLog;
import com.jn.park.electricmeter.entity.TbElectricEnergyGroupLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyGroupLogMapper {
    long countByExample(TbElectricEnergyGroupLogCriteria example);

    int deleteByExample(TbElectricEnergyGroupLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyGroupLog record);

    int insertSelective(TbElectricEnergyGroupLog record);

    List<TbElectricEnergyGroupLog> selectByExample(TbElectricEnergyGroupLogCriteria example);

    TbElectricEnergyGroupLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyGroupLog record, @Param("example") TbElectricEnergyGroupLogCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyGroupLog record, @Param("example") TbElectricEnergyGroupLogCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyGroupLog record);

    int updateByPrimaryKey(TbElectricEnergyGroupLog record);
}