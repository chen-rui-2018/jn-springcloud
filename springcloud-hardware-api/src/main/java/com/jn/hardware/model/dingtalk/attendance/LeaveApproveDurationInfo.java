package com.jn.hardware.model.dingtalk.attendance;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("duration_in_minutes")
    private String durationInMinutes;

    public String getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(String durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
