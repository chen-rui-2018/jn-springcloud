package com.jn.pay.model.alipay;

import com.jn.pay.model.PayBaseRsp;

/**
 * @ClassName：支付宝移动支付统一下单接口响应类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/5 16:26
 * @Version： v1.0
 * @Modified By:
 */
public class AlipayMobilePayRsp extends PayBaseRsp {

    /**
     * 调用SDK需要的参数
    * */
    private String payParams;
    /**
     * 签名
     * */
    private String sign;

    public String getPayParams() {
        return payParams;
    }

    public void setPayParams(String payParams) {
        this.payParams = payParams;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
