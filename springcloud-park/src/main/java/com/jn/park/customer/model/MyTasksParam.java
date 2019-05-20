package com.jn.park.customer.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/19 16:11
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "MyTasksParam",description = "客服中心查询工作流我的待办入参")
public class MyTasksParam extends Page implements Serializable {
    @ApiModelProperty(value = "流程实例id",example = "579315482578911232")
    private String procInstId;
    @ApiModelProperty(value = "任务id",example = "579322447203926017")
    private String taskId;
    @ApiModelProperty(value = "流程定义id",example = "578298796161630208")
    private String procDefId;
    @ApiModelProperty(value = "流程定义key",example = "Process_0mor50r")
    private String procDefKey;
    @ApiModelProperty(value = "流程定义名称",example = "在线客服处理流程")
    private String procDefName;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

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

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
