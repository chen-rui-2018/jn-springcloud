package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 16:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CompanyDataStatisticsListModel", description = "数据统计列表")
public class CompanyDataStatisticsModel implements Serializable {
    @ApiModelProperty(value = "填报周期（1：年，0：月)",example = "0")
    private String modelCycle;

    @ApiModelProperty(value = "模板名称",example = "XXXX企业")
    private String modelName;

    @ApiModelProperty(value = "账期",example = "201812")
    private String formTime;

    @ApiModelProperty(value = "截至日期",example = "2018-12-12")
    private Date fillInFormDeadline;

    @ApiModelProperty(value = "总数",example = "13")
    private String allTotal;

    @ApiModelProperty(value = "已上报",example = "12")
    private String upload;

    @ApiModelProperty(value = "逾期上报",example = "0")
    private String overdue;

    @ApiModelProperty(value = "未上报",example = "1")
    private String noUpload;

    @ApiModelProperty(value = "上报状态",example = "未上报")
    private String status;

    @ApiModelProperty(value = "最后催报时间",example = "2018-12-21")
    private Date callingTime;

    @ApiModelProperty(value = "提前预警天数",example = "7")
    private String  warningBeforeDays;

    @ApiModelProperty(value = "模板Id",example = "001")
    private String modelId;

    @ApiModelProperty(value = "任务批次",example = "002")
    private String taskBatch;

    public String getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(String modelCycle) {
        this.modelCycle = modelCycle;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
    }

    public Date getFillInFormDeadline() {
        return fillInFormDeadline;
    }

    public void setFillInFormDeadline(Date fillInFormDeadline) {
        this.fillInFormDeadline = fillInFormDeadline;
    }

    public String getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(String allTotal) {
        this.allTotal = allTotal;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public String getNoUpload() {
        return noUpload;
    }

    public void setNoUpload(String noUpload) {
        this.noUpload = noUpload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(Date callingTime) {
        this.callingTime = callingTime;
    }

    public String getWarningBeforeDays() {
        return warningBeforeDays;
    }

    public void setWarningBeforeDays(String warningBeforeDays) {
        this.warningBeforeDays = warningBeforeDays;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch;
    }
}
