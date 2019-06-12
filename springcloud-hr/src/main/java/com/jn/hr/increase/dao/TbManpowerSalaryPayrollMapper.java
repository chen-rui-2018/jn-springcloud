package com.jn.hr.increase.dao;

import com.jn.hr.increase.entity.TbManpowerSalaryPayroll;
import com.jn.hr.increase.entity.TbManpowerSalaryPayrollCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbManpowerSalaryPayrollMapper {
    long countByExample(TbManpowerSalaryPayrollCriteria example);

    int deleteByExample(TbManpowerSalaryPayrollCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TbManpowerSalaryPayroll record);

    int insertSelective(TbManpowerSalaryPayroll record);

    List<TbManpowerSalaryPayroll> selectByExample(TbManpowerSalaryPayrollCriteria example);

    TbManpowerSalaryPayroll selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbManpowerSalaryPayroll record, @Param("example") TbManpowerSalaryPayrollCriteria example);

    int updateByExample(@Param("record") TbManpowerSalaryPayroll record, @Param("example") TbManpowerSalaryPayrollCriteria example);

    int updateByPrimaryKeySelective(TbManpowerSalaryPayroll record);

    int updateByPrimaryKey(TbManpowerSalaryPayroll record);
}