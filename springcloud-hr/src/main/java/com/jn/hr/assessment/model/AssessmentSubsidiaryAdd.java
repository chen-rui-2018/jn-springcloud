package com.jn.hr.assessment.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessmentSubsidiaryAdd", description = "考核评估明细添加实体")
public class AssessmentSubsidiaryAdd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1109922566797551162L;

	@ApiModelProperty(value = "考核项目id")
	private String id;

	@ApiModelProperty(value = "考核名称Id")
	private String assessmentId;
	
	@ApiModelProperty(value = "考核模板id")
	private String templateId;
	
	@ApiModelProperty(value = "考核人部门")
    private String assessmentDepartment;

	@ApiModelProperty(value = "考核人姓名")
    private String Name;
	
	@ApiModelProperty(value = "考核名称")
    private String assessmentName;

	@ApiModelProperty(value = "考核状态（1：未开始，2：待归档，3：已归档）")
    private Byte assessmentStatus;

	@ApiModelProperty(value = "考核人工号")
    private String assessmentJobNumber;

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssessmentDepartment() {
		return assessmentDepartment;
	}

	public void setAssessmentDepartment(String assessmentDepartment) {
		this.assessmentDepartment = assessmentDepartment;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public Byte getAssessmentStatus() {
		return assessmentStatus;
	}

	public void setAssessmentStatus(Byte assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}

	public String getAssessmentJobNumber() {
		return assessmentJobNumber;
	}

	public void setAssessmentJobNumber(String assessmentJobNumber) {
		this.assessmentJobNumber = assessmentJobNumber;
	}
}
