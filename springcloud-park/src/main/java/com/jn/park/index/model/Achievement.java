package com.jn.park.index.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 园区成果出参
 * @author： huxw
 * @date： Created on 2019-4-28 09:49:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Achievement",description = "园区成果出参")
public class Achievement implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "详情")
    private String details;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "浏览数")
    private String viewCount;

    @ApiModelProperty(value = "发布时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", type='" + type + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
