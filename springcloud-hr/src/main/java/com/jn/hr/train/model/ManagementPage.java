package com.jn.hr.train.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [培训列表]制定课程分页查询实体
 *
 * @author： wangtt
 * @String：Created on  2019/04/18 03:33 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ManagementPage", description = "制定课程分页实体 ")
public class ManagementPage extends Page implements Serializable {

	private static final long serialVersionUID = -4463158465391711103L;

	@ApiModelProperty(value = "培训标识ID(查询培训记录时填写)", required = true, example = "\"Q1\"")
	private String id;

	@ApiModelProperty(value = "课程名称", required = true, example = "\"Q1\"")
	private String courseTitle;

	@ApiModelProperty(value = "培训开始时间", required = true, example = "\"Q1\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private String trainStartTime;

	@ApiModelProperty(value = "培训结束时间", required = true, example = "\"Q1\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private String trainEndTime;

	@ApiModelProperty(value = "状态（1：已发送，2：未发送）", required = true, example = "\"Q1\"")
	private Byte status;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "\"Q1\"")
	private Byte recordStatus;

	public ManagementPage() {
	}

	public ManagementPage(String id, String courseTitle, String trainStartTime, String trainEndTime, Byte status,
			Byte recordStatus) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.trainStartTime = trainStartTime;
		this.trainEndTime = trainEndTime;
		this.status = status;
		this.recordStatus = recordStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getTrainStartTime() {
		return trainStartTime;
	}

	public void setTrainStartTime(String trainStartTime) {
		this.trainStartTime = trainStartTime;
	}

	public String getTrainEndTime() {
		return trainEndTime;
	}

	public void setTrainEndTime(String trainEndTime) {
		this.trainEndTime = trainEndTime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Override
	public String toString() {
		return "ManagementPage{id='" + id + "', courseTitle='" + courseTitle + "', trainStartTime='" + trainStartTime
				+ "', trainEndTime='" + trainEndTime + "', status='" + status + "', recordStatus='" + recordStatus
				+ "'}";
	}

}
