DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '课程分类id',
     `name` varchar(50)  NOT NULL COMMENT '分类名称',
     `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '父分类id，一级分类父id为0',
     `level` int NOT NULL COMMENT '分类级别，1,2,3：代表一级分类，二级分类，三级分类',
     `priority` int NOT NULL DEFAULT 1 COMMENT '同级目录优先级，数字越小优先级越高，可以重复',
     `status` tinyint NOT NULL COMMENT '课程分类状态，1：正常，2：禁用',
     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     `creater` varchar(50) NOT NULL COMMENT '创建者',
     `updater` varchar(50) NOT NULL COMMENT '更新者',
     `deleted` tinyint NOT NULL DEFAULT 0,
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3656 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程分类' ROW_FORMAT = Dynamic;
