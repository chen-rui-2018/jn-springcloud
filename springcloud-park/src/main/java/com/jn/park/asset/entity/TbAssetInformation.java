package com.jn.park.asset.entity;

import java.io.Serializable;
import java.util.Date;

public class TbAssetInformation implements Serializable {
    /*@ApiModelProperty("主键")*/
    private String id;

    /*@ApiModelProperty("资产编号")*/
    private String assetNumber;

    /*@ApiModelProperty("资产名称")*/
    private String assetName;

    /*@ApiModelProperty("资产类型id")*/
    private String typeId;

    /*@ApiModelProperty("资产类型")*/
    private String assetType;

    /*@ApiModelProperty("楼宇id")*/
    private String towerId;

    /*@ApiModelProperty("楼宇名称")*/
    private String towerName;

    /*@ApiModelProperty("楼宇地址")*/
    private String towerAddress;

    /*@ApiModelProperty("二维码")*/
    private String qrCode;

    /*@ApiModelProperty("状态(0标记为待补充,1标记为正常)")*/
    private Byte status;

    /*@ApiModelProperty("录入类型(1标记为采购录入,2竣工录入)")*/
    private Byte inputType;

    /*@ApiModelProperty("图片url")*/
    private String imgUrl;

    /*@ApiModelProperty("可租借(0不可租借,1可租借)")*/
    private Byte isLease;

    /*@ApiModelProperty("需维保(0不需要维保,1需要维保)")*/
    private Byte isMaintain;

    /*@ApiModelProperty("维保周期")*/
    private String maintenancePeriod;

    /*@ApiModelProperty("位置信息")*/
    private String position;

    /*@ApiModelProperty("资产说明")*/
    private String assetExplain;

    /*@ApiModelProperty("录入人")*/
    private String creatorAccount;

    /*@ApiModelProperty("录入时间")*/
    private Date createTime;

    /*@ApiModelProperty("修改人")*/
    private String modifierAccount;

    /*@ApiModelProperty("修改时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber == null ? null : assetNumber.trim();
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId == null ? null : towerId.trim();
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName == null ? null : towerName.trim();
    }

    public String getTowerAddress() {
        return towerAddress;
    }

    public void setTowerAddress(String towerAddress) {
        this.towerAddress = towerAddress == null ? null : towerAddress.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getInputType() {
        return inputType;
    }

    public void setInputType(Byte inputType) {
        this.inputType = inputType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Byte getIsLease() {
        return isLease;
    }

    public void setIsLease(Byte isLease) {
        this.isLease = isLease;
    }

    public Byte getIsMaintain() {
        return isMaintain;
    }

    public void setIsMaintain(Byte isMaintain) {
        this.isMaintain = isMaintain;
    }

    public String getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(String maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod == null ? null : maintenancePeriod.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAssetExplain() {
        return assetExplain;
    }

    public void setAssetExplain(String assetExplain) {
        this.assetExplain = assetExplain == null ? null : assetExplain.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        TbAssetInformation other = (TbAssetInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAssetNumber() == null ? other.getAssetNumber() == null : this.getAssetNumber().equals(other.getAssetNumber()))
            && (this.getAssetName() == null ? other.getAssetName() == null : this.getAssetName().equals(other.getAssetName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getAssetType() == null ? other.getAssetType() == null : this.getAssetType().equals(other.getAssetType()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getTowerName() == null ? other.getTowerName() == null : this.getTowerName().equals(other.getTowerName()))
            && (this.getTowerAddress() == null ? other.getTowerAddress() == null : this.getTowerAddress().equals(other.getTowerAddress()))
            && (this.getQrCode() == null ? other.getQrCode() == null : this.getQrCode().equals(other.getQrCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getInputType() == null ? other.getInputType() == null : this.getInputType().equals(other.getInputType()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getIsLease() == null ? other.getIsLease() == null : this.getIsLease().equals(other.getIsLease()))
            && (this.getIsMaintain() == null ? other.getIsMaintain() == null : this.getIsMaintain().equals(other.getIsMaintain()))
            && (this.getMaintenancePeriod() == null ? other.getMaintenancePeriod() == null : this.getMaintenancePeriod().equals(other.getMaintenancePeriod()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getAssetExplain() == null ? other.getAssetExplain() == null : this.getAssetExplain().equals(other.getAssetExplain()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAssetNumber() == null) ? 0 : getAssetNumber().hashCode());
        result = prime * result + ((getAssetName() == null) ? 0 : getAssetName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getAssetType() == null) ? 0 : getAssetType().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getTowerName() == null) ? 0 : getTowerName().hashCode());
        result = prime * result + ((getTowerAddress() == null) ? 0 : getTowerAddress().hashCode());
        result = prime * result + ((getQrCode() == null) ? 0 : getQrCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getInputType() == null) ? 0 : getInputType().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getIsLease() == null) ? 0 : getIsLease().hashCode());
        result = prime * result + ((getIsMaintain() == null) ? 0 : getIsMaintain().hashCode());
        result = prime * result + ((getMaintenancePeriod() == null) ? 0 : getMaintenancePeriod().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getAssetExplain() == null) ? 0 : getAssetExplain().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", assetNumber=").append(assetNumber);
        sb.append(", assetName=").append(assetName);
        sb.append(", typeId=").append(typeId);
        sb.append(", assetType=").append(assetType);
        sb.append(", towerId=").append(towerId);
        sb.append(", towerName=").append(towerName);
        sb.append(", towerAddress=").append(towerAddress);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", status=").append(status);
        sb.append(", inputType=").append(inputType);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", isLease=").append(isLease);
        sb.append(", isMaintain=").append(isMaintain);
        sb.append(", maintenancePeriod=").append(maintenancePeriod);
        sb.append(", position=").append(position);
        sb.append(", assetExplain=").append(assetExplain);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}