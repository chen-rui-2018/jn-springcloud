package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsuredSchemeDetailed", description = "参保方案明细实体")
public class InsuredSchemeDetailed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3577940658347466968L;
	@ApiModelProperty(value = "项目id")
	private String projectId;

	@ApiModelProperty(value = "项目名称")
    private String projectName;

	@ApiModelProperty(value = "默认基数")
    private Integer defaultCardinalNumber;

	@ApiModelProperty(value = "可选基数起")
    private Integer optionalBaseStart;

	@ApiModelProperty(value = "可选基数止")
    private Integer optionalBaseEnd;

	@ApiModelProperty(value = "公司缴纳比例")
    private Integer corporateContributionRatio;

	@ApiModelProperty(value = "个人缴纳比例")
    private Integer individualContributionRatio;

	@ApiModelProperty(value = "方案ID")
    private String schemeId;

	@ApiModelProperty(value = "社保模块ID")
    private String socialSecurityId;

	@ApiModelProperty(value = "公积金模块ID")
    private String providentFundId;

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

	@ApiModelProperty(value = "项目类型：1：社保，2：公积金")
    private Byte projectType;
	
	@ApiModelProperty(value = "公司金额")
	private Double companyAmount;
	
	@ApiModelProperty(value = "个人金额")
	private Double personalAmount;

	public Double getCompanyAmount() {
		return companyAmount;
	}

	public void setCompanyAmount(Double companyAmount) {
		this.companyAmount = companyAmount;
	}

	public Double getPersonalAmount() {
		return personalAmount;
	}

	public void setPersonalAmount(Double personalAmount) {
		this.personalAmount = personalAmount;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getDefaultCardinalNumber() {
		return defaultCardinalNumber;
	}

	public void setDefaultCardinalNumber(Integer defaultCardinalNumber) {
		this.defaultCardinalNumber = defaultCardinalNumber;
	}

	public Integer getOptionalBaseStart() {
		return optionalBaseStart;
	}

	public void setOptionalBaseStart(Integer optionalBaseStart) {
		this.optionalBaseStart = optionalBaseStart;
	}

	public Integer getOptionalBaseEnd() {
		return optionalBaseEnd;
	}

	public void setOptionalBaseEnd(Integer optionalBaseEnd) {
		this.optionalBaseEnd = optionalBaseEnd;
	}

	public Integer getCorporateContributionRatio() {
		return corporateContributionRatio;
	}

	public void setCorporateContributionRatio(Integer corporateContributionRatio) {
		this.corporateContributionRatio = corporateContributionRatio;
	}

	public Integer getIndividualContributionRatio() {
		return individualContributionRatio;
	}

	public void setIndividualContributionRatio(Integer individualContributionRatio) {
		this.individualContributionRatio = individualContributionRatio;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getSocialSecurityId() {
		return socialSecurityId;
	}

	public void setSocialSecurityId(String socialSecurityId) {
		this.socialSecurityId = socialSecurityId;
	}

	public String getProvidentFundId() {
		return providentFundId;
	}

	public void setProvidentFundId(String providentFundId) {
		this.providentFundId = providentFundId;
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

	public Byte getProjectType() {
		return projectType;
	}

	public void setProjectType(Byte projectType) {
		this.projectType = projectType;
	}
	
	
}
