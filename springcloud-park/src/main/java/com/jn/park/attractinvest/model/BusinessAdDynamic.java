package com.jn.park.attractinvest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 招商动态实体
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 18:50
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "BusinessAdDynamic", description = "招商动态实体")
public class BusinessAdDynamic implements Serializable {
    private static final long serialVersionUID = -8684192085552272807L;
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "广告封面")
    private String adCover;

    @ApiModelProperty(value = "广告封面名称")
    private String coverName;

    @ApiModelProperty(value = "广告封面路径")
    private String coverUrl;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty(value = "内容")
    private String content;

    public BusinessAdDynamic() {
    }

    public BusinessAdDynamic(String id, String title, String adCover, String coverName, String coverUrl,
                             Date startTime, Date endTime, String content) {
        this.id = id;
        this.title = title;
        this.adCover = adCover;
        this.coverName = coverName;
        this.coverUrl = coverUrl;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BusinessAdDynamic{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", adCover='" + adCover + '\'' +
                ", coverName='" + coverName + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", content='" + content + '\'' +
                '}';
    }
}
