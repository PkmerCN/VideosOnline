package org.hzz.points.infrastructure.dao.mapper.points;

import jakarta.annotation.Generated;
import org.hzz.points.types.enums.PointsType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class PointsRecordDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PointsRecord pointsRecord = new PointsRecord();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = pointsRecord.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userId = pointsRecord.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<PointsType> type = pointsRecord.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> points = pointsRecord.points;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = pointsRecord.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PointsRecord extends AliasableSqlTable<PointsRecord> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<PointsType> type = column("type", JDBCType.TINYINT);

        public final SqlColumn<Byte> points = column("points", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public PointsRecord() {
            super("points_record", PointsRecord::new);
        }
    }
}