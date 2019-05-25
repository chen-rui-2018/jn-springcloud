package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsuredDetaildPage", description = "参保明细分页实体")
public class InsuredDetaildPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9205349525369399466L;
    
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "工号")
	private String jobNumber;
	
	@ApiModelProperty(value = "部门")
	private String department;
	
	@ApiModelProperty(value = "部门Id")
	private String departmentId;
	
	@ApiModelProperty(value = "参保城市")
	private String insuredCityName;
	
	@ApiModelProperty(value = "个人社保费")
	private Double personalSocialSecurity;
	
	@ApiModelProperty(value = "公司社保费")
	private Double companySocialSecurity;
	
	@ApiModelProperty(value = "个人公积金")
	private Double personalAccumulationFund;
	
	@ApiModelProperty(value = "公司公积金")
	private Double companyAccumulationFund;

	@ApiModelProperty(value = "参保月份")
	private String insuredMonth;
	
	@ApiModelProperty(value = "查询类型（1:社保,2:公积金,3:社保和公积金）")
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(String insuredMonth) {
		this.insuredMonth = insuredMonth;
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

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getInsuredCityName() {
		return insuredCityName;
	}

	public void setInsuredCityName(String insuredCityName) {
		this.insuredCityName = insuredCityName;
	}

	public Double getPersonalSocialSecurity() {
		return personalSocialSecurity;
	}

	public void setPersonalSocialSecurity(Double personalSocialSecurity) {
		this.personalSocialSecurity = personalSocialSecurity;
	}

	public Double getCompanySocialSecurity() {
		return companySocialSecurity;
	}

	public void setCompanySocialSecurity(Double companySocialSecurity) {
		this.companySocialSecurity = companySocialSecurity;
	}

	public Double getPersonalAccumulationFund() {
		return personalAccumulationFund;
	}

	public void setPersonalAccumulationFund(Double personalAccumulationFund) {
		this.personalAccumulationFund = personalAccumulationFund;
	}

	public Double getCompanyAccumulationFund() {
		return companyAccumulationFund;
	}

	public void setCompanyAccumulationFund(Double companyAccumulationFund) {
		this.companyAccumulationFund = companyAccumulationFund;
	}
	
}
