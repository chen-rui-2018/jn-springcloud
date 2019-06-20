package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @Author: yangph
 * @Date: 2019/5/20 12:24
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "IBPSCompleteCustomerParam",description = "客服中心处理任务入参")
public class IBPSCompleteCustomerParam implements Serializable {
    @ApiModelProperty(value = "流程实例id",required = true,example = "579315482578911232")
    private String procInstId;
    @ApiModelProperty(value = "任务id",required = true,example = "579322447203926017")
    private String taskId;
    @ApiModelProperty(value = "操作名称(同意/提交：agree ,反对/无法处理：oppose ,驳回上一步/转回客服中心：rejectToPrevious)",required = true,example = "agree")
    private String actionName;
    @ApiModelProperty(value = "处理意见",required = true,example = "已经解决...")
    @Size(max=500,message = "处理意见不能超过500字")
    private String opinion;
    @ApiModelProperty(value = "处理问题描述url(最多允许3张图片)",example = "http://.../123.jpg")
    private String[] opinionUrl;

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

    public String[] getOpinionUrl() {
        return opinionUrl;
    }

    public void setOpinionUrl(String[] opinionUrl) {
        this.opinionUrl = opinionUrl;
    }

    @Override
    public String toString() {
        return "IBPSCompleteCustomerParam{" +
                "procInstId='" + procInstId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", actionName='" + actionName + '\'' +
                ", opinion='" + opinion + '\'' +
                ", opinionUrl=" + Arrays.toString(opinionUrl) +
                '}';
    }
}
