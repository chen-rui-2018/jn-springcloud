package com.jn.hr.increase.model;

import java.io.Serializable;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsuredSchemePage", description = "参保方案分页实体")
public class InsuredSchemePage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1551015922081148034L;
	
	@ApiModelProperty(value = "方案名称")
    private String schemeName;
	
	@ApiModelProperty(value = "方案id")
	private String schemeId;
	
	@ApiModelProperty(value = "参保城市名称")
    private String insuredCityName;
	
	@ApiModelProperty(value = "个人社保费")
    private Double personalSocialSecurity;

	@ApiModelProperty(value = "公司社保费")
    private Double companySocialSecurity;

	@ApiModelProperty(value = "个人公积金费")
    private Double personalAccumulationFund;

	@ApiModelProperty(value = "公司公积金费")
    private Double companyAccumulationFund;
	
	@ApiModelProperty(value = "使用人数")
	private Integer number;

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
