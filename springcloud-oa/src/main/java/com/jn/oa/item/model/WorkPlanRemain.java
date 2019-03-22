package com.jn.oa.item.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 工作计划提醒实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/20 19:44
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanRemain", description = "工作计划提醒实体")
public class WorkPlanRemain implements Serializable {
    private static final long serialVersionUID = 6307771331587573572L;
    @ApiModelProperty(value = "工作计划id")
    private String id;

    @ApiModelProperty(value = "工作计划名称")
    private String workPlanName;

    @ApiModelProperty(value = "计划结束时间")
    private String planEndTime;

    public WorkPlanRemain() {
    }

    public WorkPlanRemain(String id, String workPlanName, String planEndTime) {
        this.id = id;
        this.workPlanName = workPlanName;
        this.planEndTime = planEndTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    @Override
    public String toString() {
        return "WorkPlanRemain{" +
                "id='" + id + '\'' +
                ", workPlanName='" + workPlanName + '\'' +
                ", planEndTime='" + planEndTime + '\'' +
                '}';
    }
}
