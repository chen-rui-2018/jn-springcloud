package com.jn.pay.model.wx;

import com.jn.pay.model.PayBaseRsp;

/**
 * @ClassName： 微信公众号扫码支付(统一下单接口响应类)
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/5 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class WxNativePayRsp extends PayBaseRsp {

    /**
     *预支付交易会话ID
     * 微信返回的支付交易会话ID
     * */
    private String prepayId;

    /**
     *二维码链接
     * 可将该参数值生产二维码展示
    * */
    private String codeUrl;

    /**
     * 签名
     * */
    private String sign;



    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
