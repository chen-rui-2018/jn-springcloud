package com.jn.enterprise.data.vo;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 16:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyDataParam",description = "企业数据统计详细列表的获取参数")
public class CompanyDataParam extends Page implements Serializable {

    @ApiModelProperty(value = "公司名称")
    private String fillInFormName;

    @ApiModelProperty(value = "填报状态")
    private String status;

    @ApiModelProperty(value = "账期")
    private String formTime;

    @ApiModelProperty(value = "模板名称")
    private String modelName;

    @ApiModelProperty(value = "填报周期/报表类型")
    private String modelCycle;

    @ApiModelProperty(value = "截至日期")
    private String fillInFormDeadline;

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

    public String getFillInFormDeadline() {
        return fillInFormDeadline;
    }

    public void setFillInFormDeadline(String fillInFormDeadline) {
        this.fillInFormDeadline = fillInFormDeadline;
    }

}
