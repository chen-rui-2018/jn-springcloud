package com.jn.park.sp.entity;

import java.io.Serializable;

public class TbSpPowerBusiWithBLOBs extends TbSpPowerBusi implements Serializable {
    /*@ApiModelProperty("设定依据")*/
    private String settingBasis;

    /*@ApiModelProperty("办理条件")*/
    private String dealConditions;

    private static final long serialVersionUID = 1L;

    public String getSettingBasis() {
        return settingBasis;
    }

    public void setSettingBasis(String settingBasis) {
        this.settingBasis = settingBasis == null ? null : settingBasis.trim();
    }

    public String getDealConditions() {
        return dealConditions;
    }

    public void setDealConditions(String dealConditions) {
        this.dealConditions = dealConditions == null ? null : dealConditions.trim();
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
        TbSpPowerBusiWithBLOBs other = (TbSpPowerBusiWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPowerId() == null ? other.getPowerId() == null : this.getPowerId().equals(other.getPowerId()))
            && (this.getPowerName() == null ? other.getPowerName() == null : this.getPowerName().equals(other.getPowerName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()))
            && (this.getDealAddress() == null ? other.getDealAddress() == null : this.getDealAddress().equals(other.getDealAddress()))
            && (this.getDealUrl() == null ? other.getDealUrl() == null : this.getDealUrl().equals(other.getDealUrl()))
            && (this.getLinkPhone() == null ? other.getLinkPhone() == null : this.getLinkPhone().equals(other.getLinkPhone()))
            && (this.getDealLimitDays() == null ? other.getDealLimitDays() == null : this.getDealLimitDays().equals(other.getDealLimitDays()))
            && (this.getFlowPic() == null ? other.getFlowPic() == null : this.getFlowPic().equals(other.getFlowPic()))
            && (this.getFeeStandard() == null ? other.getFeeStandard() == null : this.getFeeStandard().equals(other.getFeeStandard()))
            && (this.getIsContactOnline() == null ? other.getIsContactOnline() == null : this.getIsContactOnline().equals(other.getIsContactOnline()))
            && (this.getContactQqGroup() == null ? other.getContactQqGroup() == null : this.getContactQqGroup().equals(other.getContactQqGroup()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getSettingBasis() == null ? other.getSettingBasis() == null : this.getSettingBasis().equals(other.getSettingBasis()))
            && (this.getDealConditions() == null ? other.getDealConditions() == null : this.getDealConditions().equals(other.getDealConditions()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPowerId() == null) ? 0 : getPowerId().hashCode());
        result = prime * result + ((getPowerName() == null) ? 0 : getPowerName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        result = prime * result + ((getDealAddress() == null) ? 0 : getDealAddress().hashCode());
        result = prime * result + ((getDealUrl() == null) ? 0 : getDealUrl().hashCode());
        result = prime * result + ((getLinkPhone() == null) ? 0 : getLinkPhone().hashCode());
        result = prime * result + ((getDealLimitDays() == null) ? 0 : getDealLimitDays().hashCode());
        result = prime * result + ((getFlowPic() == null) ? 0 : getFlowPic().hashCode());
        result = prime * result + ((getFeeStandard() == null) ? 0 : getFeeStandard().hashCode());
        result = prime * result + ((getIsContactOnline() == null) ? 0 : getIsContactOnline().hashCode());
        result = prime * result + ((getContactQqGroup() == null) ? 0 : getContactQqGroup().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getSettingBasis() == null) ? 0 : getSettingBasis().hashCode());
        result = prime * result + ((getDealConditions() == null) ? 0 : getDealConditions().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", settingBasis=").append(settingBasis);
        sb.append(", dealConditions=").append(dealConditions);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}