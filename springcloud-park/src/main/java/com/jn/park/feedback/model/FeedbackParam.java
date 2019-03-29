package com.jn.park.feedback.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 15:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Feedback", description = "问题反馈后台查询条件")
public class FeedbackParam extends Page {

    @ApiModelProperty(value = "反馈类容", example = "有bug")
    private String feedContent;

    @ApiModelProperty(value = "类型ID[传园区字典表查询(条件为：userFeed)返回的codeValue字段]", notes = "传园区字典表查询(条件为：userFeed)返回的codeValue字段。", example = "user_feed_001")
    private String feedTypeId;

    @ApiModelProperty(value = "类型名称[传园区字典表查询(条件为：userFeed)返回的codeName字段]", notes = "传园区字典表查询(条件为：userFeed)返回的codeName字段。", example = "功能异常")
    private String feedTypeName;

    public String getFeedContent() {
        return feedContent;
    }

    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent;
    }

    public String getFeedTypeId() {
        return feedTypeId;
    }

    public void setFeedTypeId(String feedTypeId) {
        this.feedTypeId = feedTypeId;
    }

    public String getFeedTypeName() {
        return feedTypeName;
    }

    public void setFeedTypeName(String feedTypeName) {
        this.feedTypeName = feedTypeName;
    }
}
