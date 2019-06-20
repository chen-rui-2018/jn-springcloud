package com.jn.enterprise.data.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/6 14:59
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ScientLookupParamModel" ,description = "科技园任务查询接口")
public class ScientLookupParamModel extends Page implements Serializable {
    @ApiModelProperty(value = "纳税人名称",example = "上海天堂孟婆神汤研发公司")
    private String companyName;

    @ApiModelProperty(value = "任务Id",example = "111")
    private String fillId;
    @ApiModelProperty(value = "账期",example = "201812")
    private String formTime;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
    }
}
