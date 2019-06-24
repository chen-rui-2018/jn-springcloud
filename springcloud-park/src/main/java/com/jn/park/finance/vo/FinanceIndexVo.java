package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/7
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexVo", description = "管委会支出占比")
public class FinanceIndexVo implements Serializable {

    @ApiModelProperty(value = "占比")
    private String ratio;

    @ApiModelProperty(value = "状态")
    private  String state;


    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "FinanceIndexVo{" +
                "ratio='" + ratio + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
