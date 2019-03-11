package com.jn.enterprise.servicemarket.require.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceRequire implements Serializable {
    private String id;

    private String reqNum;

    private String businessId;

    private String businessArea;

    private String productId;

    private String productName;

    private String orgId;

    private String orgName;

    private String advisorAccount;

    private String advisorName;

    private String orgTelephone;

    private String orgEmail;

    private String reqDetail;

    private String reqName;

    private String reqPost;

    private String reqPhone;

    private String reqEmail;

    private Date issueTime;

    private String issueAccount;

    private String contractAmount;

    private String financingAmount;

    private String actualLoanAmount;

    private String financingPeriod;

    private String fundsReqDesc;

    private Date expectedDate;

    private String status;

    private Date handleTime;

    private String handleResult;

    private String resultDetail;

    private String isComment;

    private String contractHomePage;

    private String contractEndPage;

    private Date commentTime;

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

    public String getReqNum() {
        return reqNum;
    }

    public void setReqNum(String reqNum) {
        this.reqNum = reqNum == null ? null : reqNum.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea == null ? null : businessArea.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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

    public String getOrgTelephone() {
        return orgTelephone;
    }

    public void setOrgTelephone(String orgTelephone) {
        this.orgTelephone = orgTelephone == null ? null : orgTelephone.trim();
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail == null ? null : orgEmail.trim();
    }

    public String getReqDetail() {
        return reqDetail;
    }

    public void setReqDetail(String reqDetail) {
        this.reqDetail = reqDetail == null ? null : reqDetail.trim();
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName == null ? null : reqName.trim();
    }

    public String getReqPost() {
        return reqPost;
    }

    public void setReqPost(String reqPost) {
        this.reqPost = reqPost == null ? null : reqPost.trim();
    }

    public String getReqPhone() {
        return reqPhone;
    }

    public void setReqPhone(String reqPhone) {
        this.reqPhone = reqPhone == null ? null : reqPhone.trim();
    }

    public String getReqEmail() {
        return reqEmail;
    }

    public void setReqEmail(String reqEmail) {
        this.reqEmail = reqEmail == null ? null : reqEmail.trim();
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(String issueAccount) {
        this.issueAccount = issueAccount == null ? null : issueAccount.trim();
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount == null ? null : contractAmount.trim();
    }

    public String getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(String financingAmount) {
        this.financingAmount = financingAmount == null ? null : financingAmount.trim();
    }

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount == null ? null : actualLoanAmount.trim();
    }

    public String getFinancingPeriod() {
        return financingPeriod;
    }

    public void setFinancingPeriod(String financingPeriod) {
        this.financingPeriod = financingPeriod == null ? null : financingPeriod.trim();
    }

    public String getFundsReqDesc() {
        return fundsReqDesc;
    }

    public void setFundsReqDesc(String fundsReqDesc) {
        this.fundsReqDesc = fundsReqDesc == null ? null : fundsReqDesc.trim();
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult == null ? null : handleResult.trim();
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail == null ? null : resultDetail.trim();
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment == null ? null : isComment.trim();
    }

    public String getContractHomePage() {
        return contractHomePage;
    }

    public void setContractHomePage(String contractHomePage) {
        this.contractHomePage = contractHomePage == null ? null : contractHomePage.trim();
    }

    public String getContractEndPage() {
        return contractEndPage;
    }

    public void setContractEndPage(String contractEndPage) {
        this.contractEndPage = contractEndPage == null ? null : contractEndPage.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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
        TbServiceRequire other = (TbServiceRequire) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReqNum() == null ? other.getReqNum() == null : this.getReqNum().equals(other.getReqNum()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getBusinessArea() == null ? other.getBusinessArea() == null : this.getBusinessArea().equals(other.getBusinessArea()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getAdvisorAccount() == null ? other.getAdvisorAccount() == null : this.getAdvisorAccount().equals(other.getAdvisorAccount()))
            && (this.getAdvisorName() == null ? other.getAdvisorName() == null : this.getAdvisorName().equals(other.getAdvisorName()))
            && (this.getOrgTelephone() == null ? other.getOrgTelephone() == null : this.getOrgTelephone().equals(other.getOrgTelephone()))
            && (this.getOrgEmail() == null ? other.getOrgEmail() == null : this.getOrgEmail().equals(other.getOrgEmail()))
            && (this.getReqDetail() == null ? other.getReqDetail() == null : this.getReqDetail().equals(other.getReqDetail()))
            && (this.getReqName() == null ? other.getReqName() == null : this.getReqName().equals(other.getReqName()))
            && (this.getReqPost() == null ? other.getReqPost() == null : this.getReqPost().equals(other.getReqPost()))
            && (this.getReqPhone() == null ? other.getReqPhone() == null : this.getReqPhone().equals(other.getReqPhone()))
            && (this.getReqEmail() == null ? other.getReqEmail() == null : this.getReqEmail().equals(other.getReqEmail()))
            && (this.getIssueTime() == null ? other.getIssueTime() == null : this.getIssueTime().equals(other.getIssueTime()))
            && (this.getIssueAccount() == null ? other.getIssueAccount() == null : this.getIssueAccount().equals(other.getIssueAccount()))
            && (this.getContractAmount() == null ? other.getContractAmount() == null : this.getContractAmount().equals(other.getContractAmount()))
            && (this.getFinancingAmount() == null ? other.getFinancingAmount() == null : this.getFinancingAmount().equals(other.getFinancingAmount()))
            && (this.getActualLoanAmount() == null ? other.getActualLoanAmount() == null : this.getActualLoanAmount().equals(other.getActualLoanAmount()))
            && (this.getFinancingPeriod() == null ? other.getFinancingPeriod() == null : this.getFinancingPeriod().equals(other.getFinancingPeriod()))
            && (this.getFundsReqDesc() == null ? other.getFundsReqDesc() == null : this.getFundsReqDesc().equals(other.getFundsReqDesc()))
            && (this.getExpectedDate() == null ? other.getExpectedDate() == null : this.getExpectedDate().equals(other.getExpectedDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHandleTime() == null ? other.getHandleTime() == null : this.getHandleTime().equals(other.getHandleTime()))
            && (this.getHandleResult() == null ? other.getHandleResult() == null : this.getHandleResult().equals(other.getHandleResult()))
            && (this.getResultDetail() == null ? other.getResultDetail() == null : this.getResultDetail().equals(other.getResultDetail()))
            && (this.getIsComment() == null ? other.getIsComment() == null : this.getIsComment().equals(other.getIsComment()))
            && (this.getContractHomePage() == null ? other.getContractHomePage() == null : this.getContractHomePage().equals(other.getContractHomePage()))
            && (this.getContractEndPage() == null ? other.getContractEndPage() == null : this.getContractEndPage().equals(other.getContractEndPage()))
            && (this.getCommentTime() == null ? other.getCommentTime() == null : this.getCommentTime().equals(other.getCommentTime()))
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
        result = prime * result + ((getReqNum() == null) ? 0 : getReqNum().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getBusinessArea() == null) ? 0 : getBusinessArea().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getAdvisorAccount() == null) ? 0 : getAdvisorAccount().hashCode());
        result = prime * result + ((getAdvisorName() == null) ? 0 : getAdvisorName().hashCode());
        result = prime * result + ((getOrgTelephone() == null) ? 0 : getOrgTelephone().hashCode());
        result = prime * result + ((getOrgEmail() == null) ? 0 : getOrgEmail().hashCode());
        result = prime * result + ((getReqDetail() == null) ? 0 : getReqDetail().hashCode());
        result = prime * result + ((getReqName() == null) ? 0 : getReqName().hashCode());
        result = prime * result + ((getReqPost() == null) ? 0 : getReqPost().hashCode());
        result = prime * result + ((getReqPhone() == null) ? 0 : getReqPhone().hashCode());
        result = prime * result + ((getReqEmail() == null) ? 0 : getReqEmail().hashCode());
        result = prime * result + ((getIssueTime() == null) ? 0 : getIssueTime().hashCode());
        result = prime * result + ((getIssueAccount() == null) ? 0 : getIssueAccount().hashCode());
        result = prime * result + ((getContractAmount() == null) ? 0 : getContractAmount().hashCode());
        result = prime * result + ((getFinancingAmount() == null) ? 0 : getFinancingAmount().hashCode());
        result = prime * result + ((getActualLoanAmount() == null) ? 0 : getActualLoanAmount().hashCode());
        result = prime * result + ((getFinancingPeriod() == null) ? 0 : getFinancingPeriod().hashCode());
        result = prime * result + ((getFundsReqDesc() == null) ? 0 : getFundsReqDesc().hashCode());
        result = prime * result + ((getExpectedDate() == null) ? 0 : getExpectedDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHandleTime() == null) ? 0 : getHandleTime().hashCode());
        result = prime * result + ((getHandleResult() == null) ? 0 : getHandleResult().hashCode());
        result = prime * result + ((getResultDetail() == null) ? 0 : getResultDetail().hashCode());
        result = prime * result + ((getIsComment() == null) ? 0 : getIsComment().hashCode());
        result = prime * result + ((getContractHomePage() == null) ? 0 : getContractHomePage().hashCode());
        result = prime * result + ((getContractEndPage() == null) ? 0 : getContractEndPage().hashCode());
        result = prime * result + ((getCommentTime() == null) ? 0 : getCommentTime().hashCode());
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
        sb.append(", reqNum=").append(reqNum);
        sb.append(", businessId=").append(businessId);
        sb.append(", businessArea=").append(businessArea);
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgName=").append(orgName);
        sb.append(", advisorAccount=").append(advisorAccount);
        sb.append(", advisorName=").append(advisorName);
        sb.append(", orgTelephone=").append(orgTelephone);
        sb.append(", orgEmail=").append(orgEmail);
        sb.append(", reqDetail=").append(reqDetail);
        sb.append(", reqName=").append(reqName);
        sb.append(", reqPost=").append(reqPost);
        sb.append(", reqPhone=").append(reqPhone);
        sb.append(", reqEmail=").append(reqEmail);
        sb.append(", issueTime=").append(issueTime);
        sb.append(", issueAccount=").append(issueAccount);
        sb.append(", contractAmount=").append(contractAmount);
        sb.append(", financingAmount=").append(financingAmount);
        sb.append(", actualLoanAmount=").append(actualLoanAmount);
        sb.append(", financingPeriod=").append(financingPeriod);
        sb.append(", fundsReqDesc=").append(fundsReqDesc);
        sb.append(", expectedDate=").append(expectedDate);
        sb.append(", status=").append(status);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", handleResult=").append(handleResult);
        sb.append(", resultDetail=").append(resultDetail);
        sb.append(", isComment=").append(isComment);
        sb.append(", contractHomePage=").append(contractHomePage);
        sb.append(", contractEndPage=").append(contractEndPage);
        sb.append(", commentTime=").append(commentTime);
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