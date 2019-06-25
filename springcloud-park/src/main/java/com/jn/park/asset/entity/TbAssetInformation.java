package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbAssetInformation implements Serializable {
    /*@ApiModelProperty("主键")*/
    private String id;

    /*@ApiModelProperty("资产主表tb_asset的主键")*/
    private String parentId;

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

    /*@ApiModelProperty("本次维保时间")*/
    private Date maintenanceTime;

    /*@ApiModelProperty("维保周期")*/
    private String maintenancePeriod;

    /*@ApiModelProperty("位置信息")*/
    private String position;

    /*@ApiModelProperty("资产说明")*/
    private String assetExplain;

    /*@ApiModelProperty("规格型号")*/
    private String specification;

    /*@ApiModelProperty("生产日期")*/
    private Date productionTime;

    /*@ApiModelProperty("制造厂家")*/
    private String manufacturer;

    /*@ApiModelProperty("维保厂家ID")*/
    private String companyId;

    /*@ApiModelProperty("维保厂家名称")*/
    private String companyName;

    /*@ApiModelProperty("厂商联系电话")*/
    private String contactPhone;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("录入人")*/
    private String creatorAccount;

    /*@ApiModelProperty("录入时间")*/
    private Date createTime;

    /*@ApiModelProperty("修改人")*/
    private String modifierAccount;

    /*@ApiModelProperty("修改时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("租借企业ID")*/
    private String leaseEnterpriseId;

    /*@ApiModelProperty("租借企业名")*/
    private String leaseEnterpriseName;

    /*@ApiModelProperty("租借联系人")*/
    private String leaseContactName;

    /*@ApiModelProperty("租借联系方式")*/
    private String leaseContactPhone;

    /*@ApiModelProperty("租借押金")*/
    private BigDecimal leaseCash;

    /*@ApiModelProperty("租借单价")*/
    private BigDecimal leasePrice;

    /*@ApiModelProperty("最低租借时间(天)")*/
    private String leaseTime;

    /*@ApiModelProperty("租借状态(0标记为空闲,1申请中,2交付中,3租借中,4归还中,5已归还)")*/
    private Byte leaseStatus;

    /*@ApiModelProperty("租借是否逾期(1是，0否)")*/
    private Integer leaseIsOverdue;

    /*@ApiModelProperty("租借申请时间")*/
    private Date leaseApplyTime;

    /*@ApiModelProperty("租借开始时间")*/
    private Date leaseStartTime;

    /*@ApiModelProperty("租借结束时间")*/
    private Date leaseEndTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
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

    public String getLeaseEnterpriseId() {
        return leaseEnterpriseId;
    }

    public void setLeaseEnterpriseId(String leaseEnterpriseId) {
        this.leaseEnterpriseId = leaseEnterpriseId == null ? null : leaseEnterpriseId.trim();
    }

    public String getLeaseEnterpriseName() {
        return leaseEnterpriseName;
    }

    public void setLeaseEnterpriseName(String leaseEnterpriseName) {
        this.leaseEnterpriseName = leaseEnterpriseName == null ? null : leaseEnterpriseName.trim();
    }

    public String getLeaseContactName() {
        return leaseContactName;
    }

    public void setLeaseContactName(String leaseContactName) {
        this.leaseContactName = leaseContactName == null ? null : leaseContactName.trim();
    }

    public String getLeaseContactPhone() {
        return leaseContactPhone;
    }

    public void setLeaseContactPhone(String leaseContactPhone) {
        this.leaseContactPhone = leaseContactPhone == null ? null : leaseContactPhone.trim();
    }

    public BigDecimal getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(BigDecimal leaseCash) {
        this.leaseCash = leaseCash;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(String leaseTime) {
        this.leaseTime = leaseTime == null ? null : leaseTime.trim();
    }

    public Byte getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(Byte leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public Integer getLeaseIsOverdue() {
        return leaseIsOverdue;
    }

    public void setLeaseIsOverdue(Integer leaseIsOverdue) {
        this.leaseIsOverdue = leaseIsOverdue;
    }

    public Date getLeaseApplyTime() {
        return leaseApplyTime;
    }

    public void setLeaseApplyTime(Date leaseApplyTime) {
        this.leaseApplyTime = leaseApplyTime;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
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
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
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
            && (this.getMaintenanceTime() == null ? other.getMaintenanceTime() == null : this.getMaintenanceTime().equals(other.getMaintenanceTime()))
            && (this.getMaintenancePeriod() == null ? other.getMaintenancePeriod() == null : this.getMaintenancePeriod().equals(other.getMaintenancePeriod()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getAssetExplain() == null ? other.getAssetExplain() == null : this.getAssetExplain().equals(other.getAssetExplain()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getProductionTime() == null ? other.getProductionTime() == null : this.getProductionTime().equals(other.getProductionTime()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getLeaseEnterpriseId() == null ? other.getLeaseEnterpriseId() == null : this.getLeaseEnterpriseId().equals(other.getLeaseEnterpriseId()))
            && (this.getLeaseEnterpriseName() == null ? other.getLeaseEnterpriseName() == null : this.getLeaseEnterpriseName().equals(other.getLeaseEnterpriseName()))
            && (this.getLeaseContactName() == null ? other.getLeaseContactName() == null : this.getLeaseContactName().equals(other.getLeaseContactName()))
            && (this.getLeaseContactPhone() == null ? other.getLeaseContactPhone() == null : this.getLeaseContactPhone().equals(other.getLeaseContactPhone()))
            && (this.getLeaseCash() == null ? other.getLeaseCash() == null : this.getLeaseCash().equals(other.getLeaseCash()))
            && (this.getLeasePrice() == null ? other.getLeasePrice() == null : this.getLeasePrice().equals(other.getLeasePrice()))
            && (this.getLeaseTime() == null ? other.getLeaseTime() == null : this.getLeaseTime().equals(other.getLeaseTime()))
            && (this.getLeaseStatus() == null ? other.getLeaseStatus() == null : this.getLeaseStatus().equals(other.getLeaseStatus()))
            && (this.getLeaseIsOverdue() == null ? other.getLeaseIsOverdue() == null : this.getLeaseIsOverdue().equals(other.getLeaseIsOverdue()))
            && (this.getLeaseApplyTime() == null ? other.getLeaseApplyTime() == null : this.getLeaseApplyTime().equals(other.getLeaseApplyTime()))
            && (this.getLeaseStartTime() == null ? other.getLeaseStartTime() == null : this.getLeaseStartTime().equals(other.getLeaseStartTime()))
            && (this.getLeaseEndTime() == null ? other.getLeaseEndTime() == null : this.getLeaseEndTime().equals(other.getLeaseEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
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
        result = prime * result + ((getMaintenanceTime() == null) ? 0 : getMaintenanceTime().hashCode());
        result = prime * result + ((getMaintenancePeriod() == null) ? 0 : getMaintenancePeriod().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getAssetExplain() == null) ? 0 : getAssetExplain().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getProductionTime() == null) ? 0 : getProductionTime().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getLeaseEnterpriseId() == null) ? 0 : getLeaseEnterpriseId().hashCode());
        result = prime * result + ((getLeaseEnterpriseName() == null) ? 0 : getLeaseEnterpriseName().hashCode());
        result = prime * result + ((getLeaseContactName() == null) ? 0 : getLeaseContactName().hashCode());
        result = prime * result + ((getLeaseContactPhone() == null) ? 0 : getLeaseContactPhone().hashCode());
        result = prime * result + ((getLeaseCash() == null) ? 0 : getLeaseCash().hashCode());
        result = prime * result + ((getLeasePrice() == null) ? 0 : getLeasePrice().hashCode());
        result = prime * result + ((getLeaseTime() == null) ? 0 : getLeaseTime().hashCode());
        result = prime * result + ((getLeaseStatus() == null) ? 0 : getLeaseStatus().hashCode());
        result = prime * result + ((getLeaseIsOverdue() == null) ? 0 : getLeaseIsOverdue().hashCode());
        result = prime * result + ((getLeaseApplyTime() == null) ? 0 : getLeaseApplyTime().hashCode());
        result = prime * result + ((getLeaseStartTime() == null) ? 0 : getLeaseStartTime().hashCode());
        result = prime * result + ((getLeaseEndTime() == null) ? 0 : getLeaseEndTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
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
        sb.append(", maintenanceTime=").append(maintenanceTime);
        sb.append(", maintenancePeriod=").append(maintenancePeriod);
        sb.append(", position=").append(position);
        sb.append(", assetExplain=").append(assetExplain);
        sb.append(", specification=").append(specification);
        sb.append(", productionTime=").append(productionTime);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", leaseEnterpriseId=").append(leaseEnterpriseId);
        sb.append(", leaseEnterpriseName=").append(leaseEnterpriseName);
        sb.append(", leaseContactName=").append(leaseContactName);
        sb.append(", leaseContactPhone=").append(leaseContactPhone);
        sb.append(", leaseCash=").append(leaseCash);
        sb.append(", leasePrice=").append(leasePrice);
        sb.append(", leaseTime=").append(leaseTime);
        sb.append(", leaseStatus=").append(leaseStatus);
        sb.append(", leaseIsOverdue=").append(leaseIsOverdue);
        sb.append(", leaseApplyTime=").append(leaseApplyTime);
        sb.append(", leaseStartTime=").append(leaseStartTime);
        sb.append(", leaseEndTime=").append(leaseEndTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}