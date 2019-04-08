package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 17:03
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "GardenCheckList",description = "园区审核列表")
public class GardenCheckList {
    @ApiModelProperty(value = "填报状态")
    private String status;

    @ApiModelProperty(value = "账期")
    private String formTime;

    @ApiModelProperty(value = "模板名称")
    private String modelName;

    @ApiModelProperty(value = "工单编号")
    private String fillId;

    @ApiModelProperty(value = "填报人")
    private String filler;

    @ApiModelProperty(value = "填报人电话")
    private String fillerTel;

    @ApiModelProperty(value = "上报时间")
    private String upTime;

    @ApiModelProperty(value = "部门名称")
    private String fillInFormName;

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

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getFillInFormName() {
        return fillInFormName;
    }

    public void setFillInFormName(String fillInFormName) {
        this.fillInFormName = fillInFormName;
    }
}
