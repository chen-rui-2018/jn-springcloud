package com.jn.park.video.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 安防录像申请详情实体
 *
 * @author： shaobao
 * @date： Created on 2019/5/18 16:00
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "PmVideoItem", description = "安防录像申请详情实体")
public class PmVideoItem implements Serializable {
    private static final long serialVersionUID = -1813708035664444342L;
    @ApiModelProperty(value = "id", example = "578977761985560576")
    private String id;
    @ApiModelProperty(value = "录像申请单id", example = "578977761985560576")
    private String videoId;
    @ApiModelProperty(value = "录像申请说明", example = "测试")
    private String videoTitle;
    @ApiModelProperty(value = "赋权操作", example = "fba6d897-2107-4c50-bcc5-ca988c9c0b9c")
    private String operation;
    @ApiModelProperty(value = "录像播放路径", example = "1号楼摄像头")
    private String videoPlayUrl;
    @ApiModelProperty(value = "录像开始时间", example = "2019-12-12 03:05:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date videoStartTime;
    @ApiModelProperty(value = "录像结束时间", example = "2019-12-12 03:06:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date videoEndTime;

    public PmVideoItem() {
    }

    public PmVideoItem(String id, String videoId, String videoTitle, String operation, String videoPlayUrl,
                       Date videoStartTime, Date videoEndTime) {
        this.id = id;
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.operation = operation;
        this.videoPlayUrl = videoPlayUrl;
        this.videoStartTime = videoStartTime;
        this.videoEndTime = videoEndTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getVideoPlayUrl() {
        return videoPlayUrl;
    }

    public void setVideoPlayUrl(String videoPlayUrl) {
        this.videoPlayUrl = videoPlayUrl;
    }

    public Date getVideoStartTime() {
        return videoStartTime;
    }

    public void setVideoStartTime(Date videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    public Date getVideoEndTime() {
        return videoEndTime;
    }

    public void setVideoEndTime(Date videoEndTime) {
        this.videoEndTime = videoEndTime;
    }

    @Override
    public String toString() {
        return "PmVideoItem{" +
                "id='" + id + '\'' +
                ", videoId='" + videoId + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", operation='" + operation + '\'' +
                ", videoPlayUrl='" + videoPlayUrl + '\'' +
                ", videoStartTime=" + videoStartTime +
                ", videoEndTime=" + videoEndTime +
                '}';
    }
}