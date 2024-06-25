DROP TABLE IF EXISTS `course_cata_subject_draft`;
CREATE TABLE `course_cata_subject_draft`  (
      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '小节题目关系id',
      `course_id` bigint NOT NULL COMMENT '课程id',
      `cata_id` bigint NOT NULL COMMENT '小节id',
      `subject_id` bigint NOT NULL COMMENT '题目id',
      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程-题目关系表草稿' ROW_FORMAT = Dynamic;
