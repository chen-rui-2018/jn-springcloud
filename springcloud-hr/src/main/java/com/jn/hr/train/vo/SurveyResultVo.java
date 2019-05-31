package com.jn.hr.train.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 调研结果显示实体
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/17 05:57 @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SurveyResultVo", description = "调研结果显示实体")
public class SurveyResultVo implements Serializable {

	private static final long serialVersionUID = -5035846351895765859L;

	@ApiModelProperty(value = "结果编号", required = true, example = "\"2121212\"")
	private String id;

	@ApiModelProperty(value = "工号", required = true, example = "\"@21212\"")
	private String jobNumber;

	@ApiModelProperty(value = "姓名", required = true, example = "\"lal\"")
	private String name;

	@ApiModelProperty(value = "手机号", required = true)
	@Pattern(regexp = "^1[34578]\\d{9}$", message = "请正确输入手机号")
	@NotNull(message = "手机号不能为空")
	private String phone;

	@ApiModelProperty(value = "是否有效（1：有效，2：无效）", required = true, example = "1")
	private Byte isEffective;

	@ApiModelProperty(value = "是否有效（1：有效，2：无效）", required = true, example = "有效")
	private String isEffectiveStr;

	@ApiModelProperty(value = "项目ID", required = true, example = "\"1111\"")
	private String projectId;

	@ApiModelProperty(value = "提交时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 14:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date submitTime;

	@ApiModelProperty(value = "提交时间字符串", required = true, example = "2019-12-13 14:12:12")
	private String submitTimeStr;

	@ApiModelProperty(value = "题目列表", required = true, example = "\"***\"")
	private List<AnswerVo> answerList;

	public SurveyResultVo() {
	}

	public SurveyResultVo(String id, String jobNumber, String name, String phone, Byte isEffective,
			String isEffectiveStr, String projectId, Date submitTime, String submitTimeStr, List<AnswerVo> answerList) {
		super();
		this.id = id;
		this.jobNumber = jobNumber;
		this.name = name;
		this.phone = phone;
		this.isEffective = isEffective;
		this.isEffectiveStr = isEffectiveStr;
		this.projectId = projectId;
		this.submitTime = submitTime;
		this.submitTimeStr = submitTimeStr;
		this.answerList = answerList;
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

	public Byte getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Byte isEffective) {
		this.isEffective = isEffective;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public List<AnswerVo> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<AnswerVo> answerList) {
		this.answerList = answerList;
	}

	public String getIsEffectiveStr() {
		return isEffectiveStr;
	}

	public void setIsEffectiveStr(String isEffectiveStr) {
		this.isEffectiveStr = isEffectiveStr;
	}

	public String getSubmitTimeStr() {
		return submitTimeStr;
	}

	public void setSubmitTimeStr(String submitTimeStr) {
		this.submitTimeStr = submitTimeStr;
	}

	@Override
	public String toString() {
		return "SurveyResultVo [id=" + id + ", jobNumber=" + jobNumber + ", name=" + name + ", phone=" + phone
				+ ", isEffective=" + isEffective + ", isEffectiveStr=" + isEffectiveStr + ", projectId=" + projectId
				+ ", submitTime=" + submitTime + ", submitTimeStr=" + submitTimeStr + ", answerList=" + answerList
				+ "]";
	}

}
