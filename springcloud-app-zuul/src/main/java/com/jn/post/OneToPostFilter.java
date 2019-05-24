package com.jn.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jn.config.Context;
import com.jn.enums.FilterTypeEnum;
import com.jn.enums.ZuulExceptionEnum;
import com.jn.model.Result;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 返回的过滤器
 *
 * @author： fengxh
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
@Component
public class OneToPostFilter extends ZuulFilter  {


    private static Logger log = LoggerFactory.getLogger(OneToPostFilter.class);
    /**
     * 生命周期
     * @return
     */
    @Override
    public String filterType() {
        return FilterTypeEnum.POST.getCode();
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
        HashMap hashMap = Context.getContext();
        Long end = System.currentTimeMillis();
        log.info("结束 {} 请求 到 {} ，耗时：{}ms",
                hashMap.get("method"),
                hashMap.get("url"),
                (end-(Long) hashMap.get("start")));
        Context.remove();
        return null;
    }
}
