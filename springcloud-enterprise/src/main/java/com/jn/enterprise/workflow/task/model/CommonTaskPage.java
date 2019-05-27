package com.jn.enterprise.workflow.task.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 常规事项任务入参
 * @author： huxw
 * @date： Created on 2019-5-25 10:47:27
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CommonTaskPage", description = "常规事项任务入参")
public class CommonTaskPage extends Page implements Serializable {

    @ApiModelProperty(value = "待办类型ID", required = true)
    @NotNull(message = "待办类型ID不能为空")
    private String taskId;

    @ApiModelProperty(value = "账号", hidden = true)
    private String account;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CommonTaskPage{" +
                "taskId='" + taskId + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
