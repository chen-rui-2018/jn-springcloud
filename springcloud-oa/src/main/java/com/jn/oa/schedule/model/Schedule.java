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
 * 日程管理实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 17:12
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "Schedule", description = "日程管理实体")
public class Schedule implements Serializable {

    private static final long serialVersionUID = -6586518664324595427L;
    @ApiModelProperty(value = "日程id", example = "jsdkfjjfid")
    private String id;

    @ApiModelProperty(value = "日程标题", required = true, example = "我的日程")
    @NotNull(message = "日程标题不能为空")
    private String title;

    @ApiModelProperty(value = "日期", required = true, example = "2019-03-22")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;

    @ApiModelProperty(value = "是否全天",required = true,example = "\"1\"")
    @Pattern(regexp = "^[01]$", message = "只能传值0和1")
    private String allDay;

    @ApiModelProperty(value = "日程内容", example = "提成内容测试")
    private String content;

    @ApiModelProperty(value = "开始时间", required = true, example = "2019-03-22 12:12")
    @NotNull(message = "开始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date start;

    @ApiModelProperty(value = "结束时间", required = true, example = "2019-03-22 13:12")
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date end;

    @ApiModelProperty(value = "提醒时间", required = true, example = "2019-03-22 13:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date remindTime;

    @ApiModelProperty(value = "是否提醒(1是,0否)", required = true, example = "\"1\"")
    private String isRemind;

    @ApiModelProperty(value = "提醒方式",required = true,example = "\"1\"")
    private String remindWay;

    @ApiModelProperty(value = "备注", example = "日程备注测试")
    private String remark;

    public Schedule() {
    }

    public Schedule(String id, String title, Date date, String allDay, String content, Date start, Date end,
                    Date remindTime, String isRemind, String remindWay, String remark) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.allDay = allDay;
        this.content = content;
        this.start = start;
        this.end = end;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAllDay() {
        return allDay;
    }

    public void setAllDay(String allDay) {
        this.allDay = allDay;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
        return "Schedule{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", allDay='" + allDay + '\'' +
                ", content='" + content + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", remindTime=" + remindTime +
                ", isRemind='" + isRemind + '\'' +
                ", remindWay='" + remindWay + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
