package com.jn.park.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.checkerframework.checker.units.qual.A;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/5/11
 * @Version 1.0
 */
@ApiModel(value = "ProjectManageModel",description = "工程项目管理")
public class ProjectManageModel implements Serializable {

    private static final long serialVersionUID = -2062375411045770663L;

    @ApiModelProperty(value = "项目编号")
    private String projectNo;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目进度")
    private String progress;

    @ApiModelProperty(value = "项目计划开始时间")
    private String planStartTime;

    @ApiModelProperty(value = "项目计划截止时间")
    private String planStopTime;

    @ApiModelProperty(value = "项目剩余任务量")
    private String projectSurplusTask;

    @ApiModelProperty(value = "项目剩余工期")
    private String surplusTime;

    @ApiModelProperty(value = "当前时间")
    private String nowTime;

    @ApiModelProperty(value = "工程状态(2已完成;1 进行中;0 未开始)")
    private String projectState;

    @ApiModelProperty(value = "进度记录")
    ProjectProgressRecordArrayModel arrayModel;

    @ApiModelProperty(value = "进度记录-test")
    List<ProjectProgressRecordModel> projectProgressRecordModels;


    /*@ApiModelProperty(value = "排序字段(空格隔开)desc/asc(project_no:项目编号/surplus_time:剩余工期/progress:进度)默认project_no desc",example = "project_no desc")
    private String  orderByClause;*/


    public ProjectProgressRecordArrayModel getArrayModel() {
        return arrayModel;
    }

    public void setArrayModel(ProjectProgressRecordArrayModel arrayModel) {
        this.arrayModel = arrayModel;
    }

    public String getProjectState() {
        return projectState;
    }


    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
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

    public String getProjectSurplusTask() {
        return projectSurplusTask;
    }

    public void setProjectSurplusTask(String projectSurplusTask) {
        this.projectSurplusTask = projectSurplusTask;
    }

    public String getSurplusTime() {
        return surplusTime;
    }

    public void setSurplusTime(String surplusTime) {
        this.surplusTime = surplusTime;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public List<ProjectProgressRecordModel> getProjectProgressRecordModels() {
        return projectProgressRecordModels;
    }

    public void setProjectProgressRecordModels(List<ProjectProgressRecordModel> projectProgressRecordModels) {
        this.projectProgressRecordModels = projectProgressRecordModels;
    }


    @Override
    public String toString() {
        return "ProjectManageModel{" +
                "projectNo='" + projectNo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", progress='" + progress + '\'' +
                ", planStartTime='" + planStartTime + '\'' +
                ", planStopTime='" + planStopTime + '\'' +
                ", projectSurplusTask='" + projectSurplusTask + '\'' +
                ", surplusTime='" + surplusTime + '\'' +
                ", nowTime='" + nowTime + '\'' +
                ", projectState='" + projectState + '\'' +
                ", projectProgressRecordModels=" + projectProgressRecordModels +
                ", arrayModel=" + arrayModel +
                '}';
    }
}
