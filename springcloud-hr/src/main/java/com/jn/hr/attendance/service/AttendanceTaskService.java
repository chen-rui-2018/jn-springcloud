package com.jn.hr.attendance.service;

import java.util.Map;

import com.jn.common.model.Result;

public interface AttendanceTaskService {

	//汇总前一天的考勤信息
	public Result<Map<String,String>> summaryAttendanceInfo();
}
