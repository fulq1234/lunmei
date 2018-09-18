# lunmei

技术点1：lombok

作用：
    减少代码量
    
使用方法：
    1.在intellj idea中安装lombok
    
    2.pom.xml中引入引用
    
      <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        
    3.在entity类上面写@Data，类里面只要有“属性”就可以了，不需要有getter/setter方法。查看发布代码(在target文件夹下面查看)，发现实体类中已经有了属性的getter,setter等方法。
    
    4.@NotNull，用于属性的非空检查，可以查看发布代码(在target文件夹下面查看)
    
    5.@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8"),后台传到前台，时间格式的转换。
    

技术点2:swagger

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
        
     2. @Api  --------------Controller类上面
        @ApiOperation------Controller的方法上面
        @ApiModel----------实体类上面
        @ApiModelProperty--实体类的方法上面
        
