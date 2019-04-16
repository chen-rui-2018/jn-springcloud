package com.jn.oa.attendance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
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
public class Attendance extends Page implements Serializable  {

    private static final long serialVersionUID = -5671809054725364233L;
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "考勤人员id")
    private String attendanceUser;

    @ApiModelProperty(value = "签到时间")
    private Date signInAttendanceTime;

    @ApiModelProperty(value = "签到考勤平台：1：PC，2：APP，3：钉钉")
    private String signInAttendancePlatform;

    @ApiModelProperty(value = "签到定位经度")
    private String signInLongitude;

    @ApiModelProperty(value = "签到定位纬度")
    private String signInLatitude;

    @ApiModelProperty(value = "签到IP")
    private String signInAttendanceIp;

    @ApiModelProperty(value = "签退时间")
    private Date signOutAttendanceTime;

    @ApiModelProperty(value = "签退平台")
    private String signOutAttendancePlatform;

    @ApiModelProperty(value = "签退考勤平台：1：PC，2：APP，3：钉钉")
    private String signOutLongitude;

    @ApiModelProperty(value = "签退定位经度")
    private String signOutLatitude;

    @ApiModelProperty(value = "签退定位纬度")
    private String signOutAttendanceIp;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value = "最新更新时间")
    private Date modifiedTime;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAttendanceUser() {
        return attendanceUser;
    }

    public void setAttendanceUser(String attendanceUser) {
        this.attendanceUser = attendanceUser;
    }


    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getSignInAttendanceTime() {
        return signInAttendanceTime;
    }

    public void setSignInAttendanceTime(Date signInAttendanceTime) {
        this.signInAttendanceTime = signInAttendanceTime;
    }

    public String getSignInAttendancePlatform() {
        return signInAttendancePlatform;
    }

    public void setSignInAttendancePlatform(String signInAttendancePlatform) {
        this.signInAttendancePlatform = signInAttendancePlatform;
    }

    public String getSignInLongitude() {
        return signInLongitude;
    }

    public void setSignInLongitude(String signInLongitude) {
        this.signInLongitude = signInLongitude;
    }

    public String getSignInLatitude() {
        return signInLatitude;
    }

    public void setSignInLatitude(String signInLatitude) {
        this.signInLatitude = signInLatitude;
    }

    public String getSignInAttendanceIp() {
        return signInAttendanceIp;
    }

    public void setSignInAttendanceIp(String signInAttendanceIp) {
        this.signInAttendanceIp = signInAttendanceIp;
    }

    public Date getSignOutAttendanceTime() {
        return signOutAttendanceTime;
    }

    public void setSignOutAttendanceTime(Date signOutAttendanceTime) {
        this.signOutAttendanceTime = signOutAttendanceTime;
    }

    public String getSignOutAttendancePlatform() {
        return signOutAttendancePlatform;
    }

    public void setSignOutAttendancePlatform(String signOutAttendancePlatform) {
        this.signOutAttendancePlatform = signOutAttendancePlatform;
    }

    public String getSignOutLongitude() {
        return signOutLongitude;
    }

    public void setSignOutLongitude(String signOutLongitude) {
        this.signOutLongitude = signOutLongitude;
    }

    public String getSignOutLatitude() {
        return signOutLatitude;
    }

    public void setSignOutLatitude(String signOutLatitude) {
        this.signOutLatitude = signOutLatitude;
    }

    public String getSignOutAttendanceIp() {
        return signOutAttendanceIp;
    }

    public void setSignOutAttendanceIp(String signOutAttendanceIp) {
        this.signOutAttendanceIp = signOutAttendanceIp;
    }
}