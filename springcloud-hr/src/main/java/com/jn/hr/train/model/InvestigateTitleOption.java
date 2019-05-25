package com.jn.hr.train.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 题目选项实体 
 *
 * @author： wangtt
 * @date：Created on  2019/04/17 12:29 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestigateTitleOption", description = "题目选项实体")
public class InvestigateTitleOption implements Serializable {

	private static final long serialVersionUID = -4223380133015886086L;

	@ApiModelProperty(value = "编号ID", required = true, example = "\"1\"")
	private String id;

	@ApiModelProperty(value = "题目ID", required = true, example = "\"2121-2121212-2121\"")
	private String titleId;

	@ApiModelProperty(value = "选项编号", required = true, example = "\"A\"")
	private String optionId;

	@ApiModelProperty(value = "选项名称", required = true, example = "\"选择A\"")
	private String optionName;

	@ApiModelProperty(value = "序号（排序用）", required = true, example = "1")
	private Integer serialNumber;

	public InvestigateTitleOption() {
	}

	public InvestigateTitleOption(String id, String titleId, String optionId, String optionName, Integer serialNumber) {
		super();
		this.id = id;
		this.titleId = titleId;
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

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
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
		return "InvestigateTitleOption{id='" + id + "', titleId='" + titleId + "', optionId='" + optionId
				+ "', optionName='" + optionName + "', serialNumber='" + serialNumber + "'}";
	}

}
