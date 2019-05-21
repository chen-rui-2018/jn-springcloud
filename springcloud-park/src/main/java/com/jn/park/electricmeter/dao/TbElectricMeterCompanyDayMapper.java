package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricMeterCompanyDay;
import com.jn.park.electricmeter.entity.TbElectricMeterCompanyDayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricMeterCompanyDayMapper {
    long countByExample(TbElectricMeterCompanyDayCriteria example);

    int deleteByExample(TbElectricMeterCompanyDayCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricMeterCompanyDay record);

    int insertSelective(TbElectricMeterCompanyDay record);

    List<TbElectricMeterCompanyDay> selectByExample(TbElectricMeterCompanyDayCriteria example);

    TbElectricMeterCompanyDay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricMeterCompanyDay record, @Param("example") TbElectricMeterCompanyDayCriteria example);

    int updateByExample(@Param("record") TbElectricMeterCompanyDay record, @Param("example") TbElectricMeterCompanyDayCriteria example);

    int updateByPrimaryKeySelective(TbElectricMeterCompanyDay record);

    int updateByPrimaryKey(TbElectricMeterCompanyDay record);
}