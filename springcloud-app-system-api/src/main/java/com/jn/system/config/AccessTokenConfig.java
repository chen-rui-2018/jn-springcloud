package com.jn.system.config;

import com.lc.ibps.auth.client.filter.AccessTokenFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;

/**
 * AccessTokenConfig的配置文件
 *
 * @author： shenph
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Configuration
public class AccessTokenConfig {

    @Value(value = "${jn.ibps.portal.url}")
    private String portalUrl;
    @Value(value = "${jn.ibps.portal.success.url}")
    private String successUrl;
    @Value(value = "${jn.ibps.portal.client.id}")
    private String clientId;
    @Value(value = "${jn.ibps.portal.client.secret}")
    private String clientSecret;

    @Bean
    public Filter accessAutoLoginManager() {
        return new AccessAutoLoginManager();

    }

    /**
     * 拦截忽略地址,
     * TODO 头部带上token则不拦截,或者过滤以下地址
     */
    private String exclusionsUrl = "/,/hystrix.stream,/login,/noPwdLogin,/api/**,/metaData/**,/health,/loggers/**,/dump,/info,/env,/env/reset,/metrics,/trace,/heapdump,/features,/archaius,/jolokia,/logfile,/channels,/mappings,/auditevents,/configprops,/autoconfig,/refresh,/v2/api-docs/**,/swagger-ui.html,/swagger-resources/**,/swagger/**,/webjars/springfox-swagger-ui/**,/guest/**";

    @Bean
    @Order(1)
    public FilterRegistrationBean accessTokenFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new AccessTokenFilter());
        registration.addUrlPatterns("*");
        registration.addInitParameter("exclusions_url", exclusionsUrl);
        registration.addInitParameter("access_token_url", portalUrl + "/auth2/access_token.htm");
        registration.addInitParameter("client_id", clientId);
        registration.addInitParameter("client_secret", clientSecret);
        registration.addInitParameter("code_url", portalUrl + "/authorize.htm");
        registration.addInitParameter("login_url", portalUrl + "/login.jsp");
        registration.addInitParameter("redirect_url", portalUrl + "/login.jsp");
        registration.addInitParameter("logout_url", portalUrl + "/logout.htm");
        registration.addInitParameter("user_url", portalUrl + "/auth2/user.htm");
        registration.addInitParameter("success_url", successUrl);
        return registration;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean accessAutoLoginFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(accessAutoLoginManager());
        registration.addUrlPatterns("*");
        registration.addInitParameter("exclusions_url", exclusionsUrl);
        return registration;
    }
}
