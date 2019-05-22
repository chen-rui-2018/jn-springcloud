package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsuredScheme", description = "参保方案实体")
public class InsuredScheme extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2497341808381967714L;
	@ApiModelProperty(value = "方案id")
	private String schemeId;

	@ApiModelProperty(value = "方案名称")
    private String schemeName;

	@ApiModelProperty(value = "参保城市id")
    private String insuredCityId;

	@ApiModelProperty(value = "参保城市名称")
    private String insuredCityName;

	@ApiModelProperty(value = "社保模块id")
    private String socialSecurityId;

	@ApiModelProperty(value = "公积金模块id")
    private String accumulationFundId;

	@ApiModelProperty(value = "参保状态")
    private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
	
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
	
	@ApiModelProperty(value = "参保明细对象")
	private List<InsuredSchemeDetailed> InsuredSchemeDetailedList;
	

	public List<InsuredSchemeDetailed> getInsuredSchemeDetailedList() {
		return InsuredSchemeDetailedList;
	}

	public void setInsuredSchemeDetailedList(List<InsuredSchemeDetailed> insuredSchemeDetailedList) {
		InsuredSchemeDetailedList = insuredSchemeDetailedList;
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

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getInsuredCityId() {
		return insuredCityId;
	}

	public void setInsuredCityId(String insuredCityId) {
		this.insuredCityId = insuredCityId;
	}

	public String getInsuredCityName() {
		return insuredCityName;
	}

	public void setInsuredCityName(String insuredCityName) {
		this.insuredCityName = insuredCityName;
	}

	public String getSocialSecurityId() {
		return socialSecurityId;
	}

	public void setSocialSecurityId(String socialSecurityId) {
		this.socialSecurityId = socialSecurityId;
	}

	public String getAccumulationFundId() {
		return accumulationFundId;
	}

	public void setAccumulationFundId(String accumulationFundId) {
		this.accumulationFundId = accumulationFundId;
	}

	public Byte getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifierAccount() {
		return modifierAccount;
	}

	public void setModifierAccount(String modifierAccount) {
		this.modifierAccount = modifierAccount;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
}
