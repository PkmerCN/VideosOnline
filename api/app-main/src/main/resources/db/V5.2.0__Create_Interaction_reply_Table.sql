-- ----------------------------
-- 互动问题的回答或评论
-- ----------------------------
DROP TABLE IF EXISTS `interaction_reply`;
CREATE TABLE `interaction_reply`  (
      `id` bigint NOT NULL COMMENT '互动问题的回答id',
      `question_id` bigint NOT NULL COMMENT '互动问题问题id',
      `answer_id` bigint NULL DEFAULT 0 COMMENT '回复的上级回答id',
      `user_id` bigint NOT NULL COMMENT '回答者id',
      `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '回答内容',
      `target_user_id` bigint NULL DEFAULT 0 COMMENT '回复的目标用户id',
      `target_reply_id` bigint NULL DEFAULT 0 COMMENT '回复的目标回复id',
      `reply_times` int NOT NULL DEFAULT 0 COMMENT '评论数量',
      `liked_times` int NOT NULL DEFAULT 0 COMMENT '点赞数量',
      `hidden` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否被隐藏，默认false',
      `anonymity` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否匿名，默认false',
      `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
      `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
      PRIMARY KEY (`id`) USING BTREE,
      INDEX `idx_question_id`(`question_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '互动问题的回答或评论' ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Records of interaction_reply
-- ----------------------------
INSERT INTO `interaction_reply` VALUES (1548889371405492225, 1552212554946768897, 0, 1548889371405492225, '是不是Redis的依赖没有安装呢？', 0, 0, 0, 0, b'0', b'0', '2022-07-27 16:44:37', '2022-07-28 10:36:08');
INSERT INTO `interaction_reply` VALUES (1585177426969833473, 1585089140469317634, 0, 129, '同问啊，我也碰到这个问题了，老师，救救孩子吧', 2, 0, 0, 0, b'0', b'1', '2022-10-26 15:52:04', '2022-11-29 15:25:06');
INSERT INTO `interaction_reply` VALUES (1585178277083951106, 1585089140469317634, 0, 1548889371405492225, '安装完成后有没有配置环境变量呢？', 2, 0, 6, 1, b'0', b'0', '2022-10-26 15:55:27', '2023-02-07 21:19:51');
INSERT INTO `interaction_reply` VALUES (1585179315912388610, 1585089140469317634, 1585178277083951106, 2, '配置了，在Path中配置了JAVA_HOME', 1548889371405492225, 1585178277083951106, 0, 0, b'0', b'0', '2022-10-26 15:59:34', '2022-10-26 16:02:09');
INSERT INTO `interaction_reply` VALUES (1585180460118519809, 1585089140469317634, 1585178277083951106, 1548889371405492225, '如果确定环境变量没有配置错误的话，试试看关闭CMD窗口，再次打开', 2, 1585179315912388610, 0, 0, b'0', b'0', '2022-10-26 16:04:07', '2023-02-07 21:16:51');
INSERT INTO `interaction_reply` VALUES (1585183997506433026, 1585089140469317634, 1585178277083951106, 2, '老师牛啊，确实是这个问题。不过为什么要关闭呢？', 1548889371405492225, 1585178277083951106, 0, 0, b'0', b'0', '2022-10-26 16:18:10', '2023-02-06 15:03:48');
INSERT INTO `interaction_reply` VALUES (1585184256685060098, 1585089140469317634, 1585178277083951106, 129, '666，老师还是厉害啊', 1548889371405492225, 1585178277083951106, 0, 0, b'0', b'1', '2022-10-26 16:19:12', '2022-11-29 15:25:09');
INSERT INTO `interaction_reply` VALUES (1585184666292400129, 1585089140469317634, 1585178277083951106, 1548889371405492225, '因为CMD默认加载的还是你配置Path之前的环境变量，关闭重新打开后才会读取到最新的Path', 2, 1585183997506433026, 0, 0, b'0', b'0', '2022-10-26 16:20:50', '2023-02-06 15:03:52');
INSERT INTO `interaction_reply` VALUES (1585191151894343681, 1585089140469317634, 1585178277083951106, 2, '你个老6，为什么老匿名', 129, 1585184256685060098, 0, 0, b'0', b'0', '2022-10-26 16:46:36', '2022-11-29 15:25:13');
INSERT INTO `interaction_reply` VALUES (1588103282121805825, 1585589766919852033, 0, 1, '阻塞IO和非阻塞IO都有。java.io包下的都是阻塞IO，java.nio下的是非阻塞IO', 0, 0, 0, 0, b'0', b'0', '2022-11-03 16:35:32', '2022-11-03 18:13:24');
INSERT INTO `interaction_reply` VALUES (1588105119793188865, 1585589766919852033, 1588103282121805825, 2, '感谢老师的回复，我们课堂中没有讲过NIO，有没有资料啊', 0, 0, 0, 0, b'0', b'0', '2022-11-03 16:43:27', '2022-11-03 18:13:24');
INSERT INTO `interaction_reply` VALUES (1588110148121956353, 1585589766919852033, 1588103282121805825, 1, 'NIO资料可以联系客服MM获取哦', 2, 1588105119793188865, 0, 0, b'0', b'0', '2022-11-03 17:05:06', '2022-11-03 18:13:24');
