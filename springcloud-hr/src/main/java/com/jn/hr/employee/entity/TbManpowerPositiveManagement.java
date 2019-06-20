package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerPositiveManagement implements Serializable {
    private String id;

    private String jobNumber;

    private String name;

    private Date correctionDate;

    private String department;

    private String jobName;

    private String phone;

    private Date entryDate;

    private Date periodDate;

    private Byte status;

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

    public Date getCorrectionDate() {
        return correctionDate;
    }

    public void setCorrectionDate(Date correctionDate) {
        this.correctionDate = correctionDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(Date periodDate) {
        this.periodDate = periodDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        TbManpowerPositiveManagement other = (TbManpowerPositiveManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCorrectionDate() == null ? other.getCorrectionDate() == null : this.getCorrectionDate().equals(other.getCorrectionDate()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
            && (this.getPeriodDate() == null ? other.getPeriodDate() == null : this.getPeriodDate().equals(other.getPeriodDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCorrectionDate() == null) ? 0 : getCorrectionDate().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getPeriodDate() == null) ? 0 : getPeriodDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", correctionDate=").append(correctionDate);
        sb.append(", department=").append(department);
        sb.append(", jobName=").append(jobName);
        sb.append(", phone=").append(phone);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", periodDate=").append(periodDate);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}