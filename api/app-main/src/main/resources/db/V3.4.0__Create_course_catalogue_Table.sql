DROP TABLE IF EXISTS `course_catalogue`;
CREATE TABLE `course_catalogue`  (
     `id` bigint NOT NULL COMMENT '课程目录id',
     `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '目录名称',
     `trailer` tinyint NOT NULL DEFAULT 0 COMMENT '是否支持试看',
     `course_id` bigint NOT NULL COMMENT '课程id',
     `type` tinyint NOT NULL COMMENT '目录类型1：章，2：节，3：测试',
     `parent_catalogue_id` bigint NOT NULL DEFAULT 0 COMMENT '所属章id，只有小节和测试有该值，章没有，章默认为0',
     `media_id` bigint NOT NULL DEFAULT 0 COMMENT '媒资id',
     `video_id` bigint NULL DEFAULT NULL COMMENT '视频id',
     `video_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '视频名称',
     `living_start_time` datetime NULL DEFAULT NULL COMMENT '直播开始时间',
     `living_end_time` datetime NULL DEFAULT NULL COMMENT '直播结束时间',
     `play_back` tinyint NOT NULL DEFAULT 0 COMMENT '是否支持回放',
     `media_duration` int NOT NULL DEFAULT 0 COMMENT '视频时长，以秒为单位',
     `c_index` int NOT NULL DEFAULT 0 COMMENT '用于章节排序',
     `dep_id` bigint NOT NULL COMMENT '部门id',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
     `creater_id` bigint NOT NULL COMMENT '创建人Id',
     `updater_id` bigint NOT NULL COMMENT '更新人Id',
     `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程录草稿' ROW_FORMAT = Dynamic;