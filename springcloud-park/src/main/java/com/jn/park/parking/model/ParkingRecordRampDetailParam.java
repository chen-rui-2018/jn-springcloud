package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingRecordRampDetailParam",description = "停车记录匝道调用入库Bean[仅作为dao入参]")
public class ParkingRecordRampDetailParam implements Serializable {

    @ApiModelProperty(value = "匝道ID",example = "23w2")
    private String gateId;
    @ApiModelProperty(value = "停车记录id",example = "23w2")
    private String parkingId;
    @ApiModelProperty(value = "同步过来的消息id",example = "5895425")
    private String messageId;
    @ApiModelProperty(value = "车牌",example = "苏A00001")
    private String carLicense;
    @ApiModelProperty(value = "入场时间")
    private Date admissionTime;
    @ApiModelProperty(value = "离场时间")
    private Date departureTime;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ParkingRecordRampDetailParam{" +
                "gateId='" + gateId + '\'' +
                ", parkingId='" + parkingId + '\'' +
                ", messageId='" + messageId + '\'' +
                ", carLicense='" + carLicense + '\'' +
                ", admissionTime=" + admissionTime +
                ", departureTime=" + departureTime +
                ", createdTime=" + createdTime +
                '}';
    }
}
