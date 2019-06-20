package com.jn.hr.attendance.dao;

import java.util.List;

import com.jn.hr.attendance.model.AttendanceTimeSetAdd;
import com.jn.hr.attendance.model.AttendanceTimeSetPage;
import com.jn.hr.attendance.model.AttendanceTimeSetVo;

public interface AttendanceTimeSetMapper {

	void insertBatch(AttendanceTimeSetAdd record);
	
	List<AttendanceTimeSetVo> list(AttendanceTimeSetPage attendanceTimeSetPage);
	
	AttendanceTimeSetVo selectByAttendanceType(AttendanceTimeSetPage attendanceTimeSetPage);
	
	void updateByStatus(AttendanceTimeSetAdd attendanceTimeSetAdd);
	
}
