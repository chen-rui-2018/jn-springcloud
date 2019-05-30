package com.jn.oa.attendance.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 考勤定位
 *
 * @author： yuanyy
 * @date： Created on 2019/5/27 18:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AttendanceLocation", description = "考勤定位")
public class AttendanceLocation implements Serializable {

    private String distance;

    private boolean status;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
