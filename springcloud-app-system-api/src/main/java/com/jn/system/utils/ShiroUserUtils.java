package com.jn.system.utils;

import com.jn.system.config.ShiroDbRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * shiro用户的工具类
 *
 * @author： fengxh
 * @date： Created on 2018/10/30 15:35
 * @version： v1.0
 * @modified By:
 */
@Component
public class ShiroUserUtils {

    @Autowired
    private ShiroDbRealm shiroDbRealm;


    /**
     * 将功能与视图权限分类获取
     * key:视图链接
     * value:功能链接
     * @return
     */
    public HashMap<String,List<String>> getPermissionsByLoginUser() {
        AuthorizationInfo authorizationInfo = shiroDbRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        // TODO: 2018/10/30 炮哥，需要整理这块
        return null;
    }
}
