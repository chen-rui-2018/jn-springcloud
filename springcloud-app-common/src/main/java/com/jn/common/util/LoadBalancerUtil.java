package com.jn.common.util;

import com.jn.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 集群调用接口
 *
 * @author： fengxh
 * @date： Created on 2019/1/7 14:53
 * @version： v1.0
 * @modified By:
 */
@Component
public class LoadBalancerUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * RestTemplate 调用接口
     *
     * @param sysId      请求spring.application.name
     * @param url        请求地址
     * @param jsonObject 请求参数
     * @return
     */
    public Result getClientPostForEntity(String sysId, String url, String jsonObject) {
        ServiceInstance si = this.loadBalancerClient.choose(sysId);
        StringBuffer sb = new StringBuffer();
        sb.append(GlobalConstants.HTTP_PRODOCOL).append(si.getHost()).append(":").append(si.getPort()).append(url);
        HttpEntity<String> formEntity = new HttpEntity<>(jsonObject, RestTemplateUtil.setHeaders());
        ResponseEntity<Result> response = restTemplate.postForEntity(sb.toString(), formEntity, Result.class);
        return response.getBody();
    }

    /**
     * 判断客户端是否有启动
     *
     * @param sysId
     * @return
     */
    public Boolean isClientUp(String sysId) {
        ServiceInstance si = this.loadBalancerClient.choose(sysId);
        if (si == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
