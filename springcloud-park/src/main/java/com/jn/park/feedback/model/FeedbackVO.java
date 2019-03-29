package com.jn.park.feedback.model;

import com.jn.park.fileimg.model.FileImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/27 15:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FeedbackVO",description = "问题反馈VO")
public class FeedbackVO {
    @ApiModelProperty(value = "反馈ID")
    private String feedId;
    @ApiModelProperty(value = "反馈内容")
    private String feedContent;
    @ApiModelProperty(value = "反馈类型ID")
    private String feedTypeId;
    @ApiModelProperty(value = "反馈类型名称")
    private String feedTypeName;
    @ApiModelProperty(value = "反馈时间")
    private String createdTime;
    @ApiModelProperty(value = "反馈人账号")
    private String creatorAccount;
    @ApiModelProperty(value = "反馈修改时间")
    private String modifiedTime;
    @ApiModelProperty(value = "反馈修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "文件")
    private List<FileImg> fileImgs;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public List<FileImg> getFileImgs() {
        return fileImgs;
    }

    public void setFileImgs(List<FileImg> fileImgs) {
        this.fileImgs = fileImgs;
    }
}
