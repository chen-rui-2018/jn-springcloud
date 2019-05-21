package com.jn.hr.attendance.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceManagementAdd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6189613369044232569L;

	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "工号")
	private String jobNumber;

	@ApiModelProperty(value = "部门")
    private String department;

	@ApiModelProperty(value = "部门Id")
    private String departmentId;
	
	@ApiModelProperty(value = "姓名")
    private String name;
	
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	@ApiModelProperty(value = "出勤（天）")
    private Integer attendance;

	@ApiModelProperty(value = "迟到次数")
    private Integer late;

	@ApiModelProperty(value = "早退次数")
    private Integer leaveEarly;

	@ApiModelProperty(value = "上班缺卡数")
    private Integer startMissCard;

	@ApiModelProperty(value = "下班缺卡数")
    private Integer endMissCard;

	@ApiModelProperty(value = "旷工（时）")
    private Integer absenteeism;

	@ApiModelProperty(value = "事假（时）")
    private Integer compassionateLeave;

	@ApiModelProperty(value = "病假（时）")
    private Integer sickLeave;

	@ApiModelProperty(value = "婚假（时）")
    private Integer marriageHoliday;

	@ApiModelProperty(value = "丧假（时）")
    private Integer funeralLeave;

	@ApiModelProperty(value = "产假（时）")
    private Integer maternityLeave;

	@ApiModelProperty(value = "年休假（时）")
    private Integer annualLeave;
	
	@ApiModelProperty(value = "开始日期")
	private String startTime;
	
	@ApiModelProperty(value = "结束日期")
	private String endTime;
	
	@ApiModelProperty(value = "上班时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date inTime;
	
	@ApiModelProperty(value = "下班时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date outTime;

	@ApiModelProperty(value = "考勤统计日期")
	private String attendanceDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAttendance() {
		return attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}

	public Integer getLate() {
		return late;
	}

	public void setLate(Integer late) {
		this.late = late;
	}

	public Integer getLeaveEarly() {
		return leaveEarly;
	}

	public void setLeaveEarly(Integer leaveEarly) {
		this.leaveEarly = leaveEarly;
	}

	public Integer getStartMissCard() {
		return startMissCard;
	}

	public void setStartMissCard(Integer startMissCard) {
		this.startMissCard = startMissCard;
	}

	public Integer getEndMissCard() {
		return endMissCard;
	}

	public void setEndMissCard(Integer endMissCard) {
		this.endMissCard = endMissCard;
	}

	public Integer getAbsenteeism() {
		return absenteeism;
	}

	public void setAbsenteeism(Integer absenteeism) {
		this.absenteeism = absenteeism;
	}

	public Integer getCompassionateLeave() {
		return compassionateLeave;
	}

	public void setCompassionateLeave(Integer compassionateLeave) {
		this.compassionateLeave = compassionateLeave;
	}

	public Integer getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Integer sickLeave) {
		this.sickLeave = sickLeave;
	}

	public Integer getMarriageHoliday() {
		return marriageHoliday;
	}

	public void setMarriageHoliday(Integer marriageHoliday) {
		this.marriageHoliday = marriageHoliday;
	}

	public Integer getFuneralLeave() {
		return funeralLeave;
	}

	public void setFuneralLeave(Integer funeralLeave) {
		this.funeralLeave = funeralLeave;
	}

	public Integer getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(Integer maternityLeave) {
		this.maternityLeave = maternityLeave;
	}

	public Integer getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(Integer annualLeave) {
		this.annualLeave = annualLeave;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
}
