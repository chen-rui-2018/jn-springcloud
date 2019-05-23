package com.jn.hr.train.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.jn.hr.train.model.InvestigateAnswerAdd;
import com.jn.hr.train.model.InvestigateTitleOptionAdd;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 调研分析-调研结果汇总统计实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/17 12:29 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "AnswerVo", description = "[调研分析]调研结果汇总统计实体")
public class AnswerVo implements Serializable {

	private static final long serialVersionUID = -4223380133015886086L;

	@ApiModelProperty(value = "项目ID")
	private String projectId;

	@ApiModelProperty(value = "题目ID", required = true, example = "\"Q1\"")
	@NotNull(message = "题目ID不能为空")
	private String titleId;

	@ApiModelProperty(value = "题目名称", required = true, example = "\"您对培训讲师最基本的要求是?\"")
	@NotNull(message = "题目名称不能为空")
	private String titleName;

	@ApiModelProperty(value = "题型（1：单选题，2：多选题，3：主观题）", required = true, example = "1")
	@NotNull(message = "题型不能为空")
	private Byte titleType;

	@ApiModelProperty(value = "是否必答（1：必答，2：不必答）", required = true, example = "1")
	@NotNull(message = "是否必答不能为空")
	private Byte isShowAnswer;

	@ApiModelProperty(value = "答题人工号", required = true, example = "\"@1111\"")
	private String jobNumber;

	@ApiModelProperty(value = "选项百分比", required = true, example = "\"[A:40%,B:20%,C:40%]\"")
	private Map<String, String> percentMap;
	// 选项列表
	@ApiModelProperty(value = "题目选项列表", required = true, example = "1")
	private List<InvestigateTitleOptionAdd> titleOptionList;

	// 答案
	@ApiModelProperty(value = "题目答案列表", required = true, example = "[{\'id\':1},{\'id\':2}]")
	private List<InvestigateAnswerAdd> questionAnswerList;

	public AnswerVo() {
	}

	

	public AnswerVo(String projectId, String titleId, String titleName, Byte titleType, Byte isShowAnswer,
			String jobNumber, Map<String, String> percentMap, List<InvestigateTitleOptionAdd> titleOptionList,
			List<InvestigateAnswerAdd> questionAnswerList) {
		super();
		this.projectId = projectId;
		this.titleId = titleId;
		this.titleName = titleName;
		this.titleType = titleType;
		this.isShowAnswer = isShowAnswer;
		this.jobNumber = jobNumber;
		this.percentMap = percentMap;
		this.titleOptionList = titleOptionList;
		this.questionAnswerList = questionAnswerList;
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

	public List<InvestigateTitleOptionAdd> getTitleOptionList() {
		return titleOptionList;
	}

	public void setTitleOptionList(List<InvestigateTitleOptionAdd> titleOptionList) {
		this.titleOptionList = titleOptionList;
	}

	public List<InvestigateAnswerAdd> getQuestionAnswerList() {
		return questionAnswerList;
	}

	public void setQuestionAnswerList(List<InvestigateAnswerAdd> questionAnswerList) {
		this.questionAnswerList = questionAnswerList;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Override
	public String toString() {
		return "AnswerVo {projectId='" + projectId + "', titleId='" + titleId + "', titleName='" + titleName
				+ "', titleType='" + titleType + "', isShowAnswer='" + isShowAnswer + "', jobNumber='" + jobNumber
				+ "', percentMap='" + percentMap + "', titleOptionList='" + titleOptionList + "', questionAnswerList='"
				+ questionAnswerList + "'}";
	}



	public Map<String, String> getPercentMap() {
		return percentMap;
	}



	public void setPercentMap(Map<String, String> percentMap) {
		this.percentMap = percentMap;
	}

}
