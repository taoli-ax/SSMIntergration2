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
