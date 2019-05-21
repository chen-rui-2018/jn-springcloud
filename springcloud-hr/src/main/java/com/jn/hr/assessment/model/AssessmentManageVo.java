package com.jn.hr.assessment.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessmentManageVo", description = "考核管理实体")
public class AssessmentManageVo extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104395556827208007L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "考核名称Id")
	private String assessmentId;
	
	@ApiModelProperty(value = "考核名称")
    private String assessmentName;

	@ApiModelProperty(value = "考核开始时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assessmentStartTime;

	@ApiModelProperty(value = "考核结束时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assessmentEndTime;

	@ApiModelProperty(value = "考核对象")
    private String assessmentObject;

	@ApiModelProperty(value = "考核人")
    private String assessmentPeople;

	@ApiModelProperty(value = "状态（1：考核中，2：已结束）")
    private Byte status;

	@ApiModelProperty(value = "考核模板ID")
    private String templateId;

	@ApiModelProperty(value = "考核模板名称")
    private String templateName;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）")
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
	
	@ApiModelProperty(value = "待归档人数")
	private Integer archiveNumber;
	
	@ApiModelProperty(value = "部门")
	private String departmentName;
	
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "考核人工号")
    private String assessmentJobNumber;
	
	@ApiModelProperty(value = "考核对象工号")
    private String assessmentObjectJobNumber;

	public String getAssessmentObjectJobNumber() {
		return assessmentObjectJobNumber;
	}

	public void setAssessmentObjectJobNumber(String assessmentObjectJobNumber) {
		this.assessmentObjectJobNumber = assessmentObjectJobNumber;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessmentJobNumber() {
		return assessmentJobNumber;
	}

	public void setAssessmentJobNumber(String assessmentJobNumber) {
		this.assessmentJobNumber = assessmentJobNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getArchiveNumber() {
		return archiveNumber;
	}

	public void setArchiveNumber(Integer archiveNumber) {
		this.archiveNumber = archiveNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public Date getAssessmentStartTime() {
		return assessmentStartTime;
	}

	public void setAssessmentStartTime(Date assessmentStartTime) {
		this.assessmentStartTime = assessmentStartTime;
	}

	public Date getAssessmentEndTime() {
		return assessmentEndTime;
	}

	public void setAssessmentEndTime(Date assessmentEndTime) {
		this.assessmentEndTime = assessmentEndTime;
	}

	public String getAssessmentObject() {
		return assessmentObject;
	}

	public void setAssessmentObject(String assessmentObject) {
		this.assessmentObject = assessmentObject;
	}

	public String getAssessmentPeople() {
		return assessmentPeople;
	}

	public void setAssessmentPeople(String assessmentPeople) {
		this.assessmentPeople = assessmentPeople;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
