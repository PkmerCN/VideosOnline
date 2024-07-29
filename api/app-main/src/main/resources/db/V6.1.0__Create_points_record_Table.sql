-- ----------------------------
-- Table structure for points_record
-- ----------------------------
DROP TABLE IF EXISTS `points_record`;
CREATE TABLE `points_record`  (
      `id` bigint NOT NULL COMMENT '积分记录表id',
      `user_id` bigint NOT NULL COMMENT '用户id',
      `type` tinyint NOT NULL COMMENT '积分方式：1-课程学习，2-每日签到，3-课程问答， 4-课程笔记，5-课程评价',
      `points` tinyint NOT NULL COMMENT '积分值',
      `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      PRIMARY KEY (`id`) USING BTREE,
      INDEX `idx_user_id`(`user_id` ASC, `type` ASC) USING BTREE,
      INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学习积分记录，每个月底清零' ROW_FORMAT = DYNAMIC;