package com.jn.pay.vo.wx;

import com.jn.pay.model.PayBaseRsp;
import com.jn.pay.model.wx.PayParams;

/**
 * @ClassName： 微信公众号支付(统一下单接口响应类)
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/5 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class WxJsapiPayRsp extends PayBaseRsp {


    /**
     *预支付交易会话ID
     * 微信返回的支付交易会话ID
     * */
    private String prepayId;

    /**
     * 此参数用于客户端与微信服务器交互
     * */
    private PayParams payParams;


    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public PayParams getPayParams() {
        return payParams;
    }

    public void setPayParams(PayParams payParams) {
        this.payParams = payParams;
    }
}
