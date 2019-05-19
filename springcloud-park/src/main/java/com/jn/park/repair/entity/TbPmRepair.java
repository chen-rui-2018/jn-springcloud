package com.jn.park.repair.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPmRepair implements Serializable {
    private String id;

    private String enterpriseId;

    private String enterpriseName;

    private String contactMan;

    private String contactPhone;

    private String address;

    private String remarks;

    private String isFreeRepair;

    private Long materielTotalPrice;

    private String assetCompany;

    private Date assetCompleteDate;

    private String repairDepart;

    private String flowNo;

    private String flowTitle;

    private String flowStatus;

    private String flowNodeName;

    private Date flowStartTime;

    private Date flowCompleteTime;

    private String recordStatus;

    private String creatorAccount;

    private Date createTime;

    private String modifierAccount;

    private String photoUrl;

    private String applicant;

    private Date applicationTime;

    private String isNeedRepairMateriel;

    private Date feedbackCompleteDate;

    private String evaluateServiceAttitude;

    private String evaluateServiceEfficiency;

    private String evaluateServiceQuality;

    private String finishExplain;

    private String finishPhotoUrl;

    private String isPay;

    private String evaluateExplain;

    private String evaluatePhotoUrl;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getIsFreeRepair() {
        return isFreeRepair;
    }

    public void setIsFreeRepair(String isFreeRepair) {
        this.isFreeRepair = isFreeRepair == null ? null : isFreeRepair.trim();
    }

    public Long getMaterielTotalPrice() {
        return materielTotalPrice;
    }

    public void setMaterielTotalPrice(Long materielTotalPrice) {
        this.materielTotalPrice = materielTotalPrice;
    }

    public String getAssetCompany() {
        return assetCompany;
    }

    public void setAssetCompany(String assetCompany) {
        this.assetCompany = assetCompany == null ? null : assetCompany.trim();
    }

    public Date getAssetCompleteDate() {
        return assetCompleteDate;
    }

    public void setAssetCompleteDate(Date assetCompleteDate) {
        this.assetCompleteDate = assetCompleteDate;
    }

    public String getRepairDepart() {
        return repairDepart;
    }

    public void setRepairDepart(String repairDepart) {
        this.repairDepart = repairDepart == null ? null : repairDepart.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public void setFlowTitle(String flowTitle) {
        this.flowTitle = flowTitle == null ? null : flowTitle.trim();
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus == null ? null : flowStatus.trim();
    }

    public String getFlowNodeName() {
        return flowNodeName;
    }

    public void setFlowNodeName(String flowNodeName) {
        this.flowNodeName = flowNodeName == null ? null : flowNodeName.trim();
    }

    public Date getFlowStartTime() {
        return flowStartTime;
    }

    public void setFlowStartTime(Date flowStartTime) {
        this.flowStartTime = flowStartTime;
    }

    public Date getFlowCompleteTime() {
        return flowCompleteTime;
    }

    public void setFlowCompleteTime(Date flowCompleteTime) {
        this.flowCompleteTime = flowCompleteTime;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getIsNeedRepairMateriel() {
        return isNeedRepairMateriel;
    }

    public void setIsNeedRepairMateriel(String isNeedRepairMateriel) {
        this.isNeedRepairMateriel = isNeedRepairMateriel == null ? null : isNeedRepairMateriel.trim();
    }

    public Date getFeedbackCompleteDate() {
        return feedbackCompleteDate;
    }

    public void setFeedbackCompleteDate(Date feedbackCompleteDate) {
        this.feedbackCompleteDate = feedbackCompleteDate;
    }

    public String getEvaluateServiceAttitude() {
        return evaluateServiceAttitude;
    }

    public void setEvaluateServiceAttitude(String evaluateServiceAttitude) {
        this.evaluateServiceAttitude = evaluateServiceAttitude == null ? null : evaluateServiceAttitude.trim();
    }

    public String getEvaluateServiceEfficiency() {
        return evaluateServiceEfficiency;
    }

    public void setEvaluateServiceEfficiency(String evaluateServiceEfficiency) {
        this.evaluateServiceEfficiency = evaluateServiceEfficiency == null ? null : evaluateServiceEfficiency.trim();
    }

    public String getEvaluateServiceQuality() {
        return evaluateServiceQuality;
    }

    public void setEvaluateServiceQuality(String evaluateServiceQuality) {
        this.evaluateServiceQuality = evaluateServiceQuality == null ? null : evaluateServiceQuality.trim();
    }

    public String getFinishExplain() {
        return finishExplain;
    }

    public void setFinishExplain(String finishExplain) {
        this.finishExplain = finishExplain == null ? null : finishExplain.trim();
    }

    public String getFinishPhotoUrl() {
        return finishPhotoUrl;
    }

    public void setFinishPhotoUrl(String finishPhotoUrl) {
        this.finishPhotoUrl = finishPhotoUrl == null ? null : finishPhotoUrl.trim();
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay == null ? null : isPay.trim();
    }

    public String getEvaluateExplain() {
        return evaluateExplain;
    }

    public void setEvaluateExplain(String evaluateExplain) {
        this.evaluateExplain = evaluateExplain == null ? null : evaluateExplain.trim();
    }

    public String getEvaluatePhotoUrl() {
        return evaluatePhotoUrl;
    }

    public void setEvaluatePhotoUrl(String evaluatePhotoUrl) {
        this.evaluatePhotoUrl = evaluatePhotoUrl == null ? null : evaluatePhotoUrl.trim();
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
        TbPmRepair other = (TbPmRepair) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getEnterpriseName() == null ? other.getEnterpriseName() == null : this.getEnterpriseName().equals(other.getEnterpriseName()))
            && (this.getContactMan() == null ? other.getContactMan() == null : this.getContactMan().equals(other.getContactMan()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getIsFreeRepair() == null ? other.getIsFreeRepair() == null : this.getIsFreeRepair().equals(other.getIsFreeRepair()))
            && (this.getMaterielTotalPrice() == null ? other.getMaterielTotalPrice() == null : this.getMaterielTotalPrice().equals(other.getMaterielTotalPrice()))
            && (this.getAssetCompany() == null ? other.getAssetCompany() == null : this.getAssetCompany().equals(other.getAssetCompany()))
            && (this.getAssetCompleteDate() == null ? other.getAssetCompleteDate() == null : this.getAssetCompleteDate().equals(other.getAssetCompleteDate()))
            && (this.getRepairDepart() == null ? other.getRepairDepart() == null : this.getRepairDepart().equals(other.getRepairDepart()))
            && (this.getFlowNo() == null ? other.getFlowNo() == null : this.getFlowNo().equals(other.getFlowNo()))
            && (this.getFlowTitle() == null ? other.getFlowTitle() == null : this.getFlowTitle().equals(other.getFlowTitle()))
            && (this.getFlowStatus() == null ? other.getFlowStatus() == null : this.getFlowStatus().equals(other.getFlowStatus()))
            && (this.getFlowNodeName() == null ? other.getFlowNodeName() == null : this.getFlowNodeName().equals(other.getFlowNodeName()))
            && (this.getFlowStartTime() == null ? other.getFlowStartTime() == null : this.getFlowStartTime().equals(other.getFlowStartTime()))
            && (this.getFlowCompleteTime() == null ? other.getFlowCompleteTime() == null : this.getFlowCompleteTime().equals(other.getFlowCompleteTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
            && (this.getApplicationTime() == null ? other.getApplicationTime() == null : this.getApplicationTime().equals(other.getApplicationTime()))
            && (this.getIsNeedRepairMateriel() == null ? other.getIsNeedRepairMateriel() == null : this.getIsNeedRepairMateriel().equals(other.getIsNeedRepairMateriel()))
            && (this.getFeedbackCompleteDate() == null ? other.getFeedbackCompleteDate() == null : this.getFeedbackCompleteDate().equals(other.getFeedbackCompleteDate()))
            && (this.getEvaluateServiceAttitude() == null ? other.getEvaluateServiceAttitude() == null : this.getEvaluateServiceAttitude().equals(other.getEvaluateServiceAttitude()))
            && (this.getEvaluateServiceEfficiency() == null ? other.getEvaluateServiceEfficiency() == null : this.getEvaluateServiceEfficiency().equals(other.getEvaluateServiceEfficiency()))
            && (this.getEvaluateServiceQuality() == null ? other.getEvaluateServiceQuality() == null : this.getEvaluateServiceQuality().equals(other.getEvaluateServiceQuality()))
            && (this.getFinishExplain() == null ? other.getFinishExplain() == null : this.getFinishExplain().equals(other.getFinishExplain()))
            && (this.getFinishPhotoUrl() == null ? other.getFinishPhotoUrl() == null : this.getFinishPhotoUrl().equals(other.getFinishPhotoUrl()))
            && (this.getIsPay() == null ? other.getIsPay() == null : this.getIsPay().equals(other.getIsPay()))
            && (this.getEvaluateExplain() == null ? other.getEvaluateExplain() == null : this.getEvaluateExplain().equals(other.getEvaluateExplain()))
            && (this.getEvaluatePhotoUrl() == null ? other.getEvaluatePhotoUrl() == null : this.getEvaluatePhotoUrl().equals(other.getEvaluatePhotoUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getEnterpriseName() == null) ? 0 : getEnterpriseName().hashCode());
        result = prime * result + ((getContactMan() == null) ? 0 : getContactMan().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getIsFreeRepair() == null) ? 0 : getIsFreeRepair().hashCode());
        result = prime * result + ((getMaterielTotalPrice() == null) ? 0 : getMaterielTotalPrice().hashCode());
        result = prime * result + ((getAssetCompany() == null) ? 0 : getAssetCompany().hashCode());
        result = prime * result + ((getAssetCompleteDate() == null) ? 0 : getAssetCompleteDate().hashCode());
        result = prime * result + ((getRepairDepart() == null) ? 0 : getRepairDepart().hashCode());
        result = prime * result + ((getFlowNo() == null) ? 0 : getFlowNo().hashCode());
        result = prime * result + ((getFlowTitle() == null) ? 0 : getFlowTitle().hashCode());
        result = prime * result + ((getFlowStatus() == null) ? 0 : getFlowStatus().hashCode());
        result = prime * result + ((getFlowNodeName() == null) ? 0 : getFlowNodeName().hashCode());
        result = prime * result + ((getFlowStartTime() == null) ? 0 : getFlowStartTime().hashCode());
        result = prime * result + ((getFlowCompleteTime() == null) ? 0 : getFlowCompleteTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getApplicationTime() == null) ? 0 : getApplicationTime().hashCode());
        result = prime * result + ((getIsNeedRepairMateriel() == null) ? 0 : getIsNeedRepairMateriel().hashCode());
        result = prime * result + ((getFeedbackCompleteDate() == null) ? 0 : getFeedbackCompleteDate().hashCode());
        result = prime * result + ((getEvaluateServiceAttitude() == null) ? 0 : getEvaluateServiceAttitude().hashCode());
        result = prime * result + ((getEvaluateServiceEfficiency() == null) ? 0 : getEvaluateServiceEfficiency().hashCode());
        result = prime * result + ((getEvaluateServiceQuality() == null) ? 0 : getEvaluateServiceQuality().hashCode());
        result = prime * result + ((getFinishExplain() == null) ? 0 : getFinishExplain().hashCode());
        result = prime * result + ((getFinishPhotoUrl() == null) ? 0 : getFinishPhotoUrl().hashCode());
        result = prime * result + ((getIsPay() == null) ? 0 : getIsPay().hashCode());
        result = prime * result + ((getEvaluateExplain() == null) ? 0 : getEvaluateExplain().hashCode());
        result = prime * result + ((getEvaluatePhotoUrl() == null) ? 0 : getEvaluatePhotoUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", contactMan=").append(contactMan);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", address=").append(address);
        sb.append(", remarks=").append(remarks);
        sb.append(", isFreeRepair=").append(isFreeRepair);
        sb.append(", materielTotalPrice=").append(materielTotalPrice);
        sb.append(", assetCompany=").append(assetCompany);
        sb.append(", assetCompleteDate=").append(assetCompleteDate);
        sb.append(", repairDepart=").append(repairDepart);
        sb.append(", flowNo=").append(flowNo);
        sb.append(", flowTitle=").append(flowTitle);
        sb.append(", flowStatus=").append(flowStatus);
        sb.append(", flowNodeName=").append(flowNodeName);
        sb.append(", flowStartTime=").append(flowStartTime);
        sb.append(", flowCompleteTime=").append(flowCompleteTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", photoUrl=").append(photoUrl);
        sb.append(", applicant=").append(applicant);
        sb.append(", applicationTime=").append(applicationTime);
        sb.append(", isNeedRepairMateriel=").append(isNeedRepairMateriel);
        sb.append(", feedbackCompleteDate=").append(feedbackCompleteDate);
        sb.append(", evaluateServiceAttitude=").append(evaluateServiceAttitude);
        sb.append(", evaluateServiceEfficiency=").append(evaluateServiceEfficiency);
        sb.append(", evaluateServiceQuality=").append(evaluateServiceQuality);
        sb.append(", finishExplain=").append(finishExplain);
        sb.append(", finishPhotoUrl=").append(finishPhotoUrl);
        sb.append(", isPay=").append(isPay);
        sb.append(", evaluateExplain=").append(evaluateExplain);
        sb.append(", evaluatePhotoUrl=").append(evaluatePhotoUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}