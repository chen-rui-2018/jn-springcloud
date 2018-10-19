package com.jn.system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.common.model.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 重写验证失败的返回
 *
 * @author： fengxh
 * @date： Created on 2018/9/21 18:57
 * @version： v1.0
 * @modified By:
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    Logger logger  = LoggerFactory.getLogger(ShiroFormAuthenticationFilter.class);
    public static String INDEX= "index";
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (!isLoginRequest(request, response)) {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse) response;
            if(req.getMethod().equals(RequestMethod.OPTIONS.name())) {
                resp.setStatus(HttpStatus.OK.value());
                return true;
            }
            if (logger.isTraceEnabled()) {
                logger.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }
            resp.setHeader("Access-Control-Allow-Origin",  req.getHeader("Origin"));
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setContentType("application/json; charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(new Result(INDEX,null));
            out.println(json);
            out.flush();
            out.close();
            return false;
        } else {
            return super.onAccessDenied(request, response) ;
        }
    }
}
