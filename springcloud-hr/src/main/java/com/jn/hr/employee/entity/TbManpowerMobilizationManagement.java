package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbManpowerMobilizationManagement implements Serializable {
    private String id;

    private String jobNumber;

    private String name;

    private String department;

    private String jobName;

    private String rankName;

    private Double salary;

    private String contactNumber;

    private String workPlace;

    private String directlyLeader;

    private String enclosure;

    private String applicationReason;

    private Date takeEffectDate;

    private String newDepartment;

    private String newJobName;

    private String newRankName;

    private BigDecimal newSalary;

    private String newContactNumber;

    private String newWorkPlace;

    private String newDirectlyLeader;

    private Date applicateTime;

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

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName == null ? null : rankName.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getDirectlyLeader() {
        return directlyLeader;
    }

    public void setDirectlyLeader(String directlyLeader) {
        this.directlyLeader = directlyLeader == null ? null : directlyLeader.trim();
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason == null ? null : applicationReason.trim();
    }

    public Date getTakeEffectDate() {
        return takeEffectDate;
    }

    public void setTakeEffectDate(Date takeEffectDate) {
        this.takeEffectDate = takeEffectDate;
    }

    public String getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment == null ? null : newDepartment.trim();
    }

    public String getNewJobName() {
        return newJobName;
    }

    public void setNewJobName(String newJobName) {
        this.newJobName = newJobName == null ? null : newJobName.trim();
    }

    public String getNewRankName() {
        return newRankName;
    }

    public void setNewRankName(String newRankName) {
        this.newRankName = newRankName == null ? null : newRankName.trim();
    }

    public BigDecimal getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(BigDecimal newSalary) {
        this.newSalary = newSalary;
    }

    public String getNewContactNumber() {
        return newContactNumber;
    }

    public void setNewContactNumber(String newContactNumber) {
        this.newContactNumber = newContactNumber == null ? null : newContactNumber.trim();
    }

    public String getNewWorkPlace() {
        return newWorkPlace;
    }

    public void setNewWorkPlace(String newWorkPlace) {
        this.newWorkPlace = newWorkPlace == null ? null : newWorkPlace.trim();
    }

    public String getNewDirectlyLeader() {
        return newDirectlyLeader;
    }

    public void setNewDirectlyLeader(String newDirectlyLeader) {
        this.newDirectlyLeader = newDirectlyLeader == null ? null : newDirectlyLeader.trim();
    }

    public Date getApplicateTime() {
        return applicateTime;
    }

    public void setApplicateTime(Date applicateTime) {
        this.applicateTime = applicateTime;
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
        TbManpowerMobilizationManagement other = (TbManpowerMobilizationManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getRankName() == null ? other.getRankName() == null : this.getRankName().equals(other.getRankName()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getContactNumber() == null ? other.getContactNumber() == null : this.getContactNumber().equals(other.getContactNumber()))
            && (this.getWorkPlace() == null ? other.getWorkPlace() == null : this.getWorkPlace().equals(other.getWorkPlace()))
            && (this.getDirectlyLeader() == null ? other.getDirectlyLeader() == null : this.getDirectlyLeader().equals(other.getDirectlyLeader()))
            && (this.getEnclosure() == null ? other.getEnclosure() == null : this.getEnclosure().equals(other.getEnclosure()))
            && (this.getApplicationReason() == null ? other.getApplicationReason() == null : this.getApplicationReason().equals(other.getApplicationReason()))
            && (this.getTakeEffectDate() == null ? other.getTakeEffectDate() == null : this.getTakeEffectDate().equals(other.getTakeEffectDate()))
            && (this.getNewDepartment() == null ? other.getNewDepartment() == null : this.getNewDepartment().equals(other.getNewDepartment()))
            && (this.getNewJobName() == null ? other.getNewJobName() == null : this.getNewJobName().equals(other.getNewJobName()))
            && (this.getNewRankName() == null ? other.getNewRankName() == null : this.getNewRankName().equals(other.getNewRankName()))
            && (this.getNewSalary() == null ? other.getNewSalary() == null : this.getNewSalary().equals(other.getNewSalary()))
            && (this.getNewContactNumber() == null ? other.getNewContactNumber() == null : this.getNewContactNumber().equals(other.getNewContactNumber()))
            && (this.getNewWorkPlace() == null ? other.getNewWorkPlace() == null : this.getNewWorkPlace().equals(other.getNewWorkPlace()))
            && (this.getNewDirectlyLeader() == null ? other.getNewDirectlyLeader() == null : this.getNewDirectlyLeader().equals(other.getNewDirectlyLeader()))
            && (this.getApplicateTime() == null ? other.getApplicateTime() == null : this.getApplicateTime().equals(other.getApplicateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getRankName() == null) ? 0 : getRankName().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getContactNumber() == null) ? 0 : getContactNumber().hashCode());
        result = prime * result + ((getWorkPlace() == null) ? 0 : getWorkPlace().hashCode());
        result = prime * result + ((getDirectlyLeader() == null) ? 0 : getDirectlyLeader().hashCode());
        result = prime * result + ((getEnclosure() == null) ? 0 : getEnclosure().hashCode());
        result = prime * result + ((getApplicationReason() == null) ? 0 : getApplicationReason().hashCode());
        result = prime * result + ((getTakeEffectDate() == null) ? 0 : getTakeEffectDate().hashCode());
        result = prime * result + ((getNewDepartment() == null) ? 0 : getNewDepartment().hashCode());
        result = prime * result + ((getNewJobName() == null) ? 0 : getNewJobName().hashCode());
        result = prime * result + ((getNewRankName() == null) ? 0 : getNewRankName().hashCode());
        result = prime * result + ((getNewSalary() == null) ? 0 : getNewSalary().hashCode());
        result = prime * result + ((getNewContactNumber() == null) ? 0 : getNewContactNumber().hashCode());
        result = prime * result + ((getNewWorkPlace() == null) ? 0 : getNewWorkPlace().hashCode());
        result = prime * result + ((getNewDirectlyLeader() == null) ? 0 : getNewDirectlyLeader().hashCode());
        result = prime * result + ((getApplicateTime() == null) ? 0 : getApplicateTime().hashCode());
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
        sb.append(", department=").append(department);
        sb.append(", jobName=").append(jobName);
        sb.append(", rankName=").append(rankName);
        sb.append(", salary=").append(salary);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", workPlace=").append(workPlace);
        sb.append(", directlyLeader=").append(directlyLeader);
        sb.append(", enclosure=").append(enclosure);
        sb.append(", applicationReason=").append(applicationReason);
        sb.append(", takeEffectDate=").append(takeEffectDate);
        sb.append(", newDepartment=").append(newDepartment);
        sb.append(", newJobName=").append(newJobName);
        sb.append(", newRankName=").append(newRankName);
        sb.append(", newSalary=").append(newSalary);
        sb.append(", newContactNumber=").append(newContactNumber);
        sb.append(", newWorkPlace=").append(newWorkPlace);
        sb.append(", newDirectlyLeader=").append(newDirectlyLeader);
        sb.append(", applicateTime=").append(applicateTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}