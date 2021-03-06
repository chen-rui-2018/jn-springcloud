package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/18 13:42
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ExecuteHistoryShow",description = "客服中心园区用户问题处理流程历史记录出参")
public class ExecuteHistoryShow implements Serializable {
    @ApiModelProperty("流程实例id")
    private String procInstId;
    @ApiModelProperty("执行时间")
    private String createTime;
    @ApiModelProperty("节点id/任务id")
    private String taskId;
    @ApiModelProperty("节点名称/任务名称")
    private String taskName;
    @ApiModelProperty("节点可执行人的账号")
    private String  executeAccounts;
    @ApiModelProperty("节点可执行人的用户id")
    private String  executeUserIds;
    @ApiModelProperty("节点执行人用户id")
    private String auditor;
    @ApiModelProperty("节点执行人账号")
    private String auditorName;
    @ApiModelProperty("操作说明")
    private String opinion;
    @ApiModelProperty("操作状态")
    private String status;
    @ApiModelProperty("操作状态名称")
    private String statusName;
    @ApiModelProperty("操作的部门id")
    private String optionDeptId;
    @ApiModelProperty("操作的部门名称")
    private String optionDeptName;
    @ApiModelProperty("节点图片url")
    private List<String>executePictureUrl;

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getExecuteAccounts() {
        return executeAccounts;
    }

    public void setExecuteAccounts(String executeAccounts) {
        this.executeAccounts = executeAccounts;
    }

    public String getExecuteUserIds() {
        return executeUserIds;
    }

    public void setExecuteUserIds(String executeUserIds) {
        this.executeUserIds = executeUserIds;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getOptionDeptId() {
        return optionDeptId;
    }

    public void setOptionDeptId(String optionDeptId) {
        this.optionDeptId = optionDeptId;
    }

    public String getOptionDeptName() {
        return optionDeptName;
    }

    public void setOptionDeptName(String optionDeptName) {
        this.optionDeptName = optionDeptName;
    }

    public List<String> getExecutePictureUrl() {
        return executePictureUrl;
    }

    public void setExecutePictureUrl(List<String> executePictureUrl) {
        this.executePictureUrl = executePictureUrl;
    }

    @Override
    public String toString() {
        return "ExecuteHistoryShow{" +
                "procInstId='" + procInstId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", executeAccounts='" + executeAccounts + '\'' +
                ", executeUserIds='" + executeUserIds + '\'' +
                ", auditor='" + auditor + '\'' +
                ", auditorName='" + auditorName + '\'' +
                ", opinion='" + opinion + '\'' +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", optionDeptId='" + optionDeptId + '\'' +
                ", optionDeptName='" + optionDeptName + '\'' +
                ", executePictureUrl=" + executePictureUrl +
                '}';
    }
}
