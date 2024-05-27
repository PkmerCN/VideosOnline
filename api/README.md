后端接口

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


# 运行

进入到api根目录执行
```shell
mvn clean install
mvn -pl app-main spring-boot:run
```
-pl: This stands for "project list"
It allows you to specify which modules in your multi-module project you want to include