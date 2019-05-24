package com.jn.hr.attendance.model;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;

import io.swagger.annotations.ApiModelProperty;

public class VacationManageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3084424338693716743L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "工号")
    private String jobNumber;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "部门Id")
    private String departmentId;
	
	@ApiModelProperty(value = "部门名称")
    private String departmentName;
	 
	@ApiModelProperty(value = "手机号码")
	private String phone;
	 
	@ApiModelProperty(value = "职位名称")
	private String jobName;
	 
	@ApiModelProperty(value = "姓名")
    private String name;

	@ApiModelProperty(value = "假期类型")
    private String vacationType;

	@ApiModelProperty(value = "请假天数")
    private String vacationTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	public String getVacationTime() {
		return vacationTime;
	}

	public void setVacationTime(String vacationTime) {
		this.vacationTime = vacationTime;
	}
}
