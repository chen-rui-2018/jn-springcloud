package com.jn.oa.meeting.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 会议参会人员考勤实体
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingParticipantsAttendance", description = "会议参会人员考勤实体")
public class OaMeetingParticipantsAttendance implements Serializable {


    @ApiModelProperty(value = "会议id")
    private String meetingId;


    @ApiModelProperty(value = "会议考勤签到/签退类型:1:签到，2：签退")
   private String meetingAttendanceType;


    private static final long serialVersionUID = 1L;


    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId == null ? null : meetingId.trim();
    }

    public String getMeetingAttendanceType() {
        return meetingAttendanceType;
    }

    public void setMeetingAttendanceType(String meetingAttendanceType) {
        this.meetingAttendanceType = meetingAttendanceType;
    }
}