package com.jn.hr.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManagementApiVo {

	@ApiModelProperty(value = "考勤状态")
	private String attendanceType;
	
	@ApiModelProperty(value = "次数")
	private String frequency;
	
	@ApiModelProperty(value = "总时长")
	private String totalTime;
	
	@ApiModelProperty(value = "部门")
    private String department;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "状态时间明细")
	private List<AttendanceKeyValue> statusDetailedList;

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<AttendanceKeyValue> getStatusDetailedList() {
		return statusDetailedList;
	}

	public void setStatusDetailedList(List<AttendanceKeyValue> statusDetailedList) {
		this.statusDetailedList = statusDetailedList;
	}
	
}
