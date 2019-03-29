package com.jn.park.feedback.model;

import com.jn.park.fileimg.model.FileImg;
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
@ApiModel(value = "Feedback",description = "问题反馈参数")
public class Feedback {

    @ApiModelProperty(value = "反馈类容",required = true,example = "有bug")
    @NotNull(message="反馈类容不能为空")
    private String feedContent;

    @ApiModelProperty(value = "类型ID[传园区字典表查询(条件为：userFeed)返回的codeValue字段]",
            notes = "传园区字典表查询(条件为：userFeed)返回的codeValue字段。",required = true,example = "user_feed_001")
    @NotNull(message="类型ID不能为空")
    private String feedTypeId;

    @ApiModelProperty(value = "类型名称[传园区字典表查询(条件为：userFeed)返回的codeName字段]",
            notes = "传园区字典表查询(条件为：userFeed)返回的codeName字段。",required = true,example = "功能异常")
    @NotNull(message="类型名称不能为空")
    private String feedTypeName;

    @ApiModelProperty(value = "文件",required = true)
    private List<FileImg> fileImgs;

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

    public List<FileImg> getFileImgs() {
        return fileImgs;
    }

    public void setFileImgs(List<FileImg> fileImgs) {
        this.fileImgs = fileImgs;
    }
}
