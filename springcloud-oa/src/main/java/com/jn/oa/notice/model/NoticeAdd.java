package com.jn.oa.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 公告管理添加实体
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 15:39
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "NoticeAdd", description = "公告管理添加实体")
public class NoticeAdd implements Serializable {
    private static final long serialVersionUID = 3202735850534330327L;

    @ApiModelProperty(value = "公告id")
    private String id;

    @ApiModelProperty(value = "公告编号", required = true)
    @NotNull(message = "公告编号不能为空")
    private String workOrderNum;

    @ApiModelProperty(value = "公告标题", required = true)
    @Size(max = 200, message = "公告标题不能超过200字")
    private String noticeTitle;

    @ApiModelProperty(value = "发布平台类型（1:协同办公、2:外部系统,数据使用格式[{'key':'1',value:'协同办公'},...])", required = true)
    @NotNull(message = "发布平台不能为空")
    private String platformType;

    @ApiModelProperty(value = "生效时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true)
    @NotNull(message = "生效时间不能为空")
    private String effectiveTime;

    @ApiModelProperty(value = "失效时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true)
    @NotNull(message = "失效时间不能为空")
    private String failureTime;

    @ApiModelProperty(value = "状态（0删除,1有效,2失效", required = true)
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    @ApiModelProperty(value = "公告内容", required = true)
    private String noticeContent;

    public NoticeAdd() {
    }

    public NoticeAdd(String id, String workOrderNum, String noticeTitle, String platformType,
                     String effectiveTime, String failureTime, Byte recordStatus, String noticeContent) {
        this.id = id;
        this.workOrderNum = workOrderNum;
        this.noticeTitle = noticeTitle;
        this.platformType = platformType;
        this.effectiveTime = effectiveTime;
        this.failureTime = failureTime;
        this.recordStatus = recordStatus;
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

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(String failureTime) {
        this.failureTime = failureTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String toString() {
        return "NoticeAdd{" +
                "id='" + id + '\'' +
                ", workOrderNum='" + workOrderNum + '\'' +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", platformType='" + platformType + '\'' +
                ", effectiveTime='" + effectiveTime + '\'' +
                ", failureTime='" + failureTime + '\'' +
                ", recordStatus=" + recordStatus +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}
