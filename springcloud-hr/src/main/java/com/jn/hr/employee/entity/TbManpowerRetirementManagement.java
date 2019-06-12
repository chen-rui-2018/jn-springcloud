package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerRetirementManagement implements Serializable {
    private String id;

    private String jobNumber;

    private String department;

    private String name;

    private Date applicationDate;

    private String applicationReason;

    private Date expectedRetirementDate;

    private Date finalWorkDate;

    private Date salarySettlementDate;

    private String remark;

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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason == null ? null : applicationReason.trim();
    }

    public Date getExpectedRetirementDate() {
        return expectedRetirementDate;
    }

    public void setExpectedRetirementDate(Date expectedRetirementDate) {
        this.expectedRetirementDate = expectedRetirementDate;
    }

    public Date getFinalWorkDate() {
        return finalWorkDate;
    }

    public void setFinalWorkDate(Date finalWorkDate) {
        this.finalWorkDate = finalWorkDate;
    }

    public Date getSalarySettlementDate() {
        return salarySettlementDate;
    }

    public void setSalarySettlementDate(Date salarySettlementDate) {
        this.salarySettlementDate = salarySettlementDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        TbManpowerRetirementManagement other = (TbManpowerRetirementManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getApplicationDate() == null ? other.getApplicationDate() == null : this.getApplicationDate().equals(other.getApplicationDate()))
            && (this.getApplicationReason() == null ? other.getApplicationReason() == null : this.getApplicationReason().equals(other.getApplicationReason()))
            && (this.getExpectedRetirementDate() == null ? other.getExpectedRetirementDate() == null : this.getExpectedRetirementDate().equals(other.getExpectedRetirementDate()))
            && (this.getFinalWorkDate() == null ? other.getFinalWorkDate() == null : this.getFinalWorkDate().equals(other.getFinalWorkDate()))
            && (this.getSalarySettlementDate() == null ? other.getSalarySettlementDate() == null : this.getSalarySettlementDate().equals(other.getSalarySettlementDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getApplicationDate() == null) ? 0 : getApplicationDate().hashCode());
        result = prime * result + ((getApplicationReason() == null) ? 0 : getApplicationReason().hashCode());
        result = prime * result + ((getExpectedRetirementDate() == null) ? 0 : getExpectedRetirementDate().hashCode());
        result = prime * result + ((getFinalWorkDate() == null) ? 0 : getFinalWorkDate().hashCode());
        result = prime * result + ((getSalarySettlementDate() == null) ? 0 : getSalarySettlementDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", department=").append(department);
        sb.append(", name=").append(name);
        sb.append(", applicationDate=").append(applicationDate);
        sb.append(", applicationReason=").append(applicationReason);
        sb.append(", expectedRetirementDate=").append(expectedRetirementDate);
        sb.append(", finalWorkDate=").append(finalWorkDate);
        sb.append(", salarySettlementDate=").append(salarySettlementDate);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}