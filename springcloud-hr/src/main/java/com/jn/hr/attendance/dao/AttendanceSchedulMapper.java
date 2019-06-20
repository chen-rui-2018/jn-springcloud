package com.jn.hr.attendance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.jn.hr.attendance.entity.TbManpowerAttendanceSchedul;
import com.jn.hr.attendance.model.AttendanceSchedulAdd;
import com.jn.hr.attendance.model.AttendanceSchedulPage;
import com.jn.hr.attendance.model.AttendanceSchedulVo;

public interface AttendanceSchedulMapper {

	List<AttendanceSchedulVo> list(AttendanceSchedulPage record);
	
	List<AttendanceSchedulVo> selectBySchedulMonth(AttendanceSchedulPage record);
	
	void updateBatch(List<AttendanceSchedulPage> records);
	                 
	void insertBatch(List<AttendanceSchedulAdd> records);
	
	AttendanceSchedulVo selectByJobNumberAndMonth(AttendanceSchedulAdd record);
	
	int updateByPrimaryKeySelective(TbManpowerAttendanceSchedul record);
	
	@MapKey("jobNumber")
	Map<String,AttendanceSchedulVo> obtainMap(AttendanceSchedulPage record);
	
}
