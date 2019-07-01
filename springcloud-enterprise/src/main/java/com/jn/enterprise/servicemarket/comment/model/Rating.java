package com.jn.enterprise.servicemarket.comment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评价列表信息
 * @author： jiangyl
 * @date： Created on 2019/2/25 15:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Rating",description = "评价列表信息")
public class Rating {
    @ApiModelProperty(value = "评价编号")
    private String id;
    @ApiModelProperty(value = "服务机构")
    private String orgName;
    @ApiModelProperty(value = "服务专员")
    private String advisorName;
    @ApiModelProperty(value = "服务产品")
    private String productName;
    @ApiModelProperty(value = "机构电话")
    private String orgTelephone;
    @ApiModelProperty(value = "需求提出时间 yyyy-MM-dd HH:mm:ss")
    private String issueTime;
    @ApiModelProperty(value = "需求处理时间 yyyy-MM-dd HH:mm:ss")
    private String handleTime;
    @ApiModelProperty(value = "点评状态")
    private String isComment;
    @ApiModelProperty(value = "点评时间")
    private String commentTime;
    @ApiModelProperty(value = "领域id")
    private String businessId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrgTelephone() {
        return orgTelephone;
    }

    public void setOrgTelephone(String orgTelephone) {
        this.orgTelephone = orgTelephone;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
