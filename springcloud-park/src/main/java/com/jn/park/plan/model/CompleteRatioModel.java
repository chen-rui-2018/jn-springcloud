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
    List<String> plan;

    @ApiModelProperty(value = "累计已完成数量")
    List<String> autual;

    @ApiModelProperty(value = "完成及时率")
    List<String> completeRatio;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getPlan() {
        return plan;
    }

    public void setPlan(List<String> plan) {
        this.plan = plan;
    }

    public List<String> getAutual() {
        return autual;
    }

    public void setAutual(List<String> autual) {
        this.autual = autual;
    }

    public List<String> getCompleteRatio() {
        return completeRatio;
    }

    public void setCompleteRatio(List<String> completeRatio) {
        this.completeRatio = completeRatio;
    }

    @Override
    public String toString() {
        return "CompleteRatioModel{" +
                "plan=" + plan +
                ", autual=" + autual +
                ", completeRatio=" + completeRatio +
                '}';
    }
}
