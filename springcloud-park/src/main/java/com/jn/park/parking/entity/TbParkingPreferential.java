package com.jn.park.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class TbParkingPreferential implements Serializable {
    /*@ApiModelProperty("优惠政策id")*/
    private String policyId;

    /*@ApiModelProperty("政策编码")*/
    private String policyCode;

    /*@ApiModelProperty("优惠内容")*/
    private String policyComments;

    /*@ApiModelProperty("0 无效  1 有效")*/
    private String policyStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode == null ? null : policyCode.trim();
    }

    public String getPolicyComments() {
        return policyComments;
    }

    public void setPolicyComments(String policyComments) {
        this.policyComments = policyComments == null ? null : policyComments.trim();
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus == null ? null : policyStatus.trim();
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbParkingPreferential other = (TbParkingPreferential) that;
        return (this.getPolicyId() == null ? other.getPolicyId() == null : this.getPolicyId().equals(other.getPolicyId()))
            && (this.getPolicyCode() == null ? other.getPolicyCode() == null : this.getPolicyCode().equals(other.getPolicyCode()))
            && (this.getPolicyComments() == null ? other.getPolicyComments() == null : this.getPolicyComments().equals(other.getPolicyComments()))
            && (this.getPolicyStatus() == null ? other.getPolicyStatus() == null : this.getPolicyStatus().equals(other.getPolicyStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPolicyId() == null) ? 0 : getPolicyId().hashCode());
        result = prime * result + ((getPolicyCode() == null) ? 0 : getPolicyCode().hashCode());
        result = prime * result + ((getPolicyComments() == null) ? 0 : getPolicyComments().hashCode());
        result = prime * result + ((getPolicyStatus() == null) ? 0 : getPolicyStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", policyId=").append(policyId);
        sb.append(", policyCode=").append(policyCode);
        sb.append(", policyComments=").append(policyComments);
        sb.append(", policyStatus=").append(policyStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}