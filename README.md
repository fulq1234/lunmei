# lunmei

**技术点1：lombok**

项目：demo
作用：
    减少代码量
    
使用方法：
    1.在intellj idea中安装lombok
    
2.pom.xml

    <dependency>
         <groupId>org.projectlombok</groupId>
         <artifactId>lombok</artifactId>
    </dependency>

**技术点2:swagger**

项目：demo

作用：
    增加帮助文档
    
使用方法

1.pom.xml中引入引用
    
     <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.2.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.2.2</version>
        </dependency>
        
 2. 
@Api  --------------Controller类上面

@ApiOperation------Controller的方法上面

@ApiModel----------实体类上面

@ApiModelProperty--实体类的方法上面
        
**知识点3：@Profile**

项目：demo2

使用方法：配置文件application-{profile}.properties，然后在application.properties中配置spring.profiles.active=b启用。





知识点1:
maven plugin的插件
https://www.cnblogs.com/zhangxh20/p/6298062.html

知识点2:
spring.cloud.config.uri=
https://blog.csdn.net/zhuchuangang/article/details/51168674

知识点3:
http://localhost:9010/health能不能访问

知识点4:
Eureka的server端会发出5个事件通知，分别是：
    
    EurekaInstanceCanceledEvent 服务下线事件
    EurekaInstanceRegisteredEvent 服务注册事件
    EurekaInstanceRenewedEvent 服务续约事件
    EurekaRegistryAvailableEvent Eureka注册中心启动事件
    EurekaServerStartedEvent Eureka Server启动事件

知识点5:
actuator/health
actuator/info
Actuator主要暴露的功能如下,都是Get方法：
    
    路径      |   描述
    /autoconfig |  查看自动配置的使用情况，显示一个auto-configuration的报告，该报告展示所有auto-configuration候选者及它们被应用或未被应用的原因
    /configprops|  查看配置属性，包括默认配置，显示一个所有@ConfigurationPropeties的整理列表
    /beans      |   bean及其关系列表，显示一个应用中所有Spring Beans的完整列表
    /dump       |   打印线程栈
    /env        |   查看所有环境变量
    /health     |   查看应用健康指标，当使用一个未认证连接访问时显示一个简单的‘status’，使用认证连接访问则显示全部信息详情
    /info       |   查看应用信息
    /mappings   |   查看所有url映射，即所有@RequestMapping路径的整理列表
    /metrics    |   查看应用基本指标
    /shutdown   |   关闭应用，运行应用以优雅的方式关闭（默认情况下不启用）
    /trace      |   查看基本追踪信息，默认为最新的一些HTTP请求。



