package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingTaskData implements Serializable {
    /*@ApiModelProperty("填报ID")*/
    private String fallInFormId;

    /*@ApiModelProperty("快照指标ID")*/
    private String targetId;

    /*@ApiModelProperty("快照表模板ID")*/
    private String modelId;

    /*@ApiModelProperty("指标数据")*/
    private String data;

    /*@ApiModelProperty("快照表填报格式")*/
    private String formId;

    /*@ApiModelProperty("任务id")*/
    private String fillId;

    /*@ApiModelProperty("快照表表格ID")*/
    private String tabId;

    /*@ApiModelProperty("行号")*/
    private Integer rowNum;

    private static final long serialVersionUID = 1L;

    public String getFallInFormId() {
        return fallInFormId;
    }

    public void setFallInFormId(String fallInFormId) {
        this.fallInFormId = fallInFormId == null ? null : fallInFormId.trim();
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

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId == null ? null : fillId.trim();
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
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
        TbDataReportingTaskData other = (TbDataReportingTaskData) that;
        return (this.getFallInFormId() == null ? other.getFallInFormId() == null : this.getFallInFormId().equals(other.getFallInFormId()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()))
            && (this.getFillId() == null ? other.getFillId() == null : this.getFillId().equals(other.getFillId()))
            && (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()))
            && (this.getRowNum() == null ? other.getRowNum() == null : this.getRowNum().equals(other.getRowNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFallInFormId() == null) ? 0 : getFallInFormId().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        result = prime * result + ((getFillId() == null) ? 0 : getFillId().hashCode());
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        result = prime * result + ((getRowNum() == null) ? 0 : getRowNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fallInFormId=").append(fallInFormId);
        sb.append(", targetId=").append(targetId);
        sb.append(", modelId=").append(modelId);
        sb.append(", data=").append(data);
        sb.append(", formId=").append(formId);
        sb.append(", fillId=").append(fillId);
        sb.append(", tabId=").append(tabId);
        sb.append(", rowNum=").append(rowNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}