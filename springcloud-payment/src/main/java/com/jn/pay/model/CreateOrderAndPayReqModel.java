package com.jn.pay.model;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 14:08
 * @version： v1.0
 * @modified By:
 */

import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/22
 *</pre>
 */
public class CreateOrderAndPayReqModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiParam(name = "orderId", value = "订单ID",example = "2019050811515490657",required = true)
    private String orderId;
    @ApiParam(name = "channelId", value = "支付渠道ID（WX_APP：微信APP支付，ALIPAY_MOBILE：支付宝移动支付）",example = "ALIPAY_MOBILE",required = true)
    private String channelId;
    @ApiParam(name = "paySum", value = "总支付金额",example = "1.02",required = true)
    private BigDecimal paySum;
    @ApiParam(name = "businessType", value = "缴费类型（1电费，2物业费，3维修费，4房租，5物品租赁，6停车费，7车位费，8水费，9宣传费，10体验费）",example = "4",required = true)
    private String payType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "PayOrderReqModel{" +
                "orderId='" + orderId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", paySum=" + paySum +
                ", payType='" + payType + '\'' +
                '}';
    }
}
