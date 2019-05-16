package com.jn.park.customer.entity;

import java.io.Serializable;
import java.util.Date;

public class TbClientServiceCenter implements Serializable {
    /*@ApiModelProperty("主键id")*/
    private String id;

    /*@ApiModelProperty("流程实例id(启动工作流后的流程实例id)")*/
    private String processInsId;

    /*@ApiModelProperty("问题编码")*/
    private String quesCode;

    /*@ApiModelProperty("问题标题")*/
    private String quesTitle;

    /*@ApiModelProperty("问题详情")*/
    private String quesDetails;

    /*@ApiModelProperty("问题描述url(最多允许三张图片)")*/
    private String quesUrl;

    /*@ApiModelProperty("服务模块编码(从数据字典获取)")*/
    private String serviceModule;

    /*@ApiModelProperty("服务模块名称（从数据字典获取）")*/
    private String serviceModuleName;

    /*@ApiModelProperty("客户类型编码(1：个人    2：企业)")*/
    private String clientType;

    /*@ApiModelProperty("联系方式（手机号码/邮箱）")*/
    private String contactWay;

    /*@ApiModelProperty("处理状态(0：待处理  1:处理中 2：已处理)")*/
    private String status;

    /*@ApiModelProperty("当前来电")*/
    private String currentCaller;

    /*@ApiModelProperty("来电归属")*/
    private String callerOwen;

    /*@ApiModelProperty("客户姓名")*/
    private String custName;

    /*@ApiModelProperty("客户性别(0：女  1：男)")*/
    private String custSex;

    /*@ApiModelProperty("是否转派(0：否      1：是)")*/
    private String isTranPie;

    /*@ApiModelProperty("执行部门id(角色id)")*/
    private String executedeptid;

    /*@ApiModelProperty("执行人(预留字段)")*/
    private String executeperson;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("是否删除  0标记删除，1正常")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProcessInsId() {
        return processInsId;
    }

    public void setProcessInsId(String processInsId) {
        this.processInsId = processInsId == null ? null : processInsId.trim();
    }

    public String getQuesCode() {
        return quesCode;
    }

    public void setQuesCode(String quesCode) {
        this.quesCode = quesCode == null ? null : quesCode.trim();
    }

    public String getQuesTitle() {
        return quesTitle;
    }

    public void setQuesTitle(String quesTitle) {
        this.quesTitle = quesTitle == null ? null : quesTitle.trim();
    }

    public String getQuesDetails() {
        return quesDetails;
    }

    public void setQuesDetails(String quesDetails) {
        this.quesDetails = quesDetails == null ? null : quesDetails.trim();
    }

    public String getQuesUrl() {
        return quesUrl;
    }

    public void setQuesUrl(String quesUrl) {
        this.quesUrl = quesUrl == null ? null : quesUrl.trim();
    }

    public String getServiceModule() {
        return serviceModule;
    }

    public void setServiceModule(String serviceModule) {
        this.serviceModule = serviceModule == null ? null : serviceModule.trim();
    }

    public String getServiceModuleName() {
        return serviceModuleName;
    }

    public void setServiceModuleName(String serviceModuleName) {
        this.serviceModuleName = serviceModuleName == null ? null : serviceModuleName.trim();
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType == null ? null : clientType.trim();
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCurrentCaller() {
        return currentCaller;
    }

    public void setCurrentCaller(String currentCaller) {
        this.currentCaller = currentCaller == null ? null : currentCaller.trim();
    }

    public String getCallerOwen() {
        return callerOwen;
    }

    public void setCallerOwen(String callerOwen) {
        this.callerOwen = callerOwen == null ? null : callerOwen.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex == null ? null : custSex.trim();
    }

    public String getIsTranPie() {
        return isTranPie;
    }

    public void setIsTranPie(String isTranPie) {
        this.isTranPie = isTranPie == null ? null : isTranPie.trim();
    }

    public String getExecutedeptid() {
        return executedeptid;
    }

    public void setExecutedeptid(String executedeptid) {
        this.executedeptid = executedeptid == null ? null : executedeptid.trim();
    }

    public String getExecuteperson() {
        return executeperson;
    }

    public void setExecuteperson(String executeperson) {
        this.executeperson = executeperson == null ? null : executeperson.trim();
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
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbClientServiceCenter other = (TbClientServiceCenter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProcessInsId() == null ? other.getProcessInsId() == null : this.getProcessInsId().equals(other.getProcessInsId()))
            && (this.getQuesCode() == null ? other.getQuesCode() == null : this.getQuesCode().equals(other.getQuesCode()))
            && (this.getQuesTitle() == null ? other.getQuesTitle() == null : this.getQuesTitle().equals(other.getQuesTitle()))
            && (this.getQuesDetails() == null ? other.getQuesDetails() == null : this.getQuesDetails().equals(other.getQuesDetails()))
            && (this.getQuesUrl() == null ? other.getQuesUrl() == null : this.getQuesUrl().equals(other.getQuesUrl()))
            && (this.getServiceModule() == null ? other.getServiceModule() == null : this.getServiceModule().equals(other.getServiceModule()))
            && (this.getServiceModuleName() == null ? other.getServiceModuleName() == null : this.getServiceModuleName().equals(other.getServiceModuleName()))
            && (this.getClientType() == null ? other.getClientType() == null : this.getClientType().equals(other.getClientType()))
            && (this.getContactWay() == null ? other.getContactWay() == null : this.getContactWay().equals(other.getContactWay()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCurrentCaller() == null ? other.getCurrentCaller() == null : this.getCurrentCaller().equals(other.getCurrentCaller()))
            && (this.getCallerOwen() == null ? other.getCallerOwen() == null : this.getCallerOwen().equals(other.getCallerOwen()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getCustSex() == null ? other.getCustSex() == null : this.getCustSex().equals(other.getCustSex()))
            && (this.getIsTranPie() == null ? other.getIsTranPie() == null : this.getIsTranPie().equals(other.getIsTranPie()))
            && (this.getExecutedeptid() == null ? other.getExecutedeptid() == null : this.getExecutedeptid().equals(other.getExecutedeptid()))
            && (this.getExecuteperson() == null ? other.getExecuteperson() == null : this.getExecuteperson().equals(other.getExecuteperson()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProcessInsId() == null) ? 0 : getProcessInsId().hashCode());
        result = prime * result + ((getQuesCode() == null) ? 0 : getQuesCode().hashCode());
        result = prime * result + ((getQuesTitle() == null) ? 0 : getQuesTitle().hashCode());
        result = prime * result + ((getQuesDetails() == null) ? 0 : getQuesDetails().hashCode());
        result = prime * result + ((getQuesUrl() == null) ? 0 : getQuesUrl().hashCode());
        result = prime * result + ((getServiceModule() == null) ? 0 : getServiceModule().hashCode());
        result = prime * result + ((getServiceModuleName() == null) ? 0 : getServiceModuleName().hashCode());
        result = prime * result + ((getClientType() == null) ? 0 : getClientType().hashCode());
        result = prime * result + ((getContactWay() == null) ? 0 : getContactWay().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCurrentCaller() == null) ? 0 : getCurrentCaller().hashCode());
        result = prime * result + ((getCallerOwen() == null) ? 0 : getCallerOwen().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustSex() == null) ? 0 : getCustSex().hashCode());
        result = prime * result + ((getIsTranPie() == null) ? 0 : getIsTranPie().hashCode());
        result = prime * result + ((getExecutedeptid() == null) ? 0 : getExecutedeptid().hashCode());
        result = prime * result + ((getExecuteperson() == null) ? 0 : getExecuteperson().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", processInsId=").append(processInsId);
        sb.append(", quesCode=").append(quesCode);
        sb.append(", quesTitle=").append(quesTitle);
        sb.append(", quesDetails=").append(quesDetails);
        sb.append(", quesUrl=").append(quesUrl);
        sb.append(", serviceModule=").append(serviceModule);
        sb.append(", serviceModuleName=").append(serviceModuleName);
        sb.append(", clientType=").append(clientType);
        sb.append(", contactWay=").append(contactWay);
        sb.append(", status=").append(status);
        sb.append(", currentCaller=").append(currentCaller);
        sb.append(", callerOwen=").append(callerOwen);
        sb.append(", custName=").append(custName);
        sb.append(", custSex=").append(custSex);
        sb.append(", isTranPie=").append(isTranPie);
        sb.append(", executedeptid=").append(executedeptid);
        sb.append(", executeperson=").append(executeperson);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}