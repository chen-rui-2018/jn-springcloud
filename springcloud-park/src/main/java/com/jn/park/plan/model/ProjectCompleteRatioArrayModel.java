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
@ApiModel(value = "ProjectCompleteRatioArrayModel",description = "完成及时率")
public class ProjectCompleteRatioArrayModel implements Serializable {


    private static final long serialVersionUID = -504760096850558582L;
    @ApiModelProperty(value = "月份")
    List<String> month;

    @ApiModelProperty(value = "完成及时率")
    List<CompleteRatioModel> completeRatioModels;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getMonth() {
        return month;
    }

    public void setMonth(List<String> month) {
        this.month = month;
    }

    public List<CompleteRatioModel> getCompleteRatioModels() {
        return completeRatioModels;
    }

    public void setCompleteRatioModels(List<CompleteRatioModel> completeRatioModels) {
        this.completeRatioModels = completeRatioModels;
    }

    @Override
    public String toString() {
        return "ProjectCompleteRatioArrayModel{" +
                "month=" + month +
                ", completeRatioModels=" + completeRatioModels +
                '}';
    }
}
