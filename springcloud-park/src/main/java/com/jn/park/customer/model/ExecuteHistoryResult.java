package com.jn.park.customer.model;

import com.google.gson.internal.LinkedTreeMap;
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
@ApiModel(value = "ConsultationCustomerListParam",description = "客服中心园区用户问题处理流程历史记录返回数据")
public class ExecuteHistoryResult implements Serializable {
    @ApiModelProperty("流程主键id")
    private String id;
    @ApiModelProperty("主键")
    private String pk;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("流程定义id")
    private String procDefId;
    @ApiModelProperty("流程实例id")
    private String procInstId;
    @ApiModelProperty("父流程节点id")
    private String supInstId;
    @ApiModelProperty("任务key")
    private String taskKey;
    @ApiModelProperty("任务名称")
    private String taskName;
    @ApiModelProperty("任务id")
    private String taskId;
    @ApiModelProperty("节点可执行人的信息")
    private Object qualfieds;
    @ApiModelProperty("节点执行人用户id")
    private String auditor;
    @ApiModelProperty("操作说明")
    private String opinion;
    @ApiModelProperty("操作状态")
    private String status;
    @ApiModelProperty("处理时间")
    private String completeTime;
    @ApiModelProperty("总耗时")
    private long durMs;
    @ApiModelProperty("内部提出")
    private int interpose;
    @ApiModelProperty("执行人信息")
    private List<LinkedTreeMap<String,String>> qualifiedExecutor;
    @ApiModelProperty("用户图片")
    private String userImg;
    @ApiModelProperty("操作状态名称")
    private String statusName;
    @ApiModelProperty("节点执行人账号")
    private String auditorName;
    @ApiModelProperty("呼叫提交")
    private boolean callSub;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getSupInstId() {
        return supInstId;
    }

    public void setSupInstId(String supInstId) {
        this.supInstId = supInstId;
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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Object getQualfieds() {
        return qualfieds;
    }

    public void setQualfieds(Object qualfieds) {
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

    public long getDurMs() {
        return durMs;
    }

    public void setDurMs(long durMs) {
        this.durMs = durMs;
    }

    public int getInterpose() {
        return interpose;
    }

    public void setInterpose(int interpose) {
        this.interpose = interpose;
    }

    public List<LinkedTreeMap<String, String>> getQualifiedExecutor() {
        return qualifiedExecutor;
    }

    public void setQualifiedExecutor(List<LinkedTreeMap<String, String>> qualifiedExecutor) {
        this.qualifiedExecutor = qualifiedExecutor;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public boolean isCallSub() {
        return callSub;
    }

    public void setCallSub(boolean callSub) {
        this.callSub = callSub;
    }

    @Override
    public String toString() {
        return "ExecuteHistoryResult{" +
                "id='" + id + '\'' +
                ", pk='" + pk + '\'' +
                ", createTime='" + createTime + '\'' +
                ", procDefId='" + procDefId + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", supInstId='" + supInstId + '\'' +
                ", taskKey='" + taskKey + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskId='" + taskId + '\'' +
                ", qualfieds=" + qualfieds +
                ", auditor='" + auditor + '\'' +
                ", opinion='" + opinion + '\'' +
                ", status='" + status + '\'' +
                ", completeTime='" + completeTime + '\'' +
                ", durMs=" + durMs +
                ", interpose=" + interpose +
                ", qualifiedExecutor=" + qualifiedExecutor +
                ", userImg='" + userImg + '\'' +
                ", statusName='" + statusName + '\'' +
                ", auditorName='" + auditorName + '\'' +
                ", callSub=" + callSub +
                '}';
    }
}
