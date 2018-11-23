package com.jn.system.utils;

import com.jn.common.model.Result;
import com.jn.system.api.SystemClient;
import com.jn.system.config.ShiroDbRealm;
import com.jn.system.model.MenuResources;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Permission;
import java.util.*;

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
    @Autowired
    private SystemClient client;

    public static ShiroUserUtils shiroUserUtils;

    @PostConstruct
    public void init() {
        shiroUserUtils = this;
    }

    /**
     * 将功能与视图权限分类获取
     * key:视图链接
     * value:功能链接
     * @return
     */
    public static HashMap<String,List<String>> getPermissionsByLoginUser() {
        //AuthorizationInfo authorizationInfo = shiroUserUtils.shiroDbRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
        Result<List<MenuResources>> roleList = shiroUserUtils.client.getMenuResources(shiroUser.getId());
        List<MenuResources> menuResources = roleList.getData();
        HashMap<String,List<String>> permissionsMap = new HashMap<>();
        String key = "";
        List<String> value = new ArrayList<>();
        for (MenuResources m : menuResources){
            if(key.isEmpty()){key = m.getMenuUrl();}
            if(key.equals(m.getMenuUrl())){
                value.add(m.getResourcesUrl());
            }else{
                permissionsMap.put(key,value);
                value = new ArrayList<>();
                value.add(m.getResourcesUrl());
                key = m.getMenuUrl();
            }
        }
        if(!value.isEmpty()){
            permissionsMap.put(key,value);
        }
        return permissionsMap;
    }
}
