package com.jn.hr.increase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.SalaryKeyValue;
import com.jn.hr.increase.model.SalaryPayrollAdd;
import com.jn.hr.increase.model.SalaryPayrollPage;
import com.jn.hr.increase.model.SalaryPayrollVo;

public interface SalaryPayrollMapper {

	//用时间作为判断条件
	List<SalaryPayrollVo> list(SalaryPayrollPage salaryPayrollPage);
	
	//根据部门和时间查询获取sum值
	Double selectByDepartment(SalaryPayrollPage salaryPayrollPage);
	
	//各项补贴统计
	SalaryPayrollVo selectByWage(@Param("accountEntryTime") String accountEntryTime);
	//部门工资统计
	List<SalaryKeyValue> selectByDepartmentWage(@Param("accountEntryTime") String accountEntryTime);
	//部门人力统计
	List<SalaryKeyValue> selectByPeople(@Param("accountEntryTime") String accountEntryTime);
	//部门工资统计
	List<SalaryKeyValue> selectByDepartmentCost(@Param("accountEntryTime") String accountEntryTime);
	
	void insertBatch(List<SalaryPayrollAdd> record);
}
