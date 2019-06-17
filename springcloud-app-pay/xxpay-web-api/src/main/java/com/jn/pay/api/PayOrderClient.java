package com.jn.pay.api;

import com.jn.common.model.Result;
import com.jn.pay.model.PayOrderQueryReq;
import com.jn.pay.model.PayOrderQueryRsp;
import com.jn.pay.model.PayOrderReq;
import com.jn.pay.model.PayOrderRsp;
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
     * @param payOrderReq
     * @return
     */
    @RequestMapping(value = "/api/pay/createPayOrder", method = RequestMethod.POST)
    Result<PayOrderRsp> createPayOrder(@RequestBody PayOrderReq payOrderReq);

    /**
     * 支付查询接口
     * @param PayOrderQueryReq
     * @return
     */
    @RequestMapping(value = "/api/pay/payOrderQuery", method = RequestMethod.POST)
    Result<PayOrderQueryRsp> payOrderQuery(@RequestBody PayOrderQueryReq PayOrderQueryReq);


}
