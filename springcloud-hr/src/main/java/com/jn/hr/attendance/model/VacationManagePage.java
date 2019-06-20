package com.jn.hr.attendance.model;

import java.io.Serializable;
import java.util.List;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModelProperty;

public class VacationManagePage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1751733747070030215L;
    
	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "部门Id")
    private String departmentId;
	
	@ApiModelProperty(value = "姓名")
    private String name;

	@ApiModelProperty(value = "工号")
    private String jobNumber;

	@ApiModelProperty(value = "假期类型")
    private String vacationType;

	@ApiModelProperty(value = "请假天数")
    private String vacationTime;

	private List<VacationManagePage> vacationList;

	@ApiModelProperty(value = "部门IDs")
	private List<String> departmentIds;
	
	
	public List<VacationManagePage> getVacationList() {
		return vacationList;
	}

	public void setVacationList(List<VacationManagePage> vacationList) {
		this.vacationList = vacationList;
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

	public List<String> getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(List<String> departmentIds) {
		this.departmentIds = departmentIds;
	}
}
