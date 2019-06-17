package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPdPersonnelNotificationDetails implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("辅导名称")*/
    private String coachName;

    /*@ApiModelProperty("辅导专家")*/
    private String counselSpecialist;

    /*@ApiModelProperty("辅导打分")*/
    private BigDecimal counselScore;

    /*@ApiModelProperty("预约状态（1：已预约，2：未预约，3：已取消）")*/
    private Byte status;

    /*@ApiModelProperty("通知方式（1：短信，2：邮件，3：微信推送）")*/
    private Byte notificationMode;

    /*@ApiModelProperty("辅导企业(团队)名称")*/
    private String counselEnterpriseName;

    /*@ApiModelProperty("辅导人")*/
    private String counselPerson;

    /*@ApiModelProperty("企业预约时间始")*/
    private Date appointmentTimeStart;

    /*@ApiModelProperty("企业预约时间止")*/
    private Date appointmentTimeEnd;

    /*@ApiModelProperty("企业预约辅导地点")*/
    private String reservationAddress;

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

    /*@ApiModelProperty("项目ID")*/
    private Integer projectId;

    /*@ApiModelProperty("主题ID")*/
    private Integer themeId;

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

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName == null ? null : coachName.trim();
    }

    public String getCounselSpecialist() {
        return counselSpecialist;
    }

    public void setCounselSpecialist(String counselSpecialist) {
        this.counselSpecialist = counselSpecialist == null ? null : counselSpecialist.trim();
    }

    public BigDecimal getCounselScore() {
        return counselScore;
    }

    public void setCounselScore(BigDecimal counselScore) {
        this.counselScore = counselScore;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(Byte notificationMode) {
        this.notificationMode = notificationMode;
    }

    public String getCounselEnterpriseName() {
        return counselEnterpriseName;
    }

    public void setCounselEnterpriseName(String counselEnterpriseName) {
        this.counselEnterpriseName = counselEnterpriseName == null ? null : counselEnterpriseName.trim();
    }

    public String getCounselPerson() {
        return counselPerson;
    }

    public void setCounselPerson(String counselPerson) {
        this.counselPerson = counselPerson == null ? null : counselPerson.trim();
    }

    public Date getAppointmentTimeStart() {
        return appointmentTimeStart;
    }

    public void setAppointmentTimeStart(Date appointmentTimeStart) {
        this.appointmentTimeStart = appointmentTimeStart;
    }

    public Date getAppointmentTimeEnd() {
        return appointmentTimeEnd;
    }

    public void setAppointmentTimeEnd(Date appointmentTimeEnd) {
        this.appointmentTimeEnd = appointmentTimeEnd;
    }

    public String getReservationAddress() {
        return reservationAddress;
    }

    public void setReservationAddress(String reservationAddress) {
        this.reservationAddress = reservationAddress == null ? null : reservationAddress.trim();
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
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
        TbPdPersonnelNotificationDetails other = (TbPdPersonnelNotificationDetails) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCoachName() == null ? other.getCoachName() == null : this.getCoachName().equals(other.getCoachName()))
            && (this.getCounselSpecialist() == null ? other.getCounselSpecialist() == null : this.getCounselSpecialist().equals(other.getCounselSpecialist()))
            && (this.getCounselScore() == null ? other.getCounselScore() == null : this.getCounselScore().equals(other.getCounselScore()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNotificationMode() == null ? other.getNotificationMode() == null : this.getNotificationMode().equals(other.getNotificationMode()))
            && (this.getCounselEnterpriseName() == null ? other.getCounselEnterpriseName() == null : this.getCounselEnterpriseName().equals(other.getCounselEnterpriseName()))
            && (this.getCounselPerson() == null ? other.getCounselPerson() == null : this.getCounselPerson().equals(other.getCounselPerson()))
            && (this.getAppointmentTimeStart() == null ? other.getAppointmentTimeStart() == null : this.getAppointmentTimeStart().equals(other.getAppointmentTimeStart()))
            && (this.getAppointmentTimeEnd() == null ? other.getAppointmentTimeEnd() == null : this.getAppointmentTimeEnd().equals(other.getAppointmentTimeEnd()))
            && (this.getReservationAddress() == null ? other.getReservationAddress() == null : this.getReservationAddress().equals(other.getReservationAddress()))
            && (this.getParkAppointmentTimeStart() == null ? other.getParkAppointmentTimeStart() == null : this.getParkAppointmentTimeStart().equals(other.getParkAppointmentTimeStart()))
            && (this.getParkAppointmentTimeEnd() == null ? other.getParkAppointmentTimeEnd() == null : this.getParkAppointmentTimeEnd().equals(other.getParkAppointmentTimeEnd()))
            && (this.getParkReservationAddress() == null ? other.getParkReservationAddress() == null : this.getParkReservationAddress().equals(other.getParkReservationAddress()))
            && (this.getNotifyCounselTimeStart() == null ? other.getNotifyCounselTimeStart() == null : this.getNotifyCounselTimeStart().equals(other.getNotifyCounselTimeStart()))
            && (this.getNotifyCounselTimeEnd() == null ? other.getNotifyCounselTimeEnd() == null : this.getNotifyCounselTimeEnd().equals(other.getNotifyCounselTimeEnd()))
            && (this.getNotifyCounselAddress() == null ? other.getNotifyCounselAddress() == null : this.getNotifyCounselAddress().equals(other.getNotifyCounselAddress()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
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
        result = prime * result + ((getCoachName() == null) ? 0 : getCoachName().hashCode());
        result = prime * result + ((getCounselSpecialist() == null) ? 0 : getCounselSpecialist().hashCode());
        result = prime * result + ((getCounselScore() == null) ? 0 : getCounselScore().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNotificationMode() == null) ? 0 : getNotificationMode().hashCode());
        result = prime * result + ((getCounselEnterpriseName() == null) ? 0 : getCounselEnterpriseName().hashCode());
        result = prime * result + ((getCounselPerson() == null) ? 0 : getCounselPerson().hashCode());
        result = prime * result + ((getAppointmentTimeStart() == null) ? 0 : getAppointmentTimeStart().hashCode());
        result = prime * result + ((getAppointmentTimeEnd() == null) ? 0 : getAppointmentTimeEnd().hashCode());
        result = prime * result + ((getReservationAddress() == null) ? 0 : getReservationAddress().hashCode());
        result = prime * result + ((getParkAppointmentTimeStart() == null) ? 0 : getParkAppointmentTimeStart().hashCode());
        result = prime * result + ((getParkAppointmentTimeEnd() == null) ? 0 : getParkAppointmentTimeEnd().hashCode());
        result = prime * result + ((getParkReservationAddress() == null) ? 0 : getParkReservationAddress().hashCode());
        result = prime * result + ((getNotifyCounselTimeStart() == null) ? 0 : getNotifyCounselTimeStart().hashCode());
        result = prime * result + ((getNotifyCounselTimeEnd() == null) ? 0 : getNotifyCounselTimeEnd().hashCode());
        result = prime * result + ((getNotifyCounselAddress() == null) ? 0 : getNotifyCounselAddress().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
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
        sb.append(", coachName=").append(coachName);
        sb.append(", counselSpecialist=").append(counselSpecialist);
        sb.append(", counselScore=").append(counselScore);
        sb.append(", status=").append(status);
        sb.append(", notificationMode=").append(notificationMode);
        sb.append(", counselEnterpriseName=").append(counselEnterpriseName);
        sb.append(", counselPerson=").append(counselPerson);
        sb.append(", appointmentTimeStart=").append(appointmentTimeStart);
        sb.append(", appointmentTimeEnd=").append(appointmentTimeEnd);
        sb.append(", reservationAddress=").append(reservationAddress);
        sb.append(", parkAppointmentTimeStart=").append(parkAppointmentTimeStart);
        sb.append(", parkAppointmentTimeEnd=").append(parkAppointmentTimeEnd);
        sb.append(", parkReservationAddress=").append(parkReservationAddress);
        sb.append(", notifyCounselTimeStart=").append(notifyCounselTimeStart);
        sb.append(", notifyCounselTimeEnd=").append(notifyCounselTimeEnd);
        sb.append(", notifyCounselAddress=").append(notifyCounselAddress);
        sb.append(", projectId=").append(projectId);
        sb.append(", themeId=").append(themeId);
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