package com.jn.park.repair.model;

import java.io.Serializable;

/**
 * 物业服务-企业报修
 *
 * @author： yuanyy
 * @date： Created on 2019/5/15 20:17
 * @version： v1.0
 * @modified By:
 */
public class Repair implements Serializable {
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

    private String assetCompleteDate;

    private String repairDepart;

    private String flowNo;

    private String flowTitle;

    private String flowStatus;

    private String flowNodeName;

    private String flowStartTime;

    private String flowCompleteTime;

    private String recordStatus;

    private String creatorAccount;

    private String createTime;

    private String modifierAccount;

    private String photoUrl;

    private String applicant;

    private String applicationTime;

    private String isNeedRepairMateriel;

    private String feedbackCompleteDate;

    private String evaluateServiceAttitude;

    private String evaluateServiceEfficiency;

    private String evaluateServiceQuality;

    private String finishExplain;

    private String finishPhotoUrl;

    private String isPay;

    private String evaluateExplain;

    private String evaluatePhotoUrl;

    private String flowInstId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsFreeRepair() {
        return isFreeRepair;
    }

    public void setIsFreeRepair(String isFreeRepair) {
        this.isFreeRepair = isFreeRepair;
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
        this.assetCompany = assetCompany;
    }

    public String getAssetCompleteDate() {
        return assetCompleteDate;
    }

    public void setAssetCompleteDate(String assetCompleteDate) {
        this.assetCompleteDate = assetCompleteDate;
    }

    public String getRepairDepart() {
        return repairDepart;
    }

    public void setRepairDepart(String repairDepart) {
        this.repairDepart = repairDepart;
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public void setFlowTitle(String flowTitle) {
        this.flowTitle = flowTitle;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getFlowNodeName() {
        return flowNodeName;
    }

    public void setFlowNodeName(String flowNodeName) {
        this.flowNodeName = flowNodeName;
    }

    public String getFlowStartTime() {
        return flowStartTime;
    }

    public void setFlowStartTime(String flowStartTime) {
        this.flowStartTime = flowStartTime;
    }

    public String getFlowCompleteTime() {
        return flowCompleteTime;
    }

    public void setFlowCompleteTime(String flowCompleteTime) {
        this.flowCompleteTime = flowCompleteTime;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getIsNeedRepairMateriel() {
        return isNeedRepairMateriel;
    }

    public void setIsNeedRepairMateriel(String isNeedRepairMateriel) {
        this.isNeedRepairMateriel = isNeedRepairMateriel;
    }

    public String getFeedbackCompleteDate() {
        return feedbackCompleteDate;
    }

    public void setFeedbackCompleteDate(String feedbackCompleteDate) {
        this.feedbackCompleteDate = feedbackCompleteDate;
    }

    public String getEvaluateServiceAttitude() {
        return evaluateServiceAttitude;
    }

    public void setEvaluateServiceAttitude(String evaluateServiceAttitude) {
        this.evaluateServiceAttitude = evaluateServiceAttitude;
    }

    public String getEvaluateServiceEfficiency() {
        return evaluateServiceEfficiency;
    }

    public void setEvaluateServiceEfficiency(String evaluateServiceEfficiency) {
        this.evaluateServiceEfficiency = evaluateServiceEfficiency;
    }

    public String getEvaluateServiceQuality() {
        return evaluateServiceQuality;
    }

    public void setEvaluateServiceQuality(String evaluateServiceQuality) {
        this.evaluateServiceQuality = evaluateServiceQuality;
    }

    public String getFinishExplain() {
        return finishExplain;
    }

    public void setFinishExplain(String finishExplain) {
        this.finishExplain = finishExplain;
    }

    public String getFinishPhotoUrl() {
        return finishPhotoUrl;
    }

    public void setFinishPhotoUrl(String finishPhotoUrl) {
        this.finishPhotoUrl = finishPhotoUrl;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getEvaluateExplain() {
        return evaluateExplain;
    }

    public void setEvaluateExplain(String evaluateExplain) {
        this.evaluateExplain = evaluateExplain;
    }

    public String getEvaluatePhotoUrl() {
        return evaluatePhotoUrl;
    }

    public void setEvaluatePhotoUrl(String evaluatePhotoUrl) {
        this.evaluatePhotoUrl = evaluatePhotoUrl;
    }

    public String getFlowInstId() {
        return flowInstId;
    }

    public void setFlowInstId(String flowInstId) {
        this.flowInstId = flowInstId;
    }
}
