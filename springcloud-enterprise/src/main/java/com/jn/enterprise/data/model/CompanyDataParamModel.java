package com.jn.enterprise.data.model;

import com.jn.common.model.Page;
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
@ApiModel(value = "CompanyDataParamModel",description = "企业/园区数据统计详细列表的获取参数")
public class CompanyDataParamModel extends Page implements Serializable {

    @ApiModelProperty(value = "公司名称",example = "XXX企业")
    private String fillInFormName;

    @ApiModelProperty(value = "企业填报状态0：已上报；1未上报；2：逾期上报；",example = "1")
    private String status;

    @ApiModelProperty(value = "账期",example = "201812")
    private String formTime;

    @ApiModelProperty(value = "模板名称",example = "XXXX模板")
    private String modelName;

    @ApiModelProperty(value = "填报周期/报表类型(1：年，0：月)",example = "1")
    private String modelCycle;

    @ApiModelProperty(value = "截至日期",example = "2018-12-12 12:12:12")
    private Date fillInFormDeadline;

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

    public Date getFillInFormDeadline() {
        return fillInFormDeadline;
    }

    public void setFillInFormDeadline(Date fillInFormDeadline) {
        this.fillInFormDeadline = fillInFormDeadline;
    }

}
