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

    private Integer warnPercent;

    private Integer earlyWarnPercent;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getWarnPercent() {
        return warnPercent;
    }

    public void setWarnPercent(Integer warnPercent) {
        this.warnPercent = warnPercent;
    }

    public Integer getEarlyWarnPercent() {
        return earlyWarnPercent;
    }

    public void setEarlyWarnPercent(Integer earlyWarnPercent) {
        this.earlyWarnPercent = earlyWarnPercent;
    }

    @Override
    public String toString() {
        return "TaskStatistics{" +
                "userId='" + userId + '\'' +
                ", warnPercent=" + warnPercent +
                ", earlyWarnPercent=" + earlyWarnPercent +
                '}';
    }
}
