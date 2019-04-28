package com.jn.enterprise.data.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDataReportingSnapshotModel implements Serializable {
    /*@ApiModelProperty("任务批次")*/
    private String taskBatch;

    /*@ApiModelProperty("快照表模板ID")*/
    private String modelId;

    /*@ApiModelProperty("模板名称")*/
    private String modelName;

    /*@ApiModelProperty("填报类型（0：企业，1：园管委会）")*/
    private Byte modelType;

    /*@ApiModelProperty("填报群组，填报对象")*/
    private String modelFormTargetId;

    /*@ApiModelProperty("填报周期（1：年，0：月）")*/
    private String modelCycle;

    /*@ApiModelProperty("提前预警天数")*/
    private String warningBeforeDays;

    /*@ApiModelProperty("预警方式：（0:短信1:邮件2:app）多选，值以逗号隔开")*/
    private String warningBy;

    /*@ApiModelProperty("PC广告图地址")*/
    private String pcAd;

    /*@ApiModelProperty("app广告图地址")*/
    private String appAd;

    /*@ApiModelProperty("状态（0：发布1：暂停2：失效）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("描述")*/
    private String comment;

    /*@ApiModelProperty("群组ID")*/
    private String groupId;

    /*@ApiModelProperty("附件")*/
    private String otherData;

    /*@ApiModelProperty("年报表：任务生成日期（YYYYMMDD）
	月报表：是一个01-31之间的数字")*/
    private String taskCreateTime;

    /*@ApiModelProperty("年报表：截止日期（YYYYMMDD）
	月报表：当月/下月+01-31之间的数字")*/
    private String filllInFormDeadline;

    /*@ApiModelProperty("部门ID")*/
    private String departmentId;

    /*@ApiModelProperty("部门名称")*/
    private String departmentName;

    /*@ApiModelProperty("模板序号")*/
    private Integer orderNumber;

    /*@ApiModelProperty("任务全部填写完后的提醒人")*/
    private String reminder;

    /*@ApiModelProperty("是否已经提醒，填报完成")*/
    private String remindStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch == null ? null : taskBatch.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Byte getModelType() {
        return modelType;
    }

    public void setModelType(Byte modelType) {
        this.modelType = modelType;
    }

    public String getModelFormTargetId() {
        return modelFormTargetId;
    }

    public void setModelFormTargetId(String modelFormTargetId) {
        this.modelFormTargetId = modelFormTargetId == null ? null : modelFormTargetId.trim();
    }

    public String getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(String modelCycle) {
        this.modelCycle = modelCycle == null ? null : modelCycle.trim();
    }

    public String getWarningBeforeDays() {
        return warningBeforeDays;
    }

    public void setWarningBeforeDays(String warningBeforeDays) {
        this.warningBeforeDays = warningBeforeDays == null ? null : warningBeforeDays.trim();
    }

    public String getWarningBy() {
        return warningBy;
    }

    public void setWarningBy(String warningBy) {
        this.warningBy = warningBy == null ? null : warningBy.trim();
    }

    public String getPcAd() {
        return pcAd;
    }

    public void setPcAd(String pcAd) {
        this.pcAd = pcAd == null ? null : pcAd.trim();
    }

    public String getAppAd() {
        return appAd;
    }

    public void setAppAd(String appAd) {
        this.appAd = appAd == null ? null : appAd.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData == null ? null : otherData.trim();
    }

    public String getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(String taskCreateTime) {
        this.taskCreateTime = taskCreateTime == null ? null : taskCreateTime.trim();
    }

    public String getFilllInFormDeadline() {
        return filllInFormDeadline;
    }

    public void setFilllInFormDeadline(String filllInFormDeadline) {
        this.filllInFormDeadline = filllInFormDeadline == null ? null : filllInFormDeadline.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder == null ? null : reminder.trim();
    }

    public String getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus == null ? null : remindStatus.trim();
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
        TbDataReportingSnapshotModel other = (TbDataReportingSnapshotModel) that;
        return (this.getTaskBatch() == null ? other.getTaskBatch() == null : this.getTaskBatch().equals(other.getTaskBatch()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelType() == null ? other.getModelType() == null : this.getModelType().equals(other.getModelType()))
            && (this.getModelFormTargetId() == null ? other.getModelFormTargetId() == null : this.getModelFormTargetId().equals(other.getModelFormTargetId()))
            && (this.getModelCycle() == null ? other.getModelCycle() == null : this.getModelCycle().equals(other.getModelCycle()))
            && (this.getWarningBeforeDays() == null ? other.getWarningBeforeDays() == null : this.getWarningBeforeDays().equals(other.getWarningBeforeDays()))
            && (this.getWarningBy() == null ? other.getWarningBy() == null : this.getWarningBy().equals(other.getWarningBy()))
            && (this.getPcAd() == null ? other.getPcAd() == null : this.getPcAd().equals(other.getPcAd()))
            && (this.getAppAd() == null ? other.getAppAd() == null : this.getAppAd().equals(other.getAppAd()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getOtherData() == null ? other.getOtherData() == null : this.getOtherData().equals(other.getOtherData()))
            && (this.getTaskCreateTime() == null ? other.getTaskCreateTime() == null : this.getTaskCreateTime().equals(other.getTaskCreateTime()))
            && (this.getFilllInFormDeadline() == null ? other.getFilllInFormDeadline() == null : this.getFilllInFormDeadline().equals(other.getFilllInFormDeadline()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getReminder() == null ? other.getReminder() == null : this.getReminder().equals(other.getReminder()))
            && (this.getRemindStatus() == null ? other.getRemindStatus() == null : this.getRemindStatus().equals(other.getRemindStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskBatch() == null) ? 0 : getTaskBatch().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
        result = prime * result + ((getModelFormTargetId() == null) ? 0 : getModelFormTargetId().hashCode());
        result = prime * result + ((getModelCycle() == null) ? 0 : getModelCycle().hashCode());
        result = prime * result + ((getWarningBeforeDays() == null) ? 0 : getWarningBeforeDays().hashCode());
        result = prime * result + ((getWarningBy() == null) ? 0 : getWarningBy().hashCode());
        result = prime * result + ((getPcAd() == null) ? 0 : getPcAd().hashCode());
        result = prime * result + ((getAppAd() == null) ? 0 : getAppAd().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getOtherData() == null) ? 0 : getOtherData().hashCode());
        result = prime * result + ((getTaskCreateTime() == null) ? 0 : getTaskCreateTime().hashCode());
        result = prime * result + ((getFilllInFormDeadline() == null) ? 0 : getFilllInFormDeadline().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getReminder() == null) ? 0 : getReminder().hashCode());
        result = prime * result + ((getRemindStatus() == null) ? 0 : getRemindStatus().hashCode());
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
        sb.append(", taskBatch=").append(taskBatch);
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", modelType=").append(modelType);
        sb.append(", modelFormTargetId=").append(modelFormTargetId);
        sb.append(", modelCycle=").append(modelCycle);
        sb.append(", warningBeforeDays=").append(warningBeforeDays);
        sb.append(", warningBy=").append(warningBy);
        sb.append(", pcAd=").append(pcAd);
        sb.append(", appAd=").append(appAd);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", comment=").append(comment);
        sb.append(", groupId=").append(groupId);
        sb.append(", otherData=").append(otherData);
        sb.append(", taskCreateTime=").append(taskCreateTime);
        sb.append(", filllInFormDeadline=").append(filllInFormDeadline);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", reminder=").append(reminder);
        sb.append(", remindStatus=").append(remindStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}