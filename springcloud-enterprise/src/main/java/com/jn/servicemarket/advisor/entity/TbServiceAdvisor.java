package com.jn.servicemarket.advisor.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TbServiceAdvisor implements Serializable {
    private String id;

    private String orgId;

    private String tbId;

    private String asvisorAccount;

    private String businessArea;

    private String avatar;

    private String position;

    private String orgName;

    private String isCertification;

    private String contactEmail;

    private String cardType;

    private String cardNumber;

    private String education;

    private String graduatedSchool;

    private String evalluationLevel;

    private Integer evaluationNum;

    private String practiceQualification;

    private String goodAtBusiness;

    private Integer transactionNum;

    private Integer pageviews;

    private String isHaveSubsidy;

    private String approvalStatus;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private byte[] personalProfile;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getTbId() {
        return tbId;
    }

    public void setTbId(String tbId) {
        this.tbId = tbId == null ? null : tbId.trim();
    }

    public String getAsvisorAccount() {
        return asvisorAccount;
    }

    public void setAsvisorAccount(String asvisorAccount) {
        this.asvisorAccount = asvisorAccount == null ? null : asvisorAccount.trim();
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea == null ? null : businessArea.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification == null ? null : isCertification.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool == null ? null : graduatedSchool.trim();
    }

    public String getEvalluationLevel() {
        return evalluationLevel;
    }

    public void setEvalluationLevel(String evalluationLevel) {
        this.evalluationLevel = evalluationLevel == null ? null : evalluationLevel.trim();
    }

    public Integer getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(Integer evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    public String getPracticeQualification() {
        return practiceQualification;
    }

    public void setPracticeQualification(String practiceQualification) {
        this.practiceQualification = practiceQualification == null ? null : practiceQualification.trim();
    }

    public String getGoodAtBusiness() {
        return goodAtBusiness;
    }

    public void setGoodAtBusiness(String goodAtBusiness) {
        this.goodAtBusiness = goodAtBusiness == null ? null : goodAtBusiness.trim();
    }

    public Integer getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(Integer transactionNum) {
        this.transactionNum = transactionNum;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public String getIsHaveSubsidy() {
        return isHaveSubsidy;
    }

    public void setIsHaveSubsidy(String isHaveSubsidy) {
        this.isHaveSubsidy = isHaveSubsidy == null ? null : isHaveSubsidy.trim();
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
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

    public byte[] getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(byte[] personalProfile) {
        this.personalProfile = personalProfile;
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
        TbServiceAdvisor other = (TbServiceAdvisor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getTbId() == null ? other.getTbId() == null : this.getTbId().equals(other.getTbId()))
            && (this.getAsvisorAccount() == null ? other.getAsvisorAccount() == null : this.getAsvisorAccount().equals(other.getAsvisorAccount()))
            && (this.getBusinessArea() == null ? other.getBusinessArea() == null : this.getBusinessArea().equals(other.getBusinessArea()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getIsCertification() == null ? other.getIsCertification() == null : this.getIsCertification().equals(other.getIsCertification()))
            && (this.getContactEmail() == null ? other.getContactEmail() == null : this.getContactEmail().equals(other.getContactEmail()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getGraduatedSchool() == null ? other.getGraduatedSchool() == null : this.getGraduatedSchool().equals(other.getGraduatedSchool()))
            && (this.getEvalluationLevel() == null ? other.getEvalluationLevel() == null : this.getEvalluationLevel().equals(other.getEvalluationLevel()))
            && (this.getEvaluationNum() == null ? other.getEvaluationNum() == null : this.getEvaluationNum().equals(other.getEvaluationNum()))
            && (this.getPracticeQualification() == null ? other.getPracticeQualification() == null : this.getPracticeQualification().equals(other.getPracticeQualification()))
            && (this.getGoodAtBusiness() == null ? other.getGoodAtBusiness() == null : this.getGoodAtBusiness().equals(other.getGoodAtBusiness()))
            && (this.getTransactionNum() == null ? other.getTransactionNum() == null : this.getTransactionNum().equals(other.getTransactionNum()))
            && (this.getPageviews() == null ? other.getPageviews() == null : this.getPageviews().equals(other.getPageviews()))
            && (this.getIsHaveSubsidy() == null ? other.getIsHaveSubsidy() == null : this.getIsHaveSubsidy().equals(other.getIsHaveSubsidy()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (Arrays.equals(this.getPersonalProfile(), other.getPersonalProfile()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getTbId() == null) ? 0 : getTbId().hashCode());
        result = prime * result + ((getAsvisorAccount() == null) ? 0 : getAsvisorAccount().hashCode());
        result = prime * result + ((getBusinessArea() == null) ? 0 : getBusinessArea().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getIsCertification() == null) ? 0 : getIsCertification().hashCode());
        result = prime * result + ((getContactEmail() == null) ? 0 : getContactEmail().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getGraduatedSchool() == null) ? 0 : getGraduatedSchool().hashCode());
        result = prime * result + ((getEvalluationLevel() == null) ? 0 : getEvalluationLevel().hashCode());
        result = prime * result + ((getEvaluationNum() == null) ? 0 : getEvaluationNum().hashCode());
        result = prime * result + ((getPracticeQualification() == null) ? 0 : getPracticeQualification().hashCode());
        result = prime * result + ((getGoodAtBusiness() == null) ? 0 : getGoodAtBusiness().hashCode());
        result = prime * result + ((getTransactionNum() == null) ? 0 : getTransactionNum().hashCode());
        result = prime * result + ((getPageviews() == null) ? 0 : getPageviews().hashCode());
        result = prime * result + ((getIsHaveSubsidy() == null) ? 0 : getIsHaveSubsidy().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + (Arrays.hashCode(getPersonalProfile()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgId=").append(orgId);
        sb.append(", tbId=").append(tbId);
        sb.append(", asvisorAccount=").append(asvisorAccount);
        sb.append(", businessArea=").append(businessArea);
        sb.append(", avatar=").append(avatar);
        sb.append(", position=").append(position);
        sb.append(", orgName=").append(orgName);
        sb.append(", isCertification=").append(isCertification);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", education=").append(education);
        sb.append(", graduatedSchool=").append(graduatedSchool);
        sb.append(", evalluationLevel=").append(evalluationLevel);
        sb.append(", evaluationNum=").append(evaluationNum);
        sb.append(", practiceQualification=").append(practiceQualification);
        sb.append(", goodAtBusiness=").append(goodAtBusiness);
        sb.append(", transactionNum=").append(transactionNum);
        sb.append(", pageviews=").append(pageviews);
        sb.append(", isHaveSubsidy=").append(isHaveSubsidy);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", personalProfile=").append(personalProfile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}