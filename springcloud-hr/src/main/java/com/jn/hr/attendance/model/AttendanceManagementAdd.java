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
    private Integer attendance = 0;

	@ApiModelProperty(value = "迟到次数")
    private Integer late = 0;

	@ApiModelProperty(value = "早退次数")
    private Integer leaveEarly = 0;

	@ApiModelProperty(value = "上班缺卡数")
    private Integer startMissCard = 0;

	@ApiModelProperty(value = "下班缺卡数")
    private Integer endMissCard = 0;

	@ApiModelProperty(value = "旷工（时）")
    private Integer absenteeism = 0;

	@ApiModelProperty(value = "事假（时）")
    private Integer compassionateLeave = 0;

	@ApiModelProperty(value = "病假（时）")
    private Integer sickLeave = 0;

	@ApiModelProperty(value = "婚假（时）")
    private Integer marriageHoliday = 0;

	@ApiModelProperty(value = "丧假（时）")
    private Integer funeralLeave = 0;

	@ApiModelProperty(value = "产假（时）")
    private Integer maternityLeave = 0;

	@ApiModelProperty(value = "年休假（时）")
    private Integer annualLeave = 0;
	
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
		this.attendance = attendance == null ? 0 : attendance;
	}

	public Integer getLate() {
		return late;
	}

	public void setLate(Integer late) {
		this.late = late == null ? 0 : late;
	}

	public Integer getLeaveEarly() {
		return leaveEarly;
	}

	public void setLeaveEarly(Integer leaveEarly) {
		this.leaveEarly = leaveEarly == null ? 0 : leaveEarly;
	}

	public Integer getStartMissCard() {
		return startMissCard;
	}

	public void setStartMissCard(Integer startMissCard) {
		this.startMissCard = startMissCard == null ? 0 : startMissCard;
	}

	public Integer getEndMissCard() {
		return endMissCard;
	}

	public void setEndMissCard(Integer endMissCard) {
		this.endMissCard = endMissCard == null ? 0 : endMissCard;
	}

	public Integer getAbsenteeism() {
		return absenteeism;
	}

	public void setAbsenteeism(Integer absenteeism) {
		this.absenteeism = absenteeism == null ? 0 : absenteeism;
	}

	public Integer getCompassionateLeave() {
		return compassionateLeave;
	}

	public void setCompassionateLeave(Integer compassionateLeave) {
		this.compassionateLeave = compassionateLeave == null ? 0 : compassionateLeave;
	}

	public Integer getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Integer sickLeave) {
		this.sickLeave = sickLeave == null ? 0 : sickLeave;
	}

	public Integer getMarriageHoliday() {
		return marriageHoliday;
	}

	public void setMarriageHoliday(Integer marriageHoliday) {
		this.marriageHoliday = marriageHoliday == null ? 0 : marriageHoliday;
	}

	public Integer getFuneralLeave() {
		return funeralLeave;
	}

	public void setFuneralLeave(Integer funeralLeave) {
		this.funeralLeave = funeralLeave == null ? 0 : funeralLeave;
	}

	public Integer getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(Integer maternityLeave) {
		this.maternityLeave = maternityLeave == null ? 0 : maternityLeave;
	}

	public Integer getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(Integer annualLeave) {
		this.annualLeave = annualLeave == null ? 0 : annualLeave;
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
