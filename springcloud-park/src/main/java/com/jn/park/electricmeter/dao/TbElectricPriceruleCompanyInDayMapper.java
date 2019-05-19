package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricPriceruleCompanyInDay;
import com.jn.park.electricmeter.entity.TbElectricPriceruleCompanyInDayCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricPriceruleCompanyInDayMapper {
    long countByExample(TbElectricPriceruleCompanyInDayCriteria example);

    int deleteByExample(TbElectricPriceruleCompanyInDayCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricPriceruleCompanyInDay record);

    int insertSelective(TbElectricPriceruleCompanyInDay record);

    List<TbElectricPriceruleCompanyInDay> selectByExample(TbElectricPriceruleCompanyInDayCriteria example);

    TbElectricPriceruleCompanyInDay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricPriceruleCompanyInDay record, @Param("example") TbElectricPriceruleCompanyInDayCriteria example);

    int updateByExample(@Param("record") TbElectricPriceruleCompanyInDay record, @Param("example") TbElectricPriceruleCompanyInDayCriteria example);

    int updateByPrimaryKeySelective(TbElectricPriceruleCompanyInDay record);

    int updateByPrimaryKey(TbElectricPriceruleCompanyInDay record);
}