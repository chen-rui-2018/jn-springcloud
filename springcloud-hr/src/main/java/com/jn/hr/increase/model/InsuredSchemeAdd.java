package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsuredSchemeAdd", description = "添加参保方案明细实体")
public class InsuredSchemeAdd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9065812673418365702L;
    
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

	@ApiModelProperty(value = "公积金模块ID")
    private String providentFundId;

	@ApiModelProperty(value = "最新更新时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

	@ApiModelProperty(value = "项目类型：1：社保，2：公积金")
    private Byte projectType;
	
	@ApiModelProperty(value = "参保明细对象")
	private List<InsuredSchemeDetailed> insuredSchemeDetailedList;


	public List<InsuredSchemeDetailed> getInsuredSchemeDetailedList() {
		return insuredSchemeDetailedList;
	}

	public void setInsuredSchemeDetailedList(List<InsuredSchemeDetailed> insuredSchemeDetailedList) {
		this.insuredSchemeDetailedList = insuredSchemeDetailedList;
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

	public String getProvidentFundId() {
		return providentFundId;
	}

	public void setProvidentFundId(String providentFundId) {
		this.providentFundId = providentFundId;
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
