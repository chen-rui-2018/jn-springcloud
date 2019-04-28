package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 16:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyDataModel" ,description = "数据统计详细列表")
public class CompanyDataModel implements Serializable {
    @ApiModelProperty(value = "企业上报：公司名称：园区上报：部门名称",example = "XXXX企业")
    private String fillInFormName;

    @ApiModelProperty(value = "填报状态",example = "1")
    private Byte status;

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
    }

    @ApiModelProperty(value = "填报Id",example = "001")
    private String fillId;

    @ApiModelProperty(value = "账期",example = "201811")
    private String formTime;

    @ApiModelProperty(value = "填报人",example = "张三")
    private String filler;

    @ApiModelProperty(value = "填报人电话",example = "13111411111")
    private String fillerTel;

    @ApiModelProperty(value = "上报时间",example = "2019-12-12 12:12:12")
    private Date upTime;

    @ApiModelProperty(value = "催报次数",example = "2")
    private String callingTimes;

    @ApiModelProperty(value = "最后催报时间",example = "2019-12-12 12:12:12")
    private Date callingTime;

    @ApiModelProperty(value = "模板名称",example = "XXX企业")
    private String  modelName;

    @ApiModelProperty(value = "是否逾期1：是；0：否",example = "1")
    private String  isOverdue;

    @ApiModelProperty(value = "模板ID",example = "101")
    private String  modelId;

    @ApiModelProperty(value = "填报周期（1：年，0：月）",example = "1")
    private Byte modelCycle;

    @ApiModelProperty(value = "任务批次",example = "001")
    private String taskBatch;

    @ApiModelProperty( value="填报类型（0：企业，1：园管委会）", example="0" )
    private Byte fileType;

    @ApiModelProperty( value="填报对象名称；是园区时，存储部门ID;企业时填写企业ID", example="0001" )
    private String fillInFormId;

    @ApiModelProperty( value="填报截至时间", example="2018-12-09" )
    private Date fillInFormDeadline;

    @ApiModelProperty( value="剩余填报天数", example="5" )
    private Integer residueDays;

    @ApiModelProperty( value="逾期天数", example="5" )
    private Integer overdueDays;

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Integer getResidueDays() {
        return residueDays;
    }

    public void setResidueDays(Integer residueDays) {
        this.residueDays = residueDays;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getFileType() {
        return fileType;
    }

    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    public String getFillInFormId() {
        return fillInFormId;
    }

    public void setFillInFormId(String fillInFormId) {
        this.fillInFormId = fillInFormId;
    }

    public Date getFillInFormDeadline() {
        return fillInFormDeadline;
    }

    public void setFillInFormDeadline(Date fillInFormDeadline) {
        this.fillInFormDeadline = fillInFormDeadline;
    }

    public String getTaskBatch() {
        return taskBatch;
    }

    public void setTaskBatch(String taskBatch) {
        this.taskBatch = taskBatch;
    }

    public Byte getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(Byte modelCycle) {
        this.modelCycle = modelCycle;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(String isOverdue) {
        this.isOverdue = isOverdue;
    }

    public String getFillInFormName() {
        return fillInFormName;
    }

    public void setFillInFormName(String fillInFormName) {
        this.fillInFormName = fillInFormName;
    }

    public Byte getStatus() {
        return status;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
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

    public String getCallingTimes() {
        return callingTimes;
    }

    public void setCallingTimes(String callingTimes) {
        this.callingTimes = callingTimes;
    }

    public Date getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(Date callingTime) {
        this.callingTime = callingTime;
    }
}
