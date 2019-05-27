package com.jn.oa.attendance.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回考勤实体
 *
 * @author： yuanyy
 * @date： Created on 2019/3/21 20:19
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "AttendanceResultVo", description = "返回考勤实体")
public class AttendanceResultVo implements Serializable {

    private static final long serialVersionUID = -5671809053225363343L;
    @ApiModelProperty(value = "打卡时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date attendanceTime;

    @ApiModelProperty(value = "参会类型：1：签到，2:签退")
    private String type;

    @ApiModelProperty(value = "迟到/早退的分钟")
    private String minute;

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}