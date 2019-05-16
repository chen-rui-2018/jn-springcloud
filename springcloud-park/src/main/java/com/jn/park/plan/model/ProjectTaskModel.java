package com.jn.park.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
@ApiModel(value = "ProjectTaskModel",description = "任务表")
public class ProjectTaskModel implements Serializable {
    private static final long serialVersionUID = -6836393562994194163L;

    @ApiModelProperty(value = "任务名")
    private String taskName;

    @ApiModelProperty(value = "任务当前进度")
    private String nowadaysProgress;

    @ApiModelProperty(value = "任务状态 (默认0;0未到;1延期;2正常;3提前)")
    private String taskState;

    @ApiModelProperty(value = "与计划相差时间")
    private String expectDifferTime;

    @ApiModelProperty(value = "任务评价")
    private String appraise;

    @ApiModelProperty(value = "计划开始时间")
    private String planStartTime;

    @ApiModelProperty(value = "计划结束时间")
    private String planStopTime;

    @ApiModelProperty(value = "实际开始时间")
    private String actualBeginTime;

    @ApiModelProperty(value = "实际结束时间")
    private String actualEndTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNowadaysProgress() {
        return nowadaysProgress;
    }

    public void setNowadaysProgress(String nowadaysProgress) {
        this.nowadaysProgress = nowadaysProgress;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getExpectDifferTime() {
        return expectDifferTime;
    }

    public void setExpectDifferTime(String expectDifferTime) {
        this.expectDifferTime = expectDifferTime;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getPlanStopTime() {
        return planStopTime;
    }

    public void setPlanStopTime(String planStopTime) {
        this.planStopTime = planStopTime;
    }

    public String getActualBeginTime() {
        return actualBeginTime;
    }

    public void setActualBeginTime(String actualBeginTime) {
        this.actualBeginTime = actualBeginTime;
    }

    public String getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(String actualEndTime) {
        this.actualEndTime = actualEndTime;
    }


    @Override
    public String toString() {
        return "ProjectTaskModel{" +
                "taskName='" + taskName + '\'' +
                ", nowadaysProgress='" + nowadaysProgress + '\'' +
                ", taskState='" + taskState + '\'' +
                ", expectDifferTime='" + expectDifferTime + '\'' +
                ", appraise='" + appraise + '\'' +
                ", planStartTime='" + planStartTime + '\'' +
                ", planStopTime='" + planStopTime + '\'' +
                ", actualBeginTime='" + actualBeginTime + '\'' +
                ", actualEndTime='" + actualEndTime + '\'' +
                '}';
    }
}
