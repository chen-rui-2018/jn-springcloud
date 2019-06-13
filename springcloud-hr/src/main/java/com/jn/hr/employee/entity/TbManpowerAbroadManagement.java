package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerAbroadManagement implements Serializable {
    private String id;

    private String jobNumber;

    private String name;

    private Date applicationDate;

    private String abroadReason;

    private Date abroadTimeStart;

    private Date abroadTimeEnd;

    private String abroadApplication;

    private Byte abroadType;

    private Byte status;

    private String department;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getAbroadReason() {
        return abroadReason;
    }

    public void setAbroadReason(String abroadReason) {
        this.abroadReason = abroadReason == null ? null : abroadReason.trim();
    }

    public Date getAbroadTimeStart() {
        return abroadTimeStart;
    }

    public void setAbroadTimeStart(Date abroadTimeStart) {
        this.abroadTimeStart = abroadTimeStart;
    }

    public Date getAbroadTimeEnd() {
        return abroadTimeEnd;
    }

    public void setAbroadTimeEnd(Date abroadTimeEnd) {
        this.abroadTimeEnd = abroadTimeEnd;
    }

    public String getAbroadApplication() {
        return abroadApplication;
    }

    public void setAbroadApplication(String abroadApplication) {
        this.abroadApplication = abroadApplication == null ? null : abroadApplication.trim();
    }

    public Byte getAbroadType() {
        return abroadType;
    }

    public void setAbroadType(Byte abroadType) {
        this.abroadType = abroadType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
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
        TbManpowerAbroadManagement other = (TbManpowerAbroadManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getApplicationDate() == null ? other.getApplicationDate() == null : this.getApplicationDate().equals(other.getApplicationDate()))
            && (this.getAbroadReason() == null ? other.getAbroadReason() == null : this.getAbroadReason().equals(other.getAbroadReason()))
            && (this.getAbroadTimeStart() == null ? other.getAbroadTimeStart() == null : this.getAbroadTimeStart().equals(other.getAbroadTimeStart()))
            && (this.getAbroadTimeEnd() == null ? other.getAbroadTimeEnd() == null : this.getAbroadTimeEnd().equals(other.getAbroadTimeEnd()))
            && (this.getAbroadApplication() == null ? other.getAbroadApplication() == null : this.getAbroadApplication().equals(other.getAbroadApplication()))
            && (this.getAbroadType() == null ? other.getAbroadType() == null : this.getAbroadType().equals(other.getAbroadType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getApplicationDate() == null) ? 0 : getApplicationDate().hashCode());
        result = prime * result + ((getAbroadReason() == null) ? 0 : getAbroadReason().hashCode());
        result = prime * result + ((getAbroadTimeStart() == null) ? 0 : getAbroadTimeStart().hashCode());
        result = prime * result + ((getAbroadTimeEnd() == null) ? 0 : getAbroadTimeEnd().hashCode());
        result = prime * result + ((getAbroadApplication() == null) ? 0 : getAbroadApplication().hashCode());
        result = prime * result + ((getAbroadType() == null) ? 0 : getAbroadType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", applicationDate=").append(applicationDate);
        sb.append(", abroadReason=").append(abroadReason);
        sb.append(", abroadTimeStart=").append(abroadTimeStart);
        sb.append(", abroadTimeEnd=").append(abroadTimeEnd);
        sb.append(", abroadApplication=").append(abroadApplication);
        sb.append(", abroadType=").append(abroadType);
        sb.append(", status=").append(status);
        sb.append(", department=").append(department);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}