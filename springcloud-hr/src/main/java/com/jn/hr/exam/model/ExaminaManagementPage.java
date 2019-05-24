package com.jn.hr.exam.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询考试实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminaManagementPage", description = "分页查询考试实体")
public class ExaminaManagementPage extends Page implements Serializable {
	private static final long serialVersionUID = 6540687067101549696L;

	@ApiModelProperty(value = "考试名称", required = true, example = "\"Q1\"")
	private String examinaName;

	@ApiModelProperty(value = "状态（1：进行中，2：已结束）", required = true, example = "\"Q1\"")
	private Byte status;

	@ApiModelProperty(value = "有效时间起(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeEnd;

	public ExaminaManagementPage() {
		super();
	}

	public ExaminaManagementPage(String examinaName, Byte status, Date effectiveTimeStart, Date effectiveTimeEnd) {
		super();
		this.examinaName = examinaName;
		this.status = status;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeEnd = effectiveTimeEnd;
	}

	public String getExaminaName() {
		return examinaName;
	}

	public void setExaminaName(String examinaName) {
		this.examinaName = examinaName;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "ExaminaManagementPage {examinaName='" + examinaName + "', status='" + status + "', effectiveTimeStart='"
				+ effectiveTimeStart + "', effectiveTimeEnd='" + effectiveTimeEnd + "'}";
	}

}
