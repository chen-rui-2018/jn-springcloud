package com.jn.enterprise.data.vo;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 16:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyDataStatisticsParam" ,description = "")
public class CompanyDataStatisticsParam extends Page implements Serializable {
    @ApiModelProperty(value = "填报状态")
    private String status;

    @ApiModelProperty(value = "账期")
    private String formTime;

    @ApiModelProperty(value = "模板名称")
    private String modelName;

    @ApiModelProperty(value = "填报周期")
    private String modelCycle;

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

    public String getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(String modelCycle) {
        this.modelCycle = modelCycle;
    }
}
