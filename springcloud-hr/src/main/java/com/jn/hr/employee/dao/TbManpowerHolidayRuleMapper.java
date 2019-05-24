package com.jn.hr.employee.dao;

import com.jn.hr.employee.entity.TbManpowerHolidayRule;
import com.jn.hr.employee.entity.TbManpowerHolidayRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerHolidayRuleMapper {
    long countByExample(TbManpowerHolidayRuleCriteria example);

    int deleteByExample(TbManpowerHolidayRuleCriteria example);

    int deleteByPrimaryKey(String ruleId);

    int insert(TbManpowerHolidayRule record);

    int insertSelective(TbManpowerHolidayRule record);

    List<TbManpowerHolidayRule> selectByExample(TbManpowerHolidayRuleCriteria example);

    TbManpowerHolidayRule selectByPrimaryKey(String ruleId);

    int updateByExampleSelective(@Param("record") TbManpowerHolidayRule record, @Param("example") TbManpowerHolidayRuleCriteria example);

    int updateByExample(@Param("record") TbManpowerHolidayRule record, @Param("example") TbManpowerHolidayRuleCriteria example);

    int updateByPrimaryKeySelective(TbManpowerHolidayRule record);

    int updateByPrimaryKey(TbManpowerHolidayRule record);
}