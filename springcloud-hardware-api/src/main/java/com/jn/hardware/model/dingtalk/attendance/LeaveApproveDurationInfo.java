package com.jn.hardware.model.dingtalk.attendance;

import java.io.Serializable;

/**
 * @ClassName：钉钉：请假时长
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/19 17:46
 * @Version： v1.0
 * @Modified By:
 */
public class LeaveApproveDurationInfo implements Serializable {

    private static final long serialVersionUID = 5070778528505991489L;

    /**
     * 请假时长（单位分钟）
     * */
    private String duration_in_minutes;

    public String getDuration_in_minutes() {
        return duration_in_minutes;
    }

    public void setDuration_in_minutes(String duration_in_minutes) {
        this.duration_in_minutes = duration_in_minutes;
    }

    @Override
    public String toString() {
        return "LeaveApproveDurationInfo{" +
                "duration_in_minutes='" + duration_in_minutes + '\'' +
                '}';
    }
}
