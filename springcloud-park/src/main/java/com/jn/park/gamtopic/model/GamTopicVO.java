package com.jn.park.gamtopic.model;

import com.jn.park.fileimg.model.FileImg;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 话题详情VO
 * @author： jiangyl
 * @date： Created on 2019/3/27 17:46
 * @version： v1.0
 * @modified By:
 */
public class GamTopicVO {

    @ApiModelProperty(value = "话题ID")
    private String topicId;
    @ApiModelProperty(value = "话题类容")
    private String topicContent;
    @ApiModelProperty(value = "话题类型 1公开2关注可看3私密")
    private String topicType;
    @ApiModelProperty(value = "文件" )
    private List<FileImg> imgs;
    @ApiModelProperty(value = "评论数")
    private String comNum;
    @ApiModelProperty(value = "评论点赞数")
    private String comLike;
    @ApiModelProperty(value = "话题状态（0删除1有效）")
    private String topicStatus;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改人")
    private String modifiedTime;
    @ApiModelProperty(value = "修改时间")
    private String modifierAccount;

    @Override
    public String toString() {
        return "GamTopicVO{" +
                "topicId='" + topicId + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", topicType='" + topicType + '\'' +
                ", imgs=" + imgs +
                ", comNum='" + comNum + '\'' +
                ", comLike='" + comLike + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                '}';
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public List<FileImg> getImgs() {
        return imgs;
    }

    public void setImgs(List<FileImg> imgs) {
        this.imgs = imgs;
    }

    public String getComNum() {
        return comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public String getComLike() {
        return comLike;
    }

    public void setComLike(String comLike) {
        this.comLike = comLike;
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
}
