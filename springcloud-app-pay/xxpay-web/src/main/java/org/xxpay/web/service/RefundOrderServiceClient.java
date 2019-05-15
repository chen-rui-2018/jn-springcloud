package org.xxpay.web.service;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.xxpay.common.util.MyBase64;
import org.xxpay.common.util.RpcUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName：退款订单
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/4/23 17:03
 * @Version： v1.0
 * @Modified By:
 */
@Service
public class RefundOrderServiceClient {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 创建退款订单
     * @param jsonParam
     * @return
     */
    @HystrixCommand(fallbackMethod = "createRefundOrderFallback")
    public String createRefundOrder(String jsonParam) {
        return restTemplate.getForEntity("http://XXPAY-SERVICE/refund/create?jsonParam=" + MyBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }
    public String createRefundOrderFallback(String jsonParam) {
        return "error";
    }



    /**
     * 创建退款订单
     * @param refundOrderId 退款订单号
     * @param channelName 渠道名称,如:ALIPAY,  WX
     * @return
     */
    @HystrixCommand(fallbackMethod = "sendRefundOrderFallback")
    public String sendRefundNotify(String refundOrderId,String channelName) {
        JSONObject object = new JSONObject();
        object.put("refundOrderId", refundOrderId);
        object.put("channelName", channelName);
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("msg", object);
        String jsonParam = RpcUtil.createBaseParam(paramMap);
        return restTemplate.getForEntity("http://XXPAY-SERVICE/refund/sendRefundNotify?jsonParam=" + MyBase64.encode(jsonParam.getBytes()), String.class).getBody();
    }
    public String sendRefundOrderFallback(String refundOrderId,String channelName) {
        return "error";
    }
}
