## 残疾人婚恋平台

#### 项目介绍
残疾人婚恋平台（disable-date）是一款APP平台，由前台APP和后台管理系统构成，基于SpringBoot、SpringCloud、SpringCloud alibaba、Vue实现，采用前后端分离开发模式。APP具有首页、广场、聊天、用户中心等功能，后台管理系统具有控制面板、统计管理、用户系统、内容管理、系统管理等模块。

涵盖Restful接口、数据校验、网关、注册发现、配置中心、熔断、限流、降级、链路追踪、性能监控、压力测试、系统预警、集群部署、持续集成、持续部署等技术点，均采用当前最流行的技术栈。

##### 模块说明
```text
|-- disable-date
    |-- disable-date-admin -- 后台管理系统后端
    |-- disable-date-message -- 即时通讯微服务
    |-- disable-date-common -- 通用工具类
    |-- disable-date-relation -- 朋友关注关系微服务
    |-- disable-date-gateway -- 网关微服务（对用户来说分为VIP用户、用户、游客三个级别）
    |-- disable-date-nacos -- 服务注册，服务发现，灰度发布
    |-- disable-date-personinfo -- 个人信息微服务
    |-- disable-date-oauth2 -- 认证微服务
    |-- disable-date-third-services -- 第三方接口服务(例如支付接口,人脸识别接口等等)
```
#### 技术选型
##### 后端技术
技术|说明
---|---|
Spring Boot|容器+MVC框架
MyBatis|ORM框架
MySql|数据库
Redis|分布式缓存
RabbitMQ|消息中间件
Kibana + Elasticsearch + ik | 中文搜索引擎
SpringCache|简化分布式缓存开发
JSR303|数据校验
Lombok|简化对象封装工具
Nginx|反向代理、限流、负载均衡、容错
nacos|服务注册、服务发现、灰度发布
k8s + docker | 虚拟化容器技术、容器管理、集群部署
Jenkins|持续集成
AlipayTemplate|支付宝支付
Spring Cloud Gateway|API 网关
Spring Cloud Security+Oauth2|安全认证授权、第三方登录
Spring Cloud OpenFeign|服务消费（远程调用）
Spring Cloud Ribbon|服务消费（负载均衡）
Spring Cloud Sleuth+Zipkin|分布式链路追踪及可视化
Spring Cloud Alibaba Nacos|服务发现与注册、分布式配置中心
Spring Cloud Alibaba Sentinel|服务容错（限流、熔断、降级）
Spring Cloud Alibaba OSS|阿里云对象存储服务
Spring Cloud Alibaba Seata|分布式事务解决方案
Spring Cloud Alibaba SMS|短信服务

##### 前端技术
技术|说明
---|---
Vue|前端框架
Vue-router|路由管理器


#### 环境搭建
##### 开发环境
工具|版本号
---|---
JDK|1.8
MySql|8.0.28
Redis|5.0
RabbitMQ|3.8.2
Elasticsearch|7.4.2
Kibana|7.4.2
LogStash|7.4.2
Nginx|1.17.10
Docker|19.03.05
Zipkin|2.22.2
Spring Cloud Alibaba Nacos|1.1.14
Spring Cloud Alibaba Sentinel|1.8.0

##### 开发工具
工具|说明
---|---
IDEA|Java代码编译环境
VsCode|前端代码编辑器
VMware|虚拟机管理
Navicat|数据库可视化工具
RedisManager|缓存可视化工具
Postman|接口调试工具
Finalshell|Linux远程连接工具
Xftp|数据传输工具


