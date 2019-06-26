package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @ClassName：钉钉 ： 请假状态信息
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/18 15:38
 * @Version： v1.0
 * @Modified By:
 */
public class LeaveStatusInfo implements Serializable {

    private static final long serialVersionUID = 2290067778449237143L;

    /**
     * 请假单位：“percent_day”表示天，“percent_hour”表示小时
    * */
    @JsonProperty("duration_unit")
    private String durationUnit;

    /**
     * 假期时长*100，例如用户请假时长为1天，该值就等于100
     * */
    @JsonProperty("duration_percent")
    private String durationPercent;

    /**
     * 请假开始时间，时间戳
     * */
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * 请假结束时间，时间戳
     * */
    @JsonProperty("end_time")
    private Long endTime;

    /**
     * 用户id
     * */
    private String userid;


    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getDurationPercent() {
        return durationPercent;
    }

    public void setDurationPercent(String durationPercent) {
        this.durationPercent = durationPercent;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "LeaveStatusInfo{" +
                "durationUnit='" + durationUnit + '\'' +
                ", durationPercent='" + durationPercent + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userid='" + userid + '\'' +
                '}';
    }
}
