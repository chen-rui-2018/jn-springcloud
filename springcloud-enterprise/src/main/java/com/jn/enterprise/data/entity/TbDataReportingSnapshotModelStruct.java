package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingSnapshotModelStruct implements Serializable {
    /*@ApiModelProperty("任务批次")*/
    private String taskBatch;

    /*@ApiModelProperty("快照表指标ID")*/
    private String targetId;

    /*@ApiModelProperty("快照表modelID")*/
    private String modelId;

    /*@ApiModelProperty("快照表TabID")*/
    private String tabId;

    private static final long serialVersionUID = 1L;

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

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
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
        TbDataReportingSnapshotModelStruct other = (TbDataReportingSnapshotModelStruct) that;
        return (this.getTaskBatch() == null ? other.getTaskBatch() == null : this.getTaskBatch().equals(other.getTaskBatch()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskBatch() == null) ? 0 : getTaskBatch().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskBatch=").append(taskBatch);
        sb.append(", targetId=").append(targetId);
        sb.append(", modelId=").append(modelId);
        sb.append(", tabId=").append(tabId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}