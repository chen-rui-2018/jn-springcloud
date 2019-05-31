package com.jn.hr.attendance.dao;

import java.util.List;

import com.jn.hr.attendance.model.AttendanceManagementAdd;
import com.jn.hr.attendance.model.AttendanceManagementPage;
import com.jn.hr.attendance.model.AttendanceManagementVo;

public interface AttendanceManagementMapper {

	List<AttendanceManagementVo> list(AttendanceManagementPage record);
	
	List<AttendanceManagementVo> selectByTime(AttendanceManagementPage record);
	
	void insertBatch(List<AttendanceManagementAdd> records);
}
