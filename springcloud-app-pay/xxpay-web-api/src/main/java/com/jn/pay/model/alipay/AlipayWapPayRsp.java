package com.jn.pay.model.alipay;

import com.jn.pay.model.PayBaseRsp;

/**
 * @ClassName：支付宝手机网站支付统一下单接口响应类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/5 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class AlipayWapPayRsp extends PayBaseRsp {

    /**
     * 第三方支付中心生生成跳转第三方支付页面的URL地址
     * */
    private String payUrl;
    /**
     * 签名
     * */
    private String sign;

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
