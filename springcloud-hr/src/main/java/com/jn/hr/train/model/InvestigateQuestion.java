package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 题目实体
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/15 06:57 @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestigateQuestion", description = " 题目实体")
public class InvestigateQuestion implements Serializable {

	private static final long serialVersionUID = -16180379655116107L;

	@ApiModelProperty(value = "题目ID", required = true, example = "\"Q1\"")
	private String titleId;

	@ApiModelProperty(value = "项目编号ID", required = true, example = "\"19f3c263-95a7-47c6-87ed-645c3e0ef691\"")
	private String projectId;

	@ApiModelProperty(value = "题目名称", required = true, example = "\"您对培训讲师最基本的要求是?\"")
	private String titleName;

	@ApiModelProperty(value = "题型（1：单选题，2：多选题，3：主观题）", required = true, example = "1")
	private Byte titleType;

	@ApiModelProperty(value = "是否必答（1：必答，2：不必答）", required = true, example = "1")
	private Byte isShowAnswer;

	@ApiModelProperty(value = "答题人工号(新增答案时不能为空)", required = true, example = "\"Q1\"")
	private String jobNumber;

	// 题目选项
	@ApiModelProperty(value = "题目选项列表", required = true, example = "[{\"id\":\"a28676a5-c178-448f-8c2d-c636abce96db\",\"titleId\":\"24e8c652-a581-4622-9d56-50322f5c311b\",\"optionId\":\"B\",\"optionName\":\"选B2\",\"serialNumber\":2},{}]")
	private List<InvestigateTitleOption> titleOptionList;

	@ApiModelProperty(value = "删除题目选项列表", required = true, example = "[{\"id\":\"a28676a5-c178-448f-8c2d-c636abce96db\",\"titleId\":\"24e8c652-a581-4622-9d56-50322f5c311b\",\"optionId\":\"B\",\"optionName\":\"选B2\",\"serialNumber\":2},{}]")
	private List<InvestigateTitleOption> deltitleOptionList;

	// 答案
	@ApiModelProperty(value = "题目答案列表", required = true, example = "[{\'id\':1},{\'id\':2}]")
	private List<InvestigateAnswer> answerList;

	public InvestigateQuestion() {

	}

	public InvestigateQuestion(String titleId, String projectId, String titleName, Byte titleType, Byte isShowAnswer,
			String jobNumber, List<InvestigateTitleOption> titleOptionList,
			List<InvestigateTitleOption> deltitleOptionList, List<InvestigateAnswer> answerList) {
		super();
		this.titleId = titleId;
		this.projectId = projectId;
		this.titleName = titleName;
		this.titleType = titleType;
		this.isShowAnswer = isShowAnswer;
		this.jobNumber = jobNumber;
		this.titleOptionList = titleOptionList;
		this.deltitleOptionList = deltitleOptionList;
		this.answerList = answerList;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Byte getTitleType() {
		return titleType;
	}

	public void setTitleType(Byte titleType) {
		this.titleType = titleType;
	}

	public Byte getIsShowAnswer() {
		return isShowAnswer;
	}

	public void setIsShowAnswer(Byte isShowAnswer) {
		this.isShowAnswer = isShowAnswer;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<InvestigateTitleOption> getTitleOptionList() {
		return titleOptionList;
	}

	public void setTitleOptionList(List<InvestigateTitleOption> titleOptionList) {
		this.titleOptionList = titleOptionList;
	}

	public List<InvestigateAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<InvestigateAnswer> answerList) {
		this.answerList = answerList;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public List<InvestigateTitleOption> getDeltitleOptionList() {
		return deltitleOptionList;
	}

	public void setDeltitleOptionList(List<InvestigateTitleOption> deltitleOptionList) {
		this.deltitleOptionList = deltitleOptionList;
	}

	@Override
	public String toString() {
		return "InvestigateQuestion {titleId='" + titleId + "', projectId='" + projectId + "', titleName='" + titleName
				+ "', titleType='" + titleType + "', isShowAnswer='" + isShowAnswer + "', jobNumber='" + jobNumber
				+ "', titleOptionList='" + titleOptionList + "', deltitleOptionList='" + deltitleOptionList
				+ "', answerList='" + answerList + "'}";
	}

}
