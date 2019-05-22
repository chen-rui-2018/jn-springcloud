package com.jn.hr.assessment.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessmentSubsidiaryVo", description = "考核评估明细实体")
public class AssessmentSubsidiaryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6930840237419550625L;
	
	@ApiModelProperty(value = "考核项目id")
	private String id;

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

	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
