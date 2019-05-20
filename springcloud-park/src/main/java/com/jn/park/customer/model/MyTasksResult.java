package com.jn.park.customer.model;

import com.google.gson.internal.LinkedTreeMap;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/19 18:33
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "MyTasksResult",description = "客服中心我的待办返回数据")
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
    private List<LinkedTreeMap<String,String>>  skipResult;
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

    public List<LinkedTreeMap<String, String>> getSkipResult() {
        return skipResult;
    }

    public void setSkipResult(List<LinkedTreeMap<String, String>> skipResult) {
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
}
