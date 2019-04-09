package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingSnapshotModelTab implements Serializable {
    /*@ApiModelProperty("序列")*/
    private String id;

    /*@ApiModelProperty("")*/
    private String taskBatch;

    /*@ApiModelProperty("模板ID")*/
    private String modelId;

    /*@ApiModelProperty("tab_id")*/
    private String tabId;

    /*@ApiModelProperty("表名称")*/
    private String tabName;

    /*@ApiModelProperty("表类型（0：上月填报值；1：上年同期值；2：上月上年同期值；3增幅）")*/
    private String tabClumnTargetShow;

    /*@ApiModelProperty("表填报列类型（0：累计值；1：本期值）")*/
    private Byte tabClumnType;

    /*@ApiModelProperty("状态（0：有效；1作废）")*/
    private Byte status;

    /*@ApiModelProperty("表生成模式（0:普通模板,1：科技园模板）")*/
    private Byte tabCreateType;

    /*@ApiModelProperty("tab表的显示顺序（因为可能会存在一组tab,tab1,tab2）")*/
    private String order;

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

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    public String getTabClumnTargetShow() {
        return tabClumnTargetShow;
    }

    public void setTabClumnTargetShow(String tabClumnTargetShow) {
        this.tabClumnTargetShow = tabClumnTargetShow == null ? null : tabClumnTargetShow.trim();
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

    public Byte getTabCreateType() {
        return tabCreateType;
    }

    public void setTabCreateType(Byte tabCreateType) {
        this.tabCreateType = tabCreateType;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
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
        TbDataReportingSnapshotModelTab other = (TbDataReportingSnapshotModelTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskBatch() == null ? other.getTaskBatch() == null : this.getTaskBatch().equals(other.getTaskBatch()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()))
            && (this.getTabName() == null ? other.getTabName() == null : this.getTabName().equals(other.getTabName()))
            && (this.getTabClumnTargetShow() == null ? other.getTabClumnTargetShow() == null : this.getTabClumnTargetShow().equals(other.getTabClumnTargetShow()))
            && (this.getTabClumnType() == null ? other.getTabClumnType() == null : this.getTabClumnType().equals(other.getTabClumnType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTabCreateType() == null ? other.getTabCreateType() == null : this.getTabCreateType().equals(other.getTabCreateType()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskBatch() == null) ? 0 : getTaskBatch().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        result = prime * result + ((getTabName() == null) ? 0 : getTabName().hashCode());
        result = prime * result + ((getTabClumnTargetShow() == null) ? 0 : getTabClumnTargetShow().hashCode());
        result = prime * result + ((getTabClumnType() == null) ? 0 : getTabClumnType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTabCreateType() == null) ? 0 : getTabCreateType().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
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
        sb.append(", modelId=").append(modelId);
        sb.append(", tabId=").append(tabId);
        sb.append(", tabName=").append(tabName);
        sb.append(", tabClumnTargetShow=").append(tabClumnTargetShow);
        sb.append(", tabClumnType=").append(tabClumnType);
        sb.append(", status=").append(status);
        sb.append(", tabCreateType=").append(tabCreateType);
        sb.append(", order=").append(order);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}