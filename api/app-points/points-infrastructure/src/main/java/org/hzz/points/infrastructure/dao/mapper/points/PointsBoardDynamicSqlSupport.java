package org.hzz.points.infrastructure.dao.mapper.points;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;

public final class PointsBoardDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PointsBoard pointsBoard = new PointsBoard();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = pointsBoard.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userId = pointsBoard.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> points = pointsBoard.points;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> rank = pointsBoard.rank;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Short> season = pointsBoard.season;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PointsBoard extends AliasableSqlTable<PointsBoard> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> points = column("points", JDBCType.INTEGER);

        public final SqlColumn<Byte> rank = column("`rank`", JDBCType.TINYINT);

        public final SqlColumn<Short> season = column("season", JDBCType.SMALLINT);

        public PointsBoard() {
            super("points_board", PointsBoard::new);
        }
    }
}