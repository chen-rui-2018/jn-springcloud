package com.jn.park.pmpaybill.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbPmPayRule implements Serializable {
    private String id;

    private String name;

    private Byte calcMode;

    private Integer sharePercentage;

    private Byte status;

    private String remark;

    private BigDecimal price;

    private String payType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getCalcMode() {
        return calcMode;
    }

    public void setCalcMode(Byte calcMode) {
        this.calcMode = calcMode;
    }

    public Integer getSharePercentage() {
        return sharePercentage;
    }

    public void setSharePercentage(Integer sharePercentage) {
        this.sharePercentage = sharePercentage;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
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
        TbPmPayRule other = (TbPmPayRule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCalcMode() == null ? other.getCalcMode() == null : this.getCalcMode().equals(other.getCalcMode()))
            && (this.getSharePercentage() == null ? other.getSharePercentage() == null : this.getSharePercentage().equals(other.getSharePercentage()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCalcMode() == null) ? 0 : getCalcMode().hashCode());
        result = prime * result + ((getSharePercentage() == null) ? 0 : getSharePercentage().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", calcMode=").append(calcMode);
        sb.append(", sharePercentage=").append(sharePercentage);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", price=").append(price);
        sb.append(", payType=").append(payType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}