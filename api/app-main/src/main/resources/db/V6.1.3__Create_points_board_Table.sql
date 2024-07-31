-- ----------------------------
-- 每个赛季的用户积分排行榜
-- ----------------------------
DROP TABLE IF EXISTS `points_board`;
CREATE TABLE `points_board`  (
         `id` bigint NOT NULL COMMENT '榜单id',
         `user_id` bigint NOT NULL COMMENT '学生id',
         `points` int NOT NULL COMMENT '积分值',
         `rank` tinyint NOT NULL COMMENT '名次，只记录赛季前100',
         `season` smallint NOT NULL COMMENT '赛季id',
         PRIMARY KEY (`id`) USING BTREE,
         INDEX `idx_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学霸天梯榜' ROW_FORMAT = DYNAMIC;
