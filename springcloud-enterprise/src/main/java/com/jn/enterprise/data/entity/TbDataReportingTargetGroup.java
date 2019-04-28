package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingTargetGroup implements Serializable {
    /*@ApiModelProperty("填写ID")*/
    private String formId;

    /*@ApiModelProperty("指标ID")*/
    private String targetId;

    /*@ApiModelProperty("类型（0：文本框1：多行文本框2：数字3：单选框4：多选框5：图片上传）")*/
    private String formType;

    /*@ApiModelProperty("指标名称")*/
    private String formName;

    /*@ApiModelProperty("是否必填（0:否，1：是）")*/
    private Byte required;

    /*@ApiModelProperty("填写框的顺序")*/
    private Integer orderNumber;

    /*@ApiModelProperty("选项值（以逗号隔开）")*/
    private String choiceOption;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
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

    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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
        TbDataReportingTargetGroup other = (TbDataReportingTargetGroup) that;
        return (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getFormType() == null ? other.getFormType() == null : this.getFormType().equals(other.getFormType()))
            && (this.getFormName() == null ? other.getFormName() == null : this.getFormName().equals(other.getFormName()))
            && (this.getRequired() == null ? other.getRequired() == null : this.getRequired().equals(other.getRequired()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getChoiceOption() == null ? other.getChoiceOption() == null : this.getChoiceOption().equals(other.getChoiceOption()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getFormType() == null) ? 0 : getFormType().hashCode());
        result = prime * result + ((getFormName() == null) ? 0 : getFormName().hashCode());
        result = prime * result + ((getRequired() == null) ? 0 : getRequired().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
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
        sb.append(", formId=").append(formId);
        sb.append(", targetId=").append(targetId);
        sb.append(", formType=").append(formType);
        sb.append(", formName=").append(formName);
        sb.append(", required=").append(required);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", choiceOption=").append(choiceOption);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}