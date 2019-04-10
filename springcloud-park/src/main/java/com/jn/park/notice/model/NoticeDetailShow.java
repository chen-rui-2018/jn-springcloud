package com.jn.park.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/3/29 17:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "NoticeDetailShow",description = "前端公告详情/列表展示")
public class NoticeDetailShow implements Serializable {
    @ApiModelProperty(value="公告id")
    private String noticeId;
    @ApiModelProperty(value="公告标题")
    private String noticeTitle;
    @ApiModelProperty(value="生效时间")
    private String startTime;
    @ApiModelProperty(value="失效时间")
    private String endTime;
    @ApiModelProperty(value="公告内容,页面展示")
    private String noticeContent;
    @ApiModelProperty(value="公告详情,用于后台转换")
    private byte [] noticeDetails;
    @ApiModelProperty(value="发布人名称")
    private String publishName;
    @ApiModelProperty(value="发布时间")
    private String createdTime;

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public byte[] getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(byte[] noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }
}
