package com.jn.hr.train.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增题目选项实体 
 *
 * @author： wangtt
 * @date：Created on  2019/04/17 12:29 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "InvestigateTitleOptionAdd", description = "新增题目选项实体 ")
public class InvestigateTitleOptionAdd implements Serializable {

	private static final long serialVersionUID = -4223380133015886086L;

	@ApiModelProperty(value = "编号ID(新增时可为空)", required = true, example = "\"a28676a5-c178-448f-8c2d-c636abce96db\"")
	private String id;

	@ApiModelProperty(value = "题目ID", required = true, example = "\"24e8c652-a581-4622-9d56-50322f5c311b\"")
	private String titleId;

	@ApiModelProperty(value = "选项编号", required = true, example = "\"A\"")
	@NotNull(message = "选项编号不能为空")
	private String optionId;

	@ApiModelProperty(value = "选项名称", required = true, example = "\"选择A\"")
	@NotNull(message = "选项名称不能为空")
	private String optionName;

	@ApiModelProperty(value = "序号（排序用）", required = true, example = "1")
	private Integer serialNumber;

	@ApiModelProperty(value = "选项百分比", required = true, example = "100%")
	private String optionPercent;

	@ApiModelProperty(value = "选择当前选项的人数", required = true, example = "1")
	private Integer optionCount;

	public InvestigateTitleOptionAdd() {
	}

	public InvestigateTitleOptionAdd(String id, String titleId, String optionId, String optionName,
			Integer serialNumber, String optionPercent, Integer optionCount) {
		super();
		this.id = id;
		this.titleId = titleId;
		this.optionId = optionId;
		this.optionName = optionName;
		this.serialNumber = serialNumber;
		this.optionPercent = optionPercent;
		this.optionCount = optionCount;
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

	public String getOptionPercent() {
		return optionPercent;
	}

	public void setOptionPercent(String optionPercent) {
		this.optionPercent = optionPercent;
	}

	public Integer getOptionCount() {
		return optionCount;
	}

	public void setOptionCount(Integer optionCount) {
		this.optionCount = optionCount;
	}

	@Override
	public String toString() {
		return "InvestigateTitleOptionAdd {id='" + id + "', titleId='" + titleId + "', optionId='" + optionId
				+ "', optionName='" + optionName + "', serialNumber='" + serialNumber + "', optionPercent='"
				+ optionPercent + "', optionCount='" + optionCount + "'}";
	}

}
