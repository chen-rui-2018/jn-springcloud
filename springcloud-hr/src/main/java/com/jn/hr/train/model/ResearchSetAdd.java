package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [调研分析]发放调研-调研设置实体(请求)
 * 
 * @author： wangtt
 * 
 * @date：Created on 2019/04/17 10:20 @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ResearchSetAdd", description = "[调研分析]发放调研-调研设置实体")
public class ResearchSetAdd implements Serializable {

	private static final long serialVersionUID = 6421939330011614206L;

	@ApiModelProperty(value = "项目ID", required = true, example = "\"121212121\"")
	@NotNull(message = "项目ID不能为空")
	private String projectId;

	@ApiModelProperty(value = "调研方式（1：匿名调研，2：实名调研）", required = true, example = "1")
	@NotNull(message = "调研方式不能为空")
	private Byte researchMethod;

	@ApiModelProperty(value = "有效时间始(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "有效时间始不能为空")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "有效时间止不能为空")
	private Date effectiveTimeEnd;

	@ApiModelProperty(value = "调研项目名称", required = true, example = "\"新员工入职培训需求调查\"")
	private String researchProject;

	@ApiModelProperty(value = "调研二维码图片", required = true, example = "\"classpath:zxing/***.jpg\"")
	private String surveyDimensional;

	@ApiModelProperty(value = "调研链接", required = true, example = "\"https://www.***.com/\"")
	private String surveyUrl;

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

	@ApiModelProperty(value = "用户邮箱列表", required = true, example = "\"12121@qq.com,122121@qq.com\"")
	private String emailList;

	@ApiModelProperty(value = "用户邮件名称", required = true, example = "\"新入职员工调研\"")
	private String emailSubject;

	@ApiModelProperty(value = "用户邮件内容", required = true, example = "\"调研二维码：aa.jpg,调研链接:http://url.com\"")
	private String emailContent;

	public ResearchSetAdd() {
	}

	public ResearchSetAdd(String projectId, Byte researchMethod, Date effectiveTimeStart, Date effectiveTimeEnd,
			String researchProject, String surveyDimensional, String surveyUrl, Byte isShowName, Byte isShowJobNumber,
			Byte isShowPhone, Byte frequencyLimit, Byte isShowTips, String promptingLanguage, String emailList,
			String emailSubject, String emailContent) {
		super();
		this.projectId = projectId;
		this.researchMethod = researchMethod;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeEnd = effectiveTimeEnd;
		this.researchProject = researchProject;
		this.surveyDimensional = surveyDimensional;
		this.surveyUrl = surveyUrl;
		this.isShowName = isShowName;
		this.isShowJobNumber = isShowJobNumber;
		this.isShowPhone = isShowPhone;
		this.frequencyLimit = frequencyLimit;
		this.isShowTips = isShowTips;
		this.promptingLanguage = promptingLanguage;
		this.emailList = emailList;
		this.emailSubject = emailSubject;
		this.emailContent = emailContent;
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

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}

	public String getResearchProject() {
		return researchProject;
	}

	public void setResearchProject(String researchProject) {
		this.researchProject = researchProject;
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

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	@Override
	public String toString() {
		return "ResearchSetAdd {projectId='" + projectId + "', researchMethod='" + researchMethod
				+ "', effectiveTimeStart='" + effectiveTimeStart + "', effectiveTimeEnd='" + effectiveTimeEnd
				+ "', researchProject='" + researchProject + "', surveyDimensional='" + surveyDimensional
				+ "', surveyUrl='" + surveyUrl + "', isShowName='" + isShowName + "', isShowJobNumber='"
				+ isShowJobNumber + "', isShowPhone='" + isShowPhone + "', frequencyLimit='" + frequencyLimit
				+ "', isShowTips='" + isShowTips + "', promptingLanguage='" + promptingLanguage + "', emailList='"
				+ emailList + "', emailSubject='" + emailSubject + "', emailContent='" + emailContent + "'}";
	}
}
