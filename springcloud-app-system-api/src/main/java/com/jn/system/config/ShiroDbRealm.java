package com.jn.system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.LoadBalancerUtil;
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
   private LoadBalancerUtil loadBalancerUtils;
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
        Result result = loadBalancerUtils.getClientPostForEntity(
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

        Result result = loadBalancerUtils.getClientPostForEntity(
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
}
