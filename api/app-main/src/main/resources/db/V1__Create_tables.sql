-- 创建用户表
create table user(
    id bigint not null comment '主键',
    cell_phone varchar(11) not null comment '手机号',
    password varchar(255) not null comment '密码',
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';