package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricPriceruleCompany;
import com.jn.park.electricmeter.entity.TbElectricPriceruleCompanyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricPriceruleCompanyMapper {
    long countByExample(TbElectricPriceruleCompanyCriteria example);

    int deleteByExample(TbElectricPriceruleCompanyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricPriceruleCompany record);

    int insertSelective(TbElectricPriceruleCompany record);

    List<TbElectricPriceruleCompany> selectByExample(TbElectricPriceruleCompanyCriteria example);

    TbElectricPriceruleCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricPriceruleCompany record, @Param("example") TbElectricPriceruleCompanyCriteria example);

    int updateByExample(@Param("record") TbElectricPriceruleCompany record, @Param("example") TbElectricPriceruleCompanyCriteria example);

    int updateByPrimaryKeySelective(TbElectricPriceruleCompany record);

    int updateByPrimaryKey(TbElectricPriceruleCompany record);
}