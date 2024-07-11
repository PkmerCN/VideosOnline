-- ----------------------------
-- 互动提问的问题表
-- ----------------------------
DROP TABLE IF EXISTS `interaction_question`;
CREATE TABLE `interaction_question`  (
     `id` bigint NOT NULL COMMENT '主键，互动问题的id',
     `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '互动问题的标题',
     `description` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '问题描述信息',
     `course_id` bigint NOT NULL COMMENT '所属课程id',
     `chapter_id` bigint NOT NULL COMMENT '所属课程章id',
     `section_id` bigint NOT NULL COMMENT '所属课程节id',
     `user_id` bigint NOT NULL COMMENT '提问学员id',
     `latest_answer_id` bigint NULL DEFAULT NULL COMMENT '最新的一个回答的id',
     `answer_times` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '问题下的回答数量',
     `anonymity` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否匿名，默认false',
     `hidden` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否被隐藏，默认false',
     `status` tinyint NULL DEFAULT 0 COMMENT '管理端问题状态：0-未查看，1-已查看',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提问时间',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`) USING BTREE,
     INDEX `idx_course_id`(`course_id` ASC) USING BTREE,
     INDEX `section_id`(`section_id` ASC) USING BTREE,
     INDEX `user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '互动提问的问题表' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of interaction_question
-- ----------------------------
INSERT INTO `interaction_question` VALUES (1552212554946768897, 'redis安装的时候有问题，一直报错是怎么回事？', 'redis安装的时候有问题，总是报错是怎么回事？redis安装的时候有问题，总是报错是怎么回事？redis安装的时候有问题，总是报错是怎么回事？redis安装的时候有问题，总是报错是怎么回事？', 2, 15, 17, 129, 1548889371405492225, 1, b'1', b'0', 1, '2022-07-27 16:41:27', '2023-02-13 20:43:55');
INSERT INTO `interaction_question` VALUES (1585089140469317634, 'JDK安装后为什么没有效果？', '我按照老师的方式安装了JDK，但是控制台输入 java -version没有效果啊', 2, 15, 16, 2, 1585178277083951106, 2, b'0', b'0', 1, '2022-10-26 10:01:16', '2023-02-06 15:01:22');
INSERT INTO `interaction_question` VALUES (1585589766919852033, 'Java的IO是阻塞IO吗？', '比如IO流中的数据读写', 2, 15, 17, 2, 1588103282121805825, 1, b'0', b'0', 1, '2022-10-27 12:31:44', '2023-02-06 15:01:50');
INSERT INTO `interaction_question` VALUES (1620628704994623489, '老师，请问你的IDEA插件是哪个啊，看起来很好用', '就是哪个翻译用的插件', 2, 15, 16, 2, NULL, 0, b'0', b'0', 0, '2023-02-01 11:42:49', '2023-02-01 11:42:49');
