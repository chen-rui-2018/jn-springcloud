package com.jn.park.parking.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 停车位列表查询入参
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceParam",description = "停车位列表查询入参")
public class ParkingSpaceParam extends Page implements Serializable {
    @ApiModelProperty(value = "停车位ID",example = "32we4***")
    private String spaceId;

    @ApiModelProperty(value = "停车场ID",example = "32we4***")
    private String areaId;

    @ApiModelProperty(value = "停车场名称",example = "F1区停车场")
    private String areaName;

    @ApiModelProperty(value = "停车位编号",example = "A0001")
    private String spaceSerial;

    @ApiModelProperty(value = "当前租赁车牌号",example = "湘A00001")
    private String carLicense;

    @ApiModelProperty(value = "车位状态[1未出租 2已出租 0无效]",example = "1")
    private String spaceStatus;

    @ApiModelProperty(value = "车主姓名",example = "张三")
    private String name;

    @ApiModelProperty(value = "联系方式",example = "18177778888")
    private String phone;

    @ApiModelProperty(value = "用户账号",example = "wangsong")
    private String account;


    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceSerial() {
        return spaceSerial;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSpaceSerial(String spaceSerial) {
        this.spaceSerial = spaceSerial;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getSpaceStatus() {
        return spaceStatus;
    }

    public void setSpaceStatus(String spaceStatus) {
        this.spaceStatus = spaceStatus;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
