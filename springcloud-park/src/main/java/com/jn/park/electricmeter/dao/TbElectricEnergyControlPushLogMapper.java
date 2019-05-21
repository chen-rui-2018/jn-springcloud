package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyControlPushLog;
import com.jn.park.electricmeter.entity.TbElectricEnergyControlPushLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyControlPushLogMapper {
    long countByExample(TbElectricEnergyControlPushLogCriteria example);

    int deleteByExample(TbElectricEnergyControlPushLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyControlPushLog record);

    int insertSelective(TbElectricEnergyControlPushLog record);

    List<TbElectricEnergyControlPushLog> selectByExample(TbElectricEnergyControlPushLogCriteria example);

    TbElectricEnergyControlPushLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyControlPushLog record, @Param("example") TbElectricEnergyControlPushLogCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyControlPushLog record, @Param("example") TbElectricEnergyControlPushLogCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyControlPushLog record);

    int updateByPrimaryKey(TbElectricEnergyControlPushLog record);
}