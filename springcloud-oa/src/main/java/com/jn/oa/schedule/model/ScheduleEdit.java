package com.jn.oa.schedule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 日程管理添加编辑实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 17:12
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ScheduleEdit", description = "日程管理添加编辑实体")
public class ScheduleEdit implements Serializable {

    private static final long serialVersionUID = 4667928664500620922L;
    @ApiModelProperty(value = "日程id",example = "jsdkfjjfid")
    private String id;

    @ApiModelProperty(value = "日程标题",required = true,example = "我的日程")
    @NotNull(message = "日程标题不能为空")
    private String title;

    @ApiModelProperty(value = "日程内容",example = "日程内容测试")
    private String content;

    @ApiModelProperty(value = "是否全天",required = true,example = "\"1\"")
    @Pattern(regexp = "^[01]$", message = "只能传值0和1")
    private String allDay;

    @ApiModelProperty(value = "开始时间",required = true,example = "2019-03-22 12:12")
    @NotNull(message = "开始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @ApiModelProperty(value = "结束时间",required = true,example = "2019-03-22 13:12")
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    @ApiModelProperty(value = "提醒时间",required = true,example = "2019-03-22 13:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date remindTime;

    @ApiModelProperty(value = "是否提醒(1是,0否)",required = true,example = "\"1\"")
    @Pattern(regexp = "^[01]$", message = "只能传值0和1")
    private String isRemind;

    @ApiModelProperty(value = "提醒方式",required = true,example = "\"1\"")
    private String remindWay;

    @ApiModelProperty(value = "备注",example = "日程备注测试")
    private String remark;

    public ScheduleEdit() {
    }

    public ScheduleEdit(String id, String title, String content, String allDay, Date startTime, Date endTime,
                        Date remindTime, String isRemind, String remindWay, String remark) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.allDay = allDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remindTime = remindTime;
        this.isRemind = isRemind;
        this.remindWay = remindWay;
        this.remark = remark;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAllDay() {
        return allDay;
    }

    public void setAllDay(String allDay) {
        this.allDay = allDay;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind;
    }

    public String getRemindWay() {
        return remindWay;
    }

    public void setRemindWay(String remindWay) {
        this.remindWay = remindWay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ScheduleEdit{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", allDay='" + allDay + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", remindTime=" + remindTime +
                ", isRemind='" + isRemind + '\'' +
                ", remindWay='" + remindWay + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
