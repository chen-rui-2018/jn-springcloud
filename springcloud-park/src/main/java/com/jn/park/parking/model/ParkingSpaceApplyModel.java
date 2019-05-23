package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceApplyModel",description = "租车位申请")
public class ParkingSpaceApplyModel implements Serializable {
    @ApiModelProperty(value = "车位ID",required = true,example = "5215015316325")
    private String spaceId;

    @ApiModelProperty(value = "车位编码",required = true,example = "A0005")
    @NotNull(message = "车位编码不能为空")
    private String spaceSerial;

    @ApiModelProperty(value = "停车场ID",required = true,example = "24518153811")
    @NotNull(message = "停车场ID不能为空")
    private String areaId;
    @ApiModelProperty(value = "停车场名称",required = true,example = "白下高新智慧园区1号停车场")
    @NotNull(message = "停车场名称不能为空")
    private String areaName;

    @ApiModelProperty(value = "优惠标识",example = "we23eew32452r2")
    private String policyId;

    @ApiModelProperty(value = "车牌号",required = true,example = "苏A00001")
    @NotNull(message = "车牌号不能为空")
    private String carLicense;

    @ApiModelProperty(value = "租赁开始时间[yyyy-MM-dd]",required = true,example = "2019-01-01")
    @NotNull(message = "租赁开始时间不能为空")
    private String startTime;

    @ApiModelProperty(value = "租赁结束时间[yyyy-MM-dd]",required = true,example = "2020-01-01")
    @NotNull(message = "租赁结束时间不能为空")
    private String endTime;

    @ApiModelProperty(value = "车主姓名",example = "张三丰")
    private String name;

    @ApiModelProperty(value = "车主联系电话",example = "18155556666")
    private String phone;

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceSerial() {
        return spaceSerial;
    }

    public void setSpaceSerial(String spaceSerial) {
        this.spaceSerial = spaceSerial;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
