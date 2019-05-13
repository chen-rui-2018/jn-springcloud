package com.jn.park.asset.entity;

import java.io.Serializable;
import java.util.Date;

public class TbAssetMaintainManage implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("资产编号")*/
    private String assetNumber;

    /*@ApiModelProperty("设备名称(资产名称)")*/
    private String name;

    /*@ApiModelProperty("资产类型id")*/
    private String typeId;

    /*@ApiModelProperty("设备类型(资产类型)")*/
    private String assetType;

    /*@ApiModelProperty("楼宇id")*/
    private String towerId;

    /*@ApiModelProperty("楼宇名称")*/
    private String towerName;

    /*@ApiModelProperty("楼宇位置")*/
    private String towerAddress;

    /*@ApiModelProperty("规格")*/
    private String specification;

    /*@ApiModelProperty("生产日期")*/
    private Date productionTime;

    /*@ApiModelProperty("位置信息")*/
    private String position;

    /*@ApiModelProperty("设备图片url")*/
    private String assetUrl;

    /*@ApiModelProperty("本次维保时间")*/
    private Date maintenanceTime;

    /*@ApiModelProperty("维保周期")*/
    private String maintenancePeriod;

    /*@ApiModelProperty("需维保(0不需要维保,1需要维保)")*/
    private Byte isMaintaion;

    /*@ApiModelProperty("维保厂家ID")*/
    private String companyId;

    /*@ApiModelProperty("维保厂家名称")*/
    private String companyName;

    /*@ApiModelProperty("厂商联系电话")*/
    private String contactPhone;

    /*@ApiModelProperty("录入状态(0:不可录入,1可录入)")*/
    private Byte status;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

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

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber == null ? null : assetNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl == null ? null : assetUrl.trim();
    }

    public Date getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Date maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public String getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(String maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod == null ? null : maintenancePeriod.trim();
    }

    public Byte getIsMaintaion() {
        return isMaintaion;
    }

    public void setIsMaintaion(Byte isMaintaion) {
        this.isMaintaion = isMaintaion;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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
        TbAssetMaintainManage other = (TbAssetMaintainManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAssetNumber() == null ? other.getAssetNumber() == null : this.getAssetNumber().equals(other.getAssetNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getAssetType() == null ? other.getAssetType() == null : this.getAssetType().equals(other.getAssetType()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getTowerName() == null ? other.getTowerName() == null : this.getTowerName().equals(other.getTowerName()))
            && (this.getTowerAddress() == null ? other.getTowerAddress() == null : this.getTowerAddress().equals(other.getTowerAddress()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getProductionTime() == null ? other.getProductionTime() == null : this.getProductionTime().equals(other.getProductionTime()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getAssetUrl() == null ? other.getAssetUrl() == null : this.getAssetUrl().equals(other.getAssetUrl()))
            && (this.getMaintenanceTime() == null ? other.getMaintenanceTime() == null : this.getMaintenanceTime().equals(other.getMaintenanceTime()))
            && (this.getMaintenancePeriod() == null ? other.getMaintenancePeriod() == null : this.getMaintenancePeriod().equals(other.getMaintenancePeriod()))
            && (this.getIsMaintaion() == null ? other.getIsMaintaion() == null : this.getIsMaintaion().equals(other.getIsMaintaion()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getAssetType() == null) ? 0 : getAssetType().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getTowerName() == null) ? 0 : getTowerName().hashCode());
        result = prime * result + ((getTowerAddress() == null) ? 0 : getTowerAddress().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getProductionTime() == null) ? 0 : getProductionTime().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getAssetUrl() == null) ? 0 : getAssetUrl().hashCode());
        result = prime * result + ((getMaintenanceTime() == null) ? 0 : getMaintenanceTime().hashCode());
        result = prime * result + ((getMaintenancePeriod() == null) ? 0 : getMaintenancePeriod().hashCode());
        result = prime * result + ((getIsMaintaion() == null) ? 0 : getIsMaintaion().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", assetType=").append(assetType);
        sb.append(", towerId=").append(towerId);
        sb.append(", towerName=").append(towerName);
        sb.append(", towerAddress=").append(towerAddress);
        sb.append(", specification=").append(specification);
        sb.append(", productionTime=").append(productionTime);
        sb.append(", position=").append(position);
        sb.append(", assetUrl=").append(assetUrl);
        sb.append(", maintenanceTime=").append(maintenanceTime);
        sb.append(", maintenancePeriod=").append(maintenancePeriod);
        sb.append(", isMaintaion=").append(isMaintaion);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}