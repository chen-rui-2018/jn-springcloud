package com.jn.enterprise.workflow.task.model;

import java.io.Serializable;

/**
 * 时效性事项统计入参
 * @author： huxw
 * @date： Created on 2019-5-27 18:00:26
 * @version： v1.0
 * @modified By:
 */
public class TaskStatistics implements Serializable {

    private String userId;

    private Integer warnHour;

    private Integer earlyWarnHour;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getWarnHour() {
        return warnHour;
    }

    public void setWarnHour(Integer warnHour) {
        this.warnHour = warnHour;
    }

    public Integer getEarlyWarnHour() {
        return earlyWarnHour;
    }

    public void setEarlyWarnHour(Integer earlyWarnHour) {
        this.earlyWarnHour = earlyWarnHour;
    }

    @Override
    public String toString() {
        return "TaskStatistics{" +
                "userId='" + userId + '\'' +
                ", warnHour=" + warnHour +
                ", earlyWarnHour=" + earlyWarnHour +
                '}';
    }
}
