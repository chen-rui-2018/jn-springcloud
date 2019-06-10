package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdPersonnelAppointmentCounsel implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("主题")*/
    private String theme;

    /*@ApiModelProperty("园区发送预约时间始")*/
    private Date parkAppointmentTimeStart;

    /*@ApiModelProperty("园区发送预约时间止")*/
    private Date parkAppointmentTimeEnd;

    /*@ApiModelProperty("园区发送预约辅导地点")*/
    private String parkReservationAddress;

    /*@ApiModelProperty("实际辅导时间始")*/
    private Date notifyCounselTimeStart;

    /*@ApiModelProperty("实际辅导时间止")*/
    private Date notifyCounselTimeEnd;

    /*@ApiModelProperty("实际辅导地址")*/
    private String notifyCounselAddress;

    /*@ApiModelProperty("预约人数限制")*/
    private Integer reservationLimit;

    /*@ApiModelProperty("截止预约时间")*/
    private Date deadline;

    /*@ApiModelProperty("辅导类型（1：区级计划书辅导，2：区级答辩辅导，3：市级计划书辅导，4：市级答辩辅导）")*/
    private Byte counselType;

    /*@ApiModelProperty("状态（1：已使用，2：未使用）")*/
    private Byte status;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Date getParkAppointmentTimeStart() {
        return parkAppointmentTimeStart;
    }

    public void setParkAppointmentTimeStart(Date parkAppointmentTimeStart) {
        this.parkAppointmentTimeStart = parkAppointmentTimeStart;
    }

    public Date getParkAppointmentTimeEnd() {
        return parkAppointmentTimeEnd;
    }

    public void setParkAppointmentTimeEnd(Date parkAppointmentTimeEnd) {
        this.parkAppointmentTimeEnd = parkAppointmentTimeEnd;
    }

    public String getParkReservationAddress() {
        return parkReservationAddress;
    }

    public void setParkReservationAddress(String parkReservationAddress) {
        this.parkReservationAddress = parkReservationAddress == null ? null : parkReservationAddress.trim();
    }

    public Date getNotifyCounselTimeStart() {
        return notifyCounselTimeStart;
    }

    public void setNotifyCounselTimeStart(Date notifyCounselTimeStart) {
        this.notifyCounselTimeStart = notifyCounselTimeStart;
    }

    public Date getNotifyCounselTimeEnd() {
        return notifyCounselTimeEnd;
    }

    public void setNotifyCounselTimeEnd(Date notifyCounselTimeEnd) {
        this.notifyCounselTimeEnd = notifyCounselTimeEnd;
    }

    public String getNotifyCounselAddress() {
        return notifyCounselAddress;
    }

    public void setNotifyCounselAddress(String notifyCounselAddress) {
        this.notifyCounselAddress = notifyCounselAddress == null ? null : notifyCounselAddress.trim();
    }

    public Integer getReservationLimit() {
        return reservationLimit;
    }

    public void setReservationLimit(Integer reservationLimit) {
        this.reservationLimit = reservationLimit;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Byte getCounselType() {
        return counselType;
    }

    public void setCounselType(Byte counselType) {
        this.counselType = counselType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        TbPdPersonnelAppointmentCounsel other = (TbPdPersonnelAppointmentCounsel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getParkAppointmentTimeStart() == null ? other.getParkAppointmentTimeStart() == null : this.getParkAppointmentTimeStart().equals(other.getParkAppointmentTimeStart()))
            && (this.getParkAppointmentTimeEnd() == null ? other.getParkAppointmentTimeEnd() == null : this.getParkAppointmentTimeEnd().equals(other.getParkAppointmentTimeEnd()))
            && (this.getParkReservationAddress() == null ? other.getParkReservationAddress() == null : this.getParkReservationAddress().equals(other.getParkReservationAddress()))
            && (this.getNotifyCounselTimeStart() == null ? other.getNotifyCounselTimeStart() == null : this.getNotifyCounselTimeStart().equals(other.getNotifyCounselTimeStart()))
            && (this.getNotifyCounselTimeEnd() == null ? other.getNotifyCounselTimeEnd() == null : this.getNotifyCounselTimeEnd().equals(other.getNotifyCounselTimeEnd()))
            && (this.getNotifyCounselAddress() == null ? other.getNotifyCounselAddress() == null : this.getNotifyCounselAddress().equals(other.getNotifyCounselAddress()))
            && (this.getReservationLimit() == null ? other.getReservationLimit() == null : this.getReservationLimit().equals(other.getReservationLimit()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getCounselType() == null ? other.getCounselType() == null : this.getCounselType().equals(other.getCounselType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getParkAppointmentTimeStart() == null) ? 0 : getParkAppointmentTimeStart().hashCode());
        result = prime * result + ((getParkAppointmentTimeEnd() == null) ? 0 : getParkAppointmentTimeEnd().hashCode());
        result = prime * result + ((getParkReservationAddress() == null) ? 0 : getParkReservationAddress().hashCode());
        result = prime * result + ((getNotifyCounselTimeStart() == null) ? 0 : getNotifyCounselTimeStart().hashCode());
        result = prime * result + ((getNotifyCounselTimeEnd() == null) ? 0 : getNotifyCounselTimeEnd().hashCode());
        result = prime * result + ((getNotifyCounselAddress() == null) ? 0 : getNotifyCounselAddress().hashCode());
        result = prime * result + ((getReservationLimit() == null) ? 0 : getReservationLimit().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getCounselType() == null) ? 0 : getCounselType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", theme=").append(theme);
        sb.append(", parkAppointmentTimeStart=").append(parkAppointmentTimeStart);
        sb.append(", parkAppointmentTimeEnd=").append(parkAppointmentTimeEnd);
        sb.append(", parkReservationAddress=").append(parkReservationAddress);
        sb.append(", notifyCounselTimeStart=").append(notifyCounselTimeStart);
        sb.append(", notifyCounselTimeEnd=").append(notifyCounselTimeEnd);
        sb.append(", notifyCounselAddress=").append(notifyCounselAddress);
        sb.append(", reservationLimit=").append(reservationLimit);
        sb.append(", deadline=").append(deadline);
        sb.append(", counselType=").append(counselType);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}