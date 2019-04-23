package com.jn.system.config;

import com.lc.ibps.auth.client.filter.AccessTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

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

    /**
     * 拦截忽略地址,
     * TODO 头部带上token则不拦截,或者过滤以下地址
     */
    private String exclusionsUrl = "/,/hystrix.stream,/login,/api/**,/metaData/**,/health,/loggers/**,/dump,/info,/env,/env/reset,/metrics,/trace,/heapdump,/features,/archaius,/jolokia,/logfile,/channels,/mappings,/auditevents,/configprops,/autoconfig,/refresh,/v2/api-docs/**,/swagger-ui.html,/swagger-resources/**,/swagger/**,/webjars/springfox-swagger-ui/**,/guest/**";

    @Bean
    @Order(1)
    public FilterRegistrationBean accessTokenFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new AccessTokenFilter());
        registration.addUrlPatterns("*");
        registration.addInitParameter("exclusions_url", exclusionsUrl);
        registration.addInitParameter("access_token_url", "http://112.94.22.222:2383/ibps-platform-portal/auth2/access_token.htm");
        registration.addInitParameter("client_id", "test");
        registration.addInitParameter("client_secret", "0ef09aca-d525-0e94-b1e5-6259eb4ff964");
        registration.addInitParameter("code_url", "http://112.94.22.222:2383/ibps-platform-portal/authorize.htm");
        registration.addInitParameter("login_url", "http://112.94.22.222:2383/ibps-platform-portal/login.jsp");
        registration.addInitParameter("redirect_url", "http://112.94.22.222:2383/ibps-platform-portal/login.jsp");
        registration.addInitParameter("logout_url", "http://112.94.22.222:2383/ibps-platform-portal/logout.htm");
        registration.addInitParameter("user_url", "http://112.94.22.222:2383/ibps-platform-portal/auth2/user.htm");
        registration.addInitParameter("success_url", "http://112.94.22.222:2384/ibps");
        return registration;
    }

}
