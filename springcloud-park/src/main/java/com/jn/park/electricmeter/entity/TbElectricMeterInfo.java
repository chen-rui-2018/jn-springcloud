package com.jn.park.electricmeter.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbElectricMeterInfo implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("电表的设备编码")*/
    private String meterCode;

    /*@ApiModelProperty("电表名称")*/
    private String meterName;

    /*@ApiModelProperty("电表类型(0:企业用电，1：公共照明，2：空调用电，3：楼层用电)")*/
    private Byte type;

    /*@ApiModelProperty("电表位置")*/
    private String position;

    /*@ApiModelProperty("业主")*/
    private String companyId;

    /*@ApiModelProperty("使用状态（1:正常，2:损坏，3:报修中）")*/
    private Byte useStatus;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("高能耗阀值")*/
    private BigDecimal isHighEnergyThreshold;

    /*@ApiModelProperty("箱号")*/
    private String boxNumber;

    /*@ApiModelProperty("楼层号")*/
    private String floor;

    /*@ApiModelProperty("表号")*/
    private String meterNumber;

    /*@ApiModelProperty("互感倍率")*/
    private String mutualInductanceRatio;

    /*@ApiModelProperty("分组Id")*/
    private String groupId;

    /*@ApiModelProperty("电表开关状态（4-开启,5-关闭）")*/
    private Byte switchStatus;

    /*@ApiModelProperty("建筑物Id")*/
    private String buildingId;

    /*@ApiModelProperty("企业名称")*/
    private String companyName;

    /*@ApiModelProperty("低耗能阈值")*/
    private Long isLowEnergyThreshold;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode == null ? null : meterCode.trim();
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName == null ? null : meterName.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Byte getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Byte useStatus) {
        this.useStatus = useStatus;
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

    public BigDecimal getIsHighEnergyThreshold() {
        return isHighEnergyThreshold;
    }

    public void setIsHighEnergyThreshold(BigDecimal isHighEnergyThreshold) {
        this.isHighEnergyThreshold = isHighEnergyThreshold;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber == null ? null : boxNumber.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber == null ? null : meterNumber.trim();
    }

    public String getMutualInductanceRatio() {
        return mutualInductanceRatio;
    }

    public void setMutualInductanceRatio(String mutualInductanceRatio) {
        this.mutualInductanceRatio = mutualInductanceRatio == null ? null : mutualInductanceRatio.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public Byte getSwitchStatus() {
        return switchStatus;
    }

    public void setSwitchStatus(Byte switchStatus) {
        this.switchStatus = switchStatus;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Long getIsLowEnergyThreshold() {
        return isLowEnergyThreshold;
    }

    public void setIsLowEnergyThreshold(Long isLowEnergyThreshold) {
        this.isLowEnergyThreshold = isLowEnergyThreshold;
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
        TbElectricMeterInfo other = (TbElectricMeterInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMeterCode() == null ? other.getMeterCode() == null : this.getMeterCode().equals(other.getMeterCode()))
            && (this.getMeterName() == null ? other.getMeterName() == null : this.getMeterName().equals(other.getMeterName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getUseStatus() == null ? other.getUseStatus() == null : this.getUseStatus().equals(other.getUseStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getIsHighEnergyThreshold() == null ? other.getIsHighEnergyThreshold() == null : this.getIsHighEnergyThreshold().equals(other.getIsHighEnergyThreshold()))
            && (this.getBoxNumber() == null ? other.getBoxNumber() == null : this.getBoxNumber().equals(other.getBoxNumber()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getMeterNumber() == null ? other.getMeterNumber() == null : this.getMeterNumber().equals(other.getMeterNumber()))
            && (this.getMutualInductanceRatio() == null ? other.getMutualInductanceRatio() == null : this.getMutualInductanceRatio().equals(other.getMutualInductanceRatio()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getSwitchStatus() == null ? other.getSwitchStatus() == null : this.getSwitchStatus().equals(other.getSwitchStatus()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getIsLowEnergyThreshold() == null ? other.getIsLowEnergyThreshold() == null : this.getIsLowEnergyThreshold().equals(other.getIsLowEnergyThreshold()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeterCode() == null) ? 0 : getMeterCode().hashCode());
        result = prime * result + ((getMeterName() == null) ? 0 : getMeterName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getUseStatus() == null) ? 0 : getUseStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getIsHighEnergyThreshold() == null) ? 0 : getIsHighEnergyThreshold().hashCode());
        result = prime * result + ((getBoxNumber() == null) ? 0 : getBoxNumber().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getMeterNumber() == null) ? 0 : getMeterNumber().hashCode());
        result = prime * result + ((getMutualInductanceRatio() == null) ? 0 : getMutualInductanceRatio().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getSwitchStatus() == null) ? 0 : getSwitchStatus().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getIsLowEnergyThreshold() == null) ? 0 : getIsLowEnergyThreshold().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", meterCode=").append(meterCode);
        sb.append(", meterName=").append(meterName);
        sb.append(", type=").append(type);
        sb.append(", position=").append(position);
        sb.append(", companyId=").append(companyId);
        sb.append(", useStatus=").append(useStatus);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", isHighEnergyThreshold=").append(isHighEnergyThreshold);
        sb.append(", boxNumber=").append(boxNumber);
        sb.append(", floor=").append(floor);
        sb.append(", meterNumber=").append(meterNumber);
        sb.append(", mutualInductanceRatio=").append(mutualInductanceRatio);
        sb.append(", groupId=").append(groupId);
        sb.append(", switchStatus=").append(switchStatus);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", companyName=").append(companyName);
        sb.append(", isLowEnergyThreshold=").append(isLowEnergyThreshold);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}