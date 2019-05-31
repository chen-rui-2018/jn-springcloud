package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/19 18:33
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "MyTasksResult",description = "我的待办返回数据")
public class MyTasksResult implements Serializable {
    @ApiModelProperty("主键")
    private String pk;
    @ApiModelProperty("节点名称")
    private String name;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("流程主键id")
    private String id;
    @ApiModelProperty("流程提交说明")
    private String subject;
    @ApiModelProperty("创建人id")
    private String createBy;
    @ApiModelProperty("更新人id")
    private String updateBy;
    @ApiModelProperty("更新时间")
    private String updateTime;
    @ApiModelProperty("bizKey")
    private String bizKey;
    @ApiModelProperty("表单类型")
    private String formType;
    @ApiModelProperty("表单key")
    private String formKey;
    @ApiModelProperty("最后时间")
    private String endTime;
    @ApiModelProperty("响应时间")
    private int duration;
    @ApiModelProperty("是否普通")
    private String isFormmal;
    @ApiModelProperty("父流程节点id")
    private String parentInstId;
    @ApiModelProperty("是否禁止")
    private int isForbidden;
    @ApiModelProperty("结果类型")
    private String resultType;
    @ApiModelProperty("数据模型")
    private String dataMode;
    @ApiModelProperty("禁止")
    private String forbidden;
    @ApiModelProperty("流程实例id")
    private String procInstId;
    @ApiModelProperty("任务id")
    private String taskId;
    @ApiModelProperty("可执行id")
    private String execId;
    @ApiModelProperty("节点id")
    private String nodeId;
    @ApiModelProperty("流程定义id")
    private String procDefId;
    @ApiModelProperty("流程定义key")
    private String procDefKey;
    @ApiModelProperty("流程定义名称")
    private String procDefName;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("优先级")
    private int priority;
    @ApiModelProperty("暂停状态值")
    private int suspendState;
    @ApiModelProperty("业务流程建模实例id")
    private String bpmnInstId;
    @ApiModelProperty("业务流程建模编码")
    private String bpmnDefId;
    @ApiModelProperty("类型id")
    private String typeId;
    @ApiModelProperty("锁定状态值")
    private int lockState;
    @ApiModelProperty("锁定人")
    private int lockUser;
    @ApiModelProperty("允许释放")
    private String allowShfit;
    @ApiModelProperty("跳转结果")
    private Object  skipResult;
    @ApiModelProperty("可执行人名称")
    private String ownerName;
    @ApiModelProperty("提醒时间")
    private int remindTimes;
    @ApiModelProperty("执行人是否为空")
    private boolean identityEmpty;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBizKey() {
        return bizKey;
    }

    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIsFormmal() {
        return isFormmal;
    }

    public void setIsFormmal(String isFormmal) {
        this.isFormmal = isFormmal;
    }

    public String getParentInstId() {
        return parentInstId;
    }

    public void setParentInstId(String parentInstId) {
        this.parentInstId = parentInstId;
    }

    public int getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(int isForbidden) {
        this.isForbidden = isForbidden;
    }

    public String getDataMode() {
        return dataMode;
    }

    public void setDataMode(String dataMode) {
        this.dataMode = dataMode;
    }

    public String getForbidden() {
        return forbidden;
    }

    public void setForbidden(String forbidden) {
        this.forbidden = forbidden;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getProcDefKey() {
        return procDefKey;
    }

    public void setProcDefKey(String procDefKey) {
        this.procDefKey = procDefKey;
    }

    public String getProcDefName() {
        return procDefName;
    }

    public void setProcDefName(String procDefName) {
        this.procDefName = procDefName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getSuspendState() {
        return suspendState;
    }

    public void setSuspendState(int suspendState) {
        this.suspendState = suspendState;
    }

    public String getBpmnInstId() {
        return bpmnInstId;
    }

    public void setBpmnInstId(String bpmnInstId) {
        this.bpmnInstId = bpmnInstId;
    }

    public String getBpmnDefId() {
        return bpmnDefId;
    }

    public void setBpmnDefId(String bpmnDefId) {
        this.bpmnDefId = bpmnDefId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getLockState() {
        return lockState;
    }

    public void setLockState(int lockState) {
        this.lockState = lockState;
    }

    public int getLockUser() {
        return lockUser;
    }

    public void setLockUser(int lockUser) {
        this.lockUser = lockUser;
    }

    public String getAllowShfit() {
        return allowShfit;
    }

    public void setAllowShfit(String allowShfit) {
        this.allowShfit = allowShfit;
    }

    public Object getSkipResult() {
        return skipResult;
    }

    public void setSkipResult(Object skipResult) {
        this.skipResult = skipResult;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getRemindTimes() {
        return remindTimes;
    }

    public void setRemindTimes(int remindTimes) {
        this.remindTimes = remindTimes;
    }

    public boolean isIdentityEmpty() {
        return identityEmpty;
    }

    public void setIdentityEmpty(boolean identityEmpty) {
        this.identityEmpty = identityEmpty;
    }

    @Override
    public String toString() {
        return "MyTasksResult{" +
                "pk='" + pk + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", bizKey='" + bizKey + '\'' +
                ", formType='" + formType + '\'' +
                ", formKey='" + formKey + '\'' +
                ", endTime='" + endTime + '\'' +
                ", duration=" + duration +
                ", isFormmal='" + isFormmal + '\'' +
                ", parentInstId='" + parentInstId + '\'' +
                ", isForbidden=" + isForbidden +
                ", resultType='" + resultType + '\'' +
                ", dataMode='" + dataMode + '\'' +
                ", forbidden='" + forbidden + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", execId='" + execId + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", procDefId='" + procDefId + '\'' +
                ", procDefKey='" + procDefKey + '\'' +
                ", procDefName='" + procDefName + '\'' +
                ", status='" + status + '\'' +
                ", priority=" + priority +
                ", suspendState=" + suspendState +
                ", bpmnInstId='" + bpmnInstId + '\'' +
                ", bpmnDefId='" + bpmnDefId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", lockState=" + lockState +
                ", lockUser=" + lockUser +
                ", allowShfit='" + allowShfit + '\'' +
                ", skipResult=" + skipResult +
                ", ownerName='" + ownerName + '\'' +
                ", remindTimes=" + remindTimes +
                ", identityEmpty=" + identityEmpty +
                '}';
    }
}
