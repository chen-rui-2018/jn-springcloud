package com.jn.hr.assessment.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class AssessmentTemplateDetailAdd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3379647029826163177L;

	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "模板名称")
    private String templateName;

	@ApiModelProperty(value = "目标类别")
    private String targetCategory;

	@ApiModelProperty(value = "序号")
    private Integer serialNumber;

	@ApiModelProperty(value = "考核目标")
    private String assessmentTarget;

	@ApiModelProperty(value = "分值")
    private Integer score;

	@ApiModelProperty(value = "评分细则")
    private String scoreRubric;

	@ApiModelProperty(value = "牵头考核部门")
    private String leadAssessmentDepartment;

	@ApiModelProperty(value = "考核模板ID")
    private String templateId;
	
	@ApiModelProperty(value = "考核得分")
	private Integer assessmentScore;

	@ApiModelProperty(value = "扣分原因")
    private String causeDeduction;
	
	@ApiModelProperty(value = "工号")
	private String jobNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Integer getAssessmentScore() {
		return assessmentScore;
	}

	public void setAssessmentScore(Integer assessmentScore) {
		this.assessmentScore = assessmentScore;
	}

	public String getCauseDeduction() {
		return causeDeduction;
	}

	public void setCauseDeduction(String causeDeduction) {
		this.causeDeduction = causeDeduction;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTargetCategory() {
		return targetCategory;
	}

	public void setTargetCategory(String targetCategory) {
		this.targetCategory = targetCategory;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getAssessmentTarget() {
		return assessmentTarget;
	}

	public void setAssessmentTarget(String assessmentTarget) {
		this.assessmentTarget = assessmentTarget;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getScoreRubric() {
		return scoreRubric;
	}

	public void setScoreRubric(String scoreRubric) {
		this.scoreRubric = scoreRubric;
	}

	public String getLeadAssessmentDepartment() {
		return leadAssessmentDepartment;
	}

	public void setLeadAssessmentDepartment(String leadAssessmentDepartment) {
		this.leadAssessmentDepartment = leadAssessmentDepartment;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
}
