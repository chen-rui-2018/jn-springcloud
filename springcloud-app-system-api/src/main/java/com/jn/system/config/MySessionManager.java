package com.jn.system.config;

import com.jn.common.model.Result;
import com.jn.common.util.LoadBalancerUtil;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 自定义sessionId获取，如果请求头中有 Authorization 则其值为sessionId，否则按默认规则从cookie取sessionId
 */
public class MySessionManager extends DefaultWebSessionManager {

    @Autowired
    private LoadBalancerUtil loadBalancerUtils;

    private final static String SYSTEM_CLIENT = "springcloud-app-system";

    private final static String SYSTEM_CLIENT_NOPASSWORDLOGIN_SERVICE = "/api/system/noPasswordLogin";

    private static final String AUTHORIZATION = "token";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        if (StringUtils.isEmpty(id)) {
            String account = com.lc.ibps.auth.client.context.Context.getUsername();
            if (!StringUtils.isEmpty(account)) {
                Cookie[] cookies = httpServletRequest.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("shiroSessionId".equals(cookie.getName())) {
                            return cookie.getValue();
                        }
                    }
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("account", account);
                Result result = loadBalancerUtils.getClientPostForEntity(SYSTEM_CLIENT, SYSTEM_CLIENT_NOPASSWORDLOGIN_SERVICE, jsonObject.toString());
                id = result.getData().toString();
                request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
                request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
                request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
                httpServletResponse.addCookie(new Cookie("shiroSessionId",id));
                httpServletResponse.addCookie(new Cookie("Admin-Token",id));
                return id;
            }
            return super.getSessionId(request, response);
        } else {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        }
    }
}
