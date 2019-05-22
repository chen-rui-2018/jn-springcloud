package com.jn.pay.model;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 14:08
 * @version： v1.0
 * @modified By:
 */

import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/22
 *</pre>
 */
public class CreatePayReqModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiParam(name = "goodsIdArr", value = "商品ID集合（数组）",example = "[2019050811515490657]",required = true)
    private String[] goodsIdArr;
    @ApiParam(name = "goodsCountArr", value = "商品数量集合（数组），可不传（默认全部商品都是1件），数组长度必需与goodsIdArr一致",example = "[1]",required = false)
    private String[] goodsIds;
    @ApiParam(name = "channelId", value = "支付渠道ID（WX_APP：微信APP支付，ALIPAY_MOBILE：支付宝移动支付）",example = "ALIPAY_MOBILE",required = true)
    private String channelId;
    @ApiParam(name = "paySum", value = "总支付金额",example = "1.02",required = true)
    private BigDecimal paySum;
    @ApiParam(name = "payType", value = "缴费类型（1电费，2物业费，3维修费，4房租，5物品租赁，6停车费，7车位费，8水费，9宣传费，10体验费）",example = "4",required = true)
    private String payType;

    public String[] getGoodsIdArr() {
        return goodsIdArr;
    }

    public void setGoodsIdArr(String[] goodsIdArr) {
        this.goodsIdArr = goodsIdArr;
    }

    public String[] getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String[] goodsIds) {
        this.goodsIds = goodsIds;
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
        return "CreatePayReqModel{" +
                "goodsIdArr=" + Arrays.toString(goodsIdArr) +
                ", goodsIds=" + Arrays.toString(goodsIds) +
                ", channelId='" + channelId + '\'' +
                ", paySum=" + paySum +
                ", payType='" + payType + '\'' +
                '}';
    }
}
