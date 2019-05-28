package com.jn.enterprise.workflow.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 时效性事项统计出参
 * @author： huxw
 * @date： Created on 2019-5-27 18:02:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TaskStatisticsVO", description = "时效性事项统计出参")
public class TaskStatisticsVO implements Serializable {

    @ApiModelProperty(value = "报警待办事项数量")
    private Integer warnNum;

    @ApiModelProperty(value = "预警待办事项数量")
    private Integer earlyWarnNum;

    @ApiModelProperty(value = "普通待办事项数量")
    private Integer normalNum;

    @ApiModelProperty(value = "总数")
    private Integer totalNum;

    public Integer getWarnNum() {
        return warnNum;
    }

    public void setWarnNum(Integer warnNum) {
        this.warnNum = warnNum;
    }

    public Integer getEarlyWarnNum() {
        return earlyWarnNum;
    }

    public void setEarlyWarnNum(Integer earlyWarnNum) {
        this.earlyWarnNum = earlyWarnNum;
    }

    public Integer getNormalNum() {
        return normalNum;
    }

    public void setNormalNum(Integer normalNum) {
        this.normalNum = normalNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "TaskStatisticsVO{" +
                "warnNum=" + warnNum +
                ", earlyWarnNum=" + earlyWarnNum +
                ", normalNum=" + normalNum +
                ", totalNum=" + totalNum +
                '}';
    }
}
