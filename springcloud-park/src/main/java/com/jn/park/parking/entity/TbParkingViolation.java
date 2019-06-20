package com.jn.park.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class TbParkingViolation implements Serializable {
    /*@ApiModelProperty("违规上报id")*/
    private String reportId;

    /*@ApiModelProperty("车牌号")*/
    private String carLicense;

    /*@ApiModelProperty("车主姓名")*/
    private String userName;

    /*@ApiModelProperty("车主账号")*/
    private String userAccount;

    /*@ApiModelProperty("联系方式")*/
    private String userPhone;

    /*@ApiModelProperty("租车位信息")*/
    private String parkingInfo;

    /*@ApiModelProperty("车辆预留手机号")*/
    private String carPhone;

    /*@ApiModelProperty("车辆违停地址")*/
    private String parkingAddress;

    /*@ApiModelProperty("违停照片")*/
    private String pictureUrl;

    /*@ApiModelProperty("通知车主")*/
    private String noticeInfromation;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense == null ? null : carLicense.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo == null ? null : parkingInfo.trim();
    }

    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone == null ? null : carPhone.trim();
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress == null ? null : parkingAddress.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getNoticeInfromation() {
        return noticeInfromation;
    }

    public void setNoticeInfromation(String noticeInfromation) {
        this.noticeInfromation = noticeInfromation == null ? null : noticeInfromation.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
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
        TbParkingViolation other = (TbParkingViolation) that;
        return (this.getReportId() == null ? other.getReportId() == null : this.getReportId().equals(other.getReportId()))
            && (this.getCarLicense() == null ? other.getCarLicense() == null : this.getCarLicense().equals(other.getCarLicense()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
            && (this.getUserPhone() == null ? other.getUserPhone() == null : this.getUserPhone().equals(other.getUserPhone()))
            && (this.getParkingInfo() == null ? other.getParkingInfo() == null : this.getParkingInfo().equals(other.getParkingInfo()))
            && (this.getCarPhone() == null ? other.getCarPhone() == null : this.getCarPhone().equals(other.getCarPhone()))
            && (this.getParkingAddress() == null ? other.getParkingAddress() == null : this.getParkingAddress().equals(other.getParkingAddress()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
            && (this.getNoticeInfromation() == null ? other.getNoticeInfromation() == null : this.getNoticeInfromation().equals(other.getNoticeInfromation()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReportId() == null) ? 0 : getReportId().hashCode());
        result = prime * result + ((getCarLicense() == null) ? 0 : getCarLicense().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getUserPhone() == null) ? 0 : getUserPhone().hashCode());
        result = prime * result + ((getParkingInfo() == null) ? 0 : getParkingInfo().hashCode());
        result = prime * result + ((getCarPhone() == null) ? 0 : getCarPhone().hashCode());
        result = prime * result + ((getParkingAddress() == null) ? 0 : getParkingAddress().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getNoticeInfromation() == null) ? 0 : getNoticeInfromation().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportId=").append(reportId);
        sb.append(", carLicense=").append(carLicense);
        sb.append(", userName=").append(userName);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", parkingInfo=").append(parkingInfo);
        sb.append(", carPhone=").append(carPhone);
        sb.append(", parkingAddress=").append(parkingAddress);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", noticeInfromation=").append(noticeInfromation);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}