package com.jn.hr.employee.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.jn.hr.employee.entity.TbManpowerMobilizationManagement;

public interface MobilizationManagementMapper {

	@MapKey("jobNumber")
	public Map<String,TbManpowerMobilizationManagement> list(TbManpowerMobilizationManagement record);
	
	TbManpowerMobilizationManagement selectByJobNumber(@Param("jobNumber") String jobNumber);
	
}
