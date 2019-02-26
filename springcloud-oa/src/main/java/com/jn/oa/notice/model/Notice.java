package com.jn.oa.notice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.util.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告实体
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 20:19
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "Notice", description = "公告实体")
public class Notice implements Serializable {
    private static final long serialVersionUID = -5671809054725364213L;
    @ApiModelProperty(value = "公告id")
    private String id;
    @ApiModelProperty(value = "工单编号")
    private String workOrderNum;
    @ApiModelProperty(value = "公告标题")
    private String noticeTitle;
    @ApiModelProperty(value = "平台类型")
    private String platformType;
    @ApiModelProperty(value = "生效时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectiveTime;
    @ApiModelProperty(value = "失效时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date failureTime;
    @ApiModelProperty(value = "起止时间时间")
    private String startAndEndTime;
    @ApiModelProperty(value = "状态")
    private Byte recordStatus;
    @ApiModelProperty(value = "创建人")
    private String creator;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty(value = "公告内容")
    private String noticeContent;

    public Notice() {
    }

    public Notice(String id, String workOrderNum, String noticeTitle, String platformType, Date effectiveTime,
                  Date failureTime, String startAndEndTime, Byte recordStatus, String creator, Date createdTime,
                  String noticeContent) {
        this.id = id;
        this.workOrderNum = workOrderNum;
        this.noticeTitle = noticeTitle;
        this.platformType = platformType;
        this.effectiveTime = effectiveTime;
        this.failureTime = failureTime;
        this.startAndEndTime = startAndEndTime;
        this.recordStatus = recordStatus;
        this.creator = creator;
        this.createdTime = createdTime;
        this.noticeContent = noticeContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }

    public String getStartAndEndTime() {
        if (getFailureTime() != null && getEffectiveTime() != null){
            String fileTime = DateUtils.formatDate(getFailureTime(), "yyyy/MM/dd");
            String effectiveTime = DateUtils.formatDate(getEffectiveTime(), "yyyy/MM/dd");
            return effectiveTime + "--" + fileTime;
        }
        return startAndEndTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                ", workOrderNum='" + workOrderNum + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", platformType='" + platformType + '\'' +
                ", effectiveTime=" + effectiveTime +
                ", failureTime=" + failureTime +
                ", startAndEndTime='" + startAndEndTime + '\'' +
                ", recordStatus=" + recordStatus +
                ", creator='" + creator + '\'' +
                ", createdTime=" + createdTime +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}
