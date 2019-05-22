package com.jn.hr.train.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 结果查询实体
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/17 05:57 @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SurveyResultPage", description = "结果查询实体")
public class SurveyResultPage extends Page implements Serializable {

	private static final long serialVersionUID = 9063512121729362928L;

	@ApiModelProperty(value = "结果编号(在查看详情页需必传)", required = true, example = "\"1111\"")
	private String id;

	@ApiModelProperty(value = "姓名", required = true, example = "\"王松\"")
	private String name;

	@ApiModelProperty(value = "工号", required = true, example = "\"@21212\"")
	private String jobNumber;

	@ApiModelProperty(value = "项目ID", required = true, example = "\"1111\"")
	private String projectId;

	public SurveyResultPage() {
	}

	public SurveyResultPage(String id, String name, String jobNumber, String projectId) {
		super();
		this.id = id;
		this.name = name;
		this.jobNumber = jobNumber;
		this.projectId = projectId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Override
	public String toString() {
		return "SurveyResultPage{id='" + id + "', name='" + name + "', jobNumber='" + jobNumber + "', projectId='"
				+ projectId + "'}";
	}

}
