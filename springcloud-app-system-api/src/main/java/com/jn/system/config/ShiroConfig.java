package com.jn.system.config;

import com.jn.common.shiro.RedisCacheManager;
import com.jn.common.shiro.RedisSessionDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Value(value = "${shiro_redis_session}")
	private int shiroRedisSession;
	@Value(value = "${shiro_redis_cache}")
	private int shiroRedisCache;
	
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/hystrix.stream", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        //所有内部提供的api接口不需要拦截
        filterChainDefinitionMap.put("/api/**", "anon");
        //所有客人访问的接口不需要拦截
        filterChainDefinitionMap.put("/guest/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        Map<String, javax.servlet.Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc",new ShiroFormAuthenticationFilter() );
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroDbRealm myShiroRealm(){
        return new ShiroDbRealm();
    }
    /**
     * EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，
     * 然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
     * 
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager() {
    	RedisCacheManager cacheManager = new RedisCacheManager();
    	cacheManager.setRedisTemplate(redisTemplate);
    	cacheManager.setExpire(shiroRedisCache);
        return cacheManager;
    }
    
    @Bean
    public RedisSessionDAO redisSessionDAO() {
    	RedisSessionDAO sessionDAO = new RedisSessionDAO();
    	sessionDAO.setRedisTemplate(redisTemplate);
    	sessionDAO.setExpire(shiroRedisSession);
        return sessionDAO;
    }
  
    
    @Bean
    public DefaultWebSessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO() );
        mySessionManager.setGlobalSessionTimeout(shiroRedisSession);
        return mySessionManager;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }
    
    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    
   
    
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}