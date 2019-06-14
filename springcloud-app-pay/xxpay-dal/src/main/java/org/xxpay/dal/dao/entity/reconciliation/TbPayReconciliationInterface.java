package org.xxpay.dal.dao.entity.reconciliation;

import java.io.Serializable;

public class TbPayReconciliationInterface implements Serializable {
    private Integer id;

    private String interfaceName;

    private String interfaceCode;

    private String interfaceDesc;

    private Integer status;

    private Integer billDay;

    private String mchId;

    private String channelId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode == null ? null : interfaceCode.trim();
    }

    public String getInterfaceDesc() {
        return interfaceDesc;
    }

    public void setInterfaceDesc(String interfaceDesc) {
        this.interfaceDesc = interfaceDesc == null ? null : interfaceDesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
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
        TbPayReconciliationInterface other = (TbPayReconciliationInterface) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInterfaceName() == null ? other.getInterfaceName() == null : this.getInterfaceName().equals(other.getInterfaceName()))
            && (this.getInterfaceCode() == null ? other.getInterfaceCode() == null : this.getInterfaceCode().equals(other.getInterfaceCode()))
            && (this.getInterfaceDesc() == null ? other.getInterfaceDesc() == null : this.getInterfaceDesc().equals(other.getInterfaceDesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBillDay() == null ? other.getBillDay() == null : this.getBillDay().equals(other.getBillDay()))
            && (this.getMchId() == null ? other.getMchId() == null : this.getMchId().equals(other.getMchId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInterfaceName() == null) ? 0 : getInterfaceName().hashCode());
        result = prime * result + ((getInterfaceCode() == null) ? 0 : getInterfaceCode().hashCode());
        result = prime * result + ((getInterfaceDesc() == null) ? 0 : getInterfaceDesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBillDay() == null) ? 0 : getBillDay().hashCode());
        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", interfaceName=").append(interfaceName);
        sb.append(", interfaceCode=").append(interfaceCode);
        sb.append(", interfaceDesc=").append(interfaceDesc);
        sb.append(", status=").append(status);
        sb.append(", billDay=").append(billDay);
        sb.append(", mchId=").append(mchId);
        sb.append(", channelId=").append(channelId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}