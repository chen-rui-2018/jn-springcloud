package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 10:30
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityMonitoringPoint",description = "监控点列表查询,监控点信息")
public class SecurityMonitoringPoint implements Serializable {


    private static final long serialVersionUID = -7889206695085014815L;
    @ApiModelProperty(value = "海拔")
    private String altitude;
    @ApiModelProperty(value = "监控点唯一标识")
    private String cameraIndexCode;
    @ApiModelProperty(value = "监控点名称")
    private String cameraName;
    @ApiModelProperty(value = "监控点类型")
    private String cameraType;
    @ApiModelProperty(value = "监控点类型说明")
    private String cameraTypeName;
    @ApiModelProperty(value = "能力集")
    private String capabilitySet;
    @ApiModelProperty(value = "能力集说明")
    private String capabilitySetName;
    @ApiModelProperty(value = "智能分析能力集")
    private String intelligentSet;
    @ApiModelProperty(value = "智能分析能力集说明")
    private String intelligentSetName;
    @ApiModelProperty(value = "通道编号")
    private String channelNo;
    @ApiModelProperty(value = "通道类型")
    private String channelType;
    @ApiModelProperty(value = "通道类型说明")
    private String channelTypeName;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "所属编码设备唯一标识")
    private String encodeDevIndexCode;
    @ApiModelProperty(value = "所属设备类型")
    private String encodeDevResourceType;
    @ApiModelProperty(value = "所属设备类型说明")
    private String encodeDevResourceTypeName;
    @ApiModelProperty(value = "监控点国标编号")
    private String gbIndexCode;
    @ApiModelProperty(value = "安装位置")
    private String installLocation;
    @ApiModelProperty(value = "键盘控制码")
    private String keyBoardCode;
    @ApiModelProperty(value = "纬度")
    private String latitude;
    @ApiModelProperty(value = "经度")
    private String longitude;
    @ApiModelProperty(value = "摄像机像素（1-普通像素，2-130万高清，3-200万高清，4-300万高清）")
    private String pixel;
    @ApiModelProperty(value = "云镜类型（1-全方位云台（带转动和变焦），2-只有变焦,不带转动，3-只有转动，不带变焦，4-无云台，无变焦）")
    private String ptz;
    @ApiModelProperty(value = "云镜类型说明")
    private String ptzName;
    @ApiModelProperty(value = "云台控制(1-DVR，2-模拟矩阵，3-MU4000，4-NC600)")
    private String ptzController;
    @ApiModelProperty(value = "云台控制说明")
    private String ptzControllerName;
    @ApiModelProperty(value = "录像存储位置")
    private String recordLocation;
    @ApiModelProperty(value = "录像存储位置说明")
    private String recordLocationName;
    @ApiModelProperty(value = "所属区域唯一标识")
    private String regionIndexCode;
    @ApiModelProperty(value = "在线状态（0-未知，1-在线，2-离线）")
    private String status;
    @ApiModelProperty(value = "状态说明")
    private String statusName;
    @ApiModelProperty(value = "传输协议")
    private String transType;
    @ApiModelProperty(value = "传输协议类型说明")
    private String transTypeName;
    @ApiModelProperty(value = "接入协议")
    private String treatyType;
    @ApiModelProperty(value = "接入协议类型说明")
    private String treatyTypeName;
    @ApiModelProperty(value = "可视域相关（JSON格式）")
    private String viewshed;
    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getCameraIndexCode() {
        return cameraIndexCode;
    }

    public void setCameraIndexCode(String cameraIndexCode) {
        this.cameraIndexCode = cameraIndexCode;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
    }

    public String getCameraTypeName() {
        return cameraTypeName;
    }

    public void setCameraTypeName(String cameraTypeName) {
        this.cameraTypeName = cameraTypeName;
    }

    public String getCapabilitySet() {
        return capabilitySet;
    }

    public void setCapabilitySet(String capabilitySet) {
        this.capabilitySet = capabilitySet;
    }

    public String getCapabilitySetName() {
        return capabilitySetName;
    }

    public void setCapabilitySetName(String capabilitySetName) {
        this.capabilitySetName = capabilitySetName;
    }

    public String getIntelligentSet() {
        return intelligentSet;
    }

    public void setIntelligentSet(String intelligentSet) {
        this.intelligentSet = intelligentSet;
    }

    public String getIntelligentSetName() {
        return intelligentSetName;
    }

    public void setIntelligentSetName(String intelligentSetName) {
        this.intelligentSetName = intelligentSetName;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelTypeName() {
        return channelTypeName;
    }

    public void setChannelTypeName(String channelTypeName) {
        this.channelTypeName = channelTypeName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEncodeDevIndexCode() {
        return encodeDevIndexCode;
    }

    public void setEncodeDevIndexCode(String encodeDevIndexCode) {
        this.encodeDevIndexCode = encodeDevIndexCode;
    }

    public String getEncodeDevResourceType() {
        return encodeDevResourceType;
    }

    public void setEncodeDevResourceType(String encodeDevResourceType) {
        this.encodeDevResourceType = encodeDevResourceType;
    }

    public String getEncodeDevResourceTypeName() {
        return encodeDevResourceTypeName;
    }

    public void setEncodeDevResourceTypeName(String encodeDevResourceTypeName) {
        this.encodeDevResourceTypeName = encodeDevResourceTypeName;
    }

    public String getGbIndexCode() {
        return gbIndexCode;
    }

    public void setGbIndexCode(String gbIndexCode) {
        this.gbIndexCode = gbIndexCode;
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public String getKeyBoardCode() {
        return keyBoardCode;
    }

    public void setKeyBoardCode(String keyBoardCode) {
        this.keyBoardCode = keyBoardCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel;
    }

    public String getPtz() {
        return ptz;
    }

    public void setPtz(String ptz) {
        this.ptz = ptz;
    }

    public String getPtzName() {
        return ptzName;
    }

    public void setPtzName(String ptzName) {
        this.ptzName = ptzName;
    }

    public String getPtzController() {
        return ptzController;
    }

    public void setPtzController(String ptzController) {
        this.ptzController = ptzController;
    }

    public String getPtzControllerName() {
        return ptzControllerName;
    }

    public void setPtzControllerName(String ptzControllerName) {
        this.ptzControllerName = ptzControllerName;
    }

    public String getRecordLocation() {
        return recordLocation;
    }

    public void setRecordLocation(String recordLocation) {
        this.recordLocation = recordLocation;
    }

    public String getRecordLocationName() {
        return recordLocationName;
    }

    public void setRecordLocationName(String recordLocationName) {
        this.recordLocationName = recordLocationName;
    }

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransTypeName() {
        return transTypeName;
    }

    public void setTransTypeName(String transTypeName) {
        this.transTypeName = transTypeName;
    }

    public String getTreatyType() {
        return treatyType;
    }

    public void setTreatyType(String treatyType) {
        this.treatyType = treatyType;
    }

    public String getTreatyTypeName() {
        return treatyTypeName;
    }

    public void setTreatyTypeName(String treatyTypeName) {
        this.treatyTypeName = treatyTypeName;
    }

    public String getViewshed() {
        return viewshed;
    }

    public void setViewshed(String viewshed) {
        this.viewshed = viewshed;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SecurityMonitoringPoint{" +
                "altitude='" + altitude + '\'' +
                ", cameraIndexCode='" + cameraIndexCode + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", cameraType='" + cameraType + '\'' +
                ", cameraTypeName='" + cameraTypeName + '\'' +
                ", capabilitySet='" + capabilitySet + '\'' +
                ", capabilitySetName='" + capabilitySetName + '\'' +
                ", intelligentSet='" + intelligentSet + '\'' +
                ", intelligentSetName='" + intelligentSetName + '\'' +
                ", channelNo='" + channelNo + '\'' +
                ", channelType='" + channelType + '\'' +
                ", channelTypeName='" + channelTypeName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", encodeDevIndexCode='" + encodeDevIndexCode + '\'' +
                ", encodeDevResourceType='" + encodeDevResourceType + '\'' +
                ", encodeDevResourceTypeName='" + encodeDevResourceTypeName + '\'' +
                ", gbIndexCode='" + gbIndexCode + '\'' +
                ", installLocation='" + installLocation + '\'' +
                ", keyBoardCode='" + keyBoardCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", pixel='" + pixel + '\'' +
                ", ptz='" + ptz + '\'' +
                ", ptzName='" + ptzName + '\'' +
                ", ptzController='" + ptzController + '\'' +
                ", ptzControllerName='" + ptzControllerName + '\'' +
                ", recordLocation='" + recordLocation + '\'' +
                ", recordLocationName='" + recordLocationName + '\'' +
                ", regionIndexCode='" + regionIndexCode + '\'' +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", transType='" + transType + '\'' +
                ", transTypeName='" + transTypeName + '\'' +
                ", treatyType='" + treatyType + '\'' +
                ", treatyTypeName='" + treatyTypeName + '\'' +
                ", viewshed='" + viewshed + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}

