package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IncreaseStaffAdd", description = "添加增员计划实体")
public class IncreaseStaffAdd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6657252105176452862L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "类型")
    private String planType;

	@ApiModelProperty(value = "参保月份")
	@DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM")
    private Date insuredMonth;

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
	
	@ApiModelProperty(value = "参保明细对象")
	private List<InsuredSchemeDetailed> insuredSchemeDetailedList;

	
	public List<InsuredSchemeDetailed> getInsuredSchemeDetailedList() {
		return insuredSchemeDetailedList;
	}

	public void setInsuredSchemeDetailedList(List<InsuredSchemeDetailed> insuredSchemeDetailedList) {
		this.insuredSchemeDetailedList = insuredSchemeDetailedList;
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

	public Date getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(Date insuredMonth) {
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
