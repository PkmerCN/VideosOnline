drop table if exists learning_lesson;
create table if not exists learning_lesson(
    id bigint not null comment '主键',
    user_id bigint not null comment '学员id',
    course_id bigint not null comment '课程id',
    status tinyint default 0 comment '课程状态，0-未学习，1-学习中，2-已学完，3-已失效',
    week_freq tinyint default 0 comment '每周学习频率，例如每周学习6小节，则频率为6',
    plan_status tinyint not null default 0 comment '学习计划状态，0-没有计划，1-计划进行中',
    learned_sections int not null default 0 comment '已学习小节数量',
    latest_section_id bigint default null comment '最近一次学习的小节id',
    lastest_learn_time datetime default null comment '最近一次学习的时间',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key(`id`),
    unique key `idx_user_course_id` (`user_id`,`course_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='学生学习课程表';