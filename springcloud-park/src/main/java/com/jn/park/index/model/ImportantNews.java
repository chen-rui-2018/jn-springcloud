package com.jn.park.index.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 重要消息出参
 * @author： huxw
 * @date： Created on 2019-4-16 16:27:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ImportantNews",description = "重要消息出参")
public class ImportantNews implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "详情")
    private String details;

    @ApiModelProperty(value = "发布时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

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
}
