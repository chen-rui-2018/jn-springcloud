package com.jn.enterprise.workflow.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 常规待办事项
 * @author： huxw
 * @date： Created on 2019-5-24 18:03:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CommonTaskListVO", description = "常规待办事项")
public class CommonTaskListVO implements Serializable {

    @ApiModelProperty(value = "待办ID")
    private String taskId;

    @ApiModelProperty(value = "待办名称")
    private String taskName;

    @ApiModelProperty(value = "待办数目")
    private Integer taskNum;

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

    public Integer getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(Integer taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public String toString() {
        return "CommonTaskVO{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskNum=" + taskNum +
                '}';
    }
}
