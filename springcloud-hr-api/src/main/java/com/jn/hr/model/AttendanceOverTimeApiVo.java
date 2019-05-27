package com.jn.hr.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceOverTimeApiVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5875988702216475920L;

	@ApiModelProperty(value = "迟到早退的分钟数")
	private String minute;
	
	@ApiModelProperty(value = "签到类型（1:签到 ，2：签退）")
	private String type;
	
	@ApiModelProperty(value = "用户id")
	private String userId;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
