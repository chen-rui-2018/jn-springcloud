package com.jn.system.config;

import com.jn.common.model.Result;
import com.jn.common.util.LoadBalancerUtil;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * AccessAutoLoginManager
 *
 * @author： shenph
 * @date： Created on 2019/4/26 21:34
 * @version： v1.0
 * @modified By:
 */
public class AccessAutoLoginManager implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AccessAutoLoginManager.class);

    private final static String SYSTEM_CLIENT = "springcloud-app-system";

    private final static String SYSTEM_CLIENT_NOPASSWORDLOGIN_SERVICE = "/api/system/noPasswordLogin";

    @Autowired
    private LoadBalancerUtil loadBalancerUtils;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String account = com.lc.ibps.auth.client.context.Context.getUsername();
        logger.info("【oauth】 进入doFilter,ibps,account:{}", account);
        if (!StringUtils.isEmpty(account)) {
            String tokenId = httpRequest.getHeader("token");
            logger.info("【oauth】 ibps,ccount不为空,tokenid:{}",tokenId);
            if (StringUtils.isEmpty(tokenId)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("account", account);
                Result result = loadBalancerUtils.getClientPostForEntity(SYSTEM_CLIENT, SYSTEM_CLIENT_NOPASSWORDLOGIN_SERVICE, jsonObject.toString());
                String id = result.getData().toString();
                AccessContext.setTokenContext(id);
                logger.info("【oauth】 autoLogin user:{},id:{},token:{}", account, id, AccessContext.getTokenContext());
            }

        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
