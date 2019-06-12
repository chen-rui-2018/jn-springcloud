package com.jn.pre;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.config.Context;
import com.jn.enums.ZuulExceptionEnum;
import com.jn.model.Result;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.jn.enums.FilterTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接入的过滤器
 *
 * @author： fengxh
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
@Component
public class OneToAccessFilter extends ZuulFilter  {

    private final static String[] NOT_ALLOW_URL =  new String[]{"/api/"};

    private static Logger log = LoggerFactory.getLogger(OneToAccessFilter.class);
    /**
     * 生命周期
     * @return
     */
    @Override
    public String filterType() {
        return FilterTypeEnum.PRE.getCode();
    }
    /**
     * 顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return -1;
    }
    /**
     * 是否执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return Boolean.TRUE;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestUrl = request.getRequestURL().toString();
        log.info("发送 {} 请求 到 {} ", request.getMethod(), requestUrl);
        Context.getContext().put("method",request.getMethod());
        Context.getContext().put("url",requestUrl);
        Context.getContext().put("start",System.currentTimeMillis());
        for(String notAllow : NOT_ALLOW_URL){
            if(requestUrl.contains(notAllow)){
                log.warn("不允许访问");
                HttpServletResponse response = ctx.getResponse();
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json; charset=utf-8");
                ObjectMapper mapper = new ObjectMapper();
                String json = null;
                try {
                    json = mapper.writeValueAsString(new Result(ZuulExceptionEnum.UN_AUTH_EXCEPTION));
                } catch (JsonProcessingException e) {
                    log.error("JsonProcessingException异常",e);
                }
                ctx.setSendZuulResponse(false);
                try {
                    response.getWriter().write(json);
                } catch (IOException e) {
                    log.error("response io异常",e);
                }
                ctx.setResponse(response);
                return null;
            }
        }



        return null;
    }

}
