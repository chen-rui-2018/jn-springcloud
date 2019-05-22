package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IncreaseStaffPage", description = "增减员计划分页实体")
public class IncreaseStaffPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5613079757507085089L;
    
	@ApiModelProperty(value = "类型",example = "增员")
	private String planType;
	
	@ApiModelProperty(value = "参保月份")
	@DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM")
	private Date insuredMonth;
	
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "参保城市")
	private String insuredCityName;
	
	@ApiModelProperty(value = "参保方案")
	private String insuredProgrammeName;
	
	@ApiModelProperty(value = "个人缴费")
	private Double personalPayment;

	@ApiModelProperty(value = "公司缴费")
	private Double companyPayment;
	
	@ApiModelProperty(value = "参保明细的ID")
	private String detailId;
	
	@ApiModelProperty(value = "增员计划表ID")
	private String id;

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public Date getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(Date insuredMonth) {
		this.insuredMonth = insuredMonth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsuredCityName() {
		return insuredCityName;
	}

	public void setInsuredCityName(String insuredCityName) {
		this.insuredCityName = insuredCityName;
	}

	public String getInsuredProgrammeName() {
		return insuredProgrammeName;
	}

	public void setInsuredProgrammeName(String insuredProgrammeName) {
		this.insuredProgrammeName = insuredProgrammeName;
	}

	public Double getPersonalPayment() {
		return personalPayment;
	}

	public void setPersonalPayment(Double personalPayment) {
		this.personalPayment = personalPayment;
	}

	public Double getCompanyPayment() {
		return companyPayment;
	}

	public void setCompanyPayment(Double companyPayment) {
		this.companyPayment = companyPayment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
