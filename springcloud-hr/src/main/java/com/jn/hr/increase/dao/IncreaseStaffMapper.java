package com.jn.hr.increase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jn.hr.increase.model.IncreaseStaff;
import com.jn.hr.increase.model.IncreaseStaffPage;

public interface IncreaseStaffMapper {

	Integer increaseSelectByMonth(IncreaseStaff record);
	
	Integer reduceSelectByMonth(IncreaseStaff record);
	
	List<IncreaseStaff> list(IncreaseStaffPage record);
	
	IncreaseStaff selectByJobNumberAndMonth(@Param("jobNumber") String jobNumber, @Param("insuredMonth") String insuredMonth);
	
	List<IncreaseStaff> selectByMonth(IncreaseStaffPage record);
	
	void insertBatch(List<IncreaseStaff> records);
}
