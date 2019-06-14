package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/5/14 10:12
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ConsultationCustomerListShow",description = "客服中心园区用户咨询客服列表出参")
public class ConsultationCustomerListShow implements Serializable {
    @ApiModelProperty("用户账号)")
    private String userAccount;
    @ApiModelProperty("流程实例id(启动工作流后的流程实例id)")
    private String processInsId;
    @ApiModelProperty("任务id(工作流流转后的节点任务id)")
    private String taskId;
    @ApiModelProperty("问题编码")
    private String quesCode;
    @ApiModelProperty("业务模块名称")
    private String serviceModuleName;
    @ApiModelProperty("问题标题")
    private String quesTitle;
    @ApiModelProperty("问题详情")
    private String quesDetails;
    @ApiModelProperty("处理状态(0：待处理 1：处理中 2：已处理 3：无法处理)")
    private String status;
    @ApiModelProperty("发布时间")
    private String createdTime;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getProcessInsId() {
        return processInsId;
    }

    public void setProcessInsId(String processInsId) {
        this.processInsId = processInsId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

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

    public String getServiceModuleName() {
        return serviceModuleName;
    }

    public void setServiceModuleName(String serviceModuleName) {
        this.serviceModuleName = serviceModuleName;
    }

    public String getQuesDetails() {
        return quesDetails;
    }

    public void setQuesDetails(String quesDetails) {
        this.quesDetails = quesDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ConsultationCustomerListShow{" +
                "userAccount='" + userAccount + '\'' +
                ", processInsId='" + processInsId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", quesCode='" + quesCode + '\'' +
                ", serviceModuleName='" + serviceModuleName + '\'' +
                ", quesTitle='" + quesTitle + '\'' +
                ", quesDetails='" + quesDetails + '\'' +
                ", status='" + status + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
