package com.jn.system.api;

import java.util.List;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jn.system.model.Resources;
import com.jn.system.model.User;

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
    @RequestMapping(value = "/api/system/getUser", method = RequestMethod.POST)
    Result<User> getUser(@RequestBody  User u);

    /**
     * 获取资源列表
     * @param r
     * @return
     */
    @RequestMapping(value = "/api/system/getResources", method = RequestMethod.POST)
    Result<List<Resources>> getResources(@RequestBody  Resources r);



}