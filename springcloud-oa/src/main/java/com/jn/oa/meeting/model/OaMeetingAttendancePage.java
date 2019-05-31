package com.jn.oa.meeting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议参会人员考勤分页实体
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingAttendancePage", description = "会议参会人员考勤分页实体")
public class OaMeetingAttendancePage extends Page implements Serializable {


    @ApiModelProperty(value = "考勤id")
    private String id;

    @ApiModelProperty(value = "会议开始时间")
    @DateTimeFormat(pattern = "yyyy/MM")
    @JsonFormat(pattern = "yyyy/MM",timezone="GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "会议结束时间")
    @DateTimeFormat(pattern = "yyyy/MM")
    @JsonFormat(pattern = "yyyy/MM",timezone="GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "会议主题")
    private String meetingTitle;

    @ApiModelProperty(value = "预约人姓名")
    private String userName;

    @ApiModelProperty(value = "考勤人员id")
    private String meetingUserId;

    public String getMeetingUserId() {
        return meetingUserId;
    }

    public void setMeetingUserId(String meetingUserId) {
        this.meetingUserId = meetingUserId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}