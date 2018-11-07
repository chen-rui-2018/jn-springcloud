package com.jn.system.config;

import com.jn.common.enums.CommonExceptionEnum;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.api.SystemClient;
import com.jn.system.enums.ShiroExceptionEnum;
import com.jn.system.model.Resources;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
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
	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// TODO: 2018/10/30 用户有效性，还有用户的基础信息,炮哥
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Result<User> user = client.getUser(new User(token.getUsername()));
		if(GlobalConstants.SUCCESS_CODE.equals(user.getCode()) && user.getData() == null){
			throw new JnSpringCloudException(ShiroExceptionEnum.UNKNOWN_ACCOUNT);
		}else if (!GlobalConstants.SUCCESS_CODE.equals(user.getCode())){
			throw new JnSpringCloudException(user) ;
		}
		clearAuthorizationInfoCache(user.getData());
		// 认证缓存信息
		return new SimpleAuthenticationInfo(user.getData(), user.getData().getPassword().toCharArray(), getName());
	}

	/**
	 * 
	 * Shiro权限认证
	 * 
	 */
	@Override
	public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO: 2018/10/27 按照新的数据模型，进行改造。。。炮哥
		User shiroUser =(User) principals.getPrimaryPrincipal();
		Result<List<Resources>> roleList = client.getResources(new Resources(shiroUser.getId(),null,null,null,"2",null));
		Set<String> urlSet = new HashSet<>();
		for (Resources roleId : roleList.getData()) {
			urlSet.add(roleId.getUrl());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(urlSet);
		return info;
	}

	/**
	 * 清除指定用户的缓存
	 * @param user
	 */
	private void clearAuthorizationInfoCache(User user) {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		cache.remove(user.getId());
	}


}
