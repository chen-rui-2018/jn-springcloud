package com.jn.hr.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManagementApiVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5402096435312473535L;

	@ApiModelProperty(value = "考勤状态（1：迟到， 2：早退， 3：缺卡，4：加班，5：旷工，6：请假）")
	private String attendanceType;
	
	@ApiModelProperty(value = "次数")
	private String frequency;
	
	@ApiModelProperty(value = "总时长")
	private String totalTime;
	
	@ApiModelProperty(value = "部门")
    private String department;
	
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "状态时间明细")
	private List<AttendanceKeyValue> statusDetailedList;


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<AttendanceKeyValue> getStatusDetailedList() {
		return statusDetailedList;
	}

	public void setStatusDetailedList(List<AttendanceKeyValue> statusDetailedList) {
		this.statusDetailedList = statusDetailedList;
	}
	
}
