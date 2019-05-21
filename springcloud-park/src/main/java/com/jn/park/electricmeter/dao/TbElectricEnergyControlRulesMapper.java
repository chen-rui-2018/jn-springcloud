package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricEnergyControlRules;
import com.jn.park.electricmeter.entity.TbElectricEnergyControlRulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricEnergyControlRulesMapper {
    long countByExample(TbElectricEnergyControlRulesCriteria example);

    int deleteByExample(TbElectricEnergyControlRulesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricEnergyControlRules record);

    int insertSelective(TbElectricEnergyControlRules record);

    List<TbElectricEnergyControlRules> selectByExample(TbElectricEnergyControlRulesCriteria example);

    TbElectricEnergyControlRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricEnergyControlRules record, @Param("example") TbElectricEnergyControlRulesCriteria example);

    int updateByExample(@Param("record") TbElectricEnergyControlRules record, @Param("example") TbElectricEnergyControlRulesCriteria example);

    int updateByPrimaryKeySelective(TbElectricEnergyControlRules record);

    int updateByPrimaryKey(TbElectricEnergyControlRules record);
}