package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IncreaseStaff", description = "增员计划实体")
public class IncreaseStaff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797289059514560822L;
	
	@ApiModelProperty(value = "参保明细的ID")
	private String detailId;
	
	@ApiModelProperty(value = "增员计划表ID")
	private String id;

	@ApiModelProperty(value = "类型")
    private String planType;

	@ApiModelProperty(value = "参保月份")
    private String insuredMonth;

	@ApiModelProperty(value = "工号")
    private String jobNumber;

	@ApiModelProperty(value = "姓名")
    private String name;

	@ApiModelProperty(value = "部门")
    private String department;

	@ApiModelProperty(value = "参保城市id")
    private String insuredCityId;

	@ApiModelProperty(value = "参保城市名称")
    private String insuredCityName;

	@ApiModelProperty(value = "参保方案id")
    private String insuredProgrammeId;

	@ApiModelProperty(value = "参保方案名称")
    private String insuredProgrammeName;

	@ApiModelProperty(value = "是否有效：1：有效，2：无效")
    private Byte isEffective;

	@ApiModelProperty(value = "是否删除：0：标记删除，1：正常")
    private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

	@ApiModelProperty(value = "创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间")
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

	@ApiModelProperty(value = "个人缴费")
	private Double personalPayment;
	
	@ApiModelProperty(value = "公司缴费")
	private Double companyPayment;
	
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

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
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

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(String insuredMonth) {
		this.insuredMonth = insuredMonth;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getInsuredProgrammeId() {
		return insuredProgrammeId;
	}

	public void setInsuredProgrammeId(String insuredProgrammeId) {
		this.insuredProgrammeId = insuredProgrammeId;
	}

	public String getInsuredProgrammeName() {
		return insuredProgrammeName;
	}

	public void setInsuredProgrammeName(String insuredProgrammeName) {
		this.insuredProgrammeName = insuredProgrammeName;
	}

	public Byte getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Byte isEffective) {
		this.isEffective = isEffective;
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
