package com.jn.hr.attendance.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AttendanceManageApiVo", description = "部门考勤明细实体")
public class AttendanceManageApiVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6231404660079645913L;

	@ApiModelProperty(value = "考勤状态")
	private String attendanceType;
	
	@ApiModelProperty(value = "次数")
	private String frequency;
	
	@ApiModelProperty(value = "总时长")
	private String totalTime;
	
	@ApiModelProperty(value = "考勤时间")
	private String attendanceDate;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "考勤总人数")
	private Integer totalNumber;
	
	@ApiModelProperty(value = "人数")
	private Integer number;

	@ApiModelProperty(value = "状态考勤明细")
	private List<AttendanceManagementApiVo> statusAttendanceObject;
	
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

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
