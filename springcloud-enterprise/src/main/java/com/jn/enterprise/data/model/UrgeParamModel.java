package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/6/20 16:56
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UrgeParamModel",description = "催报model")
public class UrgeParamModel implements Serializable {

    @ApiModelProperty(value = "任务id",example = "001")
    private String fillId;

    @ApiModelProperty(value = "任务批次",example = "003")
    private String taskBatch;

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch;
    }
}
