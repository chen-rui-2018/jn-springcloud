package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/27 14:44
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CreateBillParam", description = "创建账单入参")
public class CreateBillParam implements Serializable {
    @ApiModelProperty(value = "宣传id",required = true,example = "897c4077f0204df2999e7c923ccdc445")
    private String propagandaId;
    @ApiModelProperty(value = "订单号(调用生成订单号接口获得)",required = true,example = "AD-20190527150224742")
    private String orderNum;

    public String getPropagandaId() {
        return propagandaId;
    }

    public void setPropagandaId(String propagandaId) {
        this.propagandaId = propagandaId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "CreateBillParam{" +
                "propagandaId='" + propagandaId + '\'' +
                ", orderNum='" + orderNum + '\'' +
                '}';
    }
}
