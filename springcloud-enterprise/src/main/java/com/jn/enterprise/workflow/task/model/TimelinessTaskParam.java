package com.jn.enterprise.workflow.task.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 时效性事项任务入参
 * @author： huxw
 * @date： Created on 2019-5-31 20:18:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TimelinessTaskParam", description = "时效性事项任务入参")
public class TimelinessTaskParam implements Serializable {

    @ApiModelProperty(value = "事项状态：1：待办、2：已办" , hidden = true)
    @Pattern(regexp = "^[12]$", message = "事项状态校检错误")
    private String status;

    @ApiModelProperty(value = "事项分类（1：数据上报 2：综合缴费 3：综合租赁）")
    @Pattern(regexp = "^[1-3]|\\s*$", message = "事项分类校检错误")
    private String type;

    @ApiModelProperty(value = "用户id'", hidden = true)
    private String userId;

    @ApiModelProperty(value = "报警时间（单位：百分比）", hidden = true)
    private Integer warnPercent;

    @ApiModelProperty(value = "预警时间（单位：百分比）", hidden = true)
    private Integer earlyWarnPercent;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
        return "TimelinessTaskParam{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", userId='" + userId + '\'' +
                ", warnPercent=" + warnPercent +
                ", earlyWarnPercent=" + earlyWarnPercent +
                '}';
    }
}
