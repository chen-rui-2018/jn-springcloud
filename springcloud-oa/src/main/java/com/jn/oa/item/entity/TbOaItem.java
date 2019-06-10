package com.jn.oa.item.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaItem implements Serializable {
    private String id;

    private String itemName;

    private String itemCode;

    private String responsibleId;

    private String itemStatus;

    private String approvalStatus;

    private String approvalAdvise;

    private Double totalPlanTime;

    private Double totalConsumeTime;

    private Double totalRemainTime;

    private Date planEndTime;

    private Date planStartTime;

    private String itemProgress;

    private Date startTime;

    private Date endTime;

    private String attachment;

    private String isExpire;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String itemContent;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(String responsibleId) {
        this.responsibleId = responsibleId == null ? null : responsibleId.trim();
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

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getItemProgress() {
        return itemProgress;
    }

    public void setItemProgress(String itemProgress) {
        this.itemProgress = itemProgress == null ? null : itemProgress.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(String isExpire) {
        this.isExpire = isExpire == null ? null : isExpire.trim();
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

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
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
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemCode() == null ? other.getItemCode() == null : this.getItemCode().equals(other.getItemCode()))
            && (this.getResponsibleId() == null ? other.getResponsibleId() == null : this.getResponsibleId().equals(other.getResponsibleId()))
            && (this.getItemStatus() == null ? other.getItemStatus() == null : this.getItemStatus().equals(other.getItemStatus()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getApprovalAdvise() == null ? other.getApprovalAdvise() == null : this.getApprovalAdvise().equals(other.getApprovalAdvise()))
            && (this.getTotalPlanTime() == null ? other.getTotalPlanTime() == null : this.getTotalPlanTime().equals(other.getTotalPlanTime()))
            && (this.getTotalConsumeTime() == null ? other.getTotalConsumeTime() == null : this.getTotalConsumeTime().equals(other.getTotalConsumeTime()))
            && (this.getTotalRemainTime() == null ? other.getTotalRemainTime() == null : this.getTotalRemainTime().equals(other.getTotalRemainTime()))
            && (this.getPlanEndTime() == null ? other.getPlanEndTime() == null : this.getPlanEndTime().equals(other.getPlanEndTime()))
            && (this.getPlanStartTime() == null ? other.getPlanStartTime() == null : this.getPlanStartTime().equals(other.getPlanStartTime()))
            && (this.getItemProgress() == null ? other.getItemProgress() == null : this.getItemProgress().equals(other.getItemProgress()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getAttachment() == null ? other.getAttachment() == null : this.getAttachment().equals(other.getAttachment()))
            && (this.getIsExpire() == null ? other.getIsExpire() == null : this.getIsExpire().equals(other.getIsExpire()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getItemContent() == null ? other.getItemContent() == null : this.getItemContent().equals(other.getItemContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemCode() == null) ? 0 : getItemCode().hashCode());
        result = prime * result + ((getResponsibleId() == null) ? 0 : getResponsibleId().hashCode());
        result = prime * result + ((getItemStatus() == null) ? 0 : getItemStatus().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getApprovalAdvise() == null) ? 0 : getApprovalAdvise().hashCode());
        result = prime * result + ((getTotalPlanTime() == null) ? 0 : getTotalPlanTime().hashCode());
        result = prime * result + ((getTotalConsumeTime() == null) ? 0 : getTotalConsumeTime().hashCode());
        result = prime * result + ((getTotalRemainTime() == null) ? 0 : getTotalRemainTime().hashCode());
        result = prime * result + ((getPlanEndTime() == null) ? 0 : getPlanEndTime().hashCode());
        result = prime * result + ((getPlanStartTime() == null) ? 0 : getPlanStartTime().hashCode());
        result = prime * result + ((getItemProgress() == null) ? 0 : getItemProgress().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getAttachment() == null) ? 0 : getAttachment().hashCode());
        result = prime * result + ((getIsExpire() == null) ? 0 : getIsExpire().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getItemContent() == null) ? 0 : getItemContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemName=").append(itemName);
        sb.append(", itemCode=").append(itemCode);
        sb.append(", responsibleId=").append(responsibleId);
        sb.append(", itemStatus=").append(itemStatus);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", approvalAdvise=").append(approvalAdvise);
        sb.append(", totalPlanTime=").append(totalPlanTime);
        sb.append(", totalConsumeTime=").append(totalConsumeTime);
        sb.append(", totalRemainTime=").append(totalRemainTime);
        sb.append(", planEndTime=").append(planEndTime);
        sb.append(", planStartTime=").append(planStartTime);
        sb.append(", itemProgress=").append(itemProgress);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", attachment=").append(attachment);
        sb.append(", isExpire=").append(isExpire);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", itemContent=").append(itemContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}