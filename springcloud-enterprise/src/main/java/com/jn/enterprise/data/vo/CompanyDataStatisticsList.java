package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 16:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CompanyDataStatisticsList", description = "数据统计列表")
public class CompanyDataStatisticsList implements Serializable {
    @ApiModelProperty(value = "填报周期")
    private String modelCycle;

    @ApiModelProperty(value = "模板名称")
    private String modelName;

    @ApiModelProperty(value = "账期")
    private String formTime;

    @ApiModelProperty(value = "截至日期")
    private String fillInFormDeadline;

    @ApiModelProperty(value = "总数")
    private String all;

    @ApiModelProperty(value = "已上报")
    private String upload;

    @ApiModelProperty(value = "逾期上报")
    private String overdue;

    @ApiModelProperty(value = "未上报")
    private String noUpload;

    @ApiModelProperty(value = "上报状态")
    private String status;

    @ApiModelProperty(value = "最后催报时间")
    private String  callingTime;

    @ApiModelProperty(value = "提前预警天数")
    private String  warningBeforeDays;

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

    public String getFillInFormDeadline() {
        return fillInFormDeadline;
    }

    public void setFillInFormDeadline(String fillInFormDeadline) {
        this.fillInFormDeadline = fillInFormDeadline;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
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

    public String getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(String callingTime) {
        this.callingTime = callingTime;
    }

    public String getWarningBeforeDays() {
        return warningBeforeDays;
    }

    public void setWarningBeforeDays(String warningBeforeDays) {
        this.warningBeforeDays = warningBeforeDays;
    }
}
