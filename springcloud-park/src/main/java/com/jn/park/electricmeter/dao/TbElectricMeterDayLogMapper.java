package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricMeterDayLog;
import com.jn.park.electricmeter.entity.TbElectricMeterDayLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricMeterDayLogMapper {
    long countByExample(TbElectricMeterDayLogCriteria example);

    int deleteByExample(TbElectricMeterDayLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricMeterDayLog record);

    int insertSelective(TbElectricMeterDayLog record);

    List<TbElectricMeterDayLog> selectByExample(TbElectricMeterDayLogCriteria example);

    TbElectricMeterDayLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricMeterDayLog record, @Param("example") TbElectricMeterDayLogCriteria example);

    int updateByExample(@Param("record") TbElectricMeterDayLog record, @Param("example") TbElectricMeterDayLogCriteria example);

    int updateByPrimaryKeySelective(TbElectricMeterDayLog record);

    int updateByPrimaryKey(TbElectricMeterDayLog record);
}