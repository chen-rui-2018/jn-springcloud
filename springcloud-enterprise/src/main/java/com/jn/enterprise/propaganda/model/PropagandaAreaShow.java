package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/25 16:04
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PropagandaAreaShow", description = "宣传区域出参")
public class PropagandaAreaShow implements Serializable {
    @ApiModelProperty(value = "宣传区域编码")
    private String propagandaArea;
    @ApiModelProperty(value = "宣传区域url")
    private String propagandaAreaUrl;
    @ApiModelProperty(value = "宣传区域金额")
    private String areaAmount;

    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea;
    }

    public String getPropagandaAreaUrl() {
        return propagandaAreaUrl;
    }

    public void setPropagandaAreaUrl(String propagandaAreaUrl) {
        this.propagandaAreaUrl = propagandaAreaUrl;
    }

    public String getAreaAmount() {
        return areaAmount;
    }

    public void setAreaAmount(String areaAmount) {
        this.areaAmount = areaAmount;
    }

    @Override
    public String toString() {
        return "PropagandaAreaShow{" +
                "propagandaArea='" + propagandaArea + '\'' +
                ", propagandaAreaUrl='" + propagandaAreaUrl + '\'' +
                ", areaAmount='" + areaAmount + '\'' +
                '}';
    }
}
