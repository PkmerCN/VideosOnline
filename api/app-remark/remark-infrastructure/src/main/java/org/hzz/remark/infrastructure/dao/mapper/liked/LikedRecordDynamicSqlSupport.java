package org.hzz.remark.infrastructure.dao.mapper.liked;

import jakarta.annotation.Generated;
import org.hzz.remark.types.BizType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class LikedRecordDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final LikedRecord likedRecord = new LikedRecord();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = likedRecord.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userId = likedRecord.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> bizId = likedRecord.bizId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BizType> bizType = likedRecord.bizType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = likedRecord.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = likedRecord.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class LikedRecord extends AliasableSqlTable<LikedRecord> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> bizId = column("biz_id", JDBCType.BIGINT);

        public final SqlColumn<BizType> bizType = column("biz_type", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public LikedRecord() {
            super("liked_record", LikedRecord::new);
        }
    }
}