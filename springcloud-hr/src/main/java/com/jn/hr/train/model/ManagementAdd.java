package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [培训列表]制定课程实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/18 03:33 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ManagementAdd", description = "制定课程新增实体 ")
public class ManagementAdd implements Serializable {

	private static final long serialVersionUID = -1825685116974540451L;

	@ApiModelProperty(value = "培训标识ID", required = true, example = "\"Q1\"")
	private String id;

	@ApiModelProperty(value = "课程名称", required = true, example = "\"Q1\"")
	@NotNull(message = "课程名称不能为空")
	private String courseTitle;

	@ApiModelProperty(value = "培训老师", required = true, example = "\"Q1\"")
	@NotNull(message = "培训老师不能为空")
	private String trainTeacher;

	@ApiModelProperty(value = "培训地点", required = true, example = "\"Q1\"")
	@NotNull(message = "培训地点不能为空")
	private String trainVenue;

	@ApiModelProperty(value = "培训开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "培训开始时间不能为空")
	private Date trainStartTime;

	@ApiModelProperty(value = "培训结束时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "培训结束时间不能为空")
	private Date trainEndTime;

	@ApiModelProperty(value = "状态（1：已发送，2：未发送）", required = true, example = "\"Q1\"")
	private Byte status;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "\"Q1\"")
	private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号", required = true, example = "\"Q1\"")
	private String creatorAccount;

	@ApiModelProperty(value = "创建时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号", required = true, example = "\"Q1\"")
	private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	@ApiModelProperty(value = "培训介绍信息", required = true, example = "\"Q1\"")
	@NotNull(message = "培训介绍信息不能为空")
	private String trainInfo;

	public ManagementAdd() {
	}

	public ManagementAdd(String id, String courseTitle, String trainTeacher, String trainVenue, Date trainStartTime,
			Date trainEndTime, Byte status, Byte recordStatus, String creatorAccount, Date createdTime,
			String modifierAccount, Date modifiedTime, String trainInfo) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.trainTeacher = trainTeacher;
		this.trainVenue = trainVenue;
		this.trainStartTime = trainStartTime;
		this.trainEndTime = trainEndTime;
		this.status = status;
		this.recordStatus = recordStatus;
		this.creatorAccount = creatorAccount;
		this.createdTime = createdTime;
		this.modifierAccount = modifierAccount;
		this.modifiedTime = modifiedTime;
		this.trainInfo = trainInfo;
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

	public String getTrainTeacher() {
		return trainTeacher;
	}

	public void setTrainTeacher(String trainTeacher) {
		this.trainTeacher = trainTeacher;
	}

	public String getTrainVenue() {
		return trainVenue;
	}

	public void setTrainVenue(String trainVenue) {
		this.trainVenue = trainVenue;
	}

	public Date getTrainStartTime() {
		return trainStartTime;
	}

	public void setTrainStartTime(Date trainStartTime) {
		this.trainStartTime = trainStartTime;
	}

	public Date getTrainEndTime() {
		return trainEndTime;
	}

	public void setTrainEndTime(Date trainEndTime) {
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

	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifierAccount() {
		return modifierAccount;
	}

	public void setModifierAccount(String modifierAccount) {
		this.modifierAccount = modifierAccount;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getTrainInfo() {
		return trainInfo;
	}

	public void setTrainInfo(String trainInfo) {
		this.trainInfo = trainInfo;
	}

	@Override
	public String toString() {
		return "ManagementAdd {id='" + id + "', courseTitle='" + courseTitle + "', trainTeacher='" + trainTeacher
				+ "', trainVenue='" + trainVenue + "', trainStartTime='" + trainStartTime + "', trainEndTime='"
				+ trainEndTime + "', status='" + status + "', recordStatus='" + recordStatus + "', creatorAccount='"
				+ creatorAccount + "', createdTime='" + createdTime + "', modifierAccount='" + modifierAccount
				+ "', modifiedTime='" + modifiedTime + "', trainInfo='" + trainInfo + "'}";
	}

}
