package com.jn.oa.item.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaItem implements Serializable {
    private String id;

    private String itemMark;

    private String itemName;

    private String responsibleAccount;

    private String itemContent;

    private String itemStatus;

    private String approvalStatus;

    private String approvalAdvise;

    private Date planStartTime;

    private Date planEndTime;

    private Double totalPlanTime;

    private Double totalConsumeTime;

    private Double totalRemainTime;

    private String itemProgress;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemMark() {
        return itemMark;
    }

    public void setItemMark(String itemMark) {
        this.itemMark = itemMark == null ? null : itemMark.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getResponsibleAccount() {
        return responsibleAccount;
    }

    public void setResponsibleAccount(String responsibleAccount) {
        this.responsibleAccount = responsibleAccount == null ? null : responsibleAccount.trim();
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus == null ? null : itemStatus.trim();
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
    }

    public String getApprovalAdvise() {
        return approvalAdvise;
    }

    public void setApprovalAdvise(String approvalAdvise) {
        this.approvalAdvise = approvalAdvise == null ? null : approvalAdvise.trim();
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Double getTotalPlanTime() {
        return totalPlanTime;
    }

    public void setTotalPlanTime(Double totalPlanTime) {
        this.totalPlanTime = totalPlanTime;
    }

    public Double getTotalConsumeTime() {
        return totalConsumeTime;
    }

    public void setTotalConsumeTime(Double totalConsumeTime) {
        this.totalConsumeTime = totalConsumeTime;
    }

    public Double getTotalRemainTime() {
        return totalRemainTime;
    }

    public void setTotalRemainTime(Double totalRemainTime) {
        this.totalRemainTime = totalRemainTime;
    }

    public String getItemProgress() {
        return itemProgress;
    }

    public void setItemProgress(String itemProgress) {
        this.itemProgress = itemProgress == null ? null : itemProgress.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        TbOaItem other = (TbOaItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemMark() == null ? other.getItemMark() == null : this.getItemMark().equals(other.getItemMark()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getResponsibleAccount() == null ? other.getResponsibleAccount() == null : this.getResponsibleAccount().equals(other.getResponsibleAccount()))
            && (this.getItemContent() == null ? other.getItemContent() == null : this.getItemContent().equals(other.getItemContent()))
            && (this.getItemStatus() == null ? other.getItemStatus() == null : this.getItemStatus().equals(other.getItemStatus()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getApprovalAdvise() == null ? other.getApprovalAdvise() == null : this.getApprovalAdvise().equals(other.getApprovalAdvise()))
            && (this.getPlanStartTime() == null ? other.getPlanStartTime() == null : this.getPlanStartTime().equals(other.getPlanStartTime()))
            && (this.getPlanEndTime() == null ? other.getPlanEndTime() == null : this.getPlanEndTime().equals(other.getPlanEndTime()))
            && (this.getTotalPlanTime() == null ? other.getTotalPlanTime() == null : this.getTotalPlanTime().equals(other.getTotalPlanTime()))
            && (this.getTotalConsumeTime() == null ? other.getTotalConsumeTime() == null : this.getTotalConsumeTime().equals(other.getTotalConsumeTime()))
            && (this.getTotalRemainTime() == null ? other.getTotalRemainTime() == null : this.getTotalRemainTime().equals(other.getTotalRemainTime()))
            && (this.getItemProgress() == null ? other.getItemProgress() == null : this.getItemProgress().equals(other.getItemProgress()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemMark() == null) ? 0 : getItemMark().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getResponsibleAccount() == null) ? 0 : getResponsibleAccount().hashCode());
        result = prime * result + ((getItemContent() == null) ? 0 : getItemContent().hashCode());
        result = prime * result + ((getItemStatus() == null) ? 0 : getItemStatus().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getApprovalAdvise() == null) ? 0 : getApprovalAdvise().hashCode());
        result = prime * result + ((getPlanStartTime() == null) ? 0 : getPlanStartTime().hashCode());
        result = prime * result + ((getPlanEndTime() == null) ? 0 : getPlanEndTime().hashCode());
        result = prime * result + ((getTotalPlanTime() == null) ? 0 : getTotalPlanTime().hashCode());
        result = prime * result + ((getTotalConsumeTime() == null) ? 0 : getTotalConsumeTime().hashCode());
        result = prime * result + ((getTotalRemainTime() == null) ? 0 : getTotalRemainTime().hashCode());
        result = prime * result + ((getItemProgress() == null) ? 0 : getItemProgress().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemMark=").append(itemMark);
        sb.append(", itemName=").append(itemName);
        sb.append(", responsibleAccount=").append(responsibleAccount);
        sb.append(", itemContent=").append(itemContent);
        sb.append(", itemStatus=").append(itemStatus);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", approvalAdvise=").append(approvalAdvise);
        sb.append(", planStartTime=").append(planStartTime);
        sb.append(", planEndTime=").append(planEndTime);
        sb.append(", totalPlanTime=").append(totalPlanTime);
        sb.append(", totalConsumeTime=").append(totalConsumeTime);
        sb.append(", totalRemainTime=").append(totalRemainTime);
        sb.append(", itemProgress=").append(itemProgress);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}