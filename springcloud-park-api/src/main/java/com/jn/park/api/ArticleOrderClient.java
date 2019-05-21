package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.pay.model.PayOrderNotify;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
*订单相关接口
*/
@FeignClient("springcloud-park")
public interface ArticleOrderClient {
    /**
     * 支付回调
     * test ArticleOrderClientTest.java
     * @param payOrderNotify
     * @return
     */
    @RequestMapping(value = "/api/order/articlePayCallBack", method = RequestMethod.POST)
    Result articlePayCallBack(@RequestBody PayOrderNotify payOrderNotify);
}
