package com.jn.hr.train.model;

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
 * [调研分析]调研结果及答案实体(请求)
 *
 * @author： wangtt
 * 
 * @date：Created on 2019/04/15 06:57 @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ResultAnswerAdd", description = " [调研分析]调研结果及答案实体")
public class ResultAnswerAdd implements Serializable {

	private static final long serialVersionUID = -5077935831187787323L;

	@ApiModelProperty(value = "结果编号(在查看[单人统计]页面需传)", required = true, example = "\"1111\"")
	private String id;

	@ApiModelProperty(value = "工号", required = true, example = "\"@212121\"")
	private String jobNumber;

	@ApiModelProperty(value = "项目ID", required = true, example = "\"1111\"")
	@NotNull(message = "项目ID不能为空")
	private String projectId;

	@ApiModelProperty(value = "姓名", required = true, example = "\"@212121\"")
	private String name;

	@ApiModelProperty(value = "手机", required = true, example = "\"12121212121\"")
	@Pattern(regexp = "^1[34578]\\d{9}$", message = "请正确输入手机号")
	private String phone;

	@ApiModelProperty(value = "（1：有效，2：无效）", required = true, example = "1")
	private Byte isEffective;

	@ApiModelProperty(value = "提交时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date submitTime;

	@ApiModelProperty(value = "题目及答案列表", required = true, example = "\"****@****\"")
	private List<InvestigateQuestion> answerInfoList;

	public ResultAnswerAdd() {
	}

	public ResultAnswerAdd(String id, String jobNumber, String projectId, String name, String phone, Byte isEffective,
			Date submitTime, List<InvestigateQuestion> answerInfoList) {
		super();
		this.id = id;
		this.jobNumber = jobNumber;
		this.projectId = projectId;
		this.name = name;
		this.phone = phone;
		this.isEffective = isEffective;
		this.submitTime = submitTime;
		this.answerInfoList = answerInfoList;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public List<InvestigateQuestion> getAnswerInfoList() {
		return answerInfoList;
	}

	public void setAnswerInfoList(List<InvestigateQuestion> answerInfoList) {
		this.answerInfoList = answerInfoList;
	}

	@Override
	public String toString() {
		return "ResultAnswerAdd{id='" + id + "', jobNumber='" + jobNumber + "', projectId='" + projectId + "', name='"
				+ name + "', phone='" + phone + "', isEffective='" + isEffective + "', submitTime='" + submitTime
				+ "', answerInfoList='" + answerInfoList + "'}";
	}

}
