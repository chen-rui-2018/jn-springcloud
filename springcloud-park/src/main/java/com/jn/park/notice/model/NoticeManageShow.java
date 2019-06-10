package com.jn.park.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/1 15:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="NoticeManageShow",description = "后台管理公告列表展示")
public class NoticeManageShow implements Serializable {
    @ApiModelProperty(value="公告id")
    private String noticeId;
    @ApiModelProperty(value="公告编号")
    private String noticeSerial;
    @ApiModelProperty(value="公告标题")
    private String noticeTitle;
    @ApiModelProperty(value="生效时间")
    private String startTime;
    @ApiModelProperty(value="失效时间")
    private String endTime;
    @ApiModelProperty(value="是否首页弹出,(0:否-1:是)")
    private String homePopup;
    @ApiModelProperty(value="是否首页展示,(0:否-1:是)")
    private String homeShow;
    @ApiModelProperty(value="平台类型(0:全部-1:app-2:门户)")
    private String platformType;
    @ApiModelProperty(value="平台类型(全部/App/门户)")
    private String platformName;
    @ApiModelProperty(value="公告内容,页面展示")
    private String  noticeDetails;
    @ApiModelProperty(value="排序字段,用于公告的默认,1,2,3,4")
    private String sortField;
    @ApiModelProperty(value="发布人名称")
    private String publishName;
    @ApiModelProperty(value="发布时间")
    private String createdTime;
    @ApiModelProperty(value="公告状态,(0:无效-1:有效)")
    private String noticeStatus;

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

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

    public String getNoticeSerial() {
        return noticeSerial;
    }

    public void setNoticeSerial(String noticeSerial) {
        this.noticeSerial = noticeSerial;
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

    public String getHomePopup() {
        return homePopup;
    }

    public void setHomePopup(String homePopup) {
        this.homePopup = homePopup;
    }

    public String getHomeShow() {
        return homeShow;
    }

    public void setHomeShow(String homeShow) {
        this.homeShow = homeShow;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }
}
