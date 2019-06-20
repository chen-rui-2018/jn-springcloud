package com.jn.hr.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.hr.train.model.InvestigateQuestionAdd;

/**
 * [调研分析]调研项目实体(返回)
 *
 * @author： @date： Created on 2019/3/11 20:26 @version： v1.0
 * 
 * @modified By:
 **/
@ApiModel(value = "InvestigatesVo", description = "[调研分析]调研项目实体")
public class InvestigatesVo implements Serializable {
	private static final long serialVersionUID = 4315984199557297656L;

	// 调研分析分页列表显示
	@ApiModelProperty(value = "项目ID")
	private String projectId;

	@ApiModelProperty(value = "调研项目名称", required = true, example = "\"新员工入职培训需求调查\"")
	private String researchProject;

	@ApiModelProperty(value = "有效时间始(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间始(时间统一格式为yyyy-MM-dd HH:mm:ss)")
	private String effectiveTimeStartStr;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeEnd;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)")
	private String effectiveTimeEndStr;

	@ApiModelProperty(value = "状态(0:草稿，1:进行中，2：已结束)", required = true, example = "1")
	private Byte status;

	@ApiModelProperty(value = "状态(0:草稿，1:进行中，2：已结束)")
	private String statusStr;

	@ApiModelProperty(value = "创建者账号", required = true, example = "\"lal\"")
	private String creatorAccount;

	@ApiModelProperty(value = "调研二维码图片", required = true, example = "\"classpath:zxing/***.jpg\"")
	private String surveyDimensional;

	@ApiModelProperty(value = "调研链接", required = true, example = "\"https://www.***.com/\"")
	private String surveyUrl;

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

	@ApiModelProperty(value = "项目须知", required = true, example = "\"各位同学：您好!...\"")
	private String projectNote;

	@ApiModelProperty(value = "创建时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号", required = true, example = "\"lala\"")
	private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 14:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	@ApiModelProperty(value = "工号", required = true, example = "\"@212121\"")
	private String jobNumber;

	@ApiModelProperty(value = "姓名", required = true, example = "\"@212121\"")
	private String name;

	@ApiModelProperty(value = "手机", required = true, example = "\"12121212121\"")
	@Pattern(regexp = "^1[34578]\\d{9}$", message = "请正确输入手机号")
	private String phone;

	@ApiModelProperty(value = "调研方式（1：匿名调研，2：实名调研）", required = true, example = "1")
	private Byte researchMethod;

	@ApiModelProperty(value = "调研问题列表", required = true, example = "\"****@***\"")
	private List<InvestigateQuestionAdd> questionList;

	public InvestigatesVo() {
	}

	public InvestigatesVo(String projectId, String researchProject, Date effectiveTimeStart,
			String effectiveTimeStartStr, Date effectiveTimeEnd, String effectiveTimeEndStr, Byte status,
			String statusStr, String creatorAccount, String surveyDimensional, String surveyUrl, String trainer,
			Byte isShowTrainer, Date trainDate, Byte isShowTrainDate, String projectNote, Date createdTime,
			String modifierAccount, Date modifiedTime, String jobNumber, String name, String phone, Byte researchMethod,
			List<InvestigateQuestionAdd> questionList) {
		super();
		this.projectId = projectId;
		this.researchProject = researchProject;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeStartStr = effectiveTimeStartStr;
		this.effectiveTimeEnd = effectiveTimeEnd;
		this.effectiveTimeEndStr = effectiveTimeEndStr;
		this.status = status;
		this.statusStr = statusStr;
		this.creatorAccount = creatorAccount;
		this.surveyDimensional = surveyDimensional;
		this.surveyUrl = surveyUrl;
		this.trainer = trainer;
		this.isShowTrainer = isShowTrainer;
		this.trainDate = trainDate;
		this.isShowTrainDate = isShowTrainDate;
		this.projectNote = projectNote;
		this.createdTime = createdTime;
		this.modifierAccount = modifierAccount;
		this.modifiedTime = modifiedTime;
		this.jobNumber = jobNumber;
		this.name = name;
		this.phone = phone;
		this.researchMethod = researchMethod;
		this.questionList = questionList;
	}

	public String getEffectiveTimeStartStr() {
		return effectiveTimeStartStr;
	}

	public void setEffectiveTimeStartStr(String effectiveTimeStartStr) {
		this.effectiveTimeStartStr = effectiveTimeStartStr;
	}

	public String getEffectiveTimeEndStr() {
		return effectiveTimeEndStr;
	}

	public void setEffectiveTimeEndStr(String effectiveTimeEndStr) {
		this.effectiveTimeEndStr = effectiveTimeEndStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
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

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public Date getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	public String getProjectNote() {
		return projectNote;
	}

	public void setProjectNote(String projectNote) {
		this.projectNote = projectNote;
	}

	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifierAccount() {
		return modifierAccount;
	}

	public void setModifierAccount(String modifierAccount) {
		this.modifierAccount = modifierAccount;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public List<InvestigateQuestionAdd> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<InvestigateQuestionAdd> questionList) {
		this.questionList = questionList;
	}

	public Byte getIsShowTrainer() {
		return isShowTrainer;
	}

	public void setIsShowTrainer(Byte isShowTrainer) {
		this.isShowTrainer = isShowTrainer;
	}

	public Byte getIsShowTrainDate() {
		return isShowTrainDate;
	}

	public void setIsShowTrainDate(Byte isShowTrainDate) {
		this.isShowTrainDate = isShowTrainDate;
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

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Byte getResearchMethod() {
		return researchMethod;
	}

	public void setResearchMethod(Byte researchMethod) {
		this.researchMethod = researchMethod;
	}

	@Override
	public String toString() {
		return "InvestigatesVo {projectId='" + projectId + "', researchProject='" + researchProject
				+ "', effectiveTimeStart='" + effectiveTimeStart + "', effectiveTimeStartStr='" + effectiveTimeStartStr
				+ "', effectiveTimeEnd='" + effectiveTimeEnd + "', effectiveTimeEndStr='" + effectiveTimeEndStr
				+ "', status='" + status + "', statusStr='" + statusStr + "', creatorAccount='" + creatorAccount
				+ "', surveyDimensional='" + surveyDimensional + "', surveyUrl='" + surveyUrl + "', trainer='" + trainer
				+ "', isShowTrainer='" + isShowTrainer + "', trainDate='" + trainDate + "', isShowTrainDate='"
				+ isShowTrainDate + "', projectNote='" + projectNote + "', createdTime='" + createdTime
				+ "', modifierAccount='" + modifierAccount + "', modifiedTime='" + modifiedTime + "', jobNumber='"
				+ jobNumber + "', name='" + name + "', phone='" + phone + "', researchMethod='" + researchMethod
				+ "', questionList='" + questionList + "'}";
	}

}
