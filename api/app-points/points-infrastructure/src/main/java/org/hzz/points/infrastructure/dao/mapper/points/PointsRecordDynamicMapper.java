package org.hzz.points.infrastructure.dao.mapper.points;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsRecordDynamicSqlSupport.*;
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
import org.hzz.points.infrastructure.dao.model.points.PointsRecord;
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

@Mapper
public interface PointsRecordDynamicMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PointsRecord>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, type, points, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PointsRecordResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="points", property="points", jdbcType=JdbcType.TINYINT),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PointsRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PointsRecordResult")
    Optional<PointsRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, pointsRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, pointsRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PointsRecord row) {
        return MyBatis3Utils.insert(this::insert, row, pointsRecord, c ->
                c.map(id).toProperty("id")
                        .map(userId).toProperty("userId")
                        .map(type).toProperty("type")
                        .map(points).toProperty("points")
                        .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PointsRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, pointsRecord, c ->
                c.map(id).toProperty("id")
                        .map(userId).toProperty("userId")
                        .map(type).toProperty("type")
                        .map(points).toProperty("points")
                        .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PointsRecord row) {
        return MyBatis3Utils.insert(this::insert, row, pointsRecord, c ->
                c.map(id).toPropertyWhenPresent("id", row::getId)
                        .map(userId).toPropertyWhenPresent("userId", row::getUserId)
                        .map(type).toPropertyWhenPresent("type", row::getType)
                        .map(points).toPropertyWhenPresent("points", row::getPoints)
                        .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PointsRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, pointsRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PointsRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, pointsRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PointsRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, pointsRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PointsRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, pointsRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PointsRecord row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userId).equalTo(row::getUserId)
                .set(type).equalTo(row::getType)
                .set(points).equalTo(row::getPoints)
                .set(createTime).equalTo(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PointsRecord row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(type).equalToWhenPresent(row::getType)
                .set(points).equalToWhenPresent(row::getPoints)
                .set(createTime).equalToWhenPresent(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PointsRecord row) {
        return update(c ->
                c.set(userId).equalTo(row::getUserId)
                        .set(type).equalTo(row::getType)
                        .set(points).equalTo(row::getPoints)
                        .set(createTime).equalTo(row::getCreateTime)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PointsRecord row) {
        return update(c ->
                c.set(userId).equalToWhenPresent(row::getUserId)
                        .set(type).equalToWhenPresent(row::getType)
                        .set(points).equalToWhenPresent(row::getPoints)
                        .set(createTime).equalToWhenPresent(row::getCreateTime)
                        .where(id, isEqualTo(row::getId))
        );
    }
}