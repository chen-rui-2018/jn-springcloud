package com.jn.oa.notice.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 公告管理分页实体类
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 15:39
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "NoticePage", description = "公告管理分页实体类")
public class NoticePage extends Page implements Serializable {

    private static final long serialVersionUID = 9083783232467337356L;

    @ApiModelProperty(value = "公告标题", example = "公告")
    private String noticeTitle;

    @ApiModelProperty(value = "发布平台类型（1:协同办公、2:外部系统", example = "\"1\"")
    private String platformType;

    @ApiModelProperty(value = "状态（0删除,1有效,2失效", example = "\"1\"")
    private Byte recordStatus;

    public NoticePage() {
    }

    public NoticePage(String noticeTitle, String platformType, Byte recordStatus) {
        this.noticeTitle = noticeTitle;
        this.platformType = platformType;
        this.recordStatus = recordStatus;
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "NoticePage{" +
                "noticeTitle='" + noticeTitle + '\'' +
                ", platformType='" + platformType + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
