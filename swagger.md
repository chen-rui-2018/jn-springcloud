
使用民间整合版

该项目主要利用Spring Boot的自动化配置特性来实现快速的将swagger2引入spring boot应用来生成API文档，简化原生使用swagger2的整合代码。

源码地址
GitHub：https://github.com/dyc87112/spring-boot-starter-swagger
码云：https://gitee.com/didispace/spring-boot-starter-swagger
使用样例：https://github.com/dyc87112/swagger-starter-demo
我的博客：http://blog.didispace.com
我们社区：http://www.spring4all.com

配置：
swagger.title=标题
swagger.description=描述
swagger.version=版本
swagger.license=许可证
swagger.licenseUrl=许可证URL
swagger.termsOfServiceUrl=服务条款URL
swagger.contact.name=维护人
swagger.contact.url=维护人URL
swagger.contact.email=维护人email
swagger.base-package=swagger扫描的基础包，默认：全扫描
swagger.base-path=需要处理的基础URL规则，默认：/**
swagger.exclude-path=需要排除的URL规则，默认：空