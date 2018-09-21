## 核心流程概要

- 用户->nginx->HTML->ZUUL(路由中心)->eureka(注册中心)->具体服务（必须引入SHIRO权限,除非是guest用户的项目）->eureka(注册中心)->核心服务（SHIRO权限认证授权）->REDIS/MYSQL
- 外部通信,方式HTTP,协议HTTP,权限SHIRO,注意ZUUL过滤器屏蔽内部接口（防止内部接口对外暴露）
- 内部通信,方式Feign,协议HTTP,权限eureka账号密码,注意SHIRO要开放内部接口


## 技术栈
- springcloud 整合
- eureka 注册中心
- zuul 路由中心
- ribbon 通信
- feign 注解通信
- config 配置中心
- bus 实时配置中心功能
- hystrix 断路器监控
- turbine 断路器监控聚合
- zipkin 链路监控
- springBoot ioc，aop
- mybatis ORM  
- shiro 会话
- redis 集群会话，shiro缓存，mybatis二级缓存
- 连接池 druid
- easyui 页面UI

## 启动
- 1.启动redis
- 2.启动rabbitmq
- 3.启动注册中心springcloud-app-eureka
- 4.启动配置中心springcloud-app-config
- 5.启动路由中心springcloud-app-zuul
- 6.启动用户服务中心springcloud-app-system

```- 7.启动调度中心springcloud-app-schedule
- 8.启动断路器监控汇总springcloud-app-turbine 访问端口8989
- 9.启动断路器监控springcloud-app-hystrix 访问端口1301/hystrix
- 10.启动链路追踪springcloud-app-zipkin 访问端口9411```


- 11.启动nginx 访问端口80/html