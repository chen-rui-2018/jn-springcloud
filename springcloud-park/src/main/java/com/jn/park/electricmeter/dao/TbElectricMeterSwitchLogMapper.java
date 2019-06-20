package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricMeterSwitchLog;
import com.jn.park.electricmeter.entity.TbElectricMeterSwitchLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricMeterSwitchLogMapper {
    long countByExample(TbElectricMeterSwitchLogCriteria example);

    int deleteByExample(TbElectricMeterSwitchLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricMeterSwitchLog record);

    int insertSelective(TbElectricMeterSwitchLog record);

    List<TbElectricMeterSwitchLog> selectByExample(TbElectricMeterSwitchLogCriteria example);

    TbElectricMeterSwitchLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricMeterSwitchLog record, @Param("example") TbElectricMeterSwitchLogCriteria example);

    int updateByExample(@Param("record") TbElectricMeterSwitchLog record, @Param("example") TbElectricMeterSwitchLogCriteria example);

    int updateByPrimaryKeySelective(TbElectricMeterSwitchLog record);

    int updateByPrimaryKey(TbElectricMeterSwitchLog record);
}