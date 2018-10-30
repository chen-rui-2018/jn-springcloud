## 核心流程概要
- 用户->nginx->HTML->ZUUL(路由中心)->eureka(注册中心)->具体服务（必须引入SHIRO权限,除非是guest用户的项目）->eureka(注册中心)->核心服务（SHIRO权限认证授权）->REDIS/MYSQL
- 外部通信,方式HTTP,协议HTTP,权限SHIRO,注意ZUUL过滤器屏蔽内部接口（防止内部接口对外暴露）
- 内部通信,方式Feign,协议HTTP,权限eureka账号密码


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
- spring 框架
- mybatis ORM  
- shiro 会话
- redis 集群会话，shiro缓存，mybatis二级缓存
- 连接池 druid
- swagger 接口API文档
- VUE js框架
- ElementUI  页面UI框架

## 启动
- 1.启动redis
- 2.启动rabbitmq
- 3.启动注册中心springcloud-app-eureka
- 4.启动配置中心springcloud-app-config
- 5.启动路由中心springcloud-app-zuul
- 6.启动用户服务中心springcloud-app-system
- 0.0 第7到10点可以不用启动
- 7.启动调度中心springcloud-app-schedule
- 8.启动断路器监控汇总springcloud-app-turbine 访问端口8989
- 9.启动断路器监控springcloud-app-hystrix 访问端口1301/hystrix
- 10.启动链路追踪springcloud-app-zipkin 访问端口9411
- 11.启动nginx 访问端口80/html



##  规范
### 1.建立子项目规范
- 公用项目命名为spring-app-xxx xxx是你需要建立的项目简称
- 业务项目命名为spring-xxx  xxx是你需要建立的项目简称
- 其他的pom 什么的，可以参考springcloud-app-system 这个项目的配置
- 在springcloud-app-zuul 的配置文件中，加入路由
### 2.建立包规范
- com.jn.xxx.config  xxx是你需要建立的项目简称 config里面放配置JAVA类 
- com.jn.xxx.server  server是你提供给内部接口的服务端类
- com.jn.xxx.XXX XXX是项目的模块包
- XXX 下面建立 controller（外部接口）、dao（数据库）、model（通信对象）、service（业务方法）、vo（数据库领域对象）、enums(枚举)、api(内部接口客户端) 共7个包
- 7个包下面按照各自需求建立包
### 3.类命名规范
- 遵守驼峰规范 
- config包：xxxConfig、xxxFilter等等
- server包：xxxController xxx是你的模块名，每个模块一个服务端类
- 其他的按照正规的来就行
### 4.注解规范
- 统一使用@RestController  不能用Controller 注解
- /api/** 的路径不会进行拦截，专用于提供内部其他系统调用
- /guest/** 的路径不会进行拦截，专用于提供外部客户端调用
- @RequiresPermissions("url") 用于菜单权限的控制，只要涉及了菜单的链接的路径，都需要使用该注解。  
- 对象的参数校验，请使用注解进行（https://blog.csdn.net/u012373815/article/details/72049796），如果一些共性校验，例如手机校验、邮箱校验等等，找“共用组”统一建立，如果是业务特殊校验，例如是一些余额校验等等，使用写代码实现
### 5.日志规范
- 不得使用System.out, System.err进行日志记录，请改使用logger.debug、logger.error
- 注意error和warn级别的区别，导致业务不正常服务的，用error级别；错误是预期会发生的，并且已经有了其他的处理流程，使用warn级别
- 日志打印不运行使用“+”拼字符串的方式
- 重要方法入口，业务流程前后及处理的结果等，记录log
### 6.开发其他规范
- Controller 返回的统一使用Result 类 返回
- 对象的参数校验，代码实现的：统一使用Assert 断言来判断，统一在controller层实现
- 业务校验统一使用抛异常JnSpringCloudException来实现
- controller层，不需要捕获任何的异常,已经有统一地方进行了处理
- controller层，都需要继承BaseController，用于统一处理参数
- 遗留问题，或者防止遗忘的，使用todo方式。
### 7.调试规范
- 不能写main 方法进行业务的调试，统一使用junit
- json的调试，请使用postman工具进行
### 8.数据库规范
- 生产表命名规则：TB_[模块]_[业务]
- 报表命名规则：TB_RPT_[模块]_[业务]_[D/M/Y]
- 字段设置必须满足数据库第一范式，即数据库表的每一列都是不可分割的原子数据项，而不能是集合，数组，记录等非原子数据项
- 字段设置必须满足数据库第三范式，即在员工信息表中列出部门编号后就不能再将部门名称、部门简介等与部门有关的信息再加入员工信息表中

