-- ----------------------------
-- Table structure for liked_record
-- ----------------------------
DROP TABLE IF EXISTS `liked_record`;
CREATE TABLE `liked_record`  (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `user_id` bigint NOT NULL COMMENT '用户id',
     `biz_id` bigint NOT NULL COMMENT '点赞的业务id',
     `biz_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '点赞的业务类型',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `idx_biz_user`(`biz_id` ASC, `user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '点赞记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of liked_record
-- ----------------------------
INSERT INTO `liked_record` VALUES (1, 2, 110, 'QA', '2023-01-05 21:35:50', '2023-01-05 21:35:50');
INSERT INTO `liked_record` VALUES (6, 2, 112, 'QA', '2023-02-06 17:58:01', '2023-02-06 17:58:01');
INSERT INTO `liked_record` VALUES (7, 2, 113, 'QA', '2023-02-06 17:59:11', '2023-02-06 17:59:11');
INSERT INTO `liked_record` VALUES (13, 2, 1585180460118519809, 'QA', '2023-02-07 09:32:56', '2023-02-07 09:32:56');
