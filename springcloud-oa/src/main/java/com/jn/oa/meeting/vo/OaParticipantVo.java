package com.jn.oa.meeting.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "OaParticipantVo", description = "会议申请参会人员vo")
public class OaParticipantVo implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "会议id")
    private String meetingId;

    @ApiModelProperty(value = "参会人员id")
    private String meetingUserId;

    @ApiModelProperty(value = "签到时间")
    private Date signInTime;

    @ApiModelProperty(value = "签退时间")
    private Date signBackTime;

    @ApiModelProperty(value = "考勤状态（0:正常、1:缺勤、2:迟到、3:早退）")
    private String attendanceStatus;

    @ApiModelProperty(value = " 是否删除（0标记删除，1正常）")

    private Byte recordStatus;
    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "账号")
    private String account;

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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId == null ? null : meetingId.trim();
    }

    public String getMeetingUserId() {
        return meetingUserId;
    }

    public void setMeetingUserId(String meetingUserId) {
        this.meetingUserId = meetingUserId == null ? null : meetingUserId.trim();
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

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus == null ? null : attendanceStatus.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }


}