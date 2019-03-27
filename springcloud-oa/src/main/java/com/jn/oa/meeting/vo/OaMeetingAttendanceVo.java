package com.jn.oa.meeting.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.oa.meeting.entity.TbOaMeetingRoomPhoto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 会议参会人员考勤会议vo
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingParticipantsAttendanceVo", description = "会议参会人员考勤会议vo")
public class OaMeetingAttendanceVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会议id")
    private String meetingId;

    @ApiModelProperty(value = "考勤id")
    private String id;

    @ApiModelProperty(value = "考勤人员id")
    private String meetingUserId;

    @ApiModelProperty(value = "签到时间")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date signInTime;

    @ApiModelProperty(value = "签退时间")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date signBackTime;

    @ApiModelProperty(value = "考勤人员部门")
    private String departmentName;

    @ApiModelProperty(value = "考勤人员account")
    private String account;

    @ApiModelProperty(value = "考勤人员用户名")
    private String userName;

    @ApiModelProperty(value = "签到状态")
    private String signInStatus;

    @ApiModelProperty(value = "签退状态")
    private String signOutStatus;

    @ApiModelProperty(value = "会议申请")
    private OaMeetingParticipantVo oaMeetingVo;

    public OaMeetingParticipantVo getOaMeetingVo() {
        return oaMeetingVo;
    }

    public void setOaMeetingVo(OaMeetingParticipantVo oaMeetingVo) {
        this.oaMeetingVo = oaMeetingVo;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeetingUserId() {
        return meetingUserId;
    }

    public void setMeetingUserId(String meetingUserId) {
        this.meetingUserId = meetingUserId;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignBackTime() {
        return signBackTime;
    }

    public void setSignBackTime(Date signBackTime) {
        this.signBackTime = signBackTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignInStatus() {
        return signInStatus;
    }

    public void setSignInStatus(String signInStatus) {
        this.signInStatus = signInStatus;
    }

    public String getSignOutStatus() {
        return signOutStatus;
    }

    public void setSignOutStatus(String signOutStatus) {
        this.signOutStatus = signOutStatus;
    }

}