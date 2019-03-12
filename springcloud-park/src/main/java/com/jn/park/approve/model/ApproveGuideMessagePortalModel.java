package com.jn.park.approve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 *
 *
 * @author： huangbq
 * @date： Created on 2019/3/12 16:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel("添加留言")
public class ApproveGuideMessagePortalModel {

    @ApiModelProperty("公司名称")
    @NotNull(message = "公司名称必填")
    private String companyName;

    @ApiModelProperty("联系人姓名")
    @NotNull(message = "联系人姓名必填")
    private Byte concatName;

    @ApiModelProperty("联系名电话")
    @NotNull(message = "联系名电话必填")
    private String concatPhone;

    @ApiModelProperty(value = "留言内容",example = "1、 问题描述： 2、诉求目的")
    @NotNull(message = "留言内容")
    private String message;

    @ApiModelProperty("要资料的审批指南ID")
    private Integer guideId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Byte getConcatName() {
        return concatName;
    }

    public void setConcatName(Byte concatName) {
        this.concatName = concatName;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }
}
