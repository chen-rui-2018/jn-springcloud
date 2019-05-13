package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 11:39
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MonthlyFeeRule",description = "道尔:月租计费规则")
public class MonthlyFeeRule implements Serializable {
    private static final long serialVersionUID = 4409637565422732478L;
    @ApiModelProperty(value = "月租计费规则名称")
    private String name;
    @ApiModelProperty(value = "月租计费规则价格（单位元）")
    private String rate;
    @ApiModelProperty(value = "月租计费规则（单位月）")
    private String unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "MonthlyFeeRule{" +
                "name='" + name + '\'' +
                ", rate='" + rate + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
