package com.jn.enterprise.pd.personnel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约辅导实体类
 *
 * @author： wzy
 * @date： Created on 2019/3/18 19:02
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PersonnelAppointmentCounselModel", description = "预约辅导实体类")
public class PersonnelAppointmentCounselModel extends Page implements Serializable {

    private static final long serialVersionUID = -153708031116707712L;
    @ApiModelProperty(value="唯一标识符")
    private Integer id;

    @ApiModelProperty(value="主题")
    private String theme;

    @ApiModelProperty(value="园区发送预约时间始")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date parkAppointmentTimeStart;

    @ApiModelProperty(value="园区发送预约时间止")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date parkAppointmentTimeEnd;

    @ApiModelProperty(value="园区发送预约辅导地点")
    private String parkReservationAddress;

    @ApiModelProperty(value="实际辅导时间始")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date notifyCounselTimeStart;

    @ApiModelProperty(value="实际辅导时间止")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date notifyCounselTimeEnd;

    @ApiModelProperty(value="实际辅导地址")
    private String notifyCounselAddress;

    @ApiModelProperty(value="预约人数限制")
    private Integer reservationLimit;

    @ApiModelProperty(value="截止预约时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date deadline;

    @ApiModelProperty(value="辅导类型（1：区级计划书辅导，2：区级答辩辅导，3：市级计划书辅导，4：市级答辩辅导）")
    private Byte counselType;

    @ApiModelProperty(value="状态（1：已使用，2：未使用）")
    private Byte status;

    @ApiModelProperty(value="是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value="创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value="创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value="最新更新时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

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
        this.theme = theme;
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
        this.parkReservationAddress = parkReservationAddress;
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
        this.notifyCounselAddress = notifyCounselAddress;
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
}
