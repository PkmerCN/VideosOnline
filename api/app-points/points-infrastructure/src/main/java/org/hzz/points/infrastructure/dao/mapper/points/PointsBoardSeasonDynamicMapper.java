package org.hzz.points.infrastructure.dao.mapper.points;

import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.hzz.points.infrastructure.dao.model.points.PointsBoardSeason;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonDynamicSqlSupport.*;
import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Mapper
public interface PointsBoardSeasonDynamicMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PointsBoardSeason>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, beginTime, endTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="PointsBoardSeasonResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.DATE),
            @Result(column="end_time", property="endTime", jdbcType=JdbcType.DATE)
    })
    List<PointsBoardSeason> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PointsBoardSeasonResult")
    Optional<PointsBoardSeason> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, pointsBoardSeason, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, pointsBoardSeason, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PointsBoardSeason row) {
        return MyBatis3Utils.insert(this::insert, row, pointsBoardSeason, c ->
                c.map(id).toProperty("id")
                        .map(name).toProperty("name")
                        .map(beginTime).toProperty("beginTime")
                        .map(endTime).toProperty("endTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PointsBoardSeason> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, pointsBoardSeason, c ->
                c.map(id).toProperty("id")
                        .map(name).toProperty("name")
                        .map(beginTime).toProperty("beginTime")
                        .map(endTime).toProperty("endTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PointsBoardSeason row) {
        return MyBatis3Utils.insert(this::insert, row, pointsBoardSeason, c ->
                c.map(id).toPropertyWhenPresent("id", row::getId)
                        .map(name).toPropertyWhenPresent("name", row::getName)
                        .map(beginTime).toPropertyWhenPresent("beginTime", row::getBeginTime)
                        .map(endTime).toPropertyWhenPresent("endTime", row::getEndTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PointsBoardSeason> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, pointsBoardSeason, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PointsBoardSeason> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, pointsBoardSeason, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PointsBoardSeason> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, pointsBoardSeason, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PointsBoardSeason> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, pointsBoardSeason, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PointsBoardSeason row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(beginTime).equalTo(row::getBeginTime)
                .set(endTime).equalTo(row::getEndTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PointsBoardSeason row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(beginTime).equalToWhenPresent(row::getBeginTime)
                .set(endTime).equalToWhenPresent(row::getEndTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PointsBoardSeason row) {
        return update(c ->
                c.set(name).equalTo(row::getName)
                        .set(beginTime).equalTo(row::getBeginTime)
                        .set(endTime).equalTo(row::getEndTime)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PointsBoardSeason row) {
        return update(c ->
                c.set(name).equalToWhenPresent(row::getName)
                        .set(beginTime).equalToWhenPresent(row::getBeginTime)
                        .set(endTime).equalToWhenPresent(row::getEndTime)
                        .where(id, isEqualTo(row::getId))
        );
    }
}