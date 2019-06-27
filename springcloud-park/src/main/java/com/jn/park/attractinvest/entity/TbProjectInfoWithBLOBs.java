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
            && (this.getInvestmentApprover() == null ? other.getInvestmentApprover() == null : this.getInvestmentApprover().equals(other.getInvestmentApprover()))
            && (this.getInvestmentApproverTime() == null ? other.getInvestmentApproverTime() == null : this.getInvestmentApproverTime().equals(other.getInvestmentApproverTime()))
            && (this.getPropertyApprover() == null ? other.getPropertyApprover() == null : this.getPropertyApprover().equals(other.getPropertyApprover()))
            && (this.getPropertyApproverTime() == null ? other.getPropertyApproverTime() == null : this.getPropertyApproverTime().equals(other.getPropertyApproverTime()))
            && (this.getPmApprover() == null ? other.getPmApprover() == null : this.getPmApprover().equals(other.getPmApprover()))
            && (this.getPmApproverTime() == null ? other.getPmApproverTime() == null : this.getPmApproverTime().equals(other.getPmApproverTime()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getRentInfo() == null ? other.getRentInfo() == null : this.getRentInfo().equals(other.getRentInfo()))
            && (this.getExpectEnterTime() == null ? other.getExpectEnterTime() == null : this.getExpectEnterTime().equals(other.getExpectEnterTime()))
            && (this.getSureTime() == null ? other.getSureTime() == null : this.getSureTime().equals(other.getSureTime()))
            && (this.getApprovalOpioion() == null ? other.getApprovalOpioion() == null : this.getApprovalOpioion().equals(other.getApprovalOpioion()))
            && (this.getLegalPersoner() == null ? other.getLegalPersoner() == null : this.getLegalPersoner().equals(other.getLegalPersoner()))
            && (this.getLegalPhone() == null ? other.getLegalPhone() == null : this.getLegalPhone().equals(other.getLegalPhone()))
            && (this.getComAdmin() == null ? other.getComAdmin() == null : this.getComAdmin().equals(other.getComAdmin()))
            && (this.getLinker() == null ? other.getLinker() == null : this.getLinker().equals(other.getLinker()))
            && (this.getLinkerPhone() == null ? other.getLinkerPhone() == null : this.getLinkerPhone().equals(other.getLinkerPhone()))
            && (this.getEnterpriseProperty() == null ? other.getEnterpriseProperty() == null : this.getEnterpriseProperty().equals(other.getEnterpriseProperty()))
            && (this.getIndustryTypeName() == null ? other.getIndustryTypeName() == null : this.getIndustryTypeName().equals(other.getIndustryTypeName()))
            && (this.getIndustryType() == null ? other.getIndustryType() == null : this.getIndustryType().equals(other.getIndustryType()))
            && (this.getRentStartTime() == null ? other.getRentStartTime() == null : this.getRentStartTime().equals(other.getRentStartTime()))
            && (this.getComEntTime() == null ? other.getComEntTime() == null : this.getComEntTime().equals(other.getComEntTime()))
            && (this.getRentMonthNum() == null ? other.getRentMonthNum() == null : this.getRentMonthNum().equals(other.getRentMonthNum()))
            && (this.getRemerk() == null ? other.getRemerk() == null : this.getRemerk().equals(other.getRemerk()))
            && (this.getActualTotalAccount() == null ? other.getActualTotalAccount() == null : this.getActualTotalAccount().equals(other.getActualTotalAccount()))
            && (this.getRoomBillId() == null ? other.getRoomBillId() == null : this.getRoomBillId().equals(other.getRoomBillId()))
            && (this.getEnterTime() == null ? other.getEnterTime() == null : this.getEnterTime().equals(other.getEnterTime()))
            && (this.getMainTowerId() == null ? other.getMainTowerId() == null : this.getMainTowerId().equals(other.getMainTowerId()))
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
        result = prime * result + ((getInvestmentApprover() == null) ? 0 : getInvestmentApprover().hashCode());
        result = prime * result + ((getInvestmentApproverTime() == null) ? 0 : getInvestmentApproverTime().hashCode());
        result = prime * result + ((getPropertyApprover() == null) ? 0 : getPropertyApprover().hashCode());
        result = prime * result + ((getPropertyApproverTime() == null) ? 0 : getPropertyApproverTime().hashCode());
        result = prime * result + ((getPmApprover() == null) ? 0 : getPmApprover().hashCode());
        result = prime * result + ((getPmApproverTime() == null) ? 0 : getPmApproverTime().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getRentInfo() == null) ? 0 : getRentInfo().hashCode());
        result = prime * result + ((getExpectEnterTime() == null) ? 0 : getExpectEnterTime().hashCode());
        result = prime * result + ((getSureTime() == null) ? 0 : getSureTime().hashCode());
        result = prime * result + ((getApprovalOpioion() == null) ? 0 : getApprovalOpioion().hashCode());
        result = prime * result + ((getLegalPersoner() == null) ? 0 : getLegalPersoner().hashCode());
        result = prime * result + ((getLegalPhone() == null) ? 0 : getLegalPhone().hashCode());
        result = prime * result + ((getComAdmin() == null) ? 0 : getComAdmin().hashCode());
        result = prime * result + ((getLinker() == null) ? 0 : getLinker().hashCode());
        result = prime * result + ((getLinkerPhone() == null) ? 0 : getLinkerPhone().hashCode());
        result = prime * result + ((getEnterpriseProperty() == null) ? 0 : getEnterpriseProperty().hashCode());
        result = prime * result + ((getIndustryTypeName() == null) ? 0 : getIndustryTypeName().hashCode());
        result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
        result = prime * result + ((getRentStartTime() == null) ? 0 : getRentStartTime().hashCode());
        result = prime * result + ((getComEntTime() == null) ? 0 : getComEntTime().hashCode());
        result = prime * result + ((getRentMonthNum() == null) ? 0 : getRentMonthNum().hashCode());
        result = prime * result + ((getRemerk() == null) ? 0 : getRemerk().hashCode());
        result = prime * result + ((getActualTotalAccount() == null) ? 0 : getActualTotalAccount().hashCode());
        result = prime * result + ((getRoomBillId() == null) ? 0 : getRoomBillId().hashCode());
        result = prime * result + ((getEnterTime() == null) ? 0 : getEnterTime().hashCode());
        result = prime * result + ((getMainTowerId() == null) ? 0 : getMainTowerId().hashCode());
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