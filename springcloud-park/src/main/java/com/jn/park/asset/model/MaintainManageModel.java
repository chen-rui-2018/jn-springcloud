package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Date;

/**
* 维保管理model
* @author： zhuyz
* @date： Created on 2019/5/5 16:52
* @version： v1.0
* @modified By:
*/
public class MaintainManageModel implements Serializable {
    private static final long serialVersionUID = 1346189258126065809L;

    @ApiModelProperty(value = "主键",example = "571720004983062528")
    private String id;

    @ApiModelProperty(value = "资产编号",example = "572058527984517120")
    private String assetNumber;

    @ApiModelProperty(value = "物品名称",example = "空调")
    private String name;

    @ApiModelProperty(value = "资产类型id",example = "569824881294704640")
    private String typeId;

    @ApiModelProperty(value = "设备类型(资产类型)",example = "空调")
    private String assetType;

    @ApiModelProperty(value = "楼宇id",example = "568817802354360320")
    private String towerId;

    @ApiModelProperty(value = "楼宇名称",example = "1号楼")
    private String towerName;

    @ApiModelProperty(value = "楼宇地址",example = "南京市秦淮区白下智慧园区XX街1号")
    private String towerAddress;

    @ApiModelProperty(value = "位置信息",example = "大厅")
    private String position;

    @ApiModelProperty(value = "规格",example = "1匹")
    private String specification;

    @ApiModelProperty(value = "厂商名称",example = "格力")
    private String manufacturerName;

    @ApiModelProperty(value = "厂商联系电话",example = "123456")
    private String contactPhone;

    @ApiModelProperty(value = "生产日期",example = "2019-05-05")
    private Date productionTime;

    @ApiModelProperty(value = "设备图片url",example = "url")
    private String assetUrl;

    @ApiModelProperty(value = "本次维保时间",example = "2019-04-27")
    private Date maintenanceTime;

    @ApiModelProperty(value = "维保周期",example = "90")
    private String maintenancePeriod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public String getTowerAddress() {
        return towerAddress;
    }

    public void setTowerAddress(String towerAddress) {
        this.towerAddress = towerAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public Date getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Date maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }



    public String getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(String maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod;
    }
}

