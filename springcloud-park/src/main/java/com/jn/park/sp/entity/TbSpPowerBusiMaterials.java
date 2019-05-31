package com.jn.park.sp.entity;

import java.io.Serializable;
import java.util.Date;

public class TbSpPowerBusiMaterials implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("服务ID")*/
    private String busiId;

    /*@ApiModelProperty("材料名称")*/
    private String name;

    /*@ApiModelProperty("材料样本")*/
    private String sample;

    /*@ApiModelProperty("来源渠道")*/
    private String fromChannel;

    /*@ApiModelProperty("纸质材料数量（份）")*/
    private Integer paperQuantity;

    /*@ApiModelProperty("是否需要电子材料")*/
    private Integer isNeedElectronic;

    /*@ApiModelProperty("材料必要性（0非必要，1必要）")*/
    private Integer isRequired;

    /*@ApiModelProperty("填报须知")*/
    private String notice;

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

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId == null ? null : busiId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample == null ? null : sample.trim();
    }

    public String getFromChannel() {
        return fromChannel;
    }

    public void setFromChannel(String fromChannel) {
        this.fromChannel = fromChannel == null ? null : fromChannel.trim();
    }

    public Integer getPaperQuantity() {
        return paperQuantity;
    }

    public void setPaperQuantity(Integer paperQuantity) {
        this.paperQuantity = paperQuantity;
    }

    public Integer getIsNeedElectronic() {
        return isNeedElectronic;
    }

    public void setIsNeedElectronic(Integer isNeedElectronic) {
        this.isNeedElectronic = isNeedElectronic;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
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
        TbSpPowerBusiMaterials other = (TbSpPowerBusiMaterials) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBusiId() == null ? other.getBusiId() == null : this.getBusiId().equals(other.getBusiId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSample() == null ? other.getSample() == null : this.getSample().equals(other.getSample()))
            && (this.getFromChannel() == null ? other.getFromChannel() == null : this.getFromChannel().equals(other.getFromChannel()))
            && (this.getPaperQuantity() == null ? other.getPaperQuantity() == null : this.getPaperQuantity().equals(other.getPaperQuantity()))
            && (this.getIsNeedElectronic() == null ? other.getIsNeedElectronic() == null : this.getIsNeedElectronic().equals(other.getIsNeedElectronic()))
            && (this.getIsRequired() == null ? other.getIsRequired() == null : this.getIsRequired().equals(other.getIsRequired()))
            && (this.getNotice() == null ? other.getNotice() == null : this.getNotice().equals(other.getNotice()))
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
        result = prime * result + ((getBusiId() == null) ? 0 : getBusiId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSample() == null) ? 0 : getSample().hashCode());
        result = prime * result + ((getFromChannel() == null) ? 0 : getFromChannel().hashCode());
        result = prime * result + ((getPaperQuantity() == null) ? 0 : getPaperQuantity().hashCode());
        result = prime * result + ((getIsNeedElectronic() == null) ? 0 : getIsNeedElectronic().hashCode());
        result = prime * result + ((getIsRequired() == null) ? 0 : getIsRequired().hashCode());
        result = prime * result + ((getNotice() == null) ? 0 : getNotice().hashCode());
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
        sb.append(", busiId=").append(busiId);
        sb.append(", name=").append(name);
        sb.append(", sample=").append(sample);
        sb.append(", fromChannel=").append(fromChannel);
        sb.append(", paperQuantity=").append(paperQuantity);
        sb.append(", isNeedElectronic=").append(isNeedElectronic);
        sb.append(", isRequired=").append(isRequired);
        sb.append(", notice=").append(notice);
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