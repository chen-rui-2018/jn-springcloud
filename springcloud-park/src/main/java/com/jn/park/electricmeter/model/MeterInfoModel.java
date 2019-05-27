package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/24 14:17
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MeterInfoModel",description = "电表信息")
public class MeterInfoModel implements Serializable {
    @ApiModelProperty("")
    private String id;

    @ApiModelProperty("电表的设备编码")
    private String meterCode;

    @ApiModelProperty("电表名称")
    private String meterName;

    @ApiModelProperty("电表类型(0:企业用电，1：公共照明，2：空调用电，3：楼层用电)")
    private Byte type;

    @ApiModelProperty("电表位置")
    private String position;

    @ApiModelProperty("业主")
    private String companyId;

    @ApiModelProperty("使用状态（1:正常，2:损坏，3:报修中）")
    private Byte useStatus;

    @ApiModelProperty("是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty("创建者账号")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("更新者账号")
    private String modifierAccount;

    @ApiModelProperty("更新时间")
    private Date modifiedTime;

    @ApiModelProperty("高能耗阀值")
    private Long isHighEnergyThreshold;

    @ApiModelProperty("箱号")
    private String boxNumber;

    @ApiModelProperty("楼层号")
    private String floor;

    @ApiModelProperty("表号")
    private String meterNumber;

    @ApiModelProperty("互感倍率")
    private String mutualInductanceRatio;

    @ApiModelProperty("分组Id")
    private String groupId;

    @ApiModelProperty("电表开关状态（4-开启,5-关闭）")
    private Byte switchStatus;

    @ApiModelProperty("建筑物Id")
    private String buildingId;

    @ApiModelProperty("企业名称")
    private String companyName;

    @ApiModelProperty("低耗能阈值")
    private Long isLowEnergyThreshold;

    @ApiModelProperty("手机号")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
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
        this.position = position;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
        this.creatorAccount = creatorAccount;
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
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getIsHighEnergyThreshold() {
        return isHighEnergyThreshold;
    }

    public void setIsHighEnergyThreshold(Long isHighEnergyThreshold) {
        this.isHighEnergyThreshold = isHighEnergyThreshold;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getMutualInductanceRatio() {
        return mutualInductanceRatio;
    }

    public void setMutualInductanceRatio(String mutualInductanceRatio) {
        this.mutualInductanceRatio = mutualInductanceRatio;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
        this.buildingId = buildingId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getIsLowEnergyThreshold() {
        return isLowEnergyThreshold;
    }

    public void setIsLowEnergyThreshold(Long isLowEnergyThreshold) {
        this.isLowEnergyThreshold = isLowEnergyThreshold;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
