package com.jn.enterprise.data.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 17:03
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GardenCheckParamModel",description = "园区审核列表查询参数")
public class GardenCheckParamModel extends Page implements Serializable {

    @ApiModelProperty(value = "填报状态",example = "1")
    private String status;

    @ApiModelProperty(value = "账期",example = "201812")
    private String formTime;

    @ApiModelProperty(value = "模板名称",example = "XXXX模板")
    private String modelName;

    @ApiModelProperty(value = "工单编号",example = "1234567")
    private String fillId;

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
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
}
