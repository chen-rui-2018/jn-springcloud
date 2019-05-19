package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/15 15:12
 * @Version v1.0
 * @modified By:
 * */
 
@ApiModel(value = "IBPSOnlineCustomerParam",description = "客服中心在线客服启动工作流入参")
public class IBPSOnlineCustomerParam implements Serializable {
    @ApiModelProperty("问题编码")
    private String quesCode;
    @ApiModelProperty("问题标题")
    private String quesTitle;
    @ApiModelProperty("问题详情")
    private String quesDetails;
    @ApiModelProperty("问题描述url(最多允许三张图片)")
    private String quesUrl;
    @ApiModelProperty("服务模块编码(从数据字典获取)")
    private String serviceModule;
    @ApiModelProperty("服务模块名称(从数据字典获取)")
    private String serviceModuleName;
    @ApiModelProperty("客户类型编码(1：个人    2：企业)")
    private String clientType;
    @ApiModelProperty("联系方式（手机号码/邮箱）")
    private String contactWay;
    @ApiModelProperty("处理状态(0：待处理 1：处理中 2：已处理 3：无法处理)")
    private String status;
    @ApiModelProperty("当前来电")
    private String currentCaller;
    @ApiModelProperty("来电归属")
    private String callerOwen;
    @ApiModelProperty("客户姓名")
    private String custName;
    @ApiModelProperty("客户性别(0：女  1：男)")
    private String custSex;
    @ApiModelProperty("是否转派(0：否      1：是)")
    private String isTranPie;
    @ApiModelProperty("创建时间")
    private String createdTime;
    @ApiModelProperty("创建者账号")
    private String creatorAccount;
    @ApiModelProperty("最新更新时间")
    private String modifiedTime;
    @ApiModelProperty("最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty("是否删除  0标记删除，1正常")
    private Byte recordStatus;

    public String getQuesCode() {
        return quesCode;
    }

    public void setQuesCode(String quesCode) {
        this.quesCode = quesCode;
    }

    public String getQuesTitle() {
        return quesTitle;
    }

    public void setQuesTitle(String quesTitle) {
        this.quesTitle = quesTitle;
    }

    public String getQuesDetails() {
        return quesDetails;
    }

    public void setQuesDetails(String quesDetails) {
        this.quesDetails = quesDetails;
    }

    public String getQuesUrl() {
        return quesUrl;
    }

    public void setQuesUrl(String quesUrl) {
        this.quesUrl = quesUrl;
    }

    public String getServiceModule() {
        return serviceModule;
    }

    public void setServiceModule(String serviceModule) {
        this.serviceModule = serviceModule;
    }

    public String getServiceModuleName() {
        return serviceModuleName;
    }

    public void setServiceModuleName(String serviceModuleName) {
        this.serviceModuleName = serviceModuleName;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentCaller() {
        return currentCaller;
    }

    public void setCurrentCaller(String currentCaller) {
        this.currentCaller = currentCaller;
    }

    public String getCallerOwen() {
        return callerOwen;
    }

    public void setCallerOwen(String callerOwen) {
        this.callerOwen = callerOwen;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex;
    }

    public String getIsTranPie() {
        return isTranPie;
    }

    public void setIsTranPie(String isTranPie) {
        this.isTranPie = isTranPie;
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
}
