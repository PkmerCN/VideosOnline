DROP TABLE IF EXISTS `course_content`;
CREATE TABLE `course_content`  (
   `id` bigint NOT NULL COMMENT '课程内容id',
   `course_introduce` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程介绍',
   `use_people` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '适用人群',
   `course_detail` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程详情',
   `dep_id` bigint NOT NULL DEFAULT 0 COMMENT '部门id',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   `creater_id` bigint NOT NULL COMMENT '创建人ID',
   `updater_id` bigint NOT NULL COMMENT '更新人ID',
   `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程内容，主要是一些大文本' ROW_FORMAT = Dynamic;
