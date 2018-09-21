package com.wangsong.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.wangsong.enums.FilterTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
/**
 * 接入的过滤器
 *
 * @author： fengxh
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
public class OneToAccessFilter extends ZuulFilter  {

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
        return 0;
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
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        // TODO: 2018/9/19 进行接入权限校验
        return null;
    }

}
