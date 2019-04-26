package com.jn.park.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class TbParkingRecord implements Serializable {
    /*@ApiModelProperty("停车记录id")*/
    private String parkingId;

    /*@ApiModelProperty("停车场ID")*/
    private String areaId;

    /*@ApiModelProperty("停车场名称")*/
    private String areaName;

    /*@ApiModelProperty("车牌")*/
    private String carLicense;

    /*@ApiModelProperty("车主账号(车辆入场时，查询车辆用户数据入库)")*/
    private String account;

    /*@ApiModelProperty("车主姓名")*/
    private String name;

    /*@ApiModelProperty("联系电话")*/
    private String phone;

    /*@ApiModelProperty("入场时间")*/
    private Date admissionTime;

    /*@ApiModelProperty("缴费开始计算时间")*/
    private Date startBillingTime;

    /*@ApiModelProperty("离场时间")*/
    private Date departureTime;

    /*@ApiModelProperty("缴费时间")*/
    private Date paymentTime;

    /*@ApiModelProperty("停车状态：1-入场,0离场")*/
    private String parkingStatus;

    /*@ApiModelProperty("停车持续时间(单位:小时)")*/
    private String parkingTime;

    /*@ApiModelProperty("应缴纳的金额")*/
    private Double dueMoney;

    /*@ApiModelProperty("积分抵扣数")*/
    private Double useIntegral;

    /*@ApiModelProperty("积分抵扣金额")*/
    private Double deductionMoney;

    /*@ApiModelProperty("实际金额数")*/
    private Double actualMoney;

    /*@ApiModelProperty("缴费单号")*/
    private String orderBillNum;

    /*@ApiModelProperty("支付成功时间")*/
    private Date payTime;

    /*@ApiModelProperty("支付状态 0未支付(支付中)1支付成功 -1取消支付")*/
    private String payStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId == null ? null : parkingId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense == null ? null : carLicense.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getStartBillingTime() {
        return startBillingTime;
    }

    public void setStartBillingTime(Date startBillingTime) {
        this.startBillingTime = startBillingTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus == null ? null : parkingStatus.trim();
    }

    public String getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(String parkingTime) {
        this.parkingTime = parkingTime == null ? null : parkingTime.trim();
    }

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getUseIntegral() {
        return useIntegral;
    }

    public void setUseIntegral(Double useIntegral) {
        this.useIntegral = useIntegral;
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
        this.orderBillNum = orderBillNum == null ? null : orderBillNum.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbParkingRecord other = (TbParkingRecord) that;
        return (this.getParkingId() == null ? other.getParkingId() == null : this.getParkingId().equals(other.getParkingId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getCarLicense() == null ? other.getCarLicense() == null : this.getCarLicense().equals(other.getCarLicense()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAdmissionTime() == null ? other.getAdmissionTime() == null : this.getAdmissionTime().equals(other.getAdmissionTime()))
            && (this.getStartBillingTime() == null ? other.getStartBillingTime() == null : this.getStartBillingTime().equals(other.getStartBillingTime()))
            && (this.getDepartureTime() == null ? other.getDepartureTime() == null : this.getDepartureTime().equals(other.getDepartureTime()))
            && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
            && (this.getParkingStatus() == null ? other.getParkingStatus() == null : this.getParkingStatus().equals(other.getParkingStatus()))
            && (this.getParkingTime() == null ? other.getParkingTime() == null : this.getParkingTime().equals(other.getParkingTime()))
            && (this.getDueMoney() == null ? other.getDueMoney() == null : this.getDueMoney().equals(other.getDueMoney()))
            && (this.getUseIntegral() == null ? other.getUseIntegral() == null : this.getUseIntegral().equals(other.getUseIntegral()))
            && (this.getDeductionMoney() == null ? other.getDeductionMoney() == null : this.getDeductionMoney().equals(other.getDeductionMoney()))
            && (this.getActualMoney() == null ? other.getActualMoney() == null : this.getActualMoney().equals(other.getActualMoney()))
            && (this.getOrderBillNum() == null ? other.getOrderBillNum() == null : this.getOrderBillNum().equals(other.getOrderBillNum()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getParkingId() == null) ? 0 : getParkingId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getCarLicense() == null) ? 0 : getCarLicense().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAdmissionTime() == null) ? 0 : getAdmissionTime().hashCode());
        result = prime * result + ((getStartBillingTime() == null) ? 0 : getStartBillingTime().hashCode());
        result = prime * result + ((getDepartureTime() == null) ? 0 : getDepartureTime().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getParkingStatus() == null) ? 0 : getParkingStatus().hashCode());
        result = prime * result + ((getParkingTime() == null) ? 0 : getParkingTime().hashCode());
        result = prime * result + ((getDueMoney() == null) ? 0 : getDueMoney().hashCode());
        result = prime * result + ((getUseIntegral() == null) ? 0 : getUseIntegral().hashCode());
        result = prime * result + ((getDeductionMoney() == null) ? 0 : getDeductionMoney().hashCode());
        result = prime * result + ((getActualMoney() == null) ? 0 : getActualMoney().hashCode());
        result = prime * result + ((getOrderBillNum() == null) ? 0 : getOrderBillNum().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", parkingId=").append(parkingId);
        sb.append(", areaId=").append(areaId);
        sb.append(", areaName=").append(areaName);
        sb.append(", carLicense=").append(carLicense);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", admissionTime=").append(admissionTime);
        sb.append(", startBillingTime=").append(startBillingTime);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", parkingStatus=").append(parkingStatus);
        sb.append(", parkingTime=").append(parkingTime);
        sb.append(", dueMoney=").append(dueMoney);
        sb.append(", useIntegral=").append(useIntegral);
        sb.append(", deductionMoney=").append(deductionMoney);
        sb.append(", actualMoney=").append(actualMoney);
        sb.append(", orderBillNum=").append(orderBillNum);
        sb.append(", payTime=").append(payTime);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}