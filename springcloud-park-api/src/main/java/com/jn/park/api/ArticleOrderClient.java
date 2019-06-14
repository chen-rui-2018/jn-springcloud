package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
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

    /**
     * 是否逾期,更改状态
     * @return
     */
    @RequestMapping(value = "/api/order/updateAssetArticleStatus",method = RequestMethod.POST)
    Result updateAssetArticleStatus();

    /**
     * 发起支付
     * @param createPayReqModel
     * @return
     */
    @RequestMapping(value = "/api/order/createArticlePay", method = RequestMethod.POST)
    public Result<PayOrderRsp> createArticlePay(@RequestBody CreatePayReqModel createPayReqModel);
}
