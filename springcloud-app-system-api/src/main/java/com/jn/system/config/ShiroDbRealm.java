package com.jn.system.config;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.api.SystemClient;
import com.jn.system.enums.ShiroExceptionEnum;
import com.jn.system.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * shiro安全数据源
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private SystemClient client;


    /**
     * 用户登录认证
     *
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Result<User> user = client.getUser(new User(token.getUsername()));
        if (GlobalConstants.SUCCESS_CODE.equals(user.getCode()) && user.getData() == null) {
            throw new JnSpringCloudException(ShiroExceptionEnum.UNKNOWN_ACCOUNT);
        } else if (!GlobalConstants.SUCCESS_CODE.equals(user.getCode())) {
            throw new JnSpringCloudException(user);
        } else if (!ShiroExceptionEnum.ACCOUNT_EFFECTIVE.getCode().equals(user.getData().getStatus())) {
            throw new JnSpringCloudException(ShiroExceptionEnum.UNKNOWN_ACCOUNT);
        }
        clearAuthorizationInfoCache(user.getData());
        // 认证缓存信息
        return new SimpleAuthenticationInfo(user.getData(), user.getData().getPassword().toCharArray(), getName());
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
        Result<Set<String>> roleList = client.getResources(shiroUser.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(roleList.getData());
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
