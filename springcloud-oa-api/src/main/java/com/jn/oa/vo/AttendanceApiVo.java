package com.jn.oa.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
public class AttendanceApiVo implements Serializable  {

    private static final long serialVersionUID = -5671809054725364233L;

    @ApiModelProperty(value = "考勤人员id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "部门")
    private String departmentName;

    @ApiModelProperty(value = "部门id")
    private String departmentId;

    @ApiModelProperty(value = "签到时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date signInAttendanceTime;


    @ApiModelProperty(value = "签退时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date signOutAttendanceTime;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getSignInAttendanceTime() {
        return signInAttendanceTime;
    }

    public void setSignInAttendanceTime(Date signInAttendanceTime) {
        this.signInAttendanceTime = signInAttendanceTime;
    }

    public Date getSignOutAttendanceTime() {
        return signOutAttendanceTime;
    }

    public void setSignOutAttendanceTime(Date signOutAttendanceTime) {
        this.signOutAttendanceTime = signOutAttendanceTime;
    }
}