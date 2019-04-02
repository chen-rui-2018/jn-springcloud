package com.jn.oa.attendance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 添加考勤实体
 *
 * @author： yuanyy
 * @date： Created on 2019/3/21 20:19
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "AttendanceAdd", description = "添加考勤实体")
public class AttendanceAdd implements Serializable {

    private static final long serialVersionUID = -5671809054725363343L;
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "考勤人员id")
    private String attendanceUser;

    @ApiModelProperty(value = "考勤类型：1：签到，2:签退")
    private String type;

    @ApiModelProperty(value = "考勤平台：1：PC，2：APP，3：钉钉")
    private String attendancePlatform;

    @ApiModelProperty(value = "打卡定位经度")
    private String longitude;

    @ApiModelProperty(value = "打卡定位纬度")
    private String latitude;

    @ApiModelProperty(value = "打卡IP")
    private String attendanceIp;


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

    public String getAttendancePlatform() {
        return attendancePlatform;
    }

    public void setAttendancePlatform(String attendancePlatform) {
        this.attendancePlatform = attendancePlatform;
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