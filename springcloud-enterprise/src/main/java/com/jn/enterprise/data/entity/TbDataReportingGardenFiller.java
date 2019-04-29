package com.jn.enterprise.data.entity;

import java.io.Serializable;

public class TbDataReportingGardenFiller implements Serializable {
    /*@ApiModelProperty("任务id")*/
    private String fillId;

    /*@ApiModelProperty("填报ID")*/
    private String filler;

    /*@ApiModelProperty("快照指标ID")*/
    private String fillerTel;

    /*@ApiModelProperty("部门ID")*/
    private String departmentId;

    /*@ApiModelProperty("部门名称")*/
    private String departmentName;

    /*@ApiModelProperty("状态（企业状态0：已上报；1未上报2：草稿")*/
    private Byte status;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("审核状态")*/
    private Byte gardenExamineStauts;

    /*@ApiModelProperty("审批意见")*/
    private String examineComment;

    /*@ApiModelProperty("快照tabId")*/
    private String tabId;

    private static final long serialVersionUID = 1L;

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId == null ? null : fillId.trim();
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler == null ? null : filler.trim();
    }

    public String getFillerTel() {
        return fillerTel;
    }

    public void setFillerTel(String fillerTel) {
        this.fillerTel = fillerTel == null ? null : fillerTel.trim();
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Byte getGardenExamineStauts() {
        return gardenExamineStauts;
    }

    public void setGardenExamineStauts(Byte gardenExamineStauts) {
        this.gardenExamineStauts = gardenExamineStauts;
    }

    public String getExamineComment() {
        return examineComment;
    }

    public void setExamineComment(String examineComment) {
        this.examineComment = examineComment == null ? null : examineComment.trim();
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
        TbDataReportingGardenFiller other = (TbDataReportingGardenFiller) that;
        return (this.getFillId() == null ? other.getFillId() == null : this.getFillId().equals(other.getFillId()))
            && (this.getFiller() == null ? other.getFiller() == null : this.getFiller().equals(other.getFiller()))
            && (this.getFillerTel() == null ? other.getFillerTel() == null : this.getFillerTel().equals(other.getFillerTel()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getGardenExamineStauts() == null ? other.getGardenExamineStauts() == null : this.getGardenExamineStauts().equals(other.getGardenExamineStauts()))
            && (this.getExamineComment() == null ? other.getExamineComment() == null : this.getExamineComment().equals(other.getExamineComment()))
            && (this.getTabId() == null ? other.getTabId() == null : this.getTabId().equals(other.getTabId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFillId() == null) ? 0 : getFillId().hashCode());
        result = prime * result + ((getFiller() == null) ? 0 : getFiller().hashCode());
        result = prime * result + ((getFillerTel() == null) ? 0 : getFillerTel().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getGardenExamineStauts() == null) ? 0 : getGardenExamineStauts().hashCode());
        result = prime * result + ((getExamineComment() == null) ? 0 : getExamineComment().hashCode());
        result = prime * result + ((getTabId() == null) ? 0 : getTabId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fillId=").append(fillId);
        sb.append(", filler=").append(filler);
        sb.append(", fillerTel=").append(fillerTel);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", gardenExamineStauts=").append(gardenExamineStauts);
        sb.append(", examineComment=").append(examineComment);
        sb.append(", tabId=").append(tabId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}