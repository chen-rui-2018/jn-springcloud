package com.jn.hr.train.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增答案实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/21 04:45 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestigateAnswerAdd", description = " 新增答案实体")
public class InvestigateAnswerAdd implements Serializable {

	private static final long serialVersionUID = 3694672507326198636L;
	@ApiModelProperty(value = "答案编号id", required = true, example = "\"121212121\"")
	private String answerId;

	@ApiModelProperty(value = "结果表id", required = true, example = "\"121212121\"")
	private String id;

	@ApiModelProperty(value = "题目ID", required = true, example = "\"121212121\"")
	@NotNull(message = "题目ID不能为空")
	private String titleId;

	@ApiModelProperty(value = "答题人工号(新增答案时不能为空)", required = true, example = "\"Q1\"")
	@NotNull(message = "答题人工号不能为空")
	private String jobNumber;

	@ApiModelProperty(value = "选项答案（单选或多选）", required = true, example = "\"121212121\"")
	private String optionAnswer;

	@ApiModelProperty(value = "主观题答案", required = true, example = "\"121212121\"")
	private String subjectiveQuestionAnswer;

	public InvestigateAnswerAdd() {
		super();
	}

	public InvestigateAnswerAdd(String answerId, String id, String titleId, String jobNumber, String optionAnswer,
			String subjectiveQuestionAnswer) {
		super();
		this.answerId = answerId;
		this.id = id;
		this.titleId = titleId;
		this.jobNumber = jobNumber;
		this.optionAnswer = optionAnswer;
		this.subjectiveQuestionAnswer = subjectiveQuestionAnswer;
	}

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

	public String getOptionAnswer() {
		return optionAnswer;
	}

	public void setOptionAnswer(String optionAnswer) {
		this.optionAnswer = optionAnswer;
	}

	public String getSubjectiveQuestionAnswer() {
		return subjectiveQuestionAnswer;
	}

	public void setSubjectiveQuestionAnswer(String subjectiveQuestionAnswer) {
		this.subjectiveQuestionAnswer = subjectiveQuestionAnswer;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Override
	public String toString() {
		return "InvestigateAnswerAdd {answerId='" + answerId + "', id='" + id + "', titleId='" + titleId
				+ "', jobNumber='" + jobNumber + "', optionAnswer='" + optionAnswer + "', subjectiveQuestionAnswer='"
				+ subjectiveQuestionAnswer + "'}";
	}

}
