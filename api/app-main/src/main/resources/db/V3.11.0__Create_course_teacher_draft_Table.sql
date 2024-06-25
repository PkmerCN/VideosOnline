DROP TABLE IF EXISTS `course_teacher_draft`;
CREATE TABLE `course_teacher_draft`  (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '课程老师关系id',
     `course_id` bigint NOT NULL COMMENT '课程id',
     `teacher_id` bigint NOT NULL COMMENT '老师id',
     `is_show` tinyint NOT NULL DEFAULT 0 COMMENT '用户端是否展示',
     `c_index` int NOT NULL COMMENT '序号',
     `dep_id` bigint NOT NULL DEFAULT 0 COMMENT '部门id',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     `creater_id` bigint NOT NULL DEFAULT 0 COMMENT '创建人ID',
     `updater_id` bigint NOT NULL DEFAULT 0 COMMENT '更新人ID',
     `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程老师关系表草稿' ROW_FORMAT = Dynamic;
