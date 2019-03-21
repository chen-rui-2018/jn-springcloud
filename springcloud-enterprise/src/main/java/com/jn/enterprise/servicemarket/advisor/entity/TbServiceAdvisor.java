package com.jn.enterprise.servicemarket.advisor.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceAdvisor implements Serializable {
    private String id;

    private String orgId;

    private String orgName;

    private String advisorAccount;

    private String advisorName;

    private String businessArea;

    private String avatar;

    private String position;

    private String isCertification;

    private String phone;

    private String contactEmail;

    private String cardType;

    private String cardNumber;

    private String education;

    private String graduatedSchool;

    private String personalProfile;

    private Float workingYears;

    private String practiceQualification;

    private String goodAtBusiness;

    private Integer transactionNum;

    private Integer pageViews;

    private String isHaveSubsidy;

    private String approvalStatus;

    private String approvalDesc;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount == null ? null : advisorAccount.trim();
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName == null ? null : advisorName.trim();
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

    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification == null ? null : isCertification.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile == null ? null : personalProfile.trim();
    }

    public Float getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Float workingYears) {
        this.workingYears = workingYears;
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

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
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

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc == null ? null : approvalDesc.trim();
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
        TbServiceAdvisor other = (TbServiceAdvisor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getAdvisorAccount() == null ? other.getAdvisorAccount() == null : this.getAdvisorAccount().equals(other.getAdvisorAccount()))
            && (this.getAdvisorName() == null ? other.getAdvisorName() == null : this.getAdvisorName().equals(other.getAdvisorName()))
            && (this.getBusinessArea() == null ? other.getBusinessArea() == null : this.getBusinessArea().equals(other.getBusinessArea()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getIsCertification() == null ? other.getIsCertification() == null : this.getIsCertification().equals(other.getIsCertification()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getContactEmail() == null ? other.getContactEmail() == null : this.getContactEmail().equals(other.getContactEmail()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getGraduatedSchool() == null ? other.getGraduatedSchool() == null : this.getGraduatedSchool().equals(other.getGraduatedSchool()))
            && (this.getPersonalProfile() == null ? other.getPersonalProfile() == null : this.getPersonalProfile().equals(other.getPersonalProfile()))
            && (this.getWorkingYears() == null ? other.getWorkingYears() == null : this.getWorkingYears().equals(other.getWorkingYears()))
            && (this.getPracticeQualification() == null ? other.getPracticeQualification() == null : this.getPracticeQualification().equals(other.getPracticeQualification()))
            && (this.getGoodAtBusiness() == null ? other.getGoodAtBusiness() == null : this.getGoodAtBusiness().equals(other.getGoodAtBusiness()))
            && (this.getTransactionNum() == null ? other.getTransactionNum() == null : this.getTransactionNum().equals(other.getTransactionNum()))
            && (this.getPageViews() == null ? other.getPageViews() == null : this.getPageViews().equals(other.getPageViews()))
            && (this.getIsHaveSubsidy() == null ? other.getIsHaveSubsidy() == null : this.getIsHaveSubsidy().equals(other.getIsHaveSubsidy()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getApprovalDesc() == null ? other.getApprovalDesc() == null : this.getApprovalDesc().equals(other.getApprovalDesc()))
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
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getAdvisorAccount() == null) ? 0 : getAdvisorAccount().hashCode());
        result = prime * result + ((getAdvisorName() == null) ? 0 : getAdvisorName().hashCode());
        result = prime * result + ((getBusinessArea() == null) ? 0 : getBusinessArea().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getIsCertification() == null) ? 0 : getIsCertification().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getContactEmail() == null) ? 0 : getContactEmail().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getGraduatedSchool() == null) ? 0 : getGraduatedSchool().hashCode());
        result = prime * result + ((getPersonalProfile() == null) ? 0 : getPersonalProfile().hashCode());
        result = prime * result + ((getWorkingYears() == null) ? 0 : getWorkingYears().hashCode());
        result = prime * result + ((getPracticeQualification() == null) ? 0 : getPracticeQualification().hashCode());
        result = prime * result + ((getGoodAtBusiness() == null) ? 0 : getGoodAtBusiness().hashCode());
        result = prime * result + ((getTransactionNum() == null) ? 0 : getTransactionNum().hashCode());
        result = prime * result + ((getPageViews() == null) ? 0 : getPageViews().hashCode());
        result = prime * result + ((getIsHaveSubsidy() == null) ? 0 : getIsHaveSubsidy().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getApprovalDesc() == null) ? 0 : getApprovalDesc().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", advisorAccount=").append(advisorAccount);
        sb.append(", advisorName=").append(advisorName);
        sb.append(", businessArea=").append(businessArea);
        sb.append(", avatar=").append(avatar);
        sb.append(", position=").append(position);
        sb.append(", isCertification=").append(isCertification);
        sb.append(", phone=").append(phone);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", education=").append(education);
        sb.append(", graduatedSchool=").append(graduatedSchool);
        sb.append(", personalProfile=").append(personalProfile);
        sb.append(", workingYears=").append(workingYears);
        sb.append(", practiceQualification=").append(practiceQualification);
        sb.append(", goodAtBusiness=").append(goodAtBusiness);
        sb.append(", transactionNum=").append(transactionNum);
        sb.append(", pageViews=").append(pageViews);
        sb.append(", isHaveSubsidy=").append(isHaveSubsidy);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", approvalDesc=").append(approvalDesc);
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