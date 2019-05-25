package com.jn.hr.exam.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询试题实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminabankPage", description = "分页查询试题实体")
public class ExaminabankPage extends Page implements Serializable {
	private static final long serialVersionUID = -8927916824393147994L;

	@ApiModelProperty(value = "试题内容", required = true, example = "\"单选题选择一个答案\"")
	private String examinationQuestion;

	@ApiModelProperty(value = "试题类型（1：单选题，2：多选题，3：问答题，4：判断题）", required = true, example = "\"1\"")
	private String testQuestionType;

	@ApiModelProperty(value = "创建时间", required = true, example = "\"2019-01-10 11:11:11\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "开始时间", required = true, example = "\"2019-01-10 00:00:00\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;

	@ApiModelProperty(value = "开始时间", required = true, example = "\"2019-01-10\"")
	private String startDateStr;

	@ApiModelProperty(value = "结束时间", required = true, example = "\"2019-01-10 23:59:59\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	@ApiModelProperty(value = "结束时间", required = true, example = "\"2019-01-11\"")
	private String endDateStr;

	public ExaminabankPage() {
		super();
	}

	public ExaminabankPage(String examinationQuestion, String testQuestionType, Date createdTime, Date startDate,
			String startDateStr, Date endDate, String endDateStr) {
		super();
		this.examinationQuestion = examinationQuestion;
		this.testQuestionType = testQuestionType;
		this.createdTime = createdTime;
		this.startDate = startDate;
		this.startDateStr = startDateStr;
		this.endDate = endDate;
		this.endDateStr = endDateStr;
	}

	public String getExaminationQuestion() {
		return examinationQuestion;
	}

	public void setExaminationQuestion(String examinationQuestion) {
		this.examinationQuestion = examinationQuestion;
	}

	public String getTestQuestionType() {
		return testQuestionType;
	}

	public void setTestQuestionType(String testQuestionType) {
		this.testQuestionType = testQuestionType;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	@Override
	public String toString() {
		return "ExaminabankPage {examinationQuestion='" + examinationQuestion + "', testQuestionType='"
				+ testQuestionType + "', createdTime='" + createdTime + "', startDate='" + startDate
				+ "', startDateStr='" + startDateStr + "', endDate='" + endDate + "', endDateStr='" + endDateStr + "'}";
	}

}
