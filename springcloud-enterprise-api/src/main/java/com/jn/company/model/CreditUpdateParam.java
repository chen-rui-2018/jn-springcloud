package com.jn.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author： jiangyl
 * @date： Created on 2019/5/28 9:36
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "CreditUpdateParam",description = "积分修改")
public class CreditUpdateParam {

    @ApiModelProperty(value = "企业ID", required = true)
    @NotNull(message = "企业ID不能为空")
    private String comId;

    @ApiModelProperty(value = "积分数", required = true)
    @NotNull(message = "积分数不能为空")
    private Double pintNum;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public Double getPintNum() {
        return pintNum;
    }

    public void setPintNum(Double pintNum) {
        this.pintNum = pintNum;
    }

    @Override
    public String toString() {
        return "CreditUpdateParam{" +
                "comId='" + comId + '\'' +
                ", pintNum=" + pintNum +
                '}';
    }
}
