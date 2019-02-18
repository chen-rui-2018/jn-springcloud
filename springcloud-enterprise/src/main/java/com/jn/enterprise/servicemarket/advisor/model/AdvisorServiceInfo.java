package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/2/13 11:01
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorInquiryInfo",description = "服务顾问信息")
public class AdvisorServiceInfo extends Page implements Serializable {
    @ApiModelProperty(value = "机构ID")
    private String orgId;
    @ApiModelProperty(value = "顾问账号")
    private String advisorAccount;
    @ApiModelProperty(value = "顾问姓名")
    private String advisorName;
    @ApiModelProperty(value = "业务领域")
    private String businessArea;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "所属机构名称")
    private String orgName;
    @ApiModelProperty(value = "是否认证")
    private String isCertification;
    @ApiModelProperty(value = "联系邮箱")
    private String contactEmail;
    @ApiModelProperty(value = "证件类型")
    private String cardType;
    @ApiModelProperty(value = "证件号码")
    private String cardNumber;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "毕业院校")
    private String graduatedSchool;
    @ApiModelProperty(value = "评价分数")
    private String evalluationLevel;
    @ApiModelProperty(value = "评价次数")
    private Integer evaluationNum;
    @ApiModelProperty(value = "从业年限")
    private Float workingYears;
    @ApiModelProperty(value = "执业资质")
    private String practiceQualification;
    @ApiModelProperty(value = "业务擅长")
    private String goodAtBusiness;
    @ApiModelProperty(value = "累计交易数")
    private Integer transactionNum;
    @ApiModelProperty(value = "浏览量")
    private Integer pageviews;
    @ApiModelProperty(value = "是否有补贴")
    private String isHaveSubsidy;
    @ApiModelProperty(value = "审核状态")
    private String approvalStatus;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "记录状态")
    private Byte recordStatus;
    @ApiModelProperty(value = "个人简介")
    private byte[] personalProfile;

    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getEvalluationLevel() {
        return evalluationLevel;
    }

    public void setEvalluationLevel(String evalluationLevel) {
        this.evalluationLevel = evalluationLevel;
    }

    public Integer getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(Integer evaluationNum) {
        this.evaluationNum = evaluationNum;
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
        this.practiceQualification = practiceQualification;
    }

    public String getGoodAtBusiness() {
        return goodAtBusiness;
    }

    public void setGoodAtBusiness(String goodAtBusiness) {
        this.goodAtBusiness = goodAtBusiness;
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
        this.isHaveSubsidy = isHaveSubsidy;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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
        this.creatorAccount = creatorAccount;
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
        this.modifierAccount = modifierAccount;
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
    public String toString() {
        return "AdvisorServiceInfo{" +
                "orgId='" + orgId + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", businessArea='" + businessArea + '\'' +
                ", avatar='" + avatar + '\'' +
                ", position='" + position + '\'' +
                ", orgName='" + orgName + '\'' +
                ", isCertification='" + isCertification + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", education='" + education + '\'' +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", evalluationLevel='" + evalluationLevel + '\'' +
                ", evaluationNum=" + evaluationNum +
                ", workingYears=" + workingYears +
                ", practiceQualification='" + practiceQualification + '\'' +
                ", goodAtBusiness='" + goodAtBusiness + '\'' +
                ", transactionNum=" + transactionNum +
                ", pageviews=" + pageviews +
                ", isHaveSubsidy='" + isHaveSubsidy + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", createdTime=" + createdTime +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                ", personalProfile=" + Arrays.toString(personalProfile) +
                '}';
    }
}
