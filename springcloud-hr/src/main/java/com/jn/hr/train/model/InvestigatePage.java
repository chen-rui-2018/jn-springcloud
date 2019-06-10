package com.jn.hr.train.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 问题/项目分页查询实体
 *
 * @author：
 * @date： Created on 2019/3/11 19:59
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestiagePage", description = "问题/项目分页查询实体")
public class InvestigatePage extends Page implements Serializable {

	private static final long serialVersionUID = -8508653126162395433L;

	@ApiModelProperty(value = "项目ID")
	private String projectId;

	@ApiModelProperty(value = "调研项目名称", required = true, example = "\"新员工入职培训需求调查\"")
	private String researchProject;

	@ApiModelProperty(value = "有效时间始(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeEnd;

	public InvestigatePage() {
	}

	public InvestigatePage(String projectId, String researchProject, Date effectiveTimeStart, Date effectiveTimeEnd) {
		super();
		this.projectId = projectId;
		this.researchProject = researchProject;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeEnd = effectiveTimeEnd;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getResearchProject() {
		return researchProject;
	}

	public void setResearchProject(String researchProject) {
		this.researchProject = researchProject;
	}

	public Date getEffectiveTimeStart() {
		return effectiveTimeStart;
	}

	public void setEffectiveTimeStart(Date effectiveTimeStart) {
		this.effectiveTimeStart = effectiveTimeStart;
	}

	public Date getEffectiveTimeEnd() {
		return effectiveTimeEnd;
	}

	public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
		this.effectiveTimeEnd = effectiveTimeEnd;
	}

	@Override
	public String toString() {
		return "InvestigatePage{projectId='" + projectId + "', researchProject='" + researchProject
				+ "', effectiveTimeStart='" + effectiveTimeStart + "', effectiveTimeEnd='" + effectiveTimeEnd + "'}";
	}

}
