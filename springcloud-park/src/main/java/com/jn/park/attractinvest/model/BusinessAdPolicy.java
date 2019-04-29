package com.jn.park.attractinvest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 招商政策实体
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:38
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "BusinessAdPolicy", description = "招商政策实体")
public class BusinessAdPolicy implements Serializable {
    private static final long serialVersionUID = 3887130785154798435L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "广告封面")
    private String adCover;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty(value = "副标题")
    private String subTitle;

    @ApiModelProperty(value = "浏览册数")
    private Integer viewCount;

    @ApiModelProperty(value = "内容")
    private String content;


    public BusinessAdPolicy() {
    }

    public BusinessAdPolicy(String id, String title, String adCover, Date startTime, Date endTime,
                            String subTitle, Integer viewCount, String content) {
        this.id = id;
        this.title = title;
        this.adCover = adCover;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subTitle = subTitle;
        this.viewCount = viewCount;
        this.content = content;
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

    public String getAdCover() {
        return adCover;
    }

    public void setAdCover(String adCover) {
        this.adCover = adCover;
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BusinessAdPolicy{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", adCover='" + adCover + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", subTitle='" + subTitle + '\'' +
                ", viewCount=" + viewCount +
                ", content='" + content + '\'' +
                '}';
    }
}