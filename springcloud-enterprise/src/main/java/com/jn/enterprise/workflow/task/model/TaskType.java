package com.jn.enterprise.workflow.task.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    private String status;

    @ApiModelProperty(value = "事项分类：1：数据上报、2：综合缴费、3：综合租赁")
    private String type;

    @ApiModelProperty(value = "初始化每个分类查询几条事项任务" , example = "3")
    private Integer rowCount;

    @ApiModelProperty(value = "用户id'")
    private String userId;


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
}
