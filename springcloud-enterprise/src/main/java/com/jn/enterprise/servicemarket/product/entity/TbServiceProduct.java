package com.jn.enterprise.servicemarket.product.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceProduct implements Serializable {
    private String productId;

    private String serialNumber;

    private String productName;

    private String referPrice;

    private String signoryId;

    private String signoryName;

    private String templateId;

    private String orgId;

    private String serviceCycle;

    private String pictureUrl;

    private String productType;

    private Integer viewCount;

    private String status;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private String approvalComments;

    private Date approvalTime;

    private Date releaseTime;

    private String approvalAccount;

    private static final long serialVersionUID = 1L;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getReferPrice() {
        return referPrice;
    }

    public void setReferPrice(String referPrice) {
        this.referPrice = referPrice == null ? null : referPrice.trim();
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId == null ? null : signoryId.trim();
    }

    public String getSignoryName() {
        return signoryName;
    }

    public void setSignoryName(String signoryName) {
        this.signoryName = signoryName == null ? null : signoryName.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getServiceCycle() {
        return serviceCycle;
    }

    public void setServiceCycle(String serviceCycle) {
        this.serviceCycle = serviceCycle == null ? null : serviceCycle.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getApprovalComments() {
        return approvalComments;
    }

    public void setApprovalComments(String approvalComments) {
        this.approvalComments = approvalComments == null ? null : approvalComments.trim();
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getApprovalAccount() {
        return approvalAccount;
    }

    public void setApprovalAccount(String approvalAccount) {
        this.approvalAccount = approvalAccount == null ? null : approvalAccount.trim();
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
        TbServiceProduct other = (TbServiceProduct) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getReferPrice() == null ? other.getReferPrice() == null : this.getReferPrice().equals(other.getReferPrice()))
            && (this.getSignoryId() == null ? other.getSignoryId() == null : this.getSignoryId().equals(other.getSignoryId()))
            && (this.getSignoryName() == null ? other.getSignoryName() == null : this.getSignoryName().equals(other.getSignoryName()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getServiceCycle() == null ? other.getServiceCycle() == null : this.getServiceCycle().equals(other.getServiceCycle()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getViewCount() == null ? other.getViewCount() == null : this.getViewCount().equals(other.getViewCount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getApprovalComments() == null ? other.getApprovalComments() == null : this.getApprovalComments().equals(other.getApprovalComments()))
            && (this.getApprovalTime() == null ? other.getApprovalTime() == null : this.getApprovalTime().equals(other.getApprovalTime()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getApprovalAccount() == null ? other.getApprovalAccount() == null : this.getApprovalAccount().equals(other.getApprovalAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getReferPrice() == null) ? 0 : getReferPrice().hashCode());
        result = prime * result + ((getSignoryId() == null) ? 0 : getSignoryId().hashCode());
        result = prime * result + ((getSignoryName() == null) ? 0 : getSignoryName().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getServiceCycle() == null) ? 0 : getServiceCycle().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getViewCount() == null) ? 0 : getViewCount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getApprovalComments() == null) ? 0 : getApprovalComments().hashCode());
        result = prime * result + ((getApprovalTime() == null) ? 0 : getApprovalTime().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getApprovalAccount() == null) ? 0 : getApprovalAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", productName=").append(productName);
        sb.append(", referPrice=").append(referPrice);
        sb.append(", signoryId=").append(signoryId);
        sb.append(", signoryName=").append(signoryName);
        sb.append(", templateId=").append(templateId);
        sb.append(", orgId=").append(orgId);
        sb.append(", serviceCycle=").append(serviceCycle);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", productType=").append(productType);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", approvalComments=").append(approvalComments);
        sb.append(", approvalTime=").append(approvalTime);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", approvalAccount=").append(approvalAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}