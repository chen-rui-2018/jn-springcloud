package com.jn.hr.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManagementApiVo {

	@ApiModelProperty(value = "考勤状态（1：迟到， 2：早退， 3：缺卡，4：加班，5：旷工，6：请假）")
	private String attendanceType;
	
	@ApiModelProperty(value = "次数")
	private String frequency;
	
	@ApiModelProperty(value = "总时长")
	private String totalTime;
	
	@ApiModelProperty(value = "部门")
    private String department;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "迟到早退的分钟数")
	private String minute;
	
	@ApiModelProperty(value = "签到类型（1:签到 ，2：签退）")
	private String type;
	
	@ApiModelProperty(value = "状态时间明细")
	private List<AttendanceKeyValue> statusDetailedList;

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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
