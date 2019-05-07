package com.jn.pay.api;

import com.jn.common.model.Result;
import com.jn.pay.model.*;
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
@FeignClient("springcloud-app-pay")
public interface PayClient {

    /**
     * 统一支付下单接口
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

    /**
     * 统一退款接口
     * @param refundOrderReq
     * @return
     */
    @RequestMapping(value = "/api/refund/createRefundOrder", method = RequestMethod.POST)
    Result<RefundOrderRsp> createRefundOrder(@RequestBody RefundOrderReq refundOrderReq);
}
