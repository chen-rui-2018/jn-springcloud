package com.jn.park.electricmeter.dao;

import com.jn.park.electricmeter.entity.TbElectricWarningRules;
import com.jn.park.electricmeter.entity.TbElectricWarningRulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbElectricWarningRulesMapper {
    long countByExample(TbElectricWarningRulesCriteria example);

    int deleteByExample(TbElectricWarningRulesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbElectricWarningRules record);

    int insertSelective(TbElectricWarningRules record);

    List<TbElectricWarningRules> selectByExample(TbElectricWarningRulesCriteria example);

    TbElectricWarningRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbElectricWarningRules record, @Param("example") TbElectricWarningRulesCriteria example);

    int updateByExample(@Param("record") TbElectricWarningRules record, @Param("example") TbElectricWarningRulesCriteria example);

    int updateByPrimaryKeySelective(TbElectricWarningRules record);

    int updateByPrimaryKey(TbElectricWarningRules record);
}