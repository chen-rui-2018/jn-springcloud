package com.jn.park.approve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author： huangbq
 * @date： Created on 2019/3/12 16:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel("咨询留言内容")
public class ApproveGuideMessageModel extends  ApproveGuideMessagePortalModel {


    @ApiModelProperty("主键")
    private Integer id;


    @ApiModelProperty("咨询名称（企业名+联系人）")
    private String title;


    @ApiModelProperty("回复状态")
    private String replyStatus;

    @ApiModelProperty("回复者账号")
    private Integer replyUserAccount;

    @ApiModelProperty("回复时间")
    private Date replyTime;

    @ApiModelProperty("回复内容")
    private String replyMessage;

    @ApiModelProperty("解决状态（已解决、未解决、其他）")
    private String solutionStatus;

    @ApiModelProperty("是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty("留言者账号")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Integer getReplyUserAccount() {
        return replyUserAccount;
    }

    public void setReplyUserAccount(Integer replyUserAccount) {
        this.replyUserAccount = replyUserAccount;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    public String getSolutionStatus() {
        return solutionStatus;
    }

    public void setSolutionStatus(String solutionStatus) {
        this.solutionStatus = solutionStatus;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
