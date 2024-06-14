# 项目特点

1. 单体项目，前后端分离
2. Java后端springboot
3. 前端后台管理： Vite+Vue3+TypeScript+Sass
4. 前端用户界面：Vite+React18+TypeScript+Sass

| 项目                                                         |                 |
| ------------------------------------------------------------ | --------------- |
| [api](https://gitee.com/developeros/videos-online/tree/master/api) | Java后端        |
| [vue-admin](https://gitee.com/developeros/videos-online/tree/master/vue-admin) | 管理后台Vue3    |
| protal                                                       | 用户界面React18 |





# Windows开发常用命令

无论是docker启动还是vite启动都会遇到一个端口占用的问题。但是使用netstat去查找端口的时候是找不到端口占用的信息的，需要使用管理员运行cmd，执行一下命令

```shell
net stop winnat
net start winnat
```

