package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayRule;
import com.jn.park.pmpaybill.entity.TbPmPayRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPayRuleMapper {
    long countByExample(TbPmPayRuleCriteria example);

    int deleteByExample(TbPmPayRuleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPayRule record);

    int insertSelective(TbPmPayRule record);

    List<TbPmPayRule> selectByExample(TbPmPayRuleCriteria example);

    TbPmPayRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPayRule record, @Param("example") TbPmPayRuleCriteria example);

    int updateByExample(@Param("record") TbPmPayRule record, @Param("example") TbPmPayRuleCriteria example);

    int updateByPrimaryKeySelective(TbPmPayRule record);

    int updateByPrimaryKey(TbPmPayRule record);
}