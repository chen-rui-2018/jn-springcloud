package com.jn.pay.api;

import com.jn.common.model.Result;
import com.jn.pay.model.PayOrderQueryReq;
import com.jn.pay.model.PayOrderQueryRsp;
import com.jn.pay.model.PayOrderReq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName：支付系统接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/6 19:15
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("xxpay-web")
public interface PayOrderClient {

    /**
     * 统一支付下单接口
     * 不同支付渠道ID data返回不同的实体类 如：
     *      ALIPAY_MOBILE(支付宝移动支付) 返回  AlipayMobilePayRsp
     *      ALIPAY_PC(支付宝PC支付)      返回  AlipayPcPayRsp
     *      ALIPAY_WAP(支付宝WAP支付)    返回  AlipayWapPayRsp
     *      WX_APP(微信APP支付)          返回  WxAppPayRsp
     *      WX_JSAPI(微信公众号支付)      返回  WxJsapiPayRsp
     *      WX_NATIVE(微信原生扫码支付)    返回  WxNativePayRsp
     *      WX_MWEB(微信H5支付)          返回  WxMwebPayRsp
     * @param payOrderReq
     * @return
     */
    @RequestMapping(value = "/api/pay/createPayOrder", method = RequestMethod.POST)
    Result createPayOrder(@RequestBody PayOrderReq payOrderReq);

    /**
     * 支付查询接口
     * @param PayOrderQueryReq
     * @return
     */
    @RequestMapping(value = "/api/pay/payOrderQuery", method = RequestMethod.POST)
    Result<PayOrderQueryRsp> payOrderQuery(@RequestBody PayOrderQueryReq PayOrderQueryReq);


}
