-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
    `id` bigint NOT NULL COMMENT '关联用户id',
    `type` tinyint NULL DEFAULT 2 COMMENT '用户类型：1-员工, 2-普通学员，3-老师',
    `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '名字',
    `gender` tinyint NOT NULL DEFAULT 0 COMMENT '性别：0-男性，1-女性',
    `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像地址',
    `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
    `qq` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'QQ号码',
    `birthday` date NULL DEFAULT NULL COMMENT '生日',
    `job` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '岗位',
    `province` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省',
    `city` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '市',
    `district` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区',
    `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人介绍',
    `photo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '形象照地址',
    `role_id` bigint NOT NULL COMMENT '角色id',
    `course_amount` smallint NULL DEFAULT 0 COMMENT '购买课程数量，学生才有该字段信息',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creater` bigint NULL DEFAULT NULL COMMENT '创建者id',
    `updater` bigint NULL DEFAULT 0 COMMENT '更新者id',
    `dep_id` bigint NOT NULL DEFAULT 0 COMMENT '部门id',
    PRIMARY KEY (`id`) USING BTREE,
    FULLTEXT INDEX `name_idx`(`name`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES (1, 1, '壮哥', 0, '/img-tx/1.jpg', '1193094618@qq.com', '1193094618', NULL, '管理员', NULL, NULL, NULL, NULL, NULL, 1, NULL, '2024-07-12 03:19:18', '2024-07-12 09:57:38', 1, 1, 0);
