package com.jn.park.wifi.entity;

import java.io.Serializable;
import java.util.Date;

public class TbWifiHeatInfoRecord implements Serializable {
    /*@ApiModelProperty("主键")*/
    private String id;

    /*@ApiModelProperty("租户ID")*/
    private String tenantId;

    /*@ApiModelProperty("IP地址")*/
    private String ip;

    /*@ApiModelProperty("创建人")*/
    private String createBy;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

    /*@ApiModelProperty("更新人")*/
    private String updateBy;

    /*@ApiModelProperty("更新时间")*/
    private Date updateTime;

    /*@ApiModelProperty("采集批次号")*/
    private String batchId;

    /*@ApiModelProperty("ap名")*/
    private String apName;

    /*@ApiModelProperty("在线人数")*/
    private Integer count;

    /*@ApiModelProperty("ap mac地址")*/
    private String device;

    /*@ApiModelProperty("所属楼宇ID")*/
    private String towerId;

    /*@ApiModelProperty("通过正则匹配出来的楼宇名")*/
    private String apNameTower;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName == null ? null : apName.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId == null ? null : towerId.trim();
    }

    public String getApNameTower() {
        return apNameTower;
    }

    public void setApNameTower(String apNameTower) {
        this.apNameTower = apNameTower == null ? null : apNameTower.trim();
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
        TbWifiHeatInfoRecord other = (TbWifiHeatInfoRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getBatchId() == null ? other.getBatchId() == null : this.getBatchId().equals(other.getBatchId()))
            && (this.getApName() == null ? other.getApName() == null : this.getApName().equals(other.getApName()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getDevice() == null ? other.getDevice() == null : this.getDevice().equals(other.getDevice()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getApNameTower() == null ? other.getApNameTower() == null : this.getApNameTower().equals(other.getApNameTower()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBatchId() == null) ? 0 : getBatchId().hashCode());
        result = prime * result + ((getApName() == null) ? 0 : getApName().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getDevice() == null) ? 0 : getDevice().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getApNameTower() == null) ? 0 : getApNameTower().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", ip=").append(ip);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", batchId=").append(batchId);
        sb.append(", apName=").append(apName);
        sb.append(", count=").append(count);
        sb.append(", device=").append(device);
        sb.append(", towerId=").append(towerId);
        sb.append(", apNameTower=").append(apNameTower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}