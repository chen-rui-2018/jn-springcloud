package com.jn.park.electric.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbElectricReading implements Serializable {
    /*@ApiModelProperty("记录Id")*/
    private String id;

    /*@ApiModelProperty("电表设备编码")*/
    private String meterCode;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("入库时间")*/
    private Date createTime;

    /*@ApiModelProperty("账期：天")*/
    private Date dealDate;

    /*@ApiModelProperty("后一小时减去前一小时的读数差")*/
    private BigDecimal degreeDiff;

    /*@ApiModelProperty("账期：小时")*/
    private Byte dealHour;

    /*@ApiModelProperty("累积用量")*/
    private BigDecimal readingEnd;

    /*@ApiModelProperty("本条数据采集时间 时间格式 :yyyy-MM-dd HH:mm:ss")*/
    private Date timeEnd;

    /*@ApiModelProperty("参数")*/
    private String param;

    /*@ApiModelProperty("建筑物id")*/
    private String buildingId;

    /*@ApiModelProperty("采集状态（1：成功，2：失败）")*/
    private Byte status;

    /*@ApiModelProperty("状态说明")*/
    private String statusMsg;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode == null ? null : meterCode.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public BigDecimal getDegreeDiff() {
        return degreeDiff;
    }

    public void setDegreeDiff(BigDecimal degreeDiff) {
        this.degreeDiff = degreeDiff;
    }

    public Byte getDealHour() {
        return dealHour;
    }

    public void setDealHour(Byte dealHour) {
        this.dealHour = dealHour;
    }

    public BigDecimal getReadingEnd() {
        return readingEnd;
    }

    public void setReadingEnd(BigDecimal readingEnd) {
        this.readingEnd = readingEnd;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg == null ? null : statusMsg.trim();
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
        TbElectricReading other = (TbElectricReading) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMeterCode() == null ? other.getMeterCode() == null : this.getMeterCode().equals(other.getMeterCode()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getDegreeDiff() == null ? other.getDegreeDiff() == null : this.getDegreeDiff().equals(other.getDegreeDiff()))
            && (this.getDealHour() == null ? other.getDealHour() == null : this.getDealHour().equals(other.getDealHour()))
            && (this.getReadingEnd() == null ? other.getReadingEnd() == null : this.getReadingEnd().equals(other.getReadingEnd()))
            && (this.getTimeEnd() == null ? other.getTimeEnd() == null : this.getTimeEnd().equals(other.getTimeEnd()))
            && (this.getParam() == null ? other.getParam() == null : this.getParam().equals(other.getParam()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatusMsg() == null ? other.getStatusMsg() == null : this.getStatusMsg().equals(other.getStatusMsg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeterCode() == null) ? 0 : getMeterCode().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDealDate() == null) ? 0 : getDealDate().hashCode());
        result = prime * result + ((getDegreeDiff() == null) ? 0 : getDegreeDiff().hashCode());
        result = prime * result + ((getDealHour() == null) ? 0 : getDealHour().hashCode());
        result = prime * result + ((getReadingEnd() == null) ? 0 : getReadingEnd().hashCode());
        result = prime * result + ((getTimeEnd() == null) ? 0 : getTimeEnd().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatusMsg() == null) ? 0 : getStatusMsg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", meterCode=").append(meterCode);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", dealDate=").append(dealDate);
        sb.append(", degreeDiff=").append(degreeDiff);
        sb.append(", dealHour=").append(dealHour);
        sb.append(", readingEnd=").append(readingEnd);
        sb.append(", timeEnd=").append(timeEnd);
        sb.append(", param=").append(param);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", status=").append(status);
        sb.append(", statusMsg=").append(statusMsg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}