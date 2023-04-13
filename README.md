# SSMIntergration2
again make build SSM environment


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



### maven的模块化开发
概念：`对于我来说，maven的模块是可以install成为另一个Maven的jar包，把要被集成的maven项目打包执行maven install`,wow!,然后，就像这样，把一个`pom.xml`的坐标加入到另一个`pom.xml`里面
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

**待续。。。**