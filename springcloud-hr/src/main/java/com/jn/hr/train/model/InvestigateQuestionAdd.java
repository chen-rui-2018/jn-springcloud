package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增题目实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 06:57 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestigateQuestionAdd", description = "新增题目实体")
public class InvestigateQuestionAdd implements Serializable {

	private static final long serialVersionUID = -16180379655116107L;

	@ApiModelProperty(value = "题目ID(新增时可为空)", required = true, example = "\"19f3c263-95a7-47c6-87ed-645c3e0ef692\"")
	private String titleId;

	@ApiModelProperty(value = "项目id", required = true, example = "\"19f3c263-95a7-47c6-87ed-645c3e0ef691\"")
	private String projectId;

	@ApiModelProperty(value = "题目名称", required = true, example = "\"您对培训讲师最基本的要求是?\"")
	@NotNull(message = "题目名称不能为空")
	private String titleName;

	@ApiModelProperty(value = "题型（1：单选题，2：多选题，3：主观题）", required = true, example = "1")
	@NotNull(message = "题型不能为空")
	private Byte titleType;

	@ApiModelProperty(value = "是否必答（1：必答，2：不必答）", required = true, example = "1")
	@NotNull(message = "是否必答不能为空")
	private Byte isShowAnswer;

	// 选项
	@ApiModelProperty(value = "题目选项列表", required = true, example = "[{\"id\":\"a28676a5-c178-448f-8c2d-c636abce96db\",\"titleId\":\"24e8c652-a581-4622-9d56-50322f5c311b\",\"optionId\":\"B\",\"optionName\":\"选B2\",\"serialNumber\":2},{}]")
	private List<InvestigateTitleOptionAdd> titleOptionList;

	// 答案
	@ApiModelProperty(value = "题目答案列表", required = true, example = "[{\"id\":\"a28676a5-c178-448f-8c2d-c636abce96db\",\"titleId\":\"24e8c652-a581-4622-9d56-50322f5c311b\",\"optionId\":\"B\",\"optionName\":\"选B2\",\"serialNumber\":2},{}]")
	private List<InvestigateAnswerAdd> answerList;

	public InvestigateQuestionAdd() {

	}

	public InvestigateQuestionAdd(String projectId, String titleId, String titleName, Byte titleType, Byte isShowAnswer,
			List<InvestigateTitleOptionAdd> titleOptionList, List<InvestigateAnswerAdd> answerList) {
		super();
		this.projectId = projectId;
		this.titleId = titleId;
		this.titleName = titleName;
		this.titleType = titleType;
		this.isShowAnswer = isShowAnswer;
		this.titleOptionList = titleOptionList;
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

	public List<InvestigateTitleOptionAdd> getTitleOptionList() {
		return titleOptionList;
	}

	public void setTitleOptionList(List<InvestigateTitleOptionAdd> titleOptionList) {
		this.titleOptionList = titleOptionList;
	}

	public List<InvestigateAnswerAdd> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<InvestigateAnswerAdd> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "InvestigateQuestionAdd{titleId='" + titleId + "', projectId='" + projectId + "', titleName='"
				+ titleName + "', titleType='" + titleType + "', isShowAnswer='" + isShowAnswer + "', titleOptionList='"
				+ titleOptionList + "', answerList='" + answerList + "'}";
	}

}
