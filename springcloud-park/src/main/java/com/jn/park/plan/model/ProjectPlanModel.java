package com.jn.park.plan.model;


/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "ProjectPlanModel",description = "任务进展")
public class ProjectPlanModel implements Serializable {
    private static final long serialVersionUID = 8521493340720623837L;

    @ApiModelProperty(value = "总数")
    private String total;

    @ApiModelProperty(value = "未开始")
    private String noStart;

    @ApiModelProperty(value = "已完成")
    private String complete;

    @ApiModelProperty(value = "未完成")
    private String unComplete;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNoStart() {
        return noStart;
    }

    public void setNoStart(String noStart) {
        this.noStart = noStart;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getUnComplete() {
        return unComplete;
    }

    public void setUnComplete(String unComplete) {
        this.unComplete = unComplete;
    }

    @Override
    public String toString() {
        return "ProjectPlanModel{" +
                "total='" + total + '\'' +
                ", noStart='" + noStart + '\'' +
                ", complete='" + complete + '\'' +
                ", unComplete='" + unComplete + '\'' +
                '}';
    }
}
