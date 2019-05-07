package com.jn.pay.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName：支付接口响应基础类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/6 9:41
 * @Version： v1.0
 * @Modified By:
 */
public class PayBaseRsp {
    /**
     *支付订单号（本支付系统生成的）
     * */
    @ApiModelProperty("支付订单号")
    private String  payOrderId;

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

}
