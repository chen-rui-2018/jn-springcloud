package com.jn.system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.enums.ShiroExceptionEnum;
import com.jn.system.enums.ShiroUserEnum;
import com.jn.system.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

/**
 * shiro安全数据源
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By: shenph
 */
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 获取用户的服务ID
     */
    private final static String SYSTEM_CLIENT = "springcloud-app-system";
    /**
     * 获取用户的服务地址
     */
    private final static String SYSTEM_CLIENT_USER_SERVICE = "/api/system/getUser";
    /**
     * 获取资源的服务地址
     */
    private final static String SYSTEM_CLIENT_RESOURCE_SERVICE = "/api/system/getUser";
    /**
     * 用户登录认证
     *
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        MyUsernamePasswordToken token = (MyUsernamePasswordToken) authcToken;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("account", token.getUsername());
        Result result = this.getSystemApiPostForEntity(
                SYSTEM_CLIENT,
                SYSTEM_CLIENT_USER_SERVICE,
                jsonObject.toString());
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(result.getData(), User.class);

        if (GlobalConstants.SUCCESS_CODE.equals(result.getCode()) && result.getData() == null) {
            throw new UnknownAccountException(ShiroExceptionEnum.UNKNOWN_ACCOUNT.getMessage());
        } else if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            throw new JnSpringCloudException(result);
        } else if (!ShiroUserEnum.ACCOUNT_EFFECTIVE.getCode().equals(user.getStatus())) {
            throw new DisabledAccountException(ShiroExceptionEnum.UNKNOWN_EFFECTIVE.getMessage());
        }

        if (token.isNoPassword()) {
            setCredentialsMatcher(new AllowAllCredentialsMatcher());
        }

        clearAuthorizationInfoCache(user);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
    }

    /**
     * Shiro权限认证
     *
     * @param principals
     * @return
     */
    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User shiroUser = (User) principals.getPrimaryPrincipal();

        Result result = this.getSystemApiPostForEntity(
                SYSTEM_CLIENT,
                SYSTEM_CLIENT_RESOURCE_SERVICE,
                shiroUser.getId());
        ObjectMapper mapper = new ObjectMapper();
        Set<String> roliList = mapper.convertValue(result.getData(), Set.class);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(roliList);
        return info;
    }

    /**
     * 清除指定用户的缓存
     *
     * @param user
     */
    private void clearAuthorizationInfoCache(User user) {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        cache.remove(user.getId());
    }


    /**
     * RestTemplate 调用接口
     *
     * @param client     请求spring.application.name
     * @param url        请求地址
     * @param jsonObject 请求参数
     * @return
     */
    private Result getSystemApiPostForEntity(String client, String url, String jsonObject) {
        ServiceInstance si = this.loadBalancerClient.choose(client);
        StringBuffer sb = new StringBuffer();
        sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append(url);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.setContentType(type);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(jsonObject, headers);
        ResponseEntity<Result> response = restTemplate.postForEntity(sb.toString(), formEntity, Result.class);
        return response.getBody();
    }


}
