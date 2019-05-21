package com.jn.hr.assessment.model;

import java.io.Serializable;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessmentTemplateDetailPage", description = "评估模板明细分页实体")
public class AssessmentTemplateDetailPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5977513331626919489L;

	@ApiModelProperty(value = "考核名称")
	private String id;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
