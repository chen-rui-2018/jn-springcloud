package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/2/15 17:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceProductDetail", description = "服务基本信息")
public class ServiceProductDetail implements Serializable {
    @ApiModelProperty(value = "服务基本信息")
    private ServiceContent content;
    @ApiModelProperty(value = "审批意见")
    private String approvalComments;
    @ApiModelProperty(value = "联系人名称")
    private String conName;
    @ApiModelProperty(value = "联系电话")
    private String conPhone;
    @ApiModelProperty(value = "顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "服务产品发布日期")
    private String releaseTime;

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public ServiceContent getContent() {
        return content;
    }

    public void setContent(ServiceContent content) {
        this.content = content;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getApprovalComments() {
        return approvalComments;
    }

    public void setApprovalComments(String approvalComments) {
        this.approvalComments = approvalComments;
    }



    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }
}
