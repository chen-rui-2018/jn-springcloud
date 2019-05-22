package com.jn.hr.attendance.entity;

import java.io.Serializable;

public class TbManpowerAttendanceManagement implements Serializable {
    private String id;

    private String jobNumber;

    private String department;

    private String name;

    private String userId;

    private Integer attendance;

    private Integer late;

    private Integer leaveEarly;

    private Integer startMissCard;

    private Integer endMissCard;

    private Integer absenteeism;

    private Integer compassionateLeave;

    private Integer sickLeave;

    private Integer marriageHoliday;

    private Integer funeralLeave;

    private Integer maternityLeave;

    private Integer annualLeave;

    private String attendanceDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate == null ? null : attendanceDate.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbManpowerAttendanceManagement other = (TbManpowerAttendanceManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAttendance() == null ? other.getAttendance() == null : this.getAttendance().equals(other.getAttendance()))
            && (this.getLate() == null ? other.getLate() == null : this.getLate().equals(other.getLate()))
            && (this.getLeaveEarly() == null ? other.getLeaveEarly() == null : this.getLeaveEarly().equals(other.getLeaveEarly()))
            && (this.getStartMissCard() == null ? other.getStartMissCard() == null : this.getStartMissCard().equals(other.getStartMissCard()))
            && (this.getEndMissCard() == null ? other.getEndMissCard() == null : this.getEndMissCard().equals(other.getEndMissCard()))
            && (this.getAbsenteeism() == null ? other.getAbsenteeism() == null : this.getAbsenteeism().equals(other.getAbsenteeism()))
            && (this.getCompassionateLeave() == null ? other.getCompassionateLeave() == null : this.getCompassionateLeave().equals(other.getCompassionateLeave()))
            && (this.getSickLeave() == null ? other.getSickLeave() == null : this.getSickLeave().equals(other.getSickLeave()))
            && (this.getMarriageHoliday() == null ? other.getMarriageHoliday() == null : this.getMarriageHoliday().equals(other.getMarriageHoliday()))
            && (this.getFuneralLeave() == null ? other.getFuneralLeave() == null : this.getFuneralLeave().equals(other.getFuneralLeave()))
            && (this.getMaternityLeave() == null ? other.getMaternityLeave() == null : this.getMaternityLeave().equals(other.getMaternityLeave()))
            && (this.getAnnualLeave() == null ? other.getAnnualLeave() == null : this.getAnnualLeave().equals(other.getAnnualLeave()))
            && (this.getAttendanceDate() == null ? other.getAttendanceDate() == null : this.getAttendanceDate().equals(other.getAttendanceDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAttendance() == null) ? 0 : getAttendance().hashCode());
        result = prime * result + ((getLate() == null) ? 0 : getLate().hashCode());
        result = prime * result + ((getLeaveEarly() == null) ? 0 : getLeaveEarly().hashCode());
        result = prime * result + ((getStartMissCard() == null) ? 0 : getStartMissCard().hashCode());
        result = prime * result + ((getEndMissCard() == null) ? 0 : getEndMissCard().hashCode());
        result = prime * result + ((getAbsenteeism() == null) ? 0 : getAbsenteeism().hashCode());
        result = prime * result + ((getCompassionateLeave() == null) ? 0 : getCompassionateLeave().hashCode());
        result = prime * result + ((getSickLeave() == null) ? 0 : getSickLeave().hashCode());
        result = prime * result + ((getMarriageHoliday() == null) ? 0 : getMarriageHoliday().hashCode());
        result = prime * result + ((getFuneralLeave() == null) ? 0 : getFuneralLeave().hashCode());
        result = prime * result + ((getMaternityLeave() == null) ? 0 : getMaternityLeave().hashCode());
        result = prime * result + ((getAnnualLeave() == null) ? 0 : getAnnualLeave().hashCode());
        result = prime * result + ((getAttendanceDate() == null) ? 0 : getAttendanceDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", department=").append(department);
        sb.append(", name=").append(name);
        sb.append(", userId=").append(userId);
        sb.append(", attendance=").append(attendance);
        sb.append(", late=").append(late);
        sb.append(", leaveEarly=").append(leaveEarly);
        sb.append(", startMissCard=").append(startMissCard);
        sb.append(", endMissCard=").append(endMissCard);
        sb.append(", absenteeism=").append(absenteeism);
        sb.append(", compassionateLeave=").append(compassionateLeave);
        sb.append(", sickLeave=").append(sickLeave);
        sb.append(", marriageHoliday=").append(marriageHoliday);
        sb.append(", funeralLeave=").append(funeralLeave);
        sb.append(", maternityLeave=").append(maternityLeave);
        sb.append(", annualLeave=").append(annualLeave);
        sb.append(", attendanceDate=").append(attendanceDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}