package com.jn.enterprise.workflow.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 时效性数据列表出参
 * @author： huxw
 * @date： Created on 2019-5-31 20:06:20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TaskListVO", description = "时效性数据列表出参")
public class TaskListVO implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "主题")
    private String title;
    @ApiModelProperty(value = "事项分类（1：数据上报 2：综合缴费 3：综合租赁）")
    private String type;
    @ApiModelProperty(value = "链接类型（1：h5 2:原生app链接）")
    private String linkType;
    @ApiModelProperty(value = "链接地址")
    private String linkUrl;
    @ApiModelProperty(value = "事项描述")
    private String describes;
    @ApiModelProperty(value = "事项状态（1：待办 2：已办）")
    private String status;
    @ApiModelProperty(value = "总天数")
    private String totalDay;
    @ApiModelProperty(value = "剩余天数")
    private String subDay;
    @ApiModelProperty(value = "剩余日期百分比")
    private String percent;
    @ApiModelProperty(value = "事项状态（1：过期 0：正常）")
    private String taskStatus;
    @ApiModelProperty(value = "事项预警状态（2：警告 1：预警 0：正常）")
    private String taskWarnStatus;
    @ApiModelProperty(value = "事项创建时间")
    private String createdTime;
    @ApiModelProperty(value = "事项截止时间")
    private String endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(String totalDay) {
        this.totalDay = totalDay;
    }

    public String getSubDay() {
        return subDay;
    }

    public void setSubDay(String subDay) {
        this.subDay = subDay;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskWarnStatus() {
        return taskWarnStatus;
    }

    public void setTaskWarnStatus(String taskWarnStatus) {
        this.taskWarnStatus = taskWarnStatus;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TaskListVO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", linkType='" + linkType + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", describes='" + describes + '\'' +
                ", status='" + status + '\'' +
                ", totalDay='" + totalDay + '\'' +
                ", subDay='" + subDay + '\'' +
                ", percent='" + percent + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskWarnStatus='" + taskWarnStatus + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
