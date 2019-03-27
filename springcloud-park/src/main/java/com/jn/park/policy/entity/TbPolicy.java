package com.jn.park.policy.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPolicy implements Serializable {
    private String policyId;

    private String policyCode;

    private String policyLevelCode;

    private String policyLevelName;

    private String policyClassCode;

    private String policyClassName;

    private String policyType;

    private String policyTitle;

    private Integer readNum;

    private Date releaseDate;

    private String status;

    private String supportMethod;

    private String supportIndustry;

    private String issueUnit;

    private String isPolicyDiagram;

    private String relationPolicyDiagramId;

    private String isPolicyOriginal;

    private String relationPolicyOriginalId;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode == null ? null : policyCode.trim();
    }

    public String getPolicyLevelCode() {
        return policyLevelCode;
    }

    public void setPolicyLevelCode(String policyLevelCode) {
        this.policyLevelCode = policyLevelCode == null ? null : policyLevelCode.trim();
    }

    public String getPolicyLevelName() {
        return policyLevelName;
    }

    public void setPolicyLevelName(String policyLevelName) {
        this.policyLevelName = policyLevelName == null ? null : policyLevelName.trim();
    }

    public String getPolicyClassCode() {
        return policyClassCode;
    }

    public void setPolicyClassCode(String policyClassCode) {
        this.policyClassCode = policyClassCode == null ? null : policyClassCode.trim();
    }

    public String getPolicyClassName() {
        return policyClassName;
    }

    public void setPolicyClassName(String policyClassName) {
        this.policyClassName = policyClassName == null ? null : policyClassName.trim();
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle == null ? null : policyTitle.trim();
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSupportMethod() {
        return supportMethod;
    }

    public void setSupportMethod(String supportMethod) {
        this.supportMethod = supportMethod == null ? null : supportMethod.trim();
    }

    public String getSupportIndustry() {
        return supportIndustry;
    }

    public void setSupportIndustry(String supportIndustry) {
        this.supportIndustry = supportIndustry == null ? null : supportIndustry.trim();
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit == null ? null : issueUnit.trim();
    }

    public String getIsPolicyDiagram() {
        return isPolicyDiagram;
    }

    public void setIsPolicyDiagram(String isPolicyDiagram) {
        this.isPolicyDiagram = isPolicyDiagram == null ? null : isPolicyDiagram.trim();
    }

    public String getRelationPolicyDiagramId() {
        return relationPolicyDiagramId;
    }

    public void setRelationPolicyDiagramId(String relationPolicyDiagramId) {
        this.relationPolicyDiagramId = relationPolicyDiagramId == null ? null : relationPolicyDiagramId.trim();
    }

    public String getIsPolicyOriginal() {
        return isPolicyOriginal;
    }

    public void setIsPolicyOriginal(String isPolicyOriginal) {
        this.isPolicyOriginal = isPolicyOriginal == null ? null : isPolicyOriginal.trim();
    }

    public String getRelationPolicyOriginalId() {
        return relationPolicyOriginalId;
    }

    public void setRelationPolicyOriginalId(String relationPolicyOriginalId) {
        this.relationPolicyOriginalId = relationPolicyOriginalId == null ? null : relationPolicyOriginalId.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbPolicy other = (TbPolicy) that;
        return (this.getPolicyId() == null ? other.getPolicyId() == null : this.getPolicyId().equals(other.getPolicyId()))
            && (this.getPolicyCode() == null ? other.getPolicyCode() == null : this.getPolicyCode().equals(other.getPolicyCode()))
            && (this.getPolicyLevelCode() == null ? other.getPolicyLevelCode() == null : this.getPolicyLevelCode().equals(other.getPolicyLevelCode()))
            && (this.getPolicyLevelName() == null ? other.getPolicyLevelName() == null : this.getPolicyLevelName().equals(other.getPolicyLevelName()))
            && (this.getPolicyClassCode() == null ? other.getPolicyClassCode() == null : this.getPolicyClassCode().equals(other.getPolicyClassCode()))
            && (this.getPolicyClassName() == null ? other.getPolicyClassName() == null : this.getPolicyClassName().equals(other.getPolicyClassName()))
            && (this.getPolicyType() == null ? other.getPolicyType() == null : this.getPolicyType().equals(other.getPolicyType()))
            && (this.getPolicyTitle() == null ? other.getPolicyTitle() == null : this.getPolicyTitle().equals(other.getPolicyTitle()))
            && (this.getReadNum() == null ? other.getReadNum() == null : this.getReadNum().equals(other.getReadNum()))
            && (this.getReleaseDate() == null ? other.getReleaseDate() == null : this.getReleaseDate().equals(other.getReleaseDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSupportMethod() == null ? other.getSupportMethod() == null : this.getSupportMethod().equals(other.getSupportMethod()))
            && (this.getSupportIndustry() == null ? other.getSupportIndustry() == null : this.getSupportIndustry().equals(other.getSupportIndustry()))
            && (this.getIssueUnit() == null ? other.getIssueUnit() == null : this.getIssueUnit().equals(other.getIssueUnit()))
            && (this.getIsPolicyDiagram() == null ? other.getIsPolicyDiagram() == null : this.getIsPolicyDiagram().equals(other.getIsPolicyDiagram()))
            && (this.getRelationPolicyDiagramId() == null ? other.getRelationPolicyDiagramId() == null : this.getRelationPolicyDiagramId().equals(other.getRelationPolicyDiagramId()))
            && (this.getIsPolicyOriginal() == null ? other.getIsPolicyOriginal() == null : this.getIsPolicyOriginal().equals(other.getIsPolicyOriginal()))
            && (this.getRelationPolicyOriginalId() == null ? other.getRelationPolicyOriginalId() == null : this.getRelationPolicyOriginalId().equals(other.getRelationPolicyOriginalId()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPolicyId() == null) ? 0 : getPolicyId().hashCode());
        result = prime * result + ((getPolicyCode() == null) ? 0 : getPolicyCode().hashCode());
        result = prime * result + ((getPolicyLevelCode() == null) ? 0 : getPolicyLevelCode().hashCode());
        result = prime * result + ((getPolicyLevelName() == null) ? 0 : getPolicyLevelName().hashCode());
        result = prime * result + ((getPolicyClassCode() == null) ? 0 : getPolicyClassCode().hashCode());
        result = prime * result + ((getPolicyClassName() == null) ? 0 : getPolicyClassName().hashCode());
        result = prime * result + ((getPolicyType() == null) ? 0 : getPolicyType().hashCode());
        result = prime * result + ((getPolicyTitle() == null) ? 0 : getPolicyTitle().hashCode());
        result = prime * result + ((getReadNum() == null) ? 0 : getReadNum().hashCode());
        result = prime * result + ((getReleaseDate() == null) ? 0 : getReleaseDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSupportMethod() == null) ? 0 : getSupportMethod().hashCode());
        result = prime * result + ((getSupportIndustry() == null) ? 0 : getSupportIndustry().hashCode());
        result = prime * result + ((getIssueUnit() == null) ? 0 : getIssueUnit().hashCode());
        result = prime * result + ((getIsPolicyDiagram() == null) ? 0 : getIsPolicyDiagram().hashCode());
        result = prime * result + ((getRelationPolicyDiagramId() == null) ? 0 : getRelationPolicyDiagramId().hashCode());
        result = prime * result + ((getIsPolicyOriginal() == null) ? 0 : getIsPolicyOriginal().hashCode());
        result = prime * result + ((getRelationPolicyOriginalId() == null) ? 0 : getRelationPolicyOriginalId().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", policyId=").append(policyId);
        sb.append(", policyCode=").append(policyCode);
        sb.append(", policyLevelCode=").append(policyLevelCode);
        sb.append(", policyLevelName=").append(policyLevelName);
        sb.append(", policyClassCode=").append(policyClassCode);
        sb.append(", policyClassName=").append(policyClassName);
        sb.append(", policyType=").append(policyType);
        sb.append(", policyTitle=").append(policyTitle);
        sb.append(", readNum=").append(readNum);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", status=").append(status);
        sb.append(", supportMethod=").append(supportMethod);
        sb.append(", supportIndustry=").append(supportIndustry);
        sb.append(", issueUnit=").append(issueUnit);
        sb.append(", isPolicyDiagram=").append(isPolicyDiagram);
        sb.append(", relationPolicyDiagramId=").append(relationPolicyDiagramId);
        sb.append(", isPolicyOriginal=").append(isPolicyOriginal);
        sb.append(", relationPolicyOriginalId=").append(relationPolicyOriginalId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}