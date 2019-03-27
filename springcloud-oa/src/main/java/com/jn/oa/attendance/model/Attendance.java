package com.jn.oa.attendance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 考勤实体
 *
 * @author： yuanyy
 * @date： Created on 2019/3/21 20:19
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "Attendance", description = "考勤实体")
public class Attendance implements Serializable {

    private static final long serialVersionUID = -5671809054725364233L;
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "考勤人员id")
    private String attendanceUser;

    @ApiModelProperty(value = "参会类型：1：签到，2:签到")
    private String type;

    @ApiModelProperty(value = "签到时间/签退时间")
    private Date attendanceTime;

    @ApiModelProperty(value = "考勤平台：1：PC，2：APP，3：钉钉")
    private String attendancePlatform;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value = "最新更新时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "打卡定位经度")
    private String longitude;

    @ApiModelProperty(value = "打卡定位纬度")
    private String latitude;

    @ApiModelProperty(value = "打卡IP")
    private String attendanceIp;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttendanceUser() {
        return attendanceUser;
    }

    public void setAttendanceUser(String attendanceUser) {
        this.attendanceUser = attendanceUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getAttendancePlatform() {
        return attendancePlatform;
    }

    public void setAttendancePlatform(String attendancePlatform) {
        this.attendancePlatform = attendancePlatform;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAttendanceIp() {
        return attendanceIp;
    }

    public void setAttendanceIp(String attendanceIp) {
        this.attendanceIp = attendanceIp;
    }
}