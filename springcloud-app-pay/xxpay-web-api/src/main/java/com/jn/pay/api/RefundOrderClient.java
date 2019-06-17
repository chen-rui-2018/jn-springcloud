package com.jn.pay.api;

import com.jn.common.model.Result;
import com.jn.pay.model.RefundOrderReq;
import com.jn.pay.model.RefundOrderRsp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName：统一退款接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/8 19:15
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("xxpay-web")
public interface RefundOrderClient {
    /**
     * 统一退款接口
     * @param refundOrderReq
     * @return
     */
    @RequestMapping(value = "/api/refund/createRefundOrder", method = RequestMethod.POST)
    Result<RefundOrderRsp> createRefundOrder(@RequestBody RefundOrderReq refundOrderReq);
}
