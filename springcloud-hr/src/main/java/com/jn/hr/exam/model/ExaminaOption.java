package com.jn.hr.exam.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 试题选项实体 
 *
 * @author： wangtt
 * @date：Created on  2019/04/17 12:29 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminaOption", description = "试题选项实体")
public class ExaminaOption implements Serializable {

	private static final long serialVersionUID = -807757076673447111L;

	@ApiModelProperty(value = "编号ID(新增时可为空)", required = true, example = "\"1\"")
	private String id;

	@ApiModelProperty(value = "试题ID", required = true, example = "\"2121-2121212-2121\"")
	private String testQuestionId;

	@ApiModelProperty(value = "选项编号", required = true, example = "\"A\"")
	private String optionId;

	@ApiModelProperty(value = "选项名称", required = true, example = "\"选择A\"")
	private String optionName;

	@ApiModelProperty(value = "序号（排序用）", required = true, example = "1")
	private Integer serialNumber;

	public ExaminaOption() {
		super();
	}

	public ExaminaOption(String id, String testQuestionId, String optionId, String optionName, Integer serialNumber) {
		super();
		this.id = id;
		this.testQuestionId = testQuestionId;
		this.optionId = optionId;
		this.optionName = optionName;
		this.serialNumber = serialNumber;
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

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "ExaminaOption {id='" + id + "', testQuestionId='" + testQuestionId + "', optionId='" + optionId
				+ "', optionName='" + optionName + "', serialNumber='" + serialNumber + "'}";
	}

}
