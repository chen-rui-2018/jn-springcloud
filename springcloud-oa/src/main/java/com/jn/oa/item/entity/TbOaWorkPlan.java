package com.jn.oa.item.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaWorkPlan implements Serializable {
    private String id;

    private String itemId;

    private String workPlanName;

    private String content;

    private String demandDescribe;

    private String isExpire;

    private Date planStartTime;

    private Date planEndTime;

    private Date startTime;

    private Date endTime;

    private Integer planTime;

    private Integer totalConsumeTime;

    private Integer totalRemainTime;

    private String workPlanStatus;

    private Byte recordStatus;

    private String attachment;

    private String creatorAccount;

    private String modifierAccount;

    private Date createdTime;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName == null ? null : workPlanName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDemandDescribe() {
        return demandDescribe;
    }

    public void setDemandDescribe(String demandDescribe) {
        this.demandDescribe = demandDescribe == null ? null : demandDescribe.trim();
    }

    public String getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(String isExpire) {
        this.isExpire = isExpire == null ? null : isExpire.trim();
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

    public Integer getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Integer planTime) {
        this.planTime = planTime;
    }

    public Integer getTotalConsumeTime() {
        return totalConsumeTime;
    }

    public void setTotalConsumeTime(Integer totalConsumeTime) {
        this.totalConsumeTime = totalConsumeTime;
    }

    public Integer getTotalRemainTime() {
        return totalRemainTime;
    }

    public void setTotalRemainTime(Integer totalRemainTime) {
        this.totalRemainTime = totalRemainTime;
    }

    public String getWorkPlanStatus() {
        return workPlanStatus;
    }

    public void setWorkPlanStatus(String workPlanStatus) {
        this.workPlanStatus = workPlanStatus == null ? null : workPlanStatus.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
        TbOaWorkPlan other = (TbOaWorkPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getWorkPlanName() == null ? other.getWorkPlanName() == null : this.getWorkPlanName().equals(other.getWorkPlanName()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getDemandDescribe() == null ? other.getDemandDescribe() == null : this.getDemandDescribe().equals(other.getDemandDescribe()))
            && (this.getIsExpire() == null ? other.getIsExpire() == null : this.getIsExpire().equals(other.getIsExpire()))
            && (this.getPlanStartTime() == null ? other.getPlanStartTime() == null : this.getPlanStartTime().equals(other.getPlanStartTime()))
            && (this.getPlanEndTime() == null ? other.getPlanEndTime() == null : this.getPlanEndTime().equals(other.getPlanEndTime()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getPlanTime() == null ? other.getPlanTime() == null : this.getPlanTime().equals(other.getPlanTime()))
            && (this.getTotalConsumeTime() == null ? other.getTotalConsumeTime() == null : this.getTotalConsumeTime().equals(other.getTotalConsumeTime()))
            && (this.getTotalRemainTime() == null ? other.getTotalRemainTime() == null : this.getTotalRemainTime().equals(other.getTotalRemainTime()))
            && (this.getWorkPlanStatus() == null ? other.getWorkPlanStatus() == null : this.getWorkPlanStatus().equals(other.getWorkPlanStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getAttachment() == null ? other.getAttachment() == null : this.getAttachment().equals(other.getAttachment()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getWorkPlanName() == null) ? 0 : getWorkPlanName().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getDemandDescribe() == null) ? 0 : getDemandDescribe().hashCode());
        result = prime * result + ((getIsExpire() == null) ? 0 : getIsExpire().hashCode());
        result = prime * result + ((getPlanStartTime() == null) ? 0 : getPlanStartTime().hashCode());
        result = prime * result + ((getPlanEndTime() == null) ? 0 : getPlanEndTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getPlanTime() == null) ? 0 : getPlanTime().hashCode());
        result = prime * result + ((getTotalConsumeTime() == null) ? 0 : getTotalConsumeTime().hashCode());
        result = prime * result + ((getTotalRemainTime() == null) ? 0 : getTotalRemainTime().hashCode());
        result = prime * result + ((getWorkPlanStatus() == null) ? 0 : getWorkPlanStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getAttachment() == null) ? 0 : getAttachment().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
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
        sb.append(", itemId=").append(itemId);
        sb.append(", workPlanName=").append(workPlanName);
        sb.append(", content=").append(content);
        sb.append(", demandDescribe=").append(demandDescribe);
        sb.append(", isExpire=").append(isExpire);
        sb.append(", planStartTime=").append(planStartTime);
        sb.append(", planEndTime=").append(planEndTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", planTime=").append(planTime);
        sb.append(", totalConsumeTime=").append(totalConsumeTime);
        sb.append(", totalRemainTime=").append(totalRemainTime);
        sb.append(", workPlanStatus=").append(workPlanStatus);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", attachment=").append(attachment);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}