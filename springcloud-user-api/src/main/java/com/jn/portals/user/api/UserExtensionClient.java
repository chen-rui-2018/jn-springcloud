package com.jn.portals.user.api;

import com.jn.common.model.Result;
import com.jn.portals.user.model.UserExtension;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录客户端
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-user")
public interface UserExtensionClient {
    /**
     * 获取登录用户扩展信息
     *
     * @param account 用户账号
     * @return
     */
    @RequestMapping(value = "/api/portals/getUserExtension", method = RequestMethod.POST)
    Result<UserExtension> getUserExtension(@RequestBody String account);
}
