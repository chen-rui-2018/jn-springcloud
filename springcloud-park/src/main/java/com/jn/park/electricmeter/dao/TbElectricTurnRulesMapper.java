package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricTurnRules;
import com.jn.park.electricmeter.entity.TbElectricTurnRulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricTurnRulesMapper {
    long countByExample(TbElectricTurnRulesCriteria example);

    int deleteByExample(TbElectricTurnRulesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricTurnRules record);

    int insertSelective(TbElectricTurnRules record);

    List<TbElectricTurnRules> selectByExample(TbElectricTurnRulesCriteria example);

    TbElectricTurnRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricTurnRules record, @Param("example") TbElectricTurnRulesCriteria example);

    int updateByExample(@Param("record") TbElectricTurnRules record, @Param("example") TbElectricTurnRulesCriteria example);

    int updateByPrimaryKeySelective(TbElectricTurnRules record);

    int updateByPrimaryKey(TbElectricTurnRules record);
}