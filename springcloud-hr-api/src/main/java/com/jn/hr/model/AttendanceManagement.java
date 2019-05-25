package com.jn.hr.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManagement {

	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "部门Id")
    private String departmentId;
	
	@ApiModelProperty(value = "考勤年月")
	private String attendanceMonth;
	
	@ApiModelProperty(value = "签到类型（1:签到 ，2：签退）")
	private String type;
	
	@ApiModelProperty(value = "打卡时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date attendanceDate;

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

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
