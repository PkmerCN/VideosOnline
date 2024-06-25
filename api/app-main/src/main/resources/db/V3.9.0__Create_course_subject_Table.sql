DROP TABLE IF EXISTS `course_subject`;
CREATE TABLE `course_subject`  (
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '课程题目关系id',
   `course_id` bigint NOT NULL,
   `subject_id` bigint NOT NULL,
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程题目关系列表' ROW_FORMAT = Dynamic;
