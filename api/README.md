
![app](./imgs/app.png)
# 版本

| Library    | Version |
|------------|---------|
| SpringBoot | 3.2.6   |
| JDK        | 17      |
| Maven      | 3.9.0   |


# 项目搭建集成的开发工具


| 集成的开发工具                                |
| -------------------------------------- |
| 多模块热部署spring-boot-devtools             |
| 多模块版本控制maven-release                   |
| 启动springboot项目spring-boot-maven-plugin |
| 自动生成API文档springdoc-openapi             |
| 数据迁移flyway                             |
| maven 多模块开发                            |
| JWT 认证                                 |





# 运行

进入到api根目录执行
```shell
mvn clean install
mvn -pl app-main spring-boot:run
```
-pl: This stands for "project list"
It allows you to specify which modules in your multi-module project you want to include

# 分包开发

主程序是app-main
以依赖的方式来处理其他功能的jar包

如app-main的`pom.xml`,依赖auth-seriver

```xml
<dependency>
    <groupId>org.hzz</groupId>
    <artifactId>auth-servier</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

开发完一个模块如app-auth需要install到本地。


