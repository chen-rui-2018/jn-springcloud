package com.jn.enterprise.propaganda.dao;

import com.jn.enterprise.propaganda.entity.TbPropagandaFeeRules;
import com.jn.enterprise.propaganda.entity.TbPropagandaFeeRulesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPropagandaFeeRulesMapper {
    long countByExample(TbPropagandaFeeRulesCriteria example);

    int deleteByExample(TbPropagandaFeeRulesCriteria example);

    int insert(TbPropagandaFeeRules record);

    int insertSelective(TbPropagandaFeeRules record);

    List<TbPropagandaFeeRules> selectByExample(TbPropagandaFeeRulesCriteria example);

    int updateByExampleSelective(@Param("record") TbPropagandaFeeRules record, @Param("example") TbPropagandaFeeRulesCriteria example);

    int updateByExample(@Param("record") TbPropagandaFeeRules record, @Param("example") TbPropagandaFeeRulesCriteria example);
}