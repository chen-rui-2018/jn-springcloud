package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingSnapshotTargetGroup implements Serializable {
    /*@ApiModelProperty("序列")*/
    private String id;

    /*@ApiModelProperty("")*/
    private String taskBatch;

    /*@ApiModelProperty("指标ID")*/
    private String targetId;

    /*@ApiModelProperty("填写ID")*/
    private String formId;

    /*@ApiModelProperty("类型（0：文本框1：多行文本框2：数字3：单选框4：多选框5：图片上传）")*/
    private String formType;

    /*@ApiModelProperty("指标名称")*/
    private String formName;

    /*@ApiModelProperty("是否必填（0:否，1：是）")*/
    private Byte haveToWrite;

    /*@ApiModelProperty("填写框的顺序")*/
    private Integer order;

    /*@ApiModelProperty("选项值（以逗号隔开）")*/
    private String choiceOption;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch == null ? null : taskBatch.trim();
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType == null ? null : formType.trim();
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    public Byte getHaveToWrite() {
        return haveToWrite;
    }

    public void setHaveToWrite(Byte haveToWrite) {
        this.haveToWrite = haveToWrite;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getChoiceOption() {
        return choiceOption;
    }

    public void setChoiceOption(String choiceOption) {
        this.choiceOption = choiceOption == null ? null : choiceOption.trim();
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
        TbDataReportingSnapshotTargetGroup other = (TbDataReportingSnapshotTargetGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskBatch() == null ? other.getTaskBatch() == null : this.getTaskBatch().equals(other.getTaskBatch()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()))
            && (this.getFormType() == null ? other.getFormType() == null : this.getFormType().equals(other.getFormType()))
            && (this.getFormName() == null ? other.getFormName() == null : this.getFormName().equals(other.getFormName()))
            && (this.getHaveToWrite() == null ? other.getHaveToWrite() == null : this.getHaveToWrite().equals(other.getHaveToWrite()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
            && (this.getChoiceOption() == null ? other.getChoiceOption() == null : this.getChoiceOption().equals(other.getChoiceOption()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskBatch() == null) ? 0 : getTaskBatch().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        result = prime * result + ((getFormType() == null) ? 0 : getFormType().hashCode());
        result = prime * result + ((getFormName() == null) ? 0 : getFormName().hashCode());
        result = prime * result + ((getHaveToWrite() == null) ? 0 : getHaveToWrite().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        result = prime * result + ((getChoiceOption() == null) ? 0 : getChoiceOption().hashCode());
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
        sb.append(", taskBatch=").append(taskBatch);
        sb.append(", targetId=").append(targetId);
        sb.append(", formId=").append(formId);
        sb.append(", formType=").append(formType);
        sb.append(", formName=").append(formName);
        sb.append(", haveToWrite=").append(haveToWrite);
        sb.append(", order=").append(order);
        sb.append(", choiceOption=").append(choiceOption);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}