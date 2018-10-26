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
3.在entity类上面写@Data，类里面只要有“属性”就可以了，不需要有getter/setter方法。查看发布代码(在target文件夹下面查看)，发现实体类中已经有了属性的getter,setter等方法。
    
4.@NotNull，用于属性的非空检查，可以查看发布代码(在target文件夹下面查看)
    
5.@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8"),后台传到前台，时间格式的转换。
    
6.@Slf4j, 插入日志，程序中可以用log.info("")，等等操作

7.@JsonProperty,在实体类的属性上备注@JsonProperty(value = "CallbackCommand"),输出的Json格式属性名称就是value的值。

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

**知识点4. thymeleaf**
项目：thymeleaf-demo
使用教程：https://blog.csdn.net/fulq1234/article/details/82907488

**知识点5.小程序模板发送**
项目hlhlo-cloud-api-wxapp
小程序前台是doc下面的min-program项目
使用教程：

**知识点6.oauth2**
项目：cjs-oauth2-code-server
使用知识点链接：http://www.cnblogs.com/cjsblog/p/9230990.html

**知识点7.微信公众号客服消息**
项目：hlhlo-cloud-framework-wx
参考网页：
1.消息管理>客服消息
https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140547
2.微信公众平台接口测试账号
https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login
3.获取AccessToken
https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxec40750a90b478e5&secret=87eb940de1cd6a9f02258162b2ccf80d


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


知识点6：学习spring cloud server

hlhlo-cloud-api-