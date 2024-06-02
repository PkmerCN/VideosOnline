-- 创建用户表
drop table if exists app_user;
create table app_user(
    id bigint not null auto_increment comment '主键',
    username varchar(11) not null comment '用户名',
    cell_phone varchar(11) not null comment '手机号',
    password varchar(255) not null comment '密码',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

insert into app_user(username,cell_phone,password) value("pkmer","17801054490","123456");
insert into app_user(username,cell_phone,password) value("pangka","17877361854","abcdefg");