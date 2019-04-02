package com.jn.enterprise.pd.declaration.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdDeclarationPlatformManage implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private String id;

    /*@ApiModelProperty("平台标题")*/
    private String platformTitle;

    /*@ApiModelProperty("链接地址")*/
    private String linkAddress;

    /*@ApiModelProperty("备注")*/
    private String remark;

    /*@ApiModelProperty("业务咨询")*/
    private String businessConsult;

    /*@ApiModelProperty("系统支持")*/
    private String systemSupport;

    /*@ApiModelProperty("所属平台ID")*/
    private String subordinatePlatformId;

    /*@ApiModelProperty("所属平台名称")*/
    private String subordinatePlatformName;

    /*@ApiModelProperty("状态（1：草稿，2：已发布，3：已下架）")*/
    private Byte status;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("")*/
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

    public String getPlatformTitle() {
        return platformTitle;
    }

    public void setPlatformTitle(String platformTitle) {
        this.platformTitle = platformTitle == null ? null : platformTitle.trim();
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBusinessConsult() {
        return businessConsult;
    }

    public void setBusinessConsult(String businessConsult) {
        this.businessConsult = businessConsult == null ? null : businessConsult.trim();
    }

    public String getSystemSupport() {
        return systemSupport;
    }

    public void setSystemSupport(String systemSupport) {
        this.systemSupport = systemSupport == null ? null : systemSupport.trim();
    }

    public String getSubordinatePlatformId() {
        return subordinatePlatformId;
    }

    public void setSubordinatePlatformId(String subordinatePlatformId) {
        this.subordinatePlatformId = subordinatePlatformId == null ? null : subordinatePlatformId.trim();
    }

    public String getSubordinatePlatformName() {
        return subordinatePlatformName;
    }

    public void setSubordinatePlatformName(String subordinatePlatformName) {
        this.subordinatePlatformName = subordinatePlatformName == null ? null : subordinatePlatformName.trim();
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
        TbPdDeclarationPlatformManage other = (TbPdDeclarationPlatformManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatformTitle() == null ? other.getPlatformTitle() == null : this.getPlatformTitle().equals(other.getPlatformTitle()))
            && (this.getLinkAddress() == null ? other.getLinkAddress() == null : this.getLinkAddress().equals(other.getLinkAddress()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBusinessConsult() == null ? other.getBusinessConsult() == null : this.getBusinessConsult().equals(other.getBusinessConsult()))
            && (this.getSystemSupport() == null ? other.getSystemSupport() == null : this.getSystemSupport().equals(other.getSystemSupport()))
            && (this.getSubordinatePlatformId() == null ? other.getSubordinatePlatformId() == null : this.getSubordinatePlatformId().equals(other.getSubordinatePlatformId()))
            && (this.getSubordinatePlatformName() == null ? other.getSubordinatePlatformName() == null : this.getSubordinatePlatformName().equals(other.getSubordinatePlatformName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getPlatformTitle() == null) ? 0 : getPlatformTitle().hashCode());
        result = prime * result + ((getLinkAddress() == null) ? 0 : getLinkAddress().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBusinessConsult() == null) ? 0 : getBusinessConsult().hashCode());
        result = prime * result + ((getSystemSupport() == null) ? 0 : getSystemSupport().hashCode());
        result = prime * result + ((getSubordinatePlatformId() == null) ? 0 : getSubordinatePlatformId().hashCode());
        result = prime * result + ((getSubordinatePlatformName() == null) ? 0 : getSubordinatePlatformName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", platformTitle=").append(platformTitle);
        sb.append(", linkAddress=").append(linkAddress);
        sb.append(", remark=").append(remark);
        sb.append(", businessConsult=").append(businessConsult);
        sb.append(", systemSupport=").append(systemSupport);
        sb.append(", subordinatePlatformId=").append(subordinatePlatformId);
        sb.append(", subordinatePlatformName=").append(subordinatePlatformName);
        sb.append(", status=").append(status);
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