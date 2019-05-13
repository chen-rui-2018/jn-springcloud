package com.jn.enterprise.data.model;

import com.github.pagehelper.PageInfo;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 17:03
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "GardenCheckModel",description = "园区审核列表")
public class GardenCheckModel implements Serializable{
    @ApiModelProperty(value = "填报状态",example = "0")
    private String status;

    @ApiModelProperty(value = "账期",example = "201812")
    private String formTime;

    @ApiModelProperty(value = "模板名称",example = "XXXX模板")
    private String modelName;

    @ApiModelProperty(value = "工单编号",example = "1231233")
    private String fillId;

    @ApiModelProperty(value = "填报人",example = "zhansan")
    private String filler;

    @ApiModelProperty(value = "填报人电话",example = "13111111111")
    private String fillerTel;

    @ApiModelProperty(value = "上报时间",example = "2018-12-21 21:12:12")
    private Date upTime;

    @ApiModelProperty(value = "部门名称",example = "招商部")
    private String fillInFormName;

    @ApiModelProperty(value = "任务批次",example = "001")
    private String taskBatch;

    @ApiModelProperty(value = "任务周期",example = "1")
    private String modelCycle;

    public String getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(String modelCycle) {
        this.modelCycle = modelCycle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getFillerTel() {
        return fillerTel;
    }

    public void setFillerTel(String fillerTel) {
        this.fillerTel = fillerTel;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getFillInFormName() {
        return fillInFormName;
    }

    public void setFillInFormName(String fillInFormName) {
        this.fillInFormName = fillInFormName;
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch;
    }
}
