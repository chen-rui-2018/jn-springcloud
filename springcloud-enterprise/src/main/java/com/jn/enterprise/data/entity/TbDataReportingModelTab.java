package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingModelTab implements Serializable {
    /*@ApiModelProperty("tab_id")*/
    private String tabId;

    /*@ApiModelProperty("模板ID")*/
    private String modelId;

    /*@ApiModelProperty("表名称")*/
    private String tabName;

    /*@ApiModelProperty("表类型（0：上月填报值；1：上年同期值；2：上月上年同期值；3增幅）")*/
    private String tabClumnTargetShow;

    /*@ApiModelProperty("表填报列类型（0：累计值；1：本期值）")*/
    private Byte tabClumnType;

    /*@ApiModelProperty("状态（0：无效；1正常）")*/
    private Byte status;

    /*@ApiModelProperty("表生成模式（0:普通模板,1：科技园模板）")*/
    private Byte tabCreateType;

    /*@ApiModelProperty("tab表的显示顺序（因为可能会存在一组tab,tab1,tab2）")*/
    private Integer orderNumber;

    private static final long serialVersionUID = 1L;

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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
        TbDataReportingModelTab other = (TbDataReportingModelTab) that;
        return (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getTabName() == null ? other.getTabName() == null : this.getTabName().equals(other.getTabName()))
            && (this.getTabClumnTargetShow() == null ? other.getTabClumnTargetShow() == null : this.getTabClumnTargetShow().equals(other.getTabClumnTargetShow()))
            && (this.getTabClumnType() == null ? other.getTabClumnType() == null : this.getTabClumnType().equals(other.getTabClumnType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTabCreateType() == null ? other.getTabCreateType() == null : this.getTabCreateType().equals(other.getTabCreateType()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getTabName() == null) ? 0 : getTabName().hashCode());
        result = prime * result + ((getTabClumnTargetShow() == null) ? 0 : getTabClumnTargetShow().hashCode());
        result = prime * result + ((getTabClumnType() == null) ? 0 : getTabClumnType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTabCreateType() == null) ? 0 : getTabCreateType().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tabId=").append(tabId);
        sb.append(", modelId=").append(modelId);
        sb.append(", tabName=").append(tabName);
        sb.append(", tabClumnTargetShow=").append(tabClumnTargetShow);
        sb.append(", tabClumnType=").append(tabClumnType);
        sb.append(", status=").append(status);
        sb.append(", tabCreateType=").append(tabCreateType);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}