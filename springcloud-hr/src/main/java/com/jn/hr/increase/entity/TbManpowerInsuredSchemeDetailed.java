package com.jn.hr.increase.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerInsuredSchemeDetailed implements Serializable {
    private String projectId;

    private String projectName;

    private Integer defaultCardinalNumber;

    private Integer optionalBaseStart;

    private Integer optionalBaseEnd;

    private Integer corporateContributionRatio;

    private Integer individualContributionRatio;

    private String schemeId;

    private String socialSecurityId;

    private String providentFundId;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private Byte projectType;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getDefaultCardinalNumber() {
        return defaultCardinalNumber;
    }

    public void setDefaultCardinalNumber(Integer defaultCardinalNumber) {
        this.defaultCardinalNumber = defaultCardinalNumber;
    }

    public Integer getOptionalBaseStart() {
        return optionalBaseStart;
    }

    public void setOptionalBaseStart(Integer optionalBaseStart) {
        this.optionalBaseStart = optionalBaseStart;
    }

    public Integer getOptionalBaseEnd() {
        return optionalBaseEnd;
    }

    public void setOptionalBaseEnd(Integer optionalBaseEnd) {
        this.optionalBaseEnd = optionalBaseEnd;
    }

    public Integer getCorporateContributionRatio() {
        return corporateContributionRatio;
    }

    public void setCorporateContributionRatio(Integer corporateContributionRatio) {
        this.corporateContributionRatio = corporateContributionRatio;
    }

    public Integer getIndividualContributionRatio() {
        return individualContributionRatio;
    }

    public void setIndividualContributionRatio(Integer individualContributionRatio) {
        this.individualContributionRatio = individualContributionRatio;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId == null ? null : schemeId.trim();
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId == null ? null : socialSecurityId.trim();
    }

    public String getProvidentFundId() {
        return providentFundId;
    }

    public void setProvidentFundId(String providentFundId) {
        this.providentFundId = providentFundId == null ? null : providentFundId.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Byte getProjectType() {
        return projectType;
    }

    public void setProjectType(Byte projectType) {
        this.projectType = projectType;
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
        TbManpowerInsuredSchemeDetailed other = (TbManpowerInsuredSchemeDetailed) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getDefaultCardinalNumber() == null ? other.getDefaultCardinalNumber() == null : this.getDefaultCardinalNumber().equals(other.getDefaultCardinalNumber()))
            && (this.getOptionalBaseStart() == null ? other.getOptionalBaseStart() == null : this.getOptionalBaseStart().equals(other.getOptionalBaseStart()))
            && (this.getOptionalBaseEnd() == null ? other.getOptionalBaseEnd() == null : this.getOptionalBaseEnd().equals(other.getOptionalBaseEnd()))
            && (this.getCorporateContributionRatio() == null ? other.getCorporateContributionRatio() == null : this.getCorporateContributionRatio().equals(other.getCorporateContributionRatio()))
            && (this.getIndividualContributionRatio() == null ? other.getIndividualContributionRatio() == null : this.getIndividualContributionRatio().equals(other.getIndividualContributionRatio()))
            && (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
            && (this.getSocialSecurityId() == null ? other.getSocialSecurityId() == null : this.getSocialSecurityId().equals(other.getSocialSecurityId()))
            && (this.getProvidentFundId() == null ? other.getProvidentFundId() == null : this.getProvidentFundId().equals(other.getProvidentFundId()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getProjectType() == null ? other.getProjectType() == null : this.getProjectType().equals(other.getProjectType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getDefaultCardinalNumber() == null) ? 0 : getDefaultCardinalNumber().hashCode());
        result = prime * result + ((getOptionalBaseStart() == null) ? 0 : getOptionalBaseStart().hashCode());
        result = prime * result + ((getOptionalBaseEnd() == null) ? 0 : getOptionalBaseEnd().hashCode());
        result = prime * result + ((getCorporateContributionRatio() == null) ? 0 : getCorporateContributionRatio().hashCode());
        result = prime * result + ((getIndividualContributionRatio() == null) ? 0 : getIndividualContributionRatio().hashCode());
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getSocialSecurityId() == null) ? 0 : getSocialSecurityId().hashCode());
        result = prime * result + ((getProvidentFundId() == null) ? 0 : getProvidentFundId().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getProjectType() == null) ? 0 : getProjectType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", defaultCardinalNumber=").append(defaultCardinalNumber);
        sb.append(", optionalBaseStart=").append(optionalBaseStart);
        sb.append(", optionalBaseEnd=").append(optionalBaseEnd);
        sb.append(", corporateContributionRatio=").append(corporateContributionRatio);
        sb.append(", individualContributionRatio=").append(individualContributionRatio);
        sb.append(", schemeId=").append(schemeId);
        sb.append(", socialSecurityId=").append(socialSecurityId);
        sb.append(", providentFundId=").append(providentFundId);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", projectType=").append(projectType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}