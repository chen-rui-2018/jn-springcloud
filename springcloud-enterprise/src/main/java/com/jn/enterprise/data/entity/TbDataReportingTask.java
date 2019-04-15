package com.jn.enterprise.data.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDataReportingTask implements Serializable {
    /*@ApiModelProperty("园区工单ID/企业填报ID")*/
    private String fillId;

    /*@ApiModelProperty("序列")*/
    private String id;

    /*@ApiModelProperty("填报类型（1：企业；2：园区）")*/
    private Byte fileType;

    /*@ApiModelProperty("模板ID")*/
    private String modelId;

    /*@ApiModelProperty("填报对象名称；是园区时，存储部门ID;企业时填写企业ID")*/
    private String fillInFormId;

    /*@ApiModelProperty("填报对象名称；如果是企业：则为企业名称，是园区时，则是那个部门")*/
    private String fillInFormName;

    /*@ApiModelProperty("账期（月YYYYMM，年YYYY）")*/
    private String formTime;

    /*@ApiModelProperty("填报截至时间")*/
    private String fillInFormDeadline;

    /*@ApiModelProperty("表填报列类型（0：累计值；1：本期值）")*/
    private Byte tabClumnType;

    /*@ApiModelProperty("状态（企业状态0：已上报；1未上报；2：逾期上报；")*/
    private Byte status;

    /*@ApiModelProperty("0：已审核；1：未审核；2审核不通过")*/
    private Byte gardenExamineStauts;

    /*@ApiModelProperty("表生成模式（0:普通模板,1：科技园模板）")*/
    private Byte tabCreateType;

    /*@ApiModelProperty("最后催报时间")*/
    private Date callingTime;

    /*@ApiModelProperty("催报次数")*/
    private Integer callingTimes;

    /*@ApiModelProperty("填报人")*/
    private String filler;

    /*@ApiModelProperty("上报时间")*/
    private Date upTime;

    /*@ApiModelProperty("填报人电话")*/
    private String fillerTel;

    /*@ApiModelProperty("是否逾期（1：是；0：否）")*/
    private Byte isOverdue;

    /*@ApiModelProperty("逾期天数")*/
    private Integer overdueDays;

    /*@ApiModelProperty("审批意见")*/
    private String examineComment;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("")*/
    private String taskBatch;

    /*@ApiModelProperty("更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("更新人")*/
    private String modifiedAccount;

    private static final long serialVersionUID = 1L;

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId == null ? null : fillId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getFileType() {
        return fileType;
    }

    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getFillInFormId() {
        return fillInFormId;
    }

    public void setFillInFormId(String fillInFormId) {
        this.fillInFormId = fillInFormId == null ? null : fillInFormId.trim();
    }

    public String getFillInFormName() {
        return fillInFormName;
    }

    public void setFillInFormName(String fillInFormName) {
        this.fillInFormName = fillInFormName == null ? null : fillInFormName.trim();
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime == null ? null : formTime.trim();
    }

    public String getFillInFormDeadline() {
        return fillInFormDeadline;
    }

    public void setFillInFormDeadline(String fillInFormDeadline) {
        this.fillInFormDeadline = fillInFormDeadline == null ? null : fillInFormDeadline.trim();
    }

    public Byte getTabClumnType() {
        return tabClumnType;
    }

    public void setTabClumnType(Byte tabClumnType) {
        this.tabClumnType = tabClumnType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getGardenExamineStauts() {
        return gardenExamineStauts;
    }

    public void setGardenExamineStauts(Byte gardenExamineStauts) {
        this.gardenExamineStauts = gardenExamineStauts;
    }

    public Byte getTabCreateType() {
        return tabCreateType;
    }

    public void setTabCreateType(Byte tabCreateType) {
        this.tabCreateType = tabCreateType;
    }

    public Date getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(Date callingTime) {
        this.callingTime = callingTime;
    }

    public Integer getCallingTimes() {
        return callingTimes;
    }

    public void setCallingTimes(Integer callingTimes) {
        this.callingTimes = callingTimes;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getFillerTel() {
        return fillerTel;
    }

    public void setFillerTel(String fillerTel) {
        this.fillerTel = fillerTel == null ? null : fillerTel.trim();
    }

    public Byte getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Byte isOverdue) {
        this.isOverdue = isOverdue;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getExamineComment() {
        return examineComment;
    }

    public void setExamineComment(String examineComment) {
        this.examineComment = examineComment == null ? null : examineComment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch == null ? null : taskBatch.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedAccount() {
        return modifiedAccount;
    }

    public void setModifiedAccount(String modifiedAccount) {
        this.modifiedAccount = modifiedAccount == null ? null : modifiedAccount.trim();
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
        TbDataReportingTask other = (TbDataReportingTask) that;
        return (this.getFillId() == null ? other.getFillId() == null : this.getFillId().equals(other.getFillId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getFillInFormId() == null ? other.getFillInFormId() == null : this.getFillInFormId().equals(other.getFillInFormId()))
            && (this.getFillInFormName() == null ? other.getFillInFormName() == null : this.getFillInFormName().equals(other.getFillInFormName()))
            && (this.getFormTime() == null ? other.getFormTime() == null : this.getFormTime().equals(other.getFormTime()))
            && (this.getFillInFormDeadline() == null ? other.getFillInFormDeadline() == null : this.getFillInFormDeadline().equals(other.getFillInFormDeadline()))
            && (this.getTabClumnType() == null ? other.getTabClumnType() == null : this.getTabClumnType().equals(other.getTabClumnType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getGardenExamineStauts() == null ? other.getGardenExamineStauts() == null : this.getGardenExamineStauts().equals(other.getGardenExamineStauts()))
            && (this.getTabCreateType() == null ? other.getTabCreateType() == null : this.getTabCreateType().equals(other.getTabCreateType()))
            && (this.getCallingTime() == null ? other.getCallingTime() == null : this.getCallingTime().equals(other.getCallingTime()))
            && (this.getCallingTimes() == null ? other.getCallingTimes() == null : this.getCallingTimes().equals(other.getCallingTimes()))
            && (this.getFiller() == null ? other.getFiller() == null : this.getFiller().equals(other.getFiller()))
            && (this.getUpTime() == null ? other.getUpTime() == null : this.getUpTime().equals(other.getUpTime()))
            && (this.getFillerTel() == null ? other.getFillerTel() == null : this.getFillerTel().equals(other.getFillerTel()))
            && (this.getIsOverdue() == null ? other.getIsOverdue() == null : this.getIsOverdue().equals(other.getIsOverdue()))
            && (this.getOverdueDays() == null ? other.getOverdueDays() == null : this.getOverdueDays().equals(other.getOverdueDays()))
            && (this.getExamineComment() == null ? other.getExamineComment() == null : this.getExamineComment().equals(other.getExamineComment()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getTaskBatch() == null ? other.getTaskBatch() == null : this.getTaskBatch().equals(other.getTaskBatch()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifiedAccount() == null ? other.getModifiedAccount() == null : this.getModifiedAccount().equals(other.getModifiedAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFillId() == null) ? 0 : getFillId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getFillInFormId() == null) ? 0 : getFillInFormId().hashCode());
        result = prime * result + ((getFillInFormName() == null) ? 0 : getFillInFormName().hashCode());
        result = prime * result + ((getFormTime() == null) ? 0 : getFormTime().hashCode());
        result = prime * result + ((getFillInFormDeadline() == null) ? 0 : getFillInFormDeadline().hashCode());
        result = prime * result + ((getTabClumnType() == null) ? 0 : getTabClumnType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGardenExamineStauts() == null) ? 0 : getGardenExamineStauts().hashCode());
        result = prime * result + ((getTabCreateType() == null) ? 0 : getTabCreateType().hashCode());
        result = prime * result + ((getCallingTime() == null) ? 0 : getCallingTime().hashCode());
        result = prime * result + ((getCallingTimes() == null) ? 0 : getCallingTimes().hashCode());
        result = prime * result + ((getFiller() == null) ? 0 : getFiller().hashCode());
        result = prime * result + ((getUpTime() == null) ? 0 : getUpTime().hashCode());
        result = prime * result + ((getFillerTel() == null) ? 0 : getFillerTel().hashCode());
        result = prime * result + ((getIsOverdue() == null) ? 0 : getIsOverdue().hashCode());
        result = prime * result + ((getOverdueDays() == null) ? 0 : getOverdueDays().hashCode());
        result = prime * result + ((getExamineComment() == null) ? 0 : getExamineComment().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getTaskBatch() == null) ? 0 : getTaskBatch().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifiedAccount() == null) ? 0 : getModifiedAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fillId=").append(fillId);
        sb.append(", id=").append(id);
        sb.append(", fileType=").append(fileType);
        sb.append(", modelId=").append(modelId);
        sb.append(", fillInFormId=").append(fillInFormId);
        sb.append(", fillInFormName=").append(fillInFormName);
        sb.append(", formTime=").append(formTime);
        sb.append(", fillInFormDeadline=").append(fillInFormDeadline);
        sb.append(", tabClumnType=").append(tabClumnType);
        sb.append(", status=").append(status);
        sb.append(", gardenExamineStauts=").append(gardenExamineStauts);
        sb.append(", tabCreateType=").append(tabCreateType);
        sb.append(", callingTime=").append(callingTime);
        sb.append(", callingTimes=").append(callingTimes);
        sb.append(", filler=").append(filler);
        sb.append(", upTime=").append(upTime);
        sb.append(", fillerTel=").append(fillerTel);
        sb.append(", isOverdue=").append(isOverdue);
        sb.append(", overdueDays=").append(overdueDays);
        sb.append(", examineComment=").append(examineComment);
        sb.append(", createTime=").append(createTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", taskBatch=").append(taskBatch);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifiedAccount=").append(modifiedAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}