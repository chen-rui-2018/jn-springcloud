package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsureManagementPage", description = "参保管理分页实体")
public class InsureManagementPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2146814479765304584L;
	
	@ApiModelProperty(value = "参保月份")
	@DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM")
	private Date insuredMonth;
	
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
	

	public Date getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(Date insuredMonth) {
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
