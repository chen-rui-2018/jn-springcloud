package com.jn.pay.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName：密钥获取接口
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/5/11 14:18
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("xxpay-web")
public interface KeyClient {

    /**
     * 根据商户ID获取请求对应商户的请求密钥
     * @param mchId 商户ID
     * @return
     */
    @RequestMapping(value = "/api/key/getRequestKey", method = RequestMethod.POST)
    Result<String> getRequestKey(@RequestBody String mchId);

    /**
     * 根据商户ID获取请求对应商户的响应密钥
     * @param mchId 商户ID
     * @return
     */
    @RequestMapping(value = "/api/key/getResponseKey", method = RequestMethod.POST)
    Result<String> getResponseKey(@RequestBody String mchId);


}
