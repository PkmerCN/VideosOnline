-- 创建用户表
drop table if exists app_user;
create table app_user(
    id bigint not null auto_increment comment '主键',
    username varchar(11) not null comment '用户名',
    password varchar(255) not null comment '密码',
    email varchar(30) not null comment '邮箱',
    cell_phone varchar(11) not null comment '手机号',
    type tinyint not null DEFAULT 0 comment '用户类型：1-员工, 2-普通学员，3-老师',
    create_time datetime not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '创建时间',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表' ROW_FORMAT = Dynamic;

