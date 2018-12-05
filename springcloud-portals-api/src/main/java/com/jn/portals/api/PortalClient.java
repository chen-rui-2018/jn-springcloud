package com.jn.portals.api;

import com.jn.common.model.Result;
import com.jn.portals.model.PortalsUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 平台客户端
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-portals")
public interface PortalClient {
    /**
     * 获取登录用户扩展信息
     *
     * @param account 用户账号
     * @return
     */
    @RequestMapping(value = "/api/portals/getUserExtension", method = RequestMethod.POST)
    Result<PortalsUser> getUserExtension(@RequestBody String account);
}