package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 16:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyDataList" ,description = "数据统计详细列表")
public class CompanyDataList implements Serializable {
    @ApiModelProperty(value = "企业上报：公司名称：园区上报：部门名称")
    private String fillInFormName;

    @ApiModelProperty(value = "填报状态")
    private String status;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @ApiModelProperty(value = "填报Id")
    private String fileId;

    @ApiModelProperty(value = "账期")
    private String formTime;

    @ApiModelProperty(value = "填报人")
    private String filler;

    @ApiModelProperty(value = "填报人电话")
    private String fillerTel;

    @ApiModelProperty(value = "上报时间")
    private String upTime;

    @ApiModelProperty(value = "催报次数")
    private String callingTimes;

    @ApiModelProperty(value = "最后催报时间")
    private String  callingTime;

    @ApiModelProperty(value = "模板名称")
    private String  modelName;

    @ApiModelProperty(value = "是否逾期")
    private String  isOverdue;

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

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getCallingTimes() {
        return callingTimes;
    }

    public void setCallingTimes(String callingTimes) {
        this.callingTimes = callingTimes;
    }

    public String getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(String callingTime) {
        this.callingTime = callingTime;
    }
}
