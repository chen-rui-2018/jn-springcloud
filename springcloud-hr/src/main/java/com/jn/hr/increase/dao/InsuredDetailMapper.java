package com.jn.hr.increase.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.InsuredDetaild;
import com.jn.hr.increase.model.InsuredDetaildPage;
import com.jn.hr.increase.model.SalaryKeyValue;

public interface InsuredDetailMapper {

	/*
	
	@MapKey("jobNumber")
	Map<String,InsuredDetaild> map(InsuredDetaildPage insuredDetaildPage);
	
	InsuredDetaild selectNameAndDepartment(@Param("姓名") String name, @Param("部门") String department);
	
	//参保方案查询
	List<InsuredDetaild> selectInsuranceschemeList(InsuredSchemePage insuredSchemePage);
	
	int selectBySchemeId(String schemdId);*/
	@MapKey("jobNumber")
	Map<String,InsuredDetaild> map(InsuredDetaildPage insuredDetaildPage);
	
	InsuredDetaild selectByJobNumberAndMonth(InsuredDetaild insuredDetaild);
	
	List<InsuredDetaild> list(InsuredDetaildPage insuredDetaildPage);
	
	@MapKey("schemeId")
	Map<String,InsuredDetaild> selectBySchemeId(InsuredDetaildPage insuredDetaildPage);
	
	InsuredDetaild selectSumByMonth(InsuredDetaild record);
	
	Integer selectBySchemeIdNumber(@Param("schemeId") String schemeId );
	//获取各部门总费用
	List<SalaryKeyValue> selectByDepartmentTotalCost(@Param("insuredMonth") String insuredMonth);
	//获取各部门公司费用
	List<SalaryKeyValue> selectByDepartmentCompanyCost(@Param("insuredMonth") String insuredMonth);
	//获取各部门个人费用
	List<SalaryKeyValue> selectByDepartmentPersonalCost(@Param("insuredMonth") String insuredMonth);
	//获取各部门人数
	List<SalaryKeyValue> selectByDepartmentNumber(@Param("insuredMonth") String insuredMonth);
	
	List<InsuredDetaild> selectByMonthAndType(@Param("insuredMonth") String insuredMonth);
	
	InsuredDetaild selectByCountNumber(@Param("insuredMonth") String insuredMonth);
	
	void insertBatch(List<InsuredDetaild> records);
	
}
