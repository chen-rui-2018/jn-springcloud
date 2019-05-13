package com.jn.pay.model.wx;

import com.jn.pay.model.PayBaseRsp;

/**
 * @ClassName： 微信H5支付(统一下单接口响应类)
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/5 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class WxMwebPayRsp extends PayBaseRsp {

    /**
     *预支付交易会话ID
     * 微信返回的支付交易会话ID
     * */
    private String prepayId;

    /**
    *第三方支付中心生生成跳转第三方支付页面的URL地址
    * */
   private String payUrl;



    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }
}
