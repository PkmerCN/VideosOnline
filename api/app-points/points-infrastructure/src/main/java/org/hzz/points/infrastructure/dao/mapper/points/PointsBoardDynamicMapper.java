package org.hzz.points.infrastructure.dao.mapper.points;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.hzz.points.infrastructure.dao.model.points.PointsBoard;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Mapper
public interface PointsBoardDynamicMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PointsBoard>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, points, rank, season);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PointsBoardResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
            @Result(column="points", property="points", jdbcType=JdbcType.INTEGER),
            @Result(column="rank", property="rank", jdbcType=JdbcType.TINYINT),
            @Result(column="season", property="season", jdbcType=JdbcType.SMALLINT)
    })
    List<PointsBoard> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PointsBoardResult")
    Optional<PointsBoard> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, pointsBoard, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, pointsBoard, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PointsBoard row) {
        return MyBatis3Utils.insert(this::insert, row, pointsBoard, c ->
                c.map(id).toProperty("id")
                        .map(userId).toProperty("userId")
                        .map(points).toProperty("points")
                        .map(rank).toProperty("rank")
                        .map(season).toProperty("season")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PointsBoard> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, pointsBoard, c ->
                c.map(id).toProperty("id")
                        .map(userId).toProperty("userId")
                        .map(points).toProperty("points")
                        .map(rank).toProperty("rank")
                        .map(season).toProperty("season")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PointsBoard row) {
        return MyBatis3Utils.insert(this::insert, row, pointsBoard, c ->
                c.map(id).toPropertyWhenPresent("id", row::getId)
                        .map(userId).toPropertyWhenPresent("userId", row::getUserId)
                        .map(points).toPropertyWhenPresent("points", row::getPoints)
                        .map(rank).toPropertyWhenPresent("rank", row::getRank)
                        .map(season).toPropertyWhenPresent("season", row::getSeason)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PointsBoard> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, pointsBoard, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PointsBoard> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, pointsBoard, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PointsBoard> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, pointsBoard, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PointsBoard> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, pointsBoard, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PointsBoard row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userId).equalTo(row::getUserId)
                .set(points).equalTo(row::getPoints)
                .set(rank).equalTo(row::getRank)
                .set(season).equalTo(row::getSeason);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PointsBoard row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(points).equalToWhenPresent(row::getPoints)
                .set(rank).equalToWhenPresent(row::getRank)
                .set(season).equalToWhenPresent(row::getSeason);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PointsBoard row) {
        return update(c ->
                c.set(userId).equalTo(row::getUserId)
                        .set(points).equalTo(row::getPoints)
                        .set(rank).equalTo(row::getRank)
                        .set(season).equalTo(row::getSeason)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PointsBoard row) {
        return update(c ->
                c.set(userId).equalToWhenPresent(row::getUserId)
                        .set(points).equalToWhenPresent(row::getPoints)
                        .set(rank).equalToWhenPresent(row::getRank)
                        .set(season).equalToWhenPresent(row::getSeason)
                        .where(id, isEqualTo(row::getId))
        );
    }
}