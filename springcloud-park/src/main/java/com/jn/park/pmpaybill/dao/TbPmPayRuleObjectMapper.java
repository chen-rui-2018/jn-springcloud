package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayRuleObject;
import com.jn.park.pmpaybill.entity.TbPmPayRuleObjectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPmPayRuleObjectMapper {
    long countByExample(TbPmPayRuleObjectCriteria example);

    int deleteByExample(TbPmPayRuleObjectCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbPmPayRuleObject record);

    int insertSelective(TbPmPayRuleObject record);

    List<TbPmPayRuleObject> selectByExample(TbPmPayRuleObjectCriteria example);

    TbPmPayRuleObject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPmPayRuleObject record, @Param("example") TbPmPayRuleObjectCriteria example);

    int updateByExample(@Param("record") TbPmPayRuleObject record, @Param("example") TbPmPayRuleObjectCriteria example);

    int updateByPrimaryKeySelective(TbPmPayRuleObject record);

    int updateByPrimaryKey(TbPmPayRuleObject record);
}