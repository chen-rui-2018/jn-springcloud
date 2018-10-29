package com.jn.system.config;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.api.SystemClient;
import com.jn.system.model.Resources;
import com.jn.system.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Result<User> user = client.getUser(new User(null,token.getUsername(),null));
		if(GlobalConstants.SUCCESS_CODE.equals(user.getCode()) && user.getData() == null ){
			// TODO: 2018/10/29 throws 用户不存在的异常
		}else if (!GlobalConstants.SUCCESS_CODE.equals(user.getCode())){
			throw new JnSpringCloudException(user) ;
		}
		// 认证缓存信息
		return new SimpleAuthenticationInfo(user.getData().getId(), user.getData().getPassword().toCharArray(), getName());
	}

	/**
	 * 
	 * Shiro权限认证
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO: 2018/10/27 按照新的数据模型，进行改造。。。炮哥
		String shiroUser =(String) principals.getPrimaryPrincipal();
		List<Resources> roleList = client.getResources(new Resources(shiroUser,null,null,null,"2",null));
		Set<String> urlSet = new HashSet<>();
		for (Resources roleId : roleList) {
			urlSet.add(roleId.getUrl());
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(urlSet);
		return info;
	}

}
