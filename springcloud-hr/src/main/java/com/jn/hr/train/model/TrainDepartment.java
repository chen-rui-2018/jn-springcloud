package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.List;

import com.jn.hr.employee.model.EmployeeBasicInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 * @author： wangtt
 * @date：Created on  2019/04/29 02:32 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "TrainDepartment", description = "员工部门组织结构实体")
public class TrainDepartment implements Serializable {
	private static final long serialVersionUID = -4525996810083115952L;
	@ApiModelProperty(value = "部门ID")
	private String departmentId;

	@ApiModelProperty(value = "部门名称")
	private String departmentName;

	@ApiModelProperty(value = "部门员工列表")
	private List<EmployeeBasicInfo> employeeBasicInfoList;

	public TrainDepartment() {
		super();
	}

	public TrainDepartment(String departmentId, String departmentName, List<EmployeeBasicInfo> employeeBasicInfoList) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeeBasicInfoList = employeeBasicInfoList;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<EmployeeBasicInfo> getEmployeeBasicInfoList() {
		return employeeBasicInfoList;
	}

	public void setEmployeeBasicInfoList(List<EmployeeBasicInfo> employeeBasicInfoList) {
		this.employeeBasicInfoList = employeeBasicInfoList;
	}

	@Override
	public String toString() {
		return "TrainDepartment {departmentId='" + departmentId + "', departmentName='" + departmentName
				+ "', employeeBasicInfoList='" + employeeBasicInfoList + "'}";
	}

}
