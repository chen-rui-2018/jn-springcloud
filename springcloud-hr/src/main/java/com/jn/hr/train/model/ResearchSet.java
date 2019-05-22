package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [调研分析]发放调研-调研设置实体(请求)
 * 
 * @author： wangtt
 * @date：Created on  2019/04/17 10:20 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ResearchSet", description = "[调研分析]发放调研-调研设置实体")
public class ResearchSet implements Serializable {

	private static final long serialVersionUID = 6421939330011614206L;

	@ApiModelProperty(value = "项目ID", required = true, example = "\"121212121\"")
	private String projectId;

	@ApiModelProperty(value = "调研项目名称", required = true, example = "\"新员工入职培训需求调查\"")
	private String researchProject;

	@ApiModelProperty(value = "项目须知", required = true, example = "\"各位同学：您好!...\"")
	private String projectNote;

	@ApiModelProperty(value = "调研二维码图片", required = true, example = "\"classpath:zxing/***.jpg\"")
	private String surveyDimensional;

	@ApiModelProperty(value = "调研链接", required = true, example = "\"https://www.***.com/\"")
	private String surveyUrl;

	@ApiModelProperty(value = "状态(0:草稿-未发送,1:进行中,2：已结束)", required = true, example = "1")
	private Byte status;

	@ApiModelProperty(value = "有效时间始(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeEnd;

	@ApiModelProperty(value = "调研方式（1：匿名调研，2：实名调研）", required = true, example = "1")
	private Byte researchMethod;

	@ApiModelProperty(value = "是否显示姓名（1：显示，2 不显示）", required = true, example = "1")
	private Byte isShowName;

	@ApiModelProperty(value = "是否显示工号（1：显示，2 不显示）", required = true, example = "1")
	private Byte isShowJobNumber;

	@ApiModelProperty(value = "是否显示手机（1：显示，2 不显示）", required = true, example = "1")
	private Byte isShowPhone;

	@ApiModelProperty(value = "次数限制（1：代表已勾选-每个学员只能调研一次，2：代表未勾选-可多次填写）", required = true, example = "1")
	private Byte frequencyLimit;

	@ApiModelProperty(value = "是否显示提示（1：显示，2：隐藏）", required = true, example = "1")
	private Byte isShowTips;

	@ApiModelProperty(value = "调研结束提示语", required = true, example = "\"已完成\"")
	private String promptingLanguage;

	public ResearchSet() {
	}

	public ResearchSet(String projectId, String researchProject, String projectNote, String surveyDimensional,
			String surveyUrl, Byte status, Date effectiveTimeStart, Date effectiveTimeEnd, Byte researchMethod,
			Byte isShowName, Byte isShowJobNumber, Byte isShowPhone, Byte frequencyLimit, Byte isShowTips,
			String promptingLanguage) {
		super();
		this.projectId = projectId;
		this.researchProject = researchProject;
		this.projectNote = projectNote;
		this.surveyDimensional = surveyDimensional;
		this.surveyUrl = surveyUrl;
		this.status = status;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeEnd = effectiveTimeEnd;
		this.researchMethod = researchMethod;
		this.isShowName = isShowName;
		this.isShowJobNumber = isShowJobNumber;
		this.isShowPhone = isShowPhone;
		this.frequencyLimit = frequencyLimit;
		this.isShowTips = isShowTips;
		this.promptingLanguage = promptingLanguage;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Byte getResearchMethod() {
		return researchMethod;
	}

	public void setResearchMethod(Byte researchMethod) {
		this.researchMethod = researchMethod;
	}

	public Byte getIsShowName() {
		return isShowName;
	}

	public void setIsShowName(Byte isShowName) {
		this.isShowName = isShowName;
	}

	public Byte getIsShowJobNumber() {
		return isShowJobNumber;
	}

	public void setIsShowJobNumber(Byte isShowJobNumber) {
		this.isShowJobNumber = isShowJobNumber;
	}

	public Byte getIsShowPhone() {
		return isShowPhone;
	}

	public void setIsShowPhone(Byte isShowPhone) {
		this.isShowPhone = isShowPhone;
	}

	public Byte getFrequencyLimit() {
		return frequencyLimit;
	}

	public void setFrequencyLimit(Byte frequencyLimit) {
		this.frequencyLimit = frequencyLimit;
	}

	public Byte getIsShowTips() {
		return isShowTips;
	}

	public void setIsShowTips(Byte isShowTips) {
		this.isShowTips = isShowTips;
	}

	public String getPromptingLanguage() {
		return promptingLanguage;
	}

	public void setPromptingLanguage(String promptingLanguage) {
		this.promptingLanguage = promptingLanguage;
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

	public String getResearchProject() {
		return researchProject;
	}

	public void setResearchProject(String researchProject) {
		this.researchProject = researchProject;
	}

	public String getProjectNote() {
		return projectNote;
	}

	public void setProjectNote(String projectNote) {
		this.projectNote = projectNote;
	}

	@Override
	public String toString() {
		return "ResearchSet {projectId='" + projectId + "', researchProject='" + researchProject + "', projectNote='"
				+ projectNote + "', surveyDimensional='" + surveyDimensional + "', surveyUrl='" + surveyUrl
				+ "', status='" + status + "', effectiveTimeStart='" + effectiveTimeStart + "', effectiveTimeEnd='"
				+ effectiveTimeEnd + "', researchMethod='" + researchMethod + "', isShowName='" + isShowName
				+ "', isShowJobNumber='" + isShowJobNumber + "', isShowPhone='" + isShowPhone + "', frequencyLimit='"
				+ frequencyLimit + "', isShowTips='" + isShowTips + "', promptingLanguage='" + promptingLanguage + "'}";
	}

}
