package com.jn.enterprise.workflow.task.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 事项任务分页实体
 *
 * @author： yuanyy
 * @date： Created on 2019/4/18 14:21
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TaskType", description = "事项任务分页实体")
public class TaskType implements Serializable {

    @ApiModelProperty(value = "事项状态：1：待办、2：已办" , example = "1")
    @Pattern(regexp = "^[12]$", message = "事项状态校检错误")
    private String status;

    @ApiModelProperty(value = "事项分类：1：数据上报、2：综合缴费、3：综合租赁")
    @Pattern(regexp = "^[1-3]$", message = "事项分类校检错误")
    private String type;

    @ApiModelProperty(value = "初始化每个分类查询几条事项任务")
    private Integer rowCount;

    @ApiModelProperty(value = "用户id'", hidden = true)
    private String userId;

    @ApiModelProperty(value = "报警时间（单位：小时）", hidden = true)
    private Integer warnHour;

    public Integer getWarnHour() {
        return warnHour;
    }

    public void setWarnHour(Integer warnHour) {
        this.warnHour = warnHour;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", rowCount=" + rowCount +
                ", userId='" + userId + '\'' +
                ", warnHour='" + warnHour + '\'' +
                '}';
    }
}
