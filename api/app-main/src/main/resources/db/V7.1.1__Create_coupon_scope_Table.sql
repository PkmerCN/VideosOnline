DROP TABLE IF EXISTS `coupon_scope`;
CREATE TABLE `coupon_scope`  (
         `id` bigint NOT NULL,
         `type` tinyint NOT NULL DEFAULT 1 COMMENT '范围限定类型：1-分类，2-课程，等等',
         `coupon_id` bigint NOT NULL COMMENT '优惠券id',
         `biz_id` bigint NOT NULL COMMENT '优惠券作用范围的业务id，例如分类id、课程id',
         PRIMARY KEY (`id`) USING BTREE,
         INDEX `idx_coupon`(`coupon_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '优惠券作用范围信息' ROW_FORMAT = Dynamic;
