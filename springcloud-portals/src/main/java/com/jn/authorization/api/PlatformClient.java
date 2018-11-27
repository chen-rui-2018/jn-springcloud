package com.jn.authorization.api;

import com.jn.authorization.model.PlatformUserLogin;
import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 平台客户端
 * @Author: yangph
 * @Date: 2018/11/22 9:19
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-app-system")
public interface PlatformClient {
    /**
     * 登录
     * @param platformUserLogin
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Result<String>  loginPost(@RequestBody PlatformUserLogin platformUserLogin);

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logoutJSON")
    Result logoutJSON();
}
