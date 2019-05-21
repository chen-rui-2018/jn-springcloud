package com.jn.hr.attendance.model;

import java.io.Serializable;
import java.util.Date;

import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AttendanceTimeSetPage", description = "考勤设置分页实体")
public class AttendanceTimeSetPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5493759774730722458L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "考勤类型（1：日常考勤，2：值班考勤，3：会议考勤）")
    private String attendanceType;

	@ApiModelProperty(value = "上班考勤时间")
    private Date workAttendanceTime;

	@ApiModelProperty(value = "下班考勤时间")
    private Date dutyAttendanceTime;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "")
    private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

	@ApiModelProperty(value = "创建时间")
    private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间")
    private Date modifiedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public Date getWorkAttendanceTime() {
		return workAttendanceTime;
	}

	public void setWorkAttendanceTime(Date workAttendanceTime) {
		this.workAttendanceTime = workAttendanceTime;
	}

	public Date getDutyAttendanceTime() {
		return dutyAttendanceTime;
	}

	public void setDutyAttendanceTime(Date dutyAttendanceTime) {
		this.dutyAttendanceTime = dutyAttendanceTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
}
