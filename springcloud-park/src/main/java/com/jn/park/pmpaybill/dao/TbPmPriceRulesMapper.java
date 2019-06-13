package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPriceRules;
import com.jn.park.pmpaybill.entity.TbPmPriceRulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPriceRulesMapper {
    long countByExample(TbPmPriceRulesCriteria example);

    int deleteByExample(TbPmPriceRulesCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPriceRules record);

    int insertSelective(TbPmPriceRules record);

    List<TbPmPriceRules> selectByExample(TbPmPriceRulesCriteria example);

    TbPmPriceRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPriceRules record, @Param("example") TbPmPriceRulesCriteria example);

    int updateByExample(@Param("record") TbPmPriceRules record, @Param("example") TbPmPriceRulesCriteria example);

    int updateByPrimaryKeySelective(TbPmPriceRules record);

    int updateByPrimaryKey(TbPmPriceRules record);
}