package com.jn.hr.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class VacationManagement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -275570587993949385L;

	@ApiModelProperty(value = "用户id")
    private String userId;

	@ApiModelProperty(value = "请假类型")
    private String vacationType;

	@ApiModelProperty(value = "请假时长")
    private Double vacationTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	public Double getVacationTime() {
		return vacationTime;
	}

	public void setVacationTime(Double vacationTime) {
		this.vacationTime = vacationTime;
	}
    
}
