package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingModelData implements Serializable {
    /*@ApiModelProperty("填报ID")*/
    private String fallInFormId;

    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("指标类型")*/
    private String targetId;

    /*@ApiModelProperty("模板ID")*/
    private String modelId;

    /*@ApiModelProperty("指标数据")*/
    private String data;

    /*@ApiModelProperty("填报格式")*/
    private String formId;

    /*@ApiModelProperty("表格ID")*/
    private String tabId;

    /*@ApiModelProperty("任务id")*/
    private String fillId;

    private static final long serialVersionUID = 1L;

    public String getFallInFormId() {
        return fallInFormId;
    }

    public void setFallInFormId(String fallInFormId) {
        this.fallInFormId = fallInFormId == null ? null : fallInFormId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
    }

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId == null ? null : fillId.trim();
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
        TbDataReportingModelData other = (TbDataReportingModelData) that;
        return (this.getFallInFormId() == null ? other.getFallInFormId() == null : this.getFallInFormId().equals(other.getFallInFormId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()))
            && (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()))
            && (this.getFillId() == null ? other.getFillId() == null : this.getFillId().equals(other.getFillId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFallInFormId() == null) ? 0 : getFallInFormId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        result = prime * result + ((getFillId() == null) ? 0 : getFillId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fallInFormId=").append(fallInFormId);
        sb.append(", id=").append(id);
        sb.append(", targetId=").append(targetId);
        sb.append(", modelId=").append(modelId);
        sb.append(", data=").append(data);
        sb.append(", formId=").append(formId);
        sb.append(", tabId=").append(tabId);
        sb.append(", fillId=").append(fillId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}