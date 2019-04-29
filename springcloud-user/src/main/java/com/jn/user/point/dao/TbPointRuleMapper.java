package com.jn.user.point.dao;

import com.jn.user.point.entity.TbPointRule;
import com.jn.user.point.entity.TbPointRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPointRuleMapper {
    long countByExample(TbPointRuleCriteria example);

    int deleteByExample(TbPointRuleCriteria example);

    int deleteByPrimaryKey(String ruleId);

    int insert(TbPointRule record);

    int insertSelective(TbPointRule record);

    List<TbPointRule> selectByExample(TbPointRuleCriteria example);

    TbPointRule selectByPrimaryKey(String ruleId);

    int updateByExampleSelective(@Param("record") TbPointRule record, @Param("example") TbPointRuleCriteria example);

    int updateByExample(@Param("record") TbPointRule record, @Param("example") TbPointRuleCriteria example);

    int updateByPrimaryKeySelective(TbPointRule record);

    int updateByPrimaryKey(TbPointRule record);
}