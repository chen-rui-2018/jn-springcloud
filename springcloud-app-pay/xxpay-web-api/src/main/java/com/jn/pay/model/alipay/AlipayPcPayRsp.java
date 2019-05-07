package com.jn.pay.model.alipay;

import com.jn.pay.model.PayBaseRsp;

/**
 * @ClassName：支付宝电脑二维码支付
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/5 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class AlipayPcPayRsp extends PayBaseRsp {

    /**
     * 第三方支付中心生生成跳转第三方支付页面的URL地址
    * */
    private String payUrl;

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }
}
