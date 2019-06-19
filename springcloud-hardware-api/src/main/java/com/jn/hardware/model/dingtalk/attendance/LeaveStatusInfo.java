package com.jn.hardware.model.dingtalk.attendance;

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
    private String duration_unit;

    /**
     * 假期时长*100，例如用户请假时长为1天，该值就等于100
     * */
    private String duration_percent;

    /**
     * 请假开始时间，时间戳
     * */
    private String start_time;

    /**
     * 请假结束时间，时间戳
     * */
    private String end_time;

    /**
     * 用户id
     * */
    private String userid;


    public String getDuration_unit() {
        return duration_unit;
    }

    public void setDuration_unit(String duration_unit) {
        this.duration_unit = duration_unit;
    }

    public String getDuration_percent() {
        return duration_percent;
    }

    public void setDuration_percent(String duration_percent) {
        this.duration_percent = duration_percent;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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
                "duration_unit='" + duration_unit + '\'' +
                ", duration_percent='" + duration_percent + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
