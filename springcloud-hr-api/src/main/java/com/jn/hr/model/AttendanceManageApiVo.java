package com.jn.hr.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManageApiVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4511930815495946073L;
	
	@ApiModelProperty(value = "考勤部门总人数")
	private Integer totalNumber;

	@ApiModelProperty(value = "状态考勤明细")
	private List<AttendanceManageObject> attendanceList;

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}	
	
	public List<AttendanceManageObject> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<AttendanceManageObject> attendanceList) {
		this.attendanceList = attendanceList;
	}

}
