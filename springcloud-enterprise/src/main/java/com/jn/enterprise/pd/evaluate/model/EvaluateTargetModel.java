package com.jn.enterprise.pd.evaluate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**企业基本信息
 * @author： huangbq
 * @date： Created on 2019/4/2 19:04
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "EvaluateTargetModel",description = "测评指标信息")
public class EvaluateTargetModel implements Serializable {

    @ApiModelProperty(value = "指标ID",example = "2323232323")
    private String id;
    @ApiModelProperty(value = "指标名称",example = "主营业务收入")
    private String name;
    @ApiModelProperty(value = "指标值",example = "3400")
    private String value;
    @ApiModelProperty(value = "指标单位",example = "万元")
    private String unit;
    @ApiModelProperty(value = "指标类型（0：月指标，1：年指标）",example = "0")
    private String type;
    @ApiModelProperty(value = "指标时间(格式YYYYMM，年指标没有月份)",example = "201904")
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}