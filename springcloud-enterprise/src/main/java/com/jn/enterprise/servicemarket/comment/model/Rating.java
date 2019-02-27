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
    private String willOrg;
    @ApiModelProperty(value = "服务顾问")
    private String willAdvisor;
    @ApiModelProperty(value = "服务产品")
    private String willProduct;
    @ApiModelProperty(value = "机构电话")
    private String orgTelephone;
    @ApiModelProperty(value = "需求提出时间")
    private String issueTime;
    @ApiModelProperty(value = "需求处理时间")
    private String handleTime;
    @ApiModelProperty(value = "点评状态")
    private String isComment;
    @ApiModelProperty(value = "点评时间")
    private String commentTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWillOrg() {
        return willOrg;
    }

    public void setWillOrg(String willOrg) {
        this.willOrg = willOrg;
    }

    public String getWillAdvisor() {
        return willAdvisor;
    }

    public void setWillAdvisor(String willAdvisor) {
        this.willAdvisor = willAdvisor;
    }

    public String getWillProduct() {
        return willProduct;
    }

    public void setWillProduct(String willProduct) {
        this.willProduct = willProduct;
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
}
