package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/13 22:40
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "IBPSCompleteParam", description = "IBPS处理任务入参")
public class IBPSCompleteParam implements Serializable {
    @ApiModelProperty(value = "任务ID",required = true)
    private String taskId;
    @ApiModelProperty(value = "工作名称",required = true)
    private String actionName;
    @ApiModelProperty(value = "审批意见")
    private String opinion;
    @ApiModelProperty(value = "流程表单数据")
    private Object data;
    @ApiModelProperty(value = "节点执行人")
    private String nodeUsers;
    @ApiModelProperty(value = "是否会签")
    private String directHandlerSign;
    @ApiModelProperty(value = "驳回模式")
    private String backHandMode;
    @ApiModelProperty(value = "驳回节点")
    private String destination;
    @ApiModelProperty(value = "版本号")
    private String version;
    @ApiModelProperty(value = "流程动态变量")
    private String procVars;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getNodeUsers() {
        return nodeUsers;
    }

    public void setNodeUsers(String nodeUsers) {
        this.nodeUsers = nodeUsers;
    }

    public String getDirectHandlerSign() {
        return directHandlerSign;
    }

    public void setDirectHandlerSign(String directHandlerSign) {
        this.directHandlerSign = directHandlerSign;
    }

    public String getBackHandMode() {
        return backHandMode;
    }

    public void setBackHandMode(String backHandMode) {
        this.backHandMode = backHandMode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProcVars() {
        return procVars;
    }

    public void setProcVars(String procVars) {
        this.procVars = procVars;
    }
}
