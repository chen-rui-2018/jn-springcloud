package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingUserSpaceRentalVo",description = "用户车位租赁列表")
public class ParkingUserSpaceRentalVo implements Serializable {

    @ApiModelProperty(value = "出租记录ID",example = "e2ew2***")
    private String rentId;
    @ApiModelProperty(value = "停车位ID",example = "e2ew3***")
    private String spaceId;
    @ApiModelProperty(value = "车位编号",example = "A00001")
    private String spaceSerial;
    @ApiModelProperty(value = "停车场名称",example = "白下园区5号停车场")
    private String areaName;
    @ApiModelProperty(value = "车牌号",example = "苏A00001")
    private String carLicense;
    @ApiModelProperty(value = "车位状态[0待审核,1审批中,2审核通过(待缴费),3审批不通过，4待支付，5支付中，6支付成功，7已取消]",example = "0")
    private String approvalStatus;
    @ApiModelProperty(value = "创建时间",example = "2019-01-01 10:10:10")
    private String createdTime;
    @ApiModelProperty(value = "姓名",example = "王五")
    private String name;
    @ApiModelProperty(value = "电话",example = "18100001111")
    private String phone;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
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
}
