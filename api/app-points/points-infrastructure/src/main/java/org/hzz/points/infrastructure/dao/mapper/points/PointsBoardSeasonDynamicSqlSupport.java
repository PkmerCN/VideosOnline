package org.hzz.points.infrastructure.dao.mapper.points;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.time.LocalDate;

public final class PointsBoardSeasonDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PointsBoardSeason pointsBoardSeason = new PointsBoardSeason();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = pointsBoardSeason.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = pointsBoardSeason.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDate> beginTime = pointsBoardSeason.beginTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDate> endTime = pointsBoardSeason.endTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PointsBoardSeason extends AliasableSqlTable<PointsBoardSeason> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<LocalDate> beginTime = column("begin_time", JDBCType.DATE);

        public final SqlColumn<LocalDate> endTime = column("end_time", JDBCType.DATE);

        public PointsBoardSeason() {
            super("points_board_season", PointsBoardSeason::new);
        }
    }
}