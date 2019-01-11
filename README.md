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
- bus 消息通信
- admin 监控中心（包含各个项目健康监控，hystrix 断路器监控，turbine监控聚合）
- zipkin 链路监控
- spring 框架
- mybatis ORM
- shiro 会话
- redis 集群会话，shiro缓存，mybatis二级缓存
- 连接池 druid
- FastDfs 分布式文件服务器
- swagger 接口API文档
- VUE js框架
- ElementUI  页面UI框架
###自定义技术
- RedisCacheFactory 缓存实现
- @LockAnnotation   锁切面
- MultipartSupportConfig    服务间文件通信配置
- @ControllerLog、@ServiceLog    日志切面


## 启动
- 1.启动redis
- 2.启动rabbitmq
- 3.启动注册中心springcloud-app-eureka
- 4.启动配置中心springcloud-app-config
- 5.启动路由中心springcloud-app-zuul
- 6.启动用户服务中心springcloud-app-system
- 7.启动nginx 访问端口80/html
##### 后面可以不启动
- 7.启动调度中心springcloud-app-schedule
- 8.启动链路追踪springcloud-app-zipkin 访问端口9411
- 9.启动服务治理监控springcloud-app-admin
- 10.启动配置中心配置项目springcloud-app-config-manager


## 运维项目
- 1.springcloud-app-eureka 注册中心项目，可以看到微服务注册到里面的情况。
- 2.springcloud-app-admin 该项目主要是服务治理，启动该项目可以监控到全部服务的健康情况。
- 3.springcloud-config-manager 该项目是配置化管理中心，启动该项目可以配置全部服务的配置文件。




##  规范
### 1.建立子项目规范（建立子项目，要先跟技术负责人沟通，建立项目只能组长建立）
- 公用项目命名为spring-app-xxx xxx是你需要建立的项目简称
- 业务项目命名为spring-xxx  xxx是你需要建立的项目简称
- 其他的pom 什么的，可以参考springcloud-app-system 这个项目的配置
- 在springcloud-app-zuul 的配置文件中，加入路由(zuul.routes.springcloud-app-fastdfs=/springcloud-app-fastdfs/**)
- 启动springcloud-app-config-manager项目，进行对项目的配置文件配置。
### 2.建立包规范
- com.jn.config   config里面放配置JAVA类 
- com.jn.server   server是你提供给内部接口的服务端类
- com.jn.XXX XXX是项目的模块包
- XXX 下面建立 controller（外部接口）、dao（数据库）、model（通信对象，单对象）、entity(数据库对象,由generator生成器生成，不需要自己处理,严禁修改)、service（业务方法）、vo（视图对象-用于组合VO）、enums(枚举)、api(内部接口客户端) 共8个包
- 8个包下面按照各自需求建立包
### 3.类命名规范
- 遵守驼峰规范 
- config包：xxxConfig、xxxFilter等等
- server包：xxxController xxx是你的API项目中的接口类名，服务端类必须实现API接口类，参考eg.com.jn.upload.api.UploadClient。
- 其他的按照正规的来就行
### 4.注解规范
- 统一使用@RestController  不能用Controller 注解
- /api/** 的路径不会进行拦截，专用于提供内部其他系统调用
- /guest/** 的路径不会进行拦截，专用于提供外部客户端调用
- @RequiresPermissions("url") 用于功能权限的控制，只要涉及了功能的链接的路径，都需要使用该注解。  
- 对象的参数校验，请使用注解进行（https://blog.csdn.net/u012373815/article/details/72049796，如果一些共性校验，例如手机校验、邮箱校验等等，找“公共组”统一建立，如果是业务特殊校验，例如是一些余额校验等等，使用写代码实现(eg:com.jn.system.user.model.UserLogin)

### 5.领域对象规范
- 一共分了3种类型：数据库对象（entity）、通信对象(model)、视图对象(vo)
- 数据库对象，统一由generator逆向生成，不允许自己建立
- 通信对象，单一对象模型，一般简单的界面，同时也是视图对象模型
- 视图对象，组合对象模型，有组合对象的，统一在vo包下建立
- 不同类型对象的转化，使用BeanUtils.copyProperties(userLogin,user) 处理，(eg：com.jn.system.user.service.impl.SysUserServiceImpl.findTByT)
- 所有的领域对象都必须要有toString的重写

### 6.日志规范
- 不得使用System.out, System.err进行日志记录，请改使用logger
- 注意error和warn级别的区别，导致业务不正常服务的，用error级别；错误是预期会发生的，并且已经有了其他的处理流程，使用warn级别（业务提醒）
- 日志打印不能使用“+”拼字符串的方式
- 重要方法入口，业务流程前后及处理的结果等，记录log
- controller层，必须在方法上加入@ControllerLog注解
- service具体实现层，必须在方法上加入@ServiceLog注解

### 7.开发其他规范
- Controller 返回的统一使用Result<T> 类 返回
- 对象的参数校验，代码实现的：统一使用Assert 断言来判断，统一在controller层实现(eg:com.jn.controller.UploadController.upload)
- 业务校验统一使用抛异常JnSpringCloudException来实现（eg：com.jn.server.SystemController.getUser）
- controller层，不需要捕获任何的异常,已经有统一地方进行了处理
- controller层，都需要继承BaseController，用于统一处理参数
- 不允许使用SimpleDateFormate 类，请使用com.jn.common.util.DateUtils
- 项目上不运行使用synchronized，lock的锁方式来完成业务，请使用redis锁，eg.com.jn.test.controller.TestController.jedis11
- 遗留问题，或者防止遗忘的，使用todo方式。

### 8.文件规范
- 文件上传在fastdfs项目上
- 上传一共有3个方法：1，需要登录后上传、2，不需要登录的上传、3，登录后的上传，但下载需要获取token。
- 下载流程分为2种：1，不需要token下载（对应上传1,2）、2，需要token下载（对应上传3）。
- 需要token下载流程：用户 -> 应用项目 -> 获取到下载链接 -> FastDFS -> 获取到token -> 在下载链接拼上token=XXX&ts=XXXX -> 下载

### 9.调试规范
- 不能写main 方法进行业务的调试，统一使用junit
- json的调试，请使用postman工具进行

### 10.数据库规范
- 生产表命名规则：TB_[模块]_[业务]
- 报表命名规则：TB_RPT_[模块]_[业务]_[D/M/Y]
- 字段设置必须满足数据库第一范式，即数据库表的每一列都是不可分割的原子数据项，而不能是集合，数组，记录等非原子数据项
- 字段设置必须满足数据库第三范式，即在员工信息表中列出部门编号后就不能再将部门名称、部门简介等与部门有关的信息再加入员工信息表中
- generator 生成的方法里面，统一都要使用Selective后缀的方法
- generator 的del方法，尽量少用，生产表，都必须使用逻辑删除（如有不懂，找炮哥）

### 11.异常编码规范
#### 编写规范
- 每个模块下面应该有自己的异常枚举
#### 编码定义：
 一共分为4组：eg.1000999---代表公共性的未知异常
##### 第一组，2位为系统编码
- 10			common  所有业务服务的公共性异常
- 11			system  基础服务
- 12			fastDfs    文件服务
- 13            news    消息中心
- 14            wetChat-miniProgram     小程序
- 15            wetChat     微信
- 16            payment     支付平台
- 17            hardware    硬件平台
- 18            delayStream 消息延时
- 30            user        用户服务
- 40            park        园区服务
- 50            enterprise  企业服务

##### 第二组，2位为模块编码
- 00		common
- eg.
- 10		用户模块
- 11		功能权限			
##### 第三组，1位为异常类型
- 1-系统级错误
- 2-应用级错误（前端参数错误）
- 3-业务级错误（Service自身处出错）
- 4-依赖级错误（Service内部调用第三方服务出错）
- 5-交互级业务提醒（正常业务逻辑，非错误，需告知用户，如库存不足）
- 9-未知错误
##### 第四组，2位为具体异常编码
- 99 - 未知错误
- 01 - XXXX


## 12.配置文件规范
- 业务子服务，如果涉及到业务变动，会进行随时调整的配置信息，请丢到配置中心那边进行管理，例如抢购业务，有一个配置为lock是用来控制等待时间的，那么这个配置就需要丢到配置中心进行管理。例子：com.jn.test.controller.TestController

## 13.版本管理规范
- 由业务子服务，在API 维护README.md，进行一个版本号和说明
- 1.0.0-RELEASE（初始化版本）
- 初始化
