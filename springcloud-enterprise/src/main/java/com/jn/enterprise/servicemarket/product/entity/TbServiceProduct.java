package com.jn.enterprise.servicemarket.product.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceProduct implements Serializable {
    private String productId;

    private String serialNumber;

    private String productName;

    private String isOnlineLoan;

    private String referPrice;

    private String signoryId;

    private String signoryName;

    private String templateId;

    private String orgId;

    private String orgName;

    private String serviceCycle;

    private String pictureUrl;

    private String productType;

    private Integer viewCount;

    private String status;

    private String approvalAccount;

    private String approvalComments;

    private Date approvalTime;

    private Date releaseTime;

    private Double refRateMin;

    private Double refRateMax;

    private String modifierAccount;

    private String isPolicyPro;

    private String isGeneralPro;

    private String isRmb;

    private String loanCategoryCode;

    private String loanCategoryName;

    private Double loanAmountMin;

    private Double loanAmountMax;

    private Integer loanTermMin;

    private Integer loanTermMax;

    private String assureMethodCode;

    private String assureMethodName;

    private String productFeature;

    private String applyCondition;

    private String submitMaterial;

    private String applicableCust;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private Byte recordStatus;

    private String productDetails;

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

    public String getIsOnlineLoan() {
        return isOnlineLoan;
    }

    public void setIsOnlineLoan(String isOnlineLoan) {
        this.isOnlineLoan = isOnlineLoan == null ? null : isOnlineLoan.trim();
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
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

    public String getApprovalAccount() {
        return approvalAccount;
    }

    public void setApprovalAccount(String approvalAccount) {
        this.approvalAccount = approvalAccount == null ? null : approvalAccount.trim();
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

    public Double getRefRateMin() {
        return refRateMin;
    }

    public void setRefRateMin(Double refRateMin) {
        this.refRateMin = refRateMin;
    }

    public Double getRefRateMax() {
        return refRateMax;
    }

    public void setRefRateMax(Double refRateMax) {
        this.refRateMax = refRateMax;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getIsPolicyPro() {
        return isPolicyPro;
    }

    public void setIsPolicyPro(String isPolicyPro) {
        this.isPolicyPro = isPolicyPro == null ? null : isPolicyPro.trim();
    }

    public String getIsGeneralPro() {
        return isGeneralPro;
    }

    public void setIsGeneralPro(String isGeneralPro) {
        this.isGeneralPro = isGeneralPro == null ? null : isGeneralPro.trim();
    }

    public String getIsRmb() {
        return isRmb;
    }

    public void setIsRmb(String isRmb) {
        this.isRmb = isRmb == null ? null : isRmb.trim();
    }

    public String getLoanCategoryCode() {
        return loanCategoryCode;
    }

    public void setLoanCategoryCode(String loanCategoryCode) {
        this.loanCategoryCode = loanCategoryCode == null ? null : loanCategoryCode.trim();
    }

    public String getLoanCategoryName() {
        return loanCategoryName;
    }

    public void setLoanCategoryName(String loanCategoryName) {
        this.loanCategoryName = loanCategoryName == null ? null : loanCategoryName.trim();
    }

    public Double getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(Double loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public Double getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(Double loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    public Integer getLoanTermMin() {
        return loanTermMin;
    }

    public void setLoanTermMin(Integer loanTermMin) {
        this.loanTermMin = loanTermMin;
    }

    public Integer getLoanTermMax() {
        return loanTermMax;
    }

    public void setLoanTermMax(Integer loanTermMax) {
        this.loanTermMax = loanTermMax;
    }

    public String getAssureMethodCode() {
        return assureMethodCode;
    }

    public void setAssureMethodCode(String assureMethodCode) {
        this.assureMethodCode = assureMethodCode == null ? null : assureMethodCode.trim();
    }

    public String getAssureMethodName() {
        return assureMethodName;
    }

    public void setAssureMethodName(String assureMethodName) {
        this.assureMethodName = assureMethodName == null ? null : assureMethodName.trim();
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature == null ? null : productFeature.trim();
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition == null ? null : applyCondition.trim();
    }

    public String getSubmitMaterial() {
        return submitMaterial;
    }

    public void setSubmitMaterial(String submitMaterial) {
        this.submitMaterial = submitMaterial == null ? null : submitMaterial.trim();
    }

    public String getApplicableCust() {
        return applicableCust;
    }

    public void setApplicableCust(String applicableCust) {
        this.applicableCust = applicableCust == null ? null : applicableCust.trim();
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails == null ? null : productDetails.trim();
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
            && (this.getIsOnlineLoan() == null ? other.getIsOnlineLoan() == null : this.getIsOnlineLoan().equals(other.getIsOnlineLoan()))
            && (this.getReferPrice() == null ? other.getReferPrice() == null : this.getReferPrice().equals(other.getReferPrice()))
            && (this.getSignoryId() == null ? other.getSignoryId() == null : this.getSignoryId().equals(other.getSignoryId()))
            && (this.getSignoryName() == null ? other.getSignoryName() == null : this.getSignoryName().equals(other.getSignoryName()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getServiceCycle() == null ? other.getServiceCycle() == null : this.getServiceCycle().equals(other.getServiceCycle()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getViewCount() == null ? other.getViewCount() == null : this.getViewCount().equals(other.getViewCount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getApprovalAccount() == null ? other.getApprovalAccount() == null : this.getApprovalAccount().equals(other.getApprovalAccount()))
            && (this.getApprovalComments() == null ? other.getApprovalComments() == null : this.getApprovalComments().equals(other.getApprovalComments()))
            && (this.getApprovalTime() == null ? other.getApprovalTime() == null : this.getApprovalTime().equals(other.getApprovalTime()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getRefRateMin() == null ? other.getRefRateMin() == null : this.getRefRateMin().equals(other.getRefRateMin()))
            && (this.getRefRateMax() == null ? other.getRefRateMax() == null : this.getRefRateMax().equals(other.getRefRateMax()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getIsPolicyPro() == null ? other.getIsPolicyPro() == null : this.getIsPolicyPro().equals(other.getIsPolicyPro()))
            && (this.getIsGeneralPro() == null ? other.getIsGeneralPro() == null : this.getIsGeneralPro().equals(other.getIsGeneralPro()))
            && (this.getIsRmb() == null ? other.getIsRmb() == null : this.getIsRmb().equals(other.getIsRmb()))
            && (this.getLoanCategoryCode() == null ? other.getLoanCategoryCode() == null : this.getLoanCategoryCode().equals(other.getLoanCategoryCode()))
            && (this.getLoanCategoryName() == null ? other.getLoanCategoryName() == null : this.getLoanCategoryName().equals(other.getLoanCategoryName()))
            && (this.getLoanAmountMin() == null ? other.getLoanAmountMin() == null : this.getLoanAmountMin().equals(other.getLoanAmountMin()))
            && (this.getLoanAmountMax() == null ? other.getLoanAmountMax() == null : this.getLoanAmountMax().equals(other.getLoanAmountMax()))
            && (this.getLoanTermMin() == null ? other.getLoanTermMin() == null : this.getLoanTermMin().equals(other.getLoanTermMin()))
            && (this.getLoanTermMax() == null ? other.getLoanTermMax() == null : this.getLoanTermMax().equals(other.getLoanTermMax()))
            && (this.getAssureMethodCode() == null ? other.getAssureMethodCode() == null : this.getAssureMethodCode().equals(other.getAssureMethodCode()))
            && (this.getAssureMethodName() == null ? other.getAssureMethodName() == null : this.getAssureMethodName().equals(other.getAssureMethodName()))
            && (this.getProductFeature() == null ? other.getProductFeature() == null : this.getProductFeature().equals(other.getProductFeature()))
            && (this.getApplyCondition() == null ? other.getApplyCondition() == null : this.getApplyCondition().equals(other.getApplyCondition()))
            && (this.getSubmitMaterial() == null ? other.getSubmitMaterial() == null : this.getSubmitMaterial().equals(other.getSubmitMaterial()))
            && (this.getApplicableCust() == null ? other.getApplicableCust() == null : this.getApplicableCust().equals(other.getApplicableCust()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getProductDetails() == null ? other.getProductDetails() == null : this.getProductDetails().equals(other.getProductDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getIsOnlineLoan() == null) ? 0 : getIsOnlineLoan().hashCode());
        result = prime * result + ((getReferPrice() == null) ? 0 : getReferPrice().hashCode());
        result = prime * result + ((getSignoryId() == null) ? 0 : getSignoryId().hashCode());
        result = prime * result + ((getSignoryName() == null) ? 0 : getSignoryName().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getServiceCycle() == null) ? 0 : getServiceCycle().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getViewCount() == null) ? 0 : getViewCount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getApprovalAccount() == null) ? 0 : getApprovalAccount().hashCode());
        result = prime * result + ((getApprovalComments() == null) ? 0 : getApprovalComments().hashCode());
        result = prime * result + ((getApprovalTime() == null) ? 0 : getApprovalTime().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getRefRateMin() == null) ? 0 : getRefRateMin().hashCode());
        result = prime * result + ((getRefRateMax() == null) ? 0 : getRefRateMax().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getIsPolicyPro() == null) ? 0 : getIsPolicyPro().hashCode());
        result = prime * result + ((getIsGeneralPro() == null) ? 0 : getIsGeneralPro().hashCode());
        result = prime * result + ((getIsRmb() == null) ? 0 : getIsRmb().hashCode());
        result = prime * result + ((getLoanCategoryCode() == null) ? 0 : getLoanCategoryCode().hashCode());
        result = prime * result + ((getLoanCategoryName() == null) ? 0 : getLoanCategoryName().hashCode());
        result = prime * result + ((getLoanAmountMin() == null) ? 0 : getLoanAmountMin().hashCode());
        result = prime * result + ((getLoanAmountMax() == null) ? 0 : getLoanAmountMax().hashCode());
        result = prime * result + ((getLoanTermMin() == null) ? 0 : getLoanTermMin().hashCode());
        result = prime * result + ((getLoanTermMax() == null) ? 0 : getLoanTermMax().hashCode());
        result = prime * result + ((getAssureMethodCode() == null) ? 0 : getAssureMethodCode().hashCode());
        result = prime * result + ((getAssureMethodName() == null) ? 0 : getAssureMethodName().hashCode());
        result = prime * result + ((getProductFeature() == null) ? 0 : getProductFeature().hashCode());
        result = prime * result + ((getApplyCondition() == null) ? 0 : getApplyCondition().hashCode());
        result = prime * result + ((getSubmitMaterial() == null) ? 0 : getSubmitMaterial().hashCode());
        result = prime * result + ((getApplicableCust() == null) ? 0 : getApplicableCust().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getProductDetails() == null) ? 0 : getProductDetails().hashCode());
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
        sb.append(", isOnlineLoan=").append(isOnlineLoan);
        sb.append(", referPrice=").append(referPrice);
        sb.append(", signoryId=").append(signoryId);
        sb.append(", signoryName=").append(signoryName);
        sb.append(", templateId=").append(templateId);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", serviceCycle=").append(serviceCycle);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", productType=").append(productType);
        sb.append(", viewCount=").append(viewCount);
        sb.append(", status=").append(status);
        sb.append(", approvalAccount=").append(approvalAccount);
        sb.append(", approvalComments=").append(approvalComments);
        sb.append(", approvalTime=").append(approvalTime);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", refRateMin=").append(refRateMin);
        sb.append(", refRateMax=").append(refRateMax);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", isPolicyPro=").append(isPolicyPro);
        sb.append(", isGeneralPro=").append(isGeneralPro);
        sb.append(", isRmb=").append(isRmb);
        sb.append(", loanCategoryCode=").append(loanCategoryCode);
        sb.append(", loanCategoryName=").append(loanCategoryName);
        sb.append(", loanAmountMin=").append(loanAmountMin);
        sb.append(", loanAmountMax=").append(loanAmountMax);
        sb.append(", loanTermMin=").append(loanTermMin);
        sb.append(", loanTermMax=").append(loanTermMax);
        sb.append(", assureMethodCode=").append(assureMethodCode);
        sb.append(", assureMethodName=").append(assureMethodName);
        sb.append(", productFeature=").append(productFeature);
        sb.append(", applyCondition=").append(applyCondition);
        sb.append(", submitMaterial=").append(submitMaterial);
        sb.append(", applicableCust=").append(applicableCust);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", productDetails=").append(productDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}