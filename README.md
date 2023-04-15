# SSMIntergration2
听我BB carefully



### 再次换了一个教程来集成SSM框架
[黑马程序员SSM框架教程](https://www.bilibili.com/video/BV1Fi4y1S7ix/?p=59&share_source=copy_web&vd_source=4ab8c0bacabe264ca7fc26a04c087e55)
- 郁闷，集成失败了，mybatis执行遇到sql问题，而且找到没有打印sql的方法
- 通过配置文件的方式实在不酷
- log4j2如何配置没搞明白
- 如何打印sql语句实在太重要了

不说了，开干

#### Question! 
>brand是对应表中的字段？对应Cup中的属性？  
>`@Insert("insert into cup(name,brand) values(#{name},#{brand})")`  
> 答案是 name,brand对应表字段，#{name}#{brand}对应的是Cup属性 


#### 分支 Controller_service_dao概述

- Service和ServiceImpl实现的是crud的服务
- Controller是实现了curd的接口
- Dao是实现了crud的mybatis操作，采用的是注解形式


### 分支testing_Controller_and_service

- service测试用junit
- controller测试用tomcat服务器
- 如果tomcat不能启动，先看tomcat自身的三个日志有没有错误



### exception分支

- 定义异常类 `SystemException`
- 业务中抛出异常 `throw new SystemException()`
- 异常处理类 `@ExceptionHandler(SystemException) doSystemException(SystemException ex)`
- 注解 `@RestControllerAdvice`,`@ExceptionHandler(SystemException) `


### 6-StaticResourceVisit_and_Interceptor
拦截器概念理解
`位于Filter之后，返回页面之前，用于对springmvc的Controller的增强` 

#### springmvc集成Spring和Mybatis 已终结 **SSM框架的注解方式**
**另附maven项目管理**


### maven的模块化开发
概念：`刷新了观念，maven的模块是可以install成为另一个Maven的jar包，把要被集成的maven项目打包执行maven install`,wow!,然后，就像这样，把一个`pom.xml`的坐标加入到另一个`pom.xml`里面
```pom
<dependencies>
    <dependency>
        <groupId>com.coh</groupId>
        <artifactId>SSMIntergration2</artifactId>
        <version>1.0-SNAPSHOT</version>
        <packaging>war</packaging>
    </dependency>
</dependencies>
```

### 依赖排除和可选依赖
`<option></option>`
- 可选依赖是不暴露给外界使用
- 排除依赖是不使用别的包中的依赖


### 聚合，继承，属性

**聚合**
- 管理所以maven子项目的项目就是聚合工程
- packing方式为pom
- 添加子模块

```pom
<packing>pom</packing>
...
...
<modules>
    <module>M1</module>
    <module>M2</module>
</modules>
```

**继承**

- 子项目引入父项目
- 父项目放公共jar包
- 子项目放独有jar包，父项目的jar包会自动继承
- 修改父项目的jar包version,子项目会自动修改
- dependencyManagement 管理子项目的Jar包版本,子项目可根据需要灵活继承
```pom
<parent>
    <groupId> SameAsParentProject <groupId>
    <artifactId> SameAsParentProject <artifactId>
    <version> SameAsParentProject <version>
    <relativePath>../projectName</relativePath>
</parent>

```
```pom
<!--父项目定义版本-->
<dependencyMangement>
    <dependencies>
        <dependency>
                <groupId>xxx<groupId>
                <artifactId>xxx<artifactId>
                <version>4.12</version>
        </dependency>
    </dependencies>
</dependencyMangement>
```
```pom
<!--子项目自动继承-->
 <dependency>
    <groupId>xxx<groupId>
    <artifactId>xxx<artifactId>
</dependency>
```

**属性**

- 设置版本变量，集中控制版本


```pom

<properties>
    <spring.version>5.3.16</spring.version>
</properties>
```


```pom 
 <dependency>
    <groupId>xxx<groupId>
    <artifactId>xxx<artifactId>
    <version>${spring.version}</version>
</dependency>
```

**集成配置文件的属性**

- 配置属性值
- 配置资源目录，开启$识别
- ${project.basedir}会遍历所有模块的根目录


```pom
<properties>
    <jdcb.url>jdbc:mysql://localhost:3306/db0?serverTimezone=GMT</spring.url>
    <jdbc.driver>com.mysql.cj.jdbc.Driver</spring.driver>
</properties>

<build>
    <resources>
        <resource>
            <directory>${project.basedir}/main/src/resources/jdbc.properties</directory>
            <filtering>true</filetring>
        </resource>
    </resources>
</build>
```

```properties
jdbc.url=${jdbc.url}
jdbc.driver=${jdbc.driver}
```

- 打war包的插件，可忽略web.xml

```xml
<build>
    <pulgins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>xx.xx.x</version>
            <configuration>
                <failOnMissingWebXml>false</failOnMissingWebXml>
            </configuration>
        </plugin>
    </pulgins>
</build>

```
### version Control
nothing here


### If you want skip maven-test graph
- `mvn package -D skipTests`
```pom
 <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>xx.xx.x</version>
            <configuration>
                <skipTests>false</skipTests>
                //skip specification testcase
                <excludes>**/PackageName/ClassName.java</excludes>
            </configuration>
 </plugin>
```


### maven Nexus
- `D:\nexus-3.16.2-01\bin>nexus.exe run /nexus`  
- `username:admin default-password:admin123`
- 分为 Hosted, Proxy 
- 

**上传私服配置**
`D:\apache-maven-3.6.3\conf\settings.xml`
- 上传位置
- 下载位置
- 访问用户名密码



### 配置当前项目在私服仓库中的具体位置
标题的意思是：当前的Maven上传到私服仓库nexus的哪个repository

```html
<distributionManagement>
    <repository>
        <id>Coh-release</id>
        <url>http://localhost:8081/repository/Coh-release/</url>
    </repository>
    <repository>
        <id>Coh-snapshot</id>
        <url>http://localhost:8081/repository/Coh-snapshot/</url>
    </repository>
</distributionManagement>
```
**待续。。。**

