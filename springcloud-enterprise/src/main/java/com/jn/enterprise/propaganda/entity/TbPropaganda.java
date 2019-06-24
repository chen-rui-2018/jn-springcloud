package com.jn.enterprise.propaganda.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPropaganda implements Serializable {
    private String id;

    private String propagandaCode;

    private String propagandaTitle;

    private String propagandaType;

    private String issuePlatform;

    private Date effectiveDate;

    private Date invalidDate;

    private String propagandaArea;

    private String propagandaAreaUrl;

    private String posterUrl;

    private Integer sort;

    private String status;

    private String orgId;

    private String orgName;

    private String proFeeRuleCode;

    private Double propagandaFee;

    private String isPay;

    private String approvalStatus;

    private String approvalDesc;

    private String viewCount;

    private String orderCode;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private String propagandaDetails;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPropagandaCode() {
        return propagandaCode;
    }

    public void setPropagandaCode(String propagandaCode) {
        this.propagandaCode = propagandaCode == null ? null : propagandaCode.trim();
    }

    public String getPropagandaTitle() {
        return propagandaTitle;
    }

    public void setPropagandaTitle(String propagandaTitle) {
        this.propagandaTitle = propagandaTitle == null ? null : propagandaTitle.trim();
    }

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType == null ? null : propagandaType.trim();
    }

    public String getIssuePlatform() {
        return issuePlatform;
    }

    public void setIssuePlatform(String issuePlatform) {
        this.issuePlatform = issuePlatform == null ? null : issuePlatform.trim();
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea == null ? null : propagandaArea.trim();
    }

    public String getPropagandaAreaUrl() {
        return propagandaAreaUrl;
    }

    public void setPropagandaAreaUrl(String propagandaAreaUrl) {
        this.propagandaAreaUrl = propagandaAreaUrl == null ? null : propagandaAreaUrl.trim();
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl == null ? null : posterUrl.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getProFeeRuleCode() {
        return proFeeRuleCode;
    }

    public void setProFeeRuleCode(String proFeeRuleCode) {
        this.proFeeRuleCode = proFeeRuleCode == null ? null : proFeeRuleCode.trim();
    }

    public Double getPropagandaFee() {
        return propagandaFee;
    }

    public void setPropagandaFee(Double propagandaFee) {
        this.propagandaFee = propagandaFee;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay == null ? null : isPay.trim();
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
    }

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc == null ? null : approvalDesc.trim();
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount == null ? null : viewCount.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
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

    public String getPropagandaDetails() {
        return propagandaDetails;
    }

    public void setPropagandaDetails(String propagandaDetails) {
        this.propagandaDetails = propagandaDetails == null ? null : propagandaDetails.trim();
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
        TbPropaganda other = (TbPropaganda) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPropagandaCode() == null ? other.getPropagandaCode() == null : this.getPropagandaCode().equals(other.getPropagandaCode()))
            && (this.getPropagandaTitle() == null ? other.getPropagandaTitle() == null : this.getPropagandaTitle().equals(other.getPropagandaTitle()))
            && (this.getPropagandaType() == null ? other.getPropagandaType() == null : this.getPropagandaType().equals(other.getPropagandaType()))
            && (this.getIssuePlatform() == null ? other.getIssuePlatform() == null : this.getIssuePlatform().equals(other.getIssuePlatform()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getInvalidDate() == null ? other.getInvalidDate() == null : this.getInvalidDate().equals(other.getInvalidDate()))
            && (this.getPropagandaArea() == null ? other.getPropagandaArea() == null : this.getPropagandaArea().equals(other.getPropagandaArea()))
            && (this.getPropagandaAreaUrl() == null ? other.getPropagandaAreaUrl() == null : this.getPropagandaAreaUrl().equals(other.getPropagandaAreaUrl()))
            && (this.getPosterUrl() == null ? other.getPosterUrl() == null : this.getPosterUrl().equals(other.getPosterUrl()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getProFeeRuleCode() == null ? other.getProFeeRuleCode() == null : this.getProFeeRuleCode().equals(other.getProFeeRuleCode()))
            && (this.getPropagandaFee() == null ? other.getPropagandaFee() == null : this.getPropagandaFee().equals(other.getPropagandaFee()))
            && (this.getIsPay() == null ? other.getIsPay() == null : this.getIsPay().equals(other.getIsPay()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getApprovalDesc() == null ? other.getApprovalDesc() == null : this.getApprovalDesc().equals(other.getApprovalDesc()))
            && (this.getViewCount() == null ? other.getViewCount() == null : this.getViewCount().equals(other.getViewCount()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getPropagandaDetails() == null ? other.getPropagandaDetails() == null : this.getPropagandaDetails().equals(other.getPropagandaDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPropagandaCode() == null) ? 0 : getPropagandaCode().hashCode());
        result = prime * result + ((getPropagandaTitle() == null) ? 0 : getPropagandaTitle().hashCode());
        result = prime * result + ((getPropagandaType() == null) ? 0 : getPropagandaType().hashCode());
        result = prime * result + ((getIssuePlatform() == null) ? 0 : getIssuePlatform().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getInvalidDate() == null) ? 0 : getInvalidDate().hashCode());
        result = prime * result + ((getPropagandaArea() == null) ? 0 : getPropagandaArea().hashCode());
        result = prime * result + ((getPropagandaAreaUrl() == null) ? 0 : getPropagandaAreaUrl().hashCode());
        result = prime * result + ((getPosterUrl() == null) ? 0 : getPosterUrl().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getProFeeRuleCode() == null) ? 0 : getProFeeRuleCode().hashCode());
        result = prime * result + ((getPropagandaFee() == null) ? 0 : getPropagandaFee().hashCode());
        result = prime * result + ((getIsPay() == null) ? 0 : getIsPay().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getApprovalDesc() == null) ? 0 : getApprovalDesc().hashCode());
        result = prime * result + ((getViewCount() == null) ? 0 : getViewCount().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getPropagandaDetails() == null) ? 0 : getPropagandaDetails().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", propagandaCode=").append(propagandaCode);
        sb.append(", propagandaTitle=").append(propagandaTitle);
        sb.append(", propagandaType=").append(propagandaType);
        sb.append(", issuePlatform=").append(issuePlatform);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", invalidDate=").append(invalidDate);
        sb.append(", propagandaArea=").append(propagandaArea);
        sb.append(", propagandaAreaUrl=").append(propagandaAreaUrl);
        sb.append(", posterUrl=").append(posterUrl);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", proFeeRuleCode=").append(proFeeRuleCode);
        sb.append(", propagandaFee=").append(propagandaFee);
        sb.append(", isPay=").append(isPay);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", approvalDesc=").append(approvalDesc);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", propagandaDetails=").append(propagandaDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}