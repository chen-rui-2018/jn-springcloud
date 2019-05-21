package com.jn.hr.exam.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 新增试题答案实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/17 12:29 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminaAnswerAdd", description = "新增试题答案实体")
public class ExaminaAnswerAdd implements Serializable {

	private static final long serialVersionUID = -4223380133015886086L;

	@ApiModelProperty(value = "编号ID(新增时可为空)", required = true, example = "\"1\"")
	private String id;

	@ApiModelProperty(value = "试题ID'", required = true, example = "\"2121-2121212-2121\"")
	private String testQuestionId;

	@ApiModelProperty(value = "答案编号", required = true, example = "\"A\"")
	private String answerNumber;

	@ApiModelProperty(value = "答案", required = true, example = "\"选择A\"")
	private String answerHtml;

	@ApiModelProperty(value = "备注", required = true, example = "1")
	private Integer remark;

	public ExaminaAnswerAdd() {
		super();
	}

	public ExaminaAnswerAdd(String id, String testQuestionId, String answerNumber, String answerHtml, Integer remark) {
		super();
		this.id = id;
		this.testQuestionId = testQuestionId;
		this.answerNumber = answerNumber;
		this.answerHtml = answerHtml;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestQuestionId() {
		return testQuestionId;
	}

	public void setTestQuestionId(String testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	public String getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}

	public String getAnswerHtml() {
		return answerHtml;
	}

	public void setAnswerHtml(String answerHtml) {
		this.answerHtml = answerHtml;
	}

	public Integer getRemark() {
		return remark;
	}

	public void setRemark(Integer remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ExaminaAnswerAdd {id='" + id + "', testQuestionId='" + testQuestionId + "', answerNumber='"
				+ answerNumber + "', answerHtml='" + answerHtml + "', remark='" + remark + "'}";
	}

	/*public static void main(String[] args) {
		ExaminaAnswerAdd ExaminaAnswerAdd=new ExaminaAnswerAdd();
		System.out.println(ExaminaAnswerAdd.toString());
	}*/

}
