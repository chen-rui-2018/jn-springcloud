package com.jn.hr.attendance.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AttendanceManagementApiVo", description = "个人考勤明细实体")
public class AttendanceManagementApiVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -153641911063319818L;
	
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
	
	@ApiModelProperty(value = "状态明细")
	private List<AttendanceKeyValue> statusDetailedList;


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

	
}
