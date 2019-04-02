package com.jn.park.sp.entity;

import java.io.Serializable;
import java.util.Date;

public class TbSpPowerBusi implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("所属权力ID")*/
    private String powerId;

    /*@ApiModelProperty("所属权力名称")*/
    private String powerName;

    /*@ApiModelProperty("业务名称")*/
    private String name;

    /*@ApiModelProperty("受理时间，例如：工作日  上午9：00 - 12：00   下午 13：30 - 17：30")*/
    private String dealTime;

    /*@ApiModelProperty("受理地址")*/
    private String dealAddress;

    /*@ApiModelProperty("在线受理地址，点击新开窗口跳转")*/
    private String dealUrl;

    /*@ApiModelProperty("联系电话")*/
    private String linkPhone;

    /*@ApiModelProperty("承诺办理时限方式（单位：工作日）")*/
    private Byte dealLimitDays;

    /*@ApiModelProperty("流程图")*/
    private String flowPic;

    /*@ApiModelProperty("收费标准")*/
    private String feeStandard;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId == null ? null : powerId.trim();
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime == null ? null : dealTime.trim();
    }

    public String getDealAddress() {
        return dealAddress;
    }

    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress == null ? null : dealAddress.trim();
    }

    public String getDealUrl() {
        return dealUrl;
    }

    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl == null ? null : dealUrl.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public Byte getDealLimitDays() {
        return dealLimitDays;
    }

    public void setDealLimitDays(Byte dealLimitDays) {
        this.dealLimitDays = dealLimitDays;
    }

    public String getFlowPic() {
        return flowPic;
    }

    public void setFlowPic(String flowPic) {
        this.flowPic = flowPic == null ? null : flowPic.trim();
    }

    public String getFeeStandard() {
        return feeStandard;
    }

    public void setFeeStandard(String feeStandard) {
        this.feeStandard = feeStandard == null ? null : feeStandard.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        TbSpPowerBusi other = (TbSpPowerBusi) that;
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
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
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
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", powerId=").append(powerId);
        sb.append(", powerName=").append(powerName);
        sb.append(", name=").append(name);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", dealAddress=").append(dealAddress);
        sb.append(", dealUrl=").append(dealUrl);
        sb.append(", linkPhone=").append(linkPhone);
        sb.append(", dealLimitDays=").append(dealLimitDays);
        sb.append(", flowPic=").append(flowPic);
        sb.append(", feeStandard=").append(feeStandard);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}