package com.jn.hr.increase.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.SalaryInfo;
import com.jn.hr.increase.model.SalaryInfoPage;

public interface SalaryInfoMapper {
	int insertBatch(List<SalaryInfo> recordList);
	
	List<SalaryInfo> exportList(SalaryInfoPage record);
	
	@MapKey("jobNumber")
	Map<String,SalaryInfo> getMap(SalaryInfoPage record);
	
	//@MapKey("jobNumber")
	//Map<String,SalaryInfo> getSalaryMap(SalaryInfo record);
	
	SalaryInfo selectByJobNumber(@Param("jobNumber") String jobNumber);
	
}
