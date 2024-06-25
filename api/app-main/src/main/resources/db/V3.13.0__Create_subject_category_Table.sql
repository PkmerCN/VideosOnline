DROP TABLE IF EXISTS `subject_category`;
CREATE TABLE `subject_category`  (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
     `subject_id` bigint NOT NULL COMMENT '题目id',
     `first_cate_id` bigint NOT NULL COMMENT '一级课程分类id',
     `second_cate_id` bigint NULL DEFAULT NULL COMMENT '二级课程分类id',
     `third_cate_id` bigint NULL DEFAULT NULL COMMENT '三级课程分类id',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5334 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程题目分类关系表' ROW_FORMAT = Dynamic;
