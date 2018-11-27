package com.jn.system.api;

import java.util.List;
import java.util.Set;

import com.jn.common.model.Result;
import com.jn.system.model.MenuResources;
import com.jn.system.model.UserLogin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jn.system.model.Resources;
import com.jn.system.model.User;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 系统客户端
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@FeignClient("springcloud-app-system")
public interface SystemClient {

    /**
     * 用户登录
     * @param u
     * @return
     */
    @RequestMapping(value = "/api/system/login", method = RequestMethod.POST)
    Result<User> login(@RequestBody UserLogin u);

    /**
     * 获取用户信息
     * @param u
     * @return
     */
    @RequestMapping(value = "/api/system/getUser", method = RequestMethod.POST)
    Result<User> getUser(@RequestBody  User u);

    /**
     * 获取资源列表
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/api/system/getResources", method = RequestMethod.POST)
    Result<Set<String>> getResources(@RequestBody String userId);

    /**
     * 获取菜单功能URL列表
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/api/system/getMenuResources", method = RequestMethod.POST)
    Result<List<MenuResources>> getMenuResources(@RequestBody String userId);

    /**
     * 获取用户文件组
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/api/system/getUserFileGroup", method = RequestMethod.POST)
    Result<Set<String>> getUserFileGroup(@RequestBody String userId);

    /**
     * 获取用户是否拥有该文件的下载权限
     * @param userId  用户ID
     * @param fileUrl 文件URL
     * @return
     */
    @RequestMapping(value = "/api/system/getUserFilePermission", method = RequestMethod.POST)
    Result<Boolean> getUserFilePermission(@RequestBody String userId, @RequestParam("fileUrl") String fileUrl);

}