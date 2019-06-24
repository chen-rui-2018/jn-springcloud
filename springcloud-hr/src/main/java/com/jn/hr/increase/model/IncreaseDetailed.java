package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IncreaseDetailed", description = "员工参保明细实体")
public class IncreaseDetailed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7420930647872077934L;
	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "参保月份")
    private String insuredMonth;

	@ApiModelProperty(value = "工号")
    private String jobNumber;

	@ApiModelProperty(value = "项目id")
    private String projectId;
	
	@ApiModelProperty(value = "方案Id")
    private String schemeId;
	
	@ApiModelProperty(value = "方案名称")
    private String schemeName;

	@ApiModelProperty(value = "默认基数")
    private Integer defaultCardinalNumber;

	@ApiModelProperty(value = "公司缴纳比例")
    private Integer corporateContributionRatio;

	@ApiModelProperty(value = "个人缴纳比例")
    private Integer individualContributionRatio;

	@ApiModelProperty(value = "项目类型：1：社保，2：公积金")
    private Byte projectType;
	
	@ApiModelProperty(value = "参保人数")
	private Integer number;

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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Integer getDefaultCardinalNumber() {
		return defaultCardinalNumber;
	}

	public void setDefaultCardinalNumber(Integer defaultCardinalNumber) {
		this.defaultCardinalNumber = defaultCardinalNumber;
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

	public Byte getProjectType() {
		return projectType;
	}

	public void setProjectType(Byte projectType) {
		this.projectType = projectType;
	}
    
}
