drop table if exists learning_lesson;
create table if not exists learning_lesson(
    id bigint not null comment '主键',
    user_id bigint not null comment '学员id',
    course_id bigint not null comment '课程id',
    status tinyint default 0 comment '课程状态，0-未学习，1-学习中，2-已学完，3-已失效',
    week_freq tinyint default null comment '每周学习频率，例如每周学习6小节，则频率为6',
    plan_status tinyint not null default 0 comment '学习计划状态，0-没有计划，1-计划进行中',
    learned_sections int not null default 0 comment '已学习小节数量',
    latest_section_id bigint default null comment '最近一次学习的小节id',
    latest_learn_time datetime default null comment '最近一次学习的时间',
    create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    expire_time datetime DEFAULT NULL COMMENT '过期时间',
    update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    primary key(`id`),
    unique key `idx_user_course_id` (`user_id`,`course_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='学生学习课程表';

DELETE FROM `learning_lesson`;
INSERT INTO `learning_lesson` (`id`, `user_id`, `course_id`, `status`, `week_freq`, `plan_status`, `learned_sections`, `latest_section_id`, `latest_learn_time`, `create_time`, `expire_time`, `update_time`)
VALUES
(1, 2, 2, 2, 6, 1, 12, 16, '2023-04-11 22:34:45', '2022-08-05 20:02:50', '2023-08-05 20:02:29', '2023-04-19 10:29:29'),
(2, 2, 3, 1, 4, 1, 3, 31, '2023-04-19 11:42:50', '2022-08-06 15:16:48', '2023-08-06 15:16:37', '2023-04-19 11:42:50'),
(1585170299127607297, 129, 2, 0, NULL, 0, 0, 16, '2023-04-11 22:37:05', '2022-12-05 23:00:29', '2023-10-26 15:14:54', '2023-04-11 22:37:05'),
(1601061367207464961, 2, 1549025085494521857, 1, 3, 1, 4, 1550383240983875589, '2023-04-11 16:34:44', '2022-12-09 11:49:11', '2023-12-09 11:49:11', '2023-04-11 16:34:43');
