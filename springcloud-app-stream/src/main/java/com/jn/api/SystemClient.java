package com.jn.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统客户端
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-app-system")
public interface SystemClient {

    /**
     * 获取用户信息
     * @param u
     * @return
     */
    @RequestMapping(value = "/api/system/getUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<Object> getUser(@RequestBody Object u);

}