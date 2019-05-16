package com.jn.park.asset.vo;/**
 * @author： huangbq
 * @date： Created on 2019/5/16 18:02
 * @version： v1.0
 * @modified By:
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * APP创建支付订单的返回对象
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/16
 *</pre>
 */
@ApiModel(value = "AppPayDataVo",description = "APP支付")
public class AppPayDataVo {
    @ApiModelProperty(value = "支付订单参数信息")
    private String orderInfo;
    @ApiModelProperty(value = "支付渠道")
    private String payChannel;
    @ApiModelProperty(value = "支付中心订单ID")
    private String payId;

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    @Override
    public String toString() {
        return "AppPayDataVo{" +
                "orderInfo='" + orderInfo + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", payId='" + payId + '\'' +
                '}';
    }
}
