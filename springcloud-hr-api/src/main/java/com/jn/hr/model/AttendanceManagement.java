package com.jn.hr.model;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManagement {

	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "部门Id")
    private String departmentId;
	
	@ApiModelProperty(value = "考勤年月")
	private String attendanceMonth;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getAttendanceMonth() {
		return attendanceMonth;
	}

	public void setAttendanceMonth(String attendanceMonth) {
		this.attendanceMonth = attendanceMonth;
	}
	
}
