package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerLeaveManagement implements Serializable {
    private String id;

    private String jobNumber;

    private Date applicationDate;

    private String name;

    private Byte turnoverType;

    private String reasonsLeav;

    private Date estimateLeaveDate;

    private Date finalWorkDate;

    private Date salarySettlementDate;

    private String remark;

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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getTurnoverType() {
        return turnoverType;
    }

    public void setTurnoverType(Byte turnoverType) {
        this.turnoverType = turnoverType;
    }

    public String getReasonsLeav() {
        return reasonsLeav;
    }

    public void setReasonsLeav(String reasonsLeav) {
        this.reasonsLeav = reasonsLeav == null ? null : reasonsLeav.trim();
    }

    public Date getEstimateLeaveDate() {
        return estimateLeaveDate;
    }

    public void setEstimateLeaveDate(Date estimateLeaveDate) {
        this.estimateLeaveDate = estimateLeaveDate;
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
        TbManpowerLeaveManagement other = (TbManpowerLeaveManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getApplicationDate() == null ? other.getApplicationDate() == null : this.getApplicationDate().equals(other.getApplicationDate()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTurnoverType() == null ? other.getTurnoverType() == null : this.getTurnoverType().equals(other.getTurnoverType()))
            && (this.getReasonsLeav() == null ? other.getReasonsLeav() == null : this.getReasonsLeav().equals(other.getReasonsLeav()))
            && (this.getEstimateLeaveDate() == null ? other.getEstimateLeaveDate() == null : this.getEstimateLeaveDate().equals(other.getEstimateLeaveDate()))
            && (this.getFinalWorkDate() == null ? other.getFinalWorkDate() == null : this.getFinalWorkDate().equals(other.getFinalWorkDate()))
            && (this.getSalarySettlementDate() == null ? other.getSalarySettlementDate() == null : this.getSalarySettlementDate().equals(other.getSalarySettlementDate()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getApplicationDate() == null) ? 0 : getApplicationDate().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTurnoverType() == null) ? 0 : getTurnoverType().hashCode());
        result = prime * result + ((getReasonsLeav() == null) ? 0 : getReasonsLeav().hashCode());
        result = prime * result + ((getEstimateLeaveDate() == null) ? 0 : getEstimateLeaveDate().hashCode());
        result = prime * result + ((getFinalWorkDate() == null) ? 0 : getFinalWorkDate().hashCode());
        result = prime * result + ((getSalarySettlementDate() == null) ? 0 : getSalarySettlementDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", applicationDate=").append(applicationDate);
        sb.append(", name=").append(name);
        sb.append(", turnoverType=").append(turnoverType);
        sb.append(", reasonsLeav=").append(reasonsLeav);
        sb.append(", estimateLeaveDate=").append(estimateLeaveDate);
        sb.append(", finalWorkDate=").append(finalWorkDate);
        sb.append(", salarySettlementDate=").append(salarySettlementDate);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", department=").append(department);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}