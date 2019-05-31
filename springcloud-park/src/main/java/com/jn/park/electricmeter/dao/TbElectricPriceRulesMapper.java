package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricPriceRules;
import com.jn.park.electricmeter.entity.TbElectricPriceRulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricPriceRulesMapper {
    long countByExample(TbElectricPriceRulesCriteria example);

    int deleteByExample(TbElectricPriceRulesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricPriceRules record);

    int insertSelective(TbElectricPriceRules record);

    List<TbElectricPriceRules> selectByExample(TbElectricPriceRulesCriteria example);

    TbElectricPriceRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricPriceRules record, @Param("example") TbElectricPriceRulesCriteria example);

    int updateByExample(@Param("record") TbElectricPriceRules record, @Param("example") TbElectricPriceRulesCriteria example);

    int updateByPrimaryKeySelective(TbElectricPriceRules record);

    int updateByPrimaryKey(TbElectricPriceRules record);
}