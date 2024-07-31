-- ----------------------------
-- Table structure for points_board_season
-- ----------------------------
DROP TABLE IF EXISTS `points_board_season`;
CREATE TABLE `points_board_season`  (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '自增长id，season标示',
    `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '赛季名称，例如：第1赛季',
    `begin_time` date NOT NULL COMMENT '赛季开始时间',
    `end_time` date NOT NULL COMMENT '赛季结束时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '赛季表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of points_board_season
-- ----------------------------
INSERT INTO `points_board_season` VALUES (1, '第1赛季', '2022-10-01', '2022-10-31');
INSERT INTO `points_board_season` VALUES (2, '第2赛季', '2022-11-01', '2022-11-30');
INSERT INTO `points_board_season` VALUES (3, '第3赛季', '2022-12-01', '2022-12-31');
INSERT INTO `points_board_season` VALUES (4, '第4赛季', '2023-01-01', '2023-01-31');
INSERT INTO `points_board_season` VALUES (5, '第5赛季', '2023-02-01', '2023-02-28');
INSERT INTO `points_board_season` VALUES (6, '第6赛季', '2023-03-01', '2023-03-31');
INSERT INTO `points_board_season` VALUES (7, '第7赛季', '2023-04-01', '2023-04-30');
INSERT INTO `points_board_season` VALUES (8, '第8赛季', '2023-05-01', '2023-05-31');
INSERT INTO `points_board_season` VALUES (9, '第9赛季', '2023-06-01', '2023-06-30');
INSERT INTO `points_board_season` VALUES (10, '第10赛季', '2023-07-01', '2023-07-31');
INSERT INTO `points_board_season` VALUES (11, '第11赛季', '2023-08-01', '2023-08-31');
INSERT INTO `points_board_season` VALUES (12, '第12赛季', '2023-09-01', '2023-09-30');