package com.jn.park.attractinvest.entity;

import java.io.Serializable;

public class TbProjectInfoWithBLOBs extends TbProjectInfo implements Serializable {
    private String projectIntroduce;

    private String companyRequire;

    private static final long serialVersionUID = 1L;

    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce == null ? null : projectIntroduce.trim();
    }

    public String getCompanyRequire() {
        return companyRequire;
    }

    public void setCompanyRequire(String companyRequire) {
        this.companyRequire = companyRequire == null ? null : companyRequire.trim();
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
        TbProjectInfoWithBLOBs other = (TbProjectInfoWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getIntroducer() == null ? other.getIntroducer() == null : this.getIntroducer().equals(other.getIntroducer()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getIndustryAssessment() == null ? other.getIndustryAssessment() == null : this.getIndustryAssessment().equals(other.getIndustryAssessment()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProjectProcess() == null ? other.getProjectProcess() == null : this.getProjectProcess().equals(other.getProjectProcess()))
            && (this.getCompactStatus() == null ? other.getCompactStatus() == null : this.getCompactStatus().equals(other.getCompactStatus()))
            && (this.getCompactStartTime() == null ? other.getCompactStartTime() == null : this.getCompactStartTime().equals(other.getCompactStartTime()))
            && (this.getCompactEndTime() == null ? other.getCompactEndTime() == null : this.getCompactEndTime().equals(other.getCompactEndTime()))
            && (this.getProjectIntroduce() == null ? other.getProjectIntroduce() == null : this.getProjectIntroduce().equals(other.getProjectIntroduce()))
            && (this.getCompanyRequire() == null ? other.getCompanyRequire() == null : this.getCompanyRequire().equals(other.getCompanyRequire()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getIntroducer() == null) ? 0 : getIntroducer().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getIndustryAssessment() == null) ? 0 : getIndustryAssessment().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProjectProcess() == null) ? 0 : getProjectProcess().hashCode());
        result = prime * result + ((getCompactStatus() == null) ? 0 : getCompactStatus().hashCode());
        result = prime * result + ((getCompactStartTime() == null) ? 0 : getCompactStartTime().hashCode());
        result = prime * result + ((getCompactEndTime() == null) ? 0 : getCompactEndTime().hashCode());
        result = prime * result + ((getProjectIntroduce() == null) ? 0 : getProjectIntroduce().hashCode());
        result = prime * result + ((getCompanyRequire() == null) ? 0 : getCompanyRequire().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectIntroduce=").append(projectIntroduce);
        sb.append(", companyRequire=").append(companyRequire);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}