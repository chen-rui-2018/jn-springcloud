package com.jn.wechat.base.filter;

import com.lc.ibps.auth.client.filter.AccessTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;

/**
 * WxAuthConfig配置文件
 *
 * @Author： cm
 * @Date： Created on 2019/6/20 16:22
 * @Version： v1.0
 * @Modified By:
 */
@Configuration
public class WxAuthConfig {
    /**
     * 这里填写注册绑定页面
     */
    private static final String exclusionsWxUrl = "/guest/wechat/menu/create";

    @Bean
    public Filter wxAuthFilter() {
        return new WxAuthFilter();
    }

    @Bean
    @Order(1)
    public FilterRegistrationBean wxAuthFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new WxAuthFilter());
        registration.addUrlPatterns("*");
        registration.addInitParameter("exclusions_wx_url", exclusionsWxUrl);
        return registration;
    }

}
