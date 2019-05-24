package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsureManagement", description = "参保管理实体")
public class InsureManagement extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146814479765304584L;

	@ApiModelProperty(value = "参保月份")
	private String insuredMonth;
	
	@ApiModelProperty(value = "参保人数")
	private Integer insuredNumber;
	
	@ApiModelProperty(value = "社保缴费")
	private Double socialSecurity;
	
	@ApiModelProperty(value = "公积金缴费")
	private Double accumulationFund;
	
	@ApiModelProperty(value = "本月增保人数")
	private Integer increaseInsuranceNumber;
	
	@ApiModelProperty(value = "本月停保人数")
	private Integer stopInsuranceNumber;

	@ApiModelProperty(value = "个人社保费")
    private Double personalSocialSecurity;

	@ApiModelProperty(value = "公司社保费")
    private Double companySocialSecurity;

	@ApiModelProperty(value = "个人公积金费")
    private Double personalAccumulationFund;

	@ApiModelProperty(value = "公司公积金费")
    private Double companyAccumulationFund;
	
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

	public String getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(String insuredMonth) {
		this.insuredMonth = insuredMonth;
	}

	public Integer getInsuredNumber() {
		return insuredNumber;
	}

	public void setInsuredNumber(Integer insuredNumber) {
		this.insuredNumber = insuredNumber;
	}

	public Double getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(Double socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public Double getAccumulationFund() {
		return accumulationFund;
	}

	public void setAccumulationFund(Double accumulationFund) {
		this.accumulationFund = accumulationFund;
	}

	public Integer getIncreaseInsuranceNumber() {
		return increaseInsuranceNumber;
	}

	public void setIncreaseInsuranceNumber(Integer increaseInsuranceNumber) {
		this.increaseInsuranceNumber = increaseInsuranceNumber;
	}

	public Integer getStopInsuranceNumber() {
		return stopInsuranceNumber;
	}

	public void setStopInsuranceNumber(Integer stopInsuranceNumber) {
		this.stopInsuranceNumber = stopInsuranceNumber;
	}
}
