package com.jn.enterprise.pd.personnel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author： huangbq
 * @date： Created on 2019/3/18 12:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FlowHistoryModel",description = "审批历史记录")
public class FlowHistoryModel {

    @ApiModelProperty("节点编码")
    private String nodeNo;
    @ApiModelProperty("节点名称")
    private String nodeName;

    @ApiModelProperty("是否同意")
    private Integer isPass;

    @ApiModelProperty("审批意见")
    private String comments;

    @ApiModelProperty("审批人")
    private String creatorAccount;

    @ApiModelProperty("审批时间")
    private Date createdTime;

    public String getNodeNo() {
        return nodeNo;
    }

    public void setNodeNo(String nodeNo) {
        this.nodeNo = nodeNo;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
