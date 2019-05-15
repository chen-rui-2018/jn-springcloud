package com.jn.park.plan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
@ApiModel(value = "CompleteRatioModel",description = "完成及时率")
public class CompleteRatioModel implements Serializable {


    private static final long serialVersionUID = 8586735657548846710L;
    @ApiModelProperty(value = "计划要完成数量")
    private String plan;

    @ApiModelProperty(value = "累计已完成数量")
    private String autual;

    @ApiModelProperty(value = "完成及时率")
    private String completeRatio;


    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getAutual() {
        return autual;
    }

    public void setAutual(String autual) {
        this.autual = autual;
    }

    public String getCompleteRatio() {
        return completeRatio;
    }

    public void setCompleteRatio(String completeRatio) {
        this.completeRatio = completeRatio;
    }

    @Override
    public String toString() {
        return "CompleteRatioModel{" +
                "plan='" + plan + '\'' +
                ", autual='" + autual + '\'' +
                ", completeRatio='" + completeRatio + '\'' +
                '}';
    }
}
