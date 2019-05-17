package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/17 15:40
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ConsultationCustomerListParam",description = "客服中心园区用户问题处理流程历史记录出参")
public class ExecuteHistoryResult implements Serializable {
    @ApiModelProperty("主键")
    private String pk;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("流程编号")
    private String procDefId;
    @ApiModelProperty("流程实例id")
    private String procInstId;
    @ApiModelProperty("节点id")
    private String taskKey;
    @ApiModelProperty("节点名称")
    private String taskName;
    @ApiModelProperty("节点执行人信息")
    private List<QualFieds> qualfieds;
    @ApiModelProperty("节点执行人用户id")
    private String auditor;
    @ApiModelProperty("操作说明")
    private String opinion;
    @ApiModelProperty("操作状态")
    private String status;
    @ApiModelProperty("处理时间")
    private String completeTime;
    @ApiModelProperty("总耗时")
    private String durMs;
    @ApiModelProperty("内部提出")
    private String interpose;
    @ApiModelProperty("执行人信息")
    private List<QualifiedExecutor> qualifiedExecutor;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<QualFieds> getQualfieds() {
        return qualfieds;
    }

    public void setQualfieds(List<QualFieds> qualfieds) {
        this.qualfieds = qualfieds;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getDurMs() {
        return durMs;
    }

    public void setDurMs(String durMs) {
        this.durMs = durMs;
    }

    public String getInterpose() {
        return interpose;
    }

    public void setInterpose(String interpose) {
        this.interpose = interpose;
    }

    public List<QualifiedExecutor> getQualifiedExecutor() {
        return qualifiedExecutor;
    }

    public void setQualifiedExecutor(List<QualifiedExecutor> qualifiedExecutor) {
        this.qualifiedExecutor = qualifiedExecutor;
    }
}
