package com.jn.hr.exam.model;

import java.io.Serializable;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 成绩明细分页查询实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminaResultPage", description = "分页查询试题实体")
public class ExaminaResultPage extends Page implements Serializable {
	private static final long serialVersionUID = -8927916824393147994L;

	@ApiModelProperty(value = "考试编号ID", required = true, example = "\"Q1\"")
	private String examinaId;

	@ApiModelProperty(value = "姓名", required = true, example = "wangsong")
	private String name;

	public ExaminaResultPage() {
		super();
	}

	public ExaminaResultPage(String examinaId, String name) {
		super();
		this.examinaId = examinaId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExaminaId() {
		return examinaId;
	}

	public void setExaminaId(String examinaId) {
		this.examinaId = examinaId;
	}

	@Override
	public String toString() {
		return "ExaminaResultPage {examinaId='" + examinaId + "', name='" + name + "'}";
	}

}
