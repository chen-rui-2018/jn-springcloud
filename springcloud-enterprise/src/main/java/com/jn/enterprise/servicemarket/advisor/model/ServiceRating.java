package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/2/13 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRating",description = "服务评分")
public class ServiceRating extends Page implements Serializable {
    @ApiModelProperty(value = "评论对象id")
    private String commentObjId;
    @ApiModelProperty(value = "评论对象名称")
    private String commentObjName;
    @ApiModelProperty(value = "服务态度评分")
    private String attitudeScore;
    @ApiModelProperty(value = "服务专业评分")
    private String professionScore;
    @ApiModelProperty(value = "服务响应评分")
    private String responseScore;
    @ApiModelProperty(value = "服务价格评分")
    private String priceScore;
    @ApiModelProperty(value = "服务评价描述")
    private String evaluationDesc;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "记录状态")
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getCommentObjId() {
        return commentObjId;
    }

    public void setCommentObjId(String commentObjId) {
        this.commentObjId = commentObjId;
    }

    public String getCommentObjName() {
        return commentObjName;
    }

    public void setCommentObjName(String commentObjName) {
        this.commentObjName = commentObjName;
    }

    public String getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(String attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public String getProfessionScore() {
        return professionScore;
    }

    public void setProfessionScore(String professionScore) {
        this.professionScore = professionScore;
    }

    public String getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(String responseScore) {
        this.responseScore = responseScore;
    }

    public String getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(String priceScore) {
        this.priceScore = priceScore;
    }

    public String getEvaluationDesc() {
        return evaluationDesc;
    }

    public void setEvaluationDesc(String evaluationDesc) {
        this.evaluationDesc = evaluationDesc;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "ServiceRating{" +
                "commentObjId='" + commentObjId + '\'' +
                ", commentObjName='" + commentObjName + '\'' +
                ", attitudeScore='" + attitudeScore + '\'' +
                ", professionScore='" + professionScore + '\'' +
                ", responseScore='" + responseScore + '\'' +
                ", priceScore='" + priceScore + '\'' +
                ", evaluationDesc='" + evaluationDesc + '\'' +
                ", createdTime=" + createdTime +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
