package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： yangh
 * @date： Created on 2019/4/10 17:19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "RelationModel",description = "指标与Tab关联关系表")
public class RelationModel {
    @ApiModelProperty(value = "主键id",example = "001")
    private Integer id;

    @ApiModelProperty(value = "任务批次",example = "003")
    private String taskBatch;

    @ApiModelProperty(value = "指标ID",example = "123")
    private String targetId;

    @ApiModelProperty(value = "模板id",example = "001")
    private String modelId;

    @ApiModelProperty(value = "填报格式标识Id",example = "001")
    private String formId;

    @ApiModelProperty(value = "tabId",example = "002")
    private String tabId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }
}
