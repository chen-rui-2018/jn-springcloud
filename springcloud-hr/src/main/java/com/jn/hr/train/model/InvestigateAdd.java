package com.jn.hr.train.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 调研/问卷新增实体
 * 
 * @author： wangtt
 * @date：Created on  2019/04/15 02:54 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestigateAdd", description = "调研/问卷新增实体")
public class InvestigateAdd implements Serializable {

	private static final long serialVersionUID = 5667605446790407949L;

	// 新建及编辑项目
	@ApiModelProperty(value = "项目ID")
	private String projectId;

	@ApiModelProperty(value = "调研项目名称", required = true, example = "\"新员工入职培训需求调查\"")
	@NotNull(message = "调研项目名称不能为空")
	private String researchProject;

	@ApiModelProperty(value = "培训讲师", required = true, example = "\"张三\"")
	private String trainer;

	@ApiModelProperty(value = "是否显示培训讲师（1：显示，2：隐藏）", required = true, example = "1")
	private Byte isShowTrainer;

	@ApiModelProperty(value = "培训日期(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date trainDate;

	@ApiModelProperty(value = "是否显示培训日期(1:显示，2：隐藏)", required = true, example = "1")
	private Byte isShowTrainDate;

	@ApiModelProperty(value = "项目须知", required = true, example = "")
	private String projectNote;

	@ApiModelProperty(value = "调研二维码图片", required = true, example = "\"新员工入职培训需求调查\"")
	private String surveyDimensional;

	@ApiModelProperty(value = "调研链接", required = true, example = "\"https://www.baidu.com/\"")
	private String surveyUrl;

	@ApiModelProperty(value = "状态(1:进行中,2：已结束)", required = true, example = "1")
	private Byte status;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "1")
	private Byte recordStatus;

	@ApiModelProperty(value = "有效时间始(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeEnd;

	@ApiModelProperty(value = "调研问题列表", required = true, example = "[{\"titleId\":\"24e8c652-a581-4622-9d56-50322f5c311b\",\"projectId\":\"2f8d6a83-0ae5-41ba-a9c0-8ed08cf06e1f\",\"titleName\":\"Q2、对讲师的要求2：\",\"titleType\":1,\"isShowAnswer\":1,\"titleOptionList\":[{\"id\":\"a28676a5-c178-448f-8c2d-c636abce96db\",\"titleId\":\"24e8c652-a581-4622-9d56-50322f5c311b\",\"optionId\":\"B\",\"optionName\":\"选B2\",\"serialNumber\":2}],\"answerList\":null}]")
	private List<InvestigateQuestionAdd> questionList;

	public InvestigateAdd() {
	}

	public InvestigateAdd(String projectId, String researchProject, String trainer, Byte isShowTrainer, Date trainDate,
			Byte isShowTrainDate, String projectNote, String surveyDimensional, String surveyUrl, Byte status,
			Byte recordStatus, Date effectiveTimeStart, Date effectiveTimeEnd,
			List<InvestigateQuestionAdd> questionList) {
		super();
		this.projectId = projectId;
		this.researchProject = researchProject;
		this.trainer = trainer;
		this.isShowTrainer = isShowTrainer;
		this.trainDate = trainDate;
		this.isShowTrainDate = isShowTrainDate;
		this.projectNote = projectNote;
		this.surveyDimensional = surveyDimensional;
		this.surveyUrl = surveyUrl;
		this.status = status;
		this.recordStatus = recordStatus;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeEnd = effectiveTimeEnd;
		this.questionList = questionList;
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

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Byte getIsShowTrainer() {
		return isShowTrainer;
	}

	public void setIsShowTrainer(Byte isShowTrainer) {
		this.isShowTrainer = isShowTrainer;
	}

	public Date getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	public Byte getIsShowTrainDate() {
		return isShowTrainDate;
	}

	public void setIsShowTrainDate(Byte isShowTrainDate) {
		this.isShowTrainDate = isShowTrainDate;
	}

	public String getProjectNote() {
		return projectNote;
	}

	public void setProjectNote(String projectNote) {
		this.projectNote = projectNote;
	}

	public String getSurveyDimensional() {
		return surveyDimensional;
	}

	public void setSurveyDimensional(String surveyDimensional) {
		this.surveyDimensional = surveyDimensional;
	}

	public String getSurveyUrl() {
		return surveyUrl;
	}

	public void setSurveyUrl(String surveyUrl) {
		this.surveyUrl = surveyUrl;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	public List<InvestigateQuestionAdd> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<InvestigateQuestionAdd> questionList) {
		this.questionList = questionList;
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
		return "InvestigateAdd{projectId='" + projectId + "', researchProject='" + researchProject + "', trainer='"
				+ trainer + "', isShowTrainer='" + isShowTrainer + "', trainDate='" + trainDate + "', isShowTrainDate='"
				+ isShowTrainDate + "', projectNote='" + projectNote + "', surveyDimensional='" + surveyDimensional
				+ "', surveyUrl='" + surveyUrl + "', status='" + status + "', recordStatus='" + recordStatus
				+ "', effectiveTimeStart='" + effectiveTimeStart + "', effectiveTimeEnd='" + effectiveTimeEnd
				+ "', questionList='" + questionList + "'}";
	}

}
