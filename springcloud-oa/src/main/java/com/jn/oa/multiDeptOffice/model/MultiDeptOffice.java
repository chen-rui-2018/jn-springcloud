package com.jn.oa.multiDeptOffice.model;

import com.jn.system.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 多部门协同办公实体
 *
 * @author： shaobao
 * @date： Created on 2019/4/13 22:25
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "MultiDeptOffice", description = "多部门协同办公实体")
public class MultiDeptOffice implements Serializable {
    private static final long serialVersionUID = -3723785591634453306L;

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "协同事项")
    private String title;
    @ApiModelProperty(value = "重要程度(1.紧急,2重要,3日常)")
    private String importanceDegree;
    @ApiModelProperty(value = "协调人员id")
    private String userIds;
    @ApiModelProperty(value = "分类")
    private String classify;
    @ApiModelProperty(value = "周期")
    private String period;
    @ApiModelProperty(value = "提醒时间")
    private Date remindTime;
    @ApiModelProperty(value = "星期")
    private String remindWeekday;
    @ApiModelProperty(value = "提醒时间")
    private String remindMonthDay;
    @ApiModelProperty(value = "小时")
    private String remindHour;
    @ApiModelProperty(value = "分钟")
    private String remindMinute;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endtTime;
    @ApiModelProperty(value = "事项状态（1.正常，2已截止）")
    private String status;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "部门")
    private String deptId;
    @ApiModelProperty(value = "提醒方法")
    private String remindWay;
    @ApiModelProperty(value = "协调部门")
    private String deptIds;
    @ApiModelProperty(value = "是否创建定时任务")
    private String timedTask;

    private List<User> userList;

    public MultiDeptOffice() {
    }

    public MultiDeptOffice(String id, String title, String importanceDegree, String userIds, String classify,
                           String period, Date remindTime, String remindWeekday, String remindMonthDay,
                           String remindHour, String remindMinute, Date startTime, Date endtTime, String status,
                           String content, String deptId, String remindWay, String deptIds, String timedTask,
                           List<User> userList) {
        this.id = id;
        this.title = title;
        this.importanceDegree = importanceDegree;
        this.userIds = userIds;
        this.classify = classify;
        this.period = period;
        this.remindTime = remindTime;
        this.remindWeekday = remindWeekday;
        this.remindMonthDay = remindMonthDay;
        this.remindHour = remindHour;
        this.remindMinute = remindMinute;
        this.startTime = startTime;
        this.endtTime = endtTime;
        this.status = status;
        this.content = content;
        this.deptId = deptId;
        this.remindWay = remindWay;
        this.deptIds = deptIds;
        this.timedTask = timedTask;
        this.userList = userList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImportanceDegree() {
        return importanceDegree;
    }

    public void setImportanceDegree(String importanceDegree) {
        this.importanceDegree = importanceDegree;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public String getRemindWeekday() {
        return remindWeekday;
    }

    public void setRemindWeekday(String remindWeekday) {
        this.remindWeekday = remindWeekday;
    }

    public String getRemindMonthDay() {
        return remindMonthDay;
    }

    public void setRemindMonthDay(String remindMonthDay) {
        this.remindMonthDay = remindMonthDay;
    }

    public String getRemindHour() {
        return remindHour;
    }

    public void setRemindHour(String remindHour) {
        this.remindHour = remindHour;
    }

    public String getRemindMinute() {
        return remindMinute;
    }

    public void setRemindMinute(String remindMinute) {
        this.remindMinute = remindMinute;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndtTime() {
        return endtTime;
    }

    public void setEndtTime(Date endtTime) {
        this.endtTime = endtTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getRemindWay() {
        return remindWay;
    }

    public void setRemindWay(String remindWay) {
        this.remindWay = remindWay;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public String getTimedTask() {
        return timedTask;
    }

    public void setTimedTask(String timedTask) {
        this.timedTask = timedTask;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "MultiDeptOffice{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", importanceDegree='" + importanceDegree + '\'' +
                ", userIds='" + userIds + '\'' +
                ", classify='" + classify + '\'' +
                ", period='" + period + '\'' +
                ", remindTime=" + remindTime +
                ", remindWeekday='" + remindWeekday + '\'' +
                ", remindMonthDay='" + remindMonthDay + '\'' +
                ", remindHour='" + remindHour + '\'' +
                ", remindMinute='" + remindMinute + '\'' +
                ", startTime=" + startTime +
                ", endtTime=" + endtTime +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", deptId='" + deptId + '\'' +
                ", remindWay='" + remindWay + '\'' +
                ", deptIds='" + deptIds + '\'' +
                ", timedTask='" + timedTask + '\'' +
                ", userList=" + userList +
                '}';
    }
}
