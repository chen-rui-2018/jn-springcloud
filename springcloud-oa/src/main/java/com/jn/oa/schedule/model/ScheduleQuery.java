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
 * 日程管理查询实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/22 17:12
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ScheduleQuery", description = "日程管理查询实体")
public class ScheduleQuery implements Serializable {

    private static final long serialVersionUID = -8420951756936038579L;
    @ApiModelProperty(value = "日程标题", example = "我的日程")
    private String title;

    @ApiModelProperty(value = "日期,用于按月份查询", example = "2019-03-22")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;

    @ApiModelProperty(value = "时间段查询开始时间", example = "2019-03-22 12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @ApiModelProperty(value = "时间段查询结束时间", example = "2019-03-22 13:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    @ApiModelProperty(value = "用户账号", example = "不用传")
    private String userAccount;


    public ScheduleQuery() {
    }

    public ScheduleQuery(String title, Date date, Date startTime, Date endTime, String userAccount) {
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userAccount = userAccount;
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "ScheduleQuery{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userAccount='" + userAccount + '\'' +
                '}';
    }
}
