DROP TABLE IF EXISTS `learning_record`;
CREATE TABLE `learning_record`  (
    `id` bigint NOT NULL COMMENT '学习记录的id',
    `lesson_id` bigint NOT NULL COMMENT '对应课表的id',
    `section_id` bigint NOT NULL COMMENT '对应小节的id',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `moment` int NULL DEFAULT 0 COMMENT '视频的当前观看时间点，单位秒',
    `finished` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否完成学习，默认false',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '第一次观看时间',
    `finish_time` datetime NULL DEFAULT NULL COMMENT '完成学习的时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间（最近一次观看时间）',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_update_time`(`update_time` ASC) USING BTREE,
    INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
    INDEX `idx_lesson_id`(`lesson_id` ASC, `section_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学习记录表' ROW_FORMAT = DYNAMIC;