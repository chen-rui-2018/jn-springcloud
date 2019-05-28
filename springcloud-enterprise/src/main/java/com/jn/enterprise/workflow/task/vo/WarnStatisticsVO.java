package com.jn.enterprise.workflow.task.vo;

import java.io.Serializable;

/**
 * 时效性事项统计出参
 * @author： huxw
 * @date： Created on 2019-5-27 18:02:31
 * @version： v1.0
 * @modified By:
 */
public class WarnStatisticsVO implements Serializable {

    private String warnType;

    private String warnNum;

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    @Override
    public String toString() {
        return "WarnStatisticsVO{" +
                "warnType='" + warnType + '\'' +
                ", warnNum='" + warnNum + '\'' +
                '}';
    }
}
