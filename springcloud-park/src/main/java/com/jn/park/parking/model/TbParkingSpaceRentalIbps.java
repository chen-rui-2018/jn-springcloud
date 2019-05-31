package com.jn.park.parking.model;

import java.io.Serializable;
import java.util.Date;

public class TbParkingSpaceRentalIbps implements Serializable {
    /*@ApiModelProperty("出租记录id")*/
    private String rentId;

    /*@ApiModelProperty("停车场标识")*/
    private String areaId;

    /*@ApiModelProperty("停车场名称")*/
    private String areaName;

    /*@ApiModelProperty("停车位标识")*/
    private String spaceId;

    /*@ApiModelProperty("车位编号")*/
    private String spaceSerial;

    /*@ApiModelProperty("停车位名称")*/
    private String parkingInfo;

    /*@ApiModelProperty("车牌号")*/
    private String carLicense;

    /*@ApiModelProperty("车主账号")*/
    private String account;

    /*@ApiModelProperty("用户对应企业Id(通过该字段校验某个企业税收免费对应数)")*/
    private String companyId;

    /*@ApiModelProperty("车主姓名")*/
    private String name;

    /*@ApiModelProperty("联系电话")*/
    private String phone;

    /*@ApiModelProperty("价格(单位元/年)")*/
    private String rentPrice;

    /*@ApiModelProperty("优惠政策标识")*/
    private String policyId;

    /*@ApiModelProperty("开始日期")*/
    private String startTime;

    /*@ApiModelProperty("结束日期")*/
    private String endTime;

    /*@ApiModelProperty("应缴金额[优惠前金额]")*/
    private Double dueMoney;

    /*@ApiModelProperty("减免金额")*/
    private Double deductionMoney;

    /*@ApiModelProperty("实缴金额[优惠后金额]")*/
    private Double actualMoney;

    /*@ApiModelProperty("缴费单号")*/
    private String orderBillNum;

    /*@ApiModelProperty("审批人账号")*/
    private String approvalAccount;

    /*@ApiModelProperty("审批人姓名")*/
    private String approvalName;

    /*@ApiModelProperty("审批意见")*/
    private String approvalComments;

    /*@ApiModelProperty("-1无效,0待审核,1审批中,2审核通过(待缴费),3审批不通过，4待支付，5支付中，6支付成功 7已取消")*/
    private String approvalStatus;

    /*@ApiModelProperty("合同下载路径")*/
    private String contractAttachment;

    /*@ApiModelProperty("创建时间")*/
    private String createdTime;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private String modifiedTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
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

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Double deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getOrderBillNum() {
        return orderBillNum;
    }

    public void setOrderBillNum(String orderBillNum) {
        this.orderBillNum = orderBillNum;
    }

    public String getApprovalAccount() {
        return approvalAccount;
    }

    public void setApprovalAccount(String approvalAccount) {
        this.approvalAccount = approvalAccount;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalComments() {
        return approvalComments;
    }

    public void setApprovalComments(String approvalComments) {
        this.approvalComments = approvalComments;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getContractAttachment() {
        return contractAttachment;
    }

    public void setContractAttachment(String contractAttachment) {
        this.contractAttachment = contractAttachment;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "TbParkingSpaceRentalIbps{" +
                "rentId='" + rentId + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", spaceId='" + spaceId + '\'' +
                ", spaceSerial='" + spaceSerial + '\'' +
                ", parkingInfo='" + parkingInfo + '\'' +
                ", carLicense='" + carLicense + '\'' +
                ", account='" + account + '\'' +
                ", companyId='" + companyId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", rentPrice='" + rentPrice + '\'' +
                ", policyId='" + policyId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", dueMoney=" + dueMoney +
                ", deductionMoney=" + deductionMoney +
                ", actualMoney=" + actualMoney +
                ", orderBillNum='" + orderBillNum + '\'' +
                ", approvalAccount='" + approvalAccount + '\'' +
                ", approvalName='" + approvalName + '\'' +
                ", approvalComments='" + approvalComments + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", contractAttachment='" + contractAttachment + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}