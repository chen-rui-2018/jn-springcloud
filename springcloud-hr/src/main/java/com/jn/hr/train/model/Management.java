package com.jn.hr.train.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.hr.employee.model.EmployeeBasicInfo;

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
@ApiModel(value = "Management", description = "制定课程实体 ")
public class Management implements Serializable {

	private static final long serialVersionUID = -1825685116974540451L;

	@ApiModelProperty(value = "培训标识ID", required = true, example = "\"Q1\"")
	@NotNull(message = "培训标识ID不能为空")
	private String id;

	@ApiModelProperty(value = "课程名称", required = true, example = "\"Q1\"")
	private String courseTitle;

	@ApiModelProperty(value = "培训老师", required = true, example = "\"Q1\"")
	private String trainTeacher;

	@ApiModelProperty(value = "培训地点", required = true, example = "\"Q1\"")
	private String trainVenue;

	@ApiModelProperty(value = "培训开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date trainStartTime;

	@ApiModelProperty(value = "培训开始时间(时间统一格式为yyyy-MM-dd HH:mm:ss)")
	private String trainStartTimeStr;

	@ApiModelProperty(value = "培训结束时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date trainEndTime;

	@ApiModelProperty(value = "培训结束时间(时间统一格式为yyyy-MM-dd HH:mm:ss)")
	private String trainEndTimeStr;

	@ApiModelProperty(value = "状态（1：已发送，2：未发送）", required = true, example = "\"Q1\"")
	private Byte status;

	@ApiModelProperty(value = "状态（1：已发送，2：未发送）")
	private String statusStr;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "\"Q1\"")
	private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号", required = true, example = "\"Q1\"")
	private String creatorAccount;

	@ApiModelProperty(value = "创建时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "创建时间(时间统一格式为yyyy-MM-dd HH:mm:ss)")
	private String createdTimeStr;

	@ApiModelProperty(value = "最新更新者账号", required = true, example = "\"Q1\"")
	private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	@ApiModelProperty(value = "最新更新时间(时间统一格式为yyyy-MM-dd HH:mm:ss)")
	private String modifiedTimeStr;

	@ApiModelProperty(value = "培训介绍信息", required = true, example = "\"Q1\"")
	private String trainInfo;

	// 培训记录
	@ApiModelProperty(value = "培训记录编号", required = true, example = "\"Q1\"")
	private String recordId;

	@ApiModelProperty(value = "课程编号ID", required = true, example = "\"Q1\"")
	private String managementId;

	@ApiModelProperty(value = "培训人部门", required = true, example = "\"Q1\"")
	private String trainerDepartment;

	@ApiModelProperty(value = "培训人工号", required = true, example = "\"Q1\"")
	private String trainerJobNumber;

	@ApiModelProperty(value = "培训人姓名", required = true, example = "\"张三\"")
	private String trainerName;

	// 通知人员信息列表
	@ApiModelProperty(value = "通知人员信息列表", required = true, example = "[]")
	private List<EmployeeBasicInfo> employeeBasicInfoList;

	// 接受培训人员列表
	@ApiModelProperty(value = "培训记录列表", required = true, example = "[]")
	private List<ManagementTrainRecord> managementTrainRecordList;

	@ApiModelProperty(value = "培训人数")
	private String managementTrainRecord;

	public Management() {

	}

	public Management(String id, String courseTitle, String trainTeacher, String trainVenue, Date trainStartTime,
			String trainStartTimeStr, Date trainEndTime, String trainEndTimeStr, Byte status, String statusStr,
			Byte recordStatus, String creatorAccount, Date createdTime, String createdTimeStr, String modifierAccount,
			Date modifiedTime, String modifiedTimeStr, String trainInfo, String recordId, String managementId,
			String trainerDepartment, String trainerJobNumber, String trainerName,
			List<EmployeeBasicInfo> employeeBasicInfoList, List<ManagementTrainRecord> managementTrainRecordList,
			String managementTrainRecord) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.trainTeacher = trainTeacher;
		this.trainVenue = trainVenue;
		this.trainStartTime = trainStartTime;
		this.trainStartTimeStr = trainStartTimeStr;
		this.trainEndTime = trainEndTime;
		this.trainEndTimeStr = trainEndTimeStr;
		this.status = status;
		this.statusStr = statusStr;
		this.recordStatus = recordStatus;
		this.creatorAccount = creatorAccount;
		this.createdTime = createdTime;
		this.createdTimeStr = createdTimeStr;
		this.modifierAccount = modifierAccount;
		this.modifiedTime = modifiedTime;
		this.modifiedTimeStr = modifiedTimeStr;
		this.trainInfo = trainInfo;
		this.recordId = recordId;
		this.managementId = managementId;
		this.trainerDepartment = trainerDepartment;
		this.trainerJobNumber = trainerJobNumber;
		this.trainerName = trainerName;
		this.employeeBasicInfoList = employeeBasicInfoList;
		this.managementTrainRecordList = managementTrainRecordList;
		this.managementTrainRecord = managementTrainRecord;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getManagementTrainRecord() {
		return managementTrainRecord;
	}

	public void setManagementTrainRecord(String managementTrainRecord) {
		this.managementTrainRecord = managementTrainRecord;
	}

	public String getTrainStartTimeStr() {
		return trainStartTimeStr;
	}

	public void setTrainStartTimeStr(String trainStartTimeStr) {
		this.trainStartTimeStr = trainStartTimeStr;
	}

	public String getTrainEndTimeStr() {
		return trainEndTimeStr;
	}

	public void setTrainEndTimeStr(String trainEndTimeStr) {
		this.trainEndTimeStr = trainEndTimeStr;
	}

	public String getCreatedTimeStr() {
		return createdTimeStr;
	}

	public void setCreatedTimeStr(String createdTimeStr) {
		this.createdTimeStr = createdTimeStr;
	}

	public String getModifiedTimeStr() {
		return modifiedTimeStr;
	}

	public void setModifiedTimeStr(String modifiedTimeStr) {
		this.modifiedTimeStr = modifiedTimeStr;
	}

	public void setTrainStartTime(Date trainStartTime) {
		this.trainStartTime = trainStartTime;
	}

	public void setTrainEndTime(Date trainEndTime) {
		this.trainEndTime = trainEndTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
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

	public String getModifierAccount() {
		return modifierAccount;
	}

	public void setModifierAccount(String modifierAccount) {
		this.modifierAccount = modifierAccount;
	}

	public List<EmployeeBasicInfo> getEmployeeBasicInfoList() {
		return employeeBasicInfoList;
	}

	public void setEmployeeBasicInfoList(List<EmployeeBasicInfo> employeeBasicInfoList) {
		this.employeeBasicInfoList = employeeBasicInfoList;
	}

	public List<ManagementTrainRecord> getManagementTrainRecordList() {
		return managementTrainRecordList;
	}

	public void setManagementTrainRecordList(List<ManagementTrainRecord> managementTrainRecordList) {
		this.managementTrainRecordList = managementTrainRecordList;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getManagementId() {
		return managementId;
	}

	public void setManagementId(String managementId) {
		this.managementId = managementId;
	}

	public String getTrainerDepartment() {
		return trainerDepartment;
	}

	public void setTrainerDepartment(String trainerDepartment) {
		this.trainerDepartment = trainerDepartment;
	}

	public String getTrainerJobNumber() {
		return trainerJobNumber;
	}

	public void setTrainerJobNumber(String trainerJobNumber) {
		this.trainerJobNumber = trainerJobNumber;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainInfo() {
		return trainInfo;
	}

	public void setTrainInfo(String trainInfo) {
		this.trainInfo = trainInfo;
	}

	public Date getTrainStartTime() {
		return trainStartTime;
	}

	public Date getTrainEndTime() {
		return trainEndTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	@Override
	public String toString() {
		return "Management {id='" + id + "', courseTitle='" + courseTitle + "', trainTeacher='" + trainTeacher
				+ "', trainVenue='" + trainVenue + "', trainStartTime='" + trainStartTime + "', trainStartTimeStr='"
				+ trainStartTimeStr + "', trainEndTime='" + trainEndTime + "', trainEndTimeStr='" + trainEndTimeStr
				+ "', status='" + status + "', statusStr='" + statusStr + "', recordStatus='" + recordStatus
				+ "', creatorAccount='" + creatorAccount + "', createdTime='" + createdTime + "', createdTimeStr='"
				+ createdTimeStr + "', modifierAccount='" + modifierAccount + "', modifiedTime='" + modifiedTime
				+ "', modifiedTimeStr='" + modifiedTimeStr + "', trainInfo='" + trainInfo + "', recordId='" + recordId
				+ "', managementId='" + managementId + "', trainerDepartment='" + trainerDepartment
				+ "', trainerJobNumber='" + trainerJobNumber + "', trainerName='" + trainerName
				+ "', employeeBasicInfoList='" + employeeBasicInfoList + "', managementTrainRecordList='"
				+ managementTrainRecordList + "', managementTrainRecord='" + managementTrainRecord + "'}";
	}

}
