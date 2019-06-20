package com.jn.park.electricmeter.entity;

import java.io.Serializable;
import java.util.Date;

public class TbElectricReadingFailLog implements Serializable {
    /*@ApiModelProperty("记录Id")*/
    private String id;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("入库时间")*/
    private Date createTime;

    /*@ApiModelProperty("账期：天")*/
    private Date dealDate;

    /*@ApiModelProperty("账期：小时")*/
    private Byte dealHour;

    /*@ApiModelProperty("采集状态（1：成功，2：失败）")*/
    private Byte status;

    /*@ApiModelProperty("采集时的参数")*/
    private String param;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Byte getDealHour() {
        return dealHour;
    }

    public void setDealHour(Byte dealHour) {
        this.dealHour = dealHour;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
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
        TbElectricReadingFailLog other = (TbElectricReadingFailLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getDealHour() == null ? other.getDealHour() == null : this.getDealHour().equals(other.getDealHour()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getParam() == null ? other.getParam() == null : this.getParam().equals(other.getParam()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDealDate() == null) ? 0 : getDealDate().hashCode());
        result = prime * result + ((getDealHour() == null) ? 0 : getDealHour().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", dealDate=").append(dealDate);
        sb.append(", dealHour=").append(dealHour);
        sb.append(", status=").append(status);
        sb.append(", param=").append(param);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}