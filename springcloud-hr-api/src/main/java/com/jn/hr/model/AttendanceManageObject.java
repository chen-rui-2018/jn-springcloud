package com.jn.hr.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManageObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5546108690920215388L;

	@ApiModelProperty(value = "考勤状态（1：迟到， 2：早退， 3：缺卡，4：加班，5：旷工，6：请假）")
	private String attendanceType;
	
	@ApiModelProperty(value = "状态对应人数")
	private Integer number;

	@ApiModelProperty(value = "状态考勤明细")
	private List<AttendanceManagementApiVo> statusAttendanceObject;

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<AttendanceManagementApiVo> getStatusAttendanceObject() {
		return statusAttendanceObject;
	}

	public void setStatusAttendanceObject(List<AttendanceManagementApiVo> statusAttendanceObject) {
		this.statusAttendanceObject = statusAttendanceObject;
	}
	
}
