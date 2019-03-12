package com.jn.park.approve.entity;

import java.io.Serializable;

public class TbApproveGuideMaterials implements Serializable {
    /*@ApiModelProperty("")*/
    private Integer id;

    /*@ApiModelProperty("内容ID")*/
    private Integer guideId;

    /*@ApiModelProperty("材料名称")*/
    private String name;

    /*@ApiModelProperty("材料样本")*/
    private String sample;

    /*@ApiModelProperty("纸质材料数量")*/
    private String paperQuantity;

    /*@ApiModelProperty("是否需要电子材料")*/
    private Byte isNeedElectronic;

    /*@ApiModelProperty("材料必要性（0非必要，1必要）")*/
    private Byte isRequired;

    /*@ApiModelProperty("附加说明")*/
    private String description;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private String createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private String modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
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

    public String getPaperQuantity() {
        return paperQuantity;
    }

    public void setPaperQuantity(String paperQuantity) {
        this.paperQuantity = paperQuantity == null ? null : paperQuantity.trim();
    }

    public Byte getIsNeedElectronic() {
        return isNeedElectronic;
    }

    public void setIsNeedElectronic(Byte isNeedElectronic) {
        this.isNeedElectronic = isNeedElectronic;
    }

    public Byte getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Byte isRequired) {
        this.isRequired = isRequired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
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
        TbApproveGuideMaterials other = (TbApproveGuideMaterials) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGuideId() == null ? other.getGuideId() == null : this.getGuideId().equals(other.getGuideId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSample() == null ? other.getSample() == null : this.getSample().equals(other.getSample()))
            && (this.getPaperQuantity() == null ? other.getPaperQuantity() == null : this.getPaperQuantity().equals(other.getPaperQuantity()))
            && (this.getIsNeedElectronic() == null ? other.getIsNeedElectronic() == null : this.getIsNeedElectronic().equals(other.getIsNeedElectronic()))
            && (this.getIsRequired() == null ? other.getIsRequired() == null : this.getIsRequired().equals(other.getIsRequired()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
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
        result = prime * result + ((getGuideId() == null) ? 0 : getGuideId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSample() == null) ? 0 : getSample().hashCode());
        result = prime * result + ((getPaperQuantity() == null) ? 0 : getPaperQuantity().hashCode());
        result = prime * result + ((getIsNeedElectronic() == null) ? 0 : getIsNeedElectronic().hashCode());
        result = prime * result + ((getIsRequired() == null) ? 0 : getIsRequired().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
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
        sb.append(", guideId=").append(guideId);
        sb.append(", name=").append(name);
        sb.append(", sample=").append(sample);
        sb.append(", paperQuantity=").append(paperQuantity);
        sb.append(", isNeedElectronic=").append(isNeedElectronic);
        sb.append(", isRequired=").append(isRequired);
        sb.append(", description=").append(description);
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