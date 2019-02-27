package com.jn.enterprise.servicemarket.comment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceRating implements Serializable {
    private String id;

    private String orgId;

    private String orgName;

    private String productId;

    private String productName;

    private String advisorAccount;

    private String advisorName;

    private String evaluatorAccount;

    private String attitudeScore;

    private String professionScore;

    private String responseScore;

    private String priceScore;

    private String evaluationDesc;

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

    public String getEvaluatorAccount() {
        return evaluatorAccount;
    }

    public void setEvaluatorAccount(String evaluatorAccount) {
        this.evaluatorAccount = evaluatorAccount == null ? null : evaluatorAccount.trim();
    }

    public String getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(String attitudeScore) {
        this.attitudeScore = attitudeScore == null ? null : attitudeScore.trim();
    }

    public String getProfessionScore() {
        return professionScore;
    }

    public void setProfessionScore(String professionScore) {
        this.professionScore = professionScore == null ? null : professionScore.trim();
    }

    public String getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(String responseScore) {
        this.responseScore = responseScore == null ? null : responseScore.trim();
    }

    public String getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(String priceScore) {
        this.priceScore = priceScore == null ? null : priceScore.trim();
    }

    public String getEvaluationDesc() {
        return evaluationDesc;
    }

    public void setEvaluationDesc(String evaluationDesc) {
        this.evaluationDesc = evaluationDesc == null ? null : evaluationDesc.trim();
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
        TbServiceRating other = (TbServiceRating) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getAdvisorAccount() == null ? other.getAdvisorAccount() == null : this.getAdvisorAccount().equals(other.getAdvisorAccount()))
            && (this.getAdvisorName() == null ? other.getAdvisorName() == null : this.getAdvisorName().equals(other.getAdvisorName()))
            && (this.getEvaluatorAccount() == null ? other.getEvaluatorAccount() == null : this.getEvaluatorAccount().equals(other.getEvaluatorAccount()))
            && (this.getAttitudeScore() == null ? other.getAttitudeScore() == null : this.getAttitudeScore().equals(other.getAttitudeScore()))
            && (this.getProfessionScore() == null ? other.getProfessionScore() == null : this.getProfessionScore().equals(other.getProfessionScore()))
            && (this.getResponseScore() == null ? other.getResponseScore() == null : this.getResponseScore().equals(other.getResponseScore()))
            && (this.getPriceScore() == null ? other.getPriceScore() == null : this.getPriceScore().equals(other.getPriceScore()))
            && (this.getEvaluationDesc() == null ? other.getEvaluationDesc() == null : this.getEvaluationDesc().equals(other.getEvaluationDesc()))
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
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getAdvisorAccount() == null) ? 0 : getAdvisorAccount().hashCode());
        result = prime * result + ((getAdvisorName() == null) ? 0 : getAdvisorName().hashCode());
        result = prime * result + ((getEvaluatorAccount() == null) ? 0 : getEvaluatorAccount().hashCode());
        result = prime * result + ((getAttitudeScore() == null) ? 0 : getAttitudeScore().hashCode());
        result = prime * result + ((getProfessionScore() == null) ? 0 : getProfessionScore().hashCode());
        result = prime * result + ((getResponseScore() == null) ? 0 : getResponseScore().hashCode());
        result = prime * result + ((getPriceScore() == null) ? 0 : getPriceScore().hashCode());
        result = prime * result + ((getEvaluationDesc() == null) ? 0 : getEvaluationDesc().hashCode());
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
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", advisorAccount=").append(advisorAccount);
        sb.append(", advisorName=").append(advisorName);
        sb.append(", evaluatorAccount=").append(evaluatorAccount);
        sb.append(", attitudeScore=").append(attitudeScore);
        sb.append(", professionScore=").append(professionScore);
        sb.append(", responseScore=").append(responseScore);
        sb.append(", priceScore=").append(priceScore);
        sb.append(", evaluationDesc=").append(evaluationDesc);
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