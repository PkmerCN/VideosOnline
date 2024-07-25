package org.hzz.remark.infrastructure.dao.mapper.liked;

import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.hzz.remark.infrastructure.dao.model.liked.LikedRecord;
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

import static org.hzz.remark.infrastructure.dao.mapper.liked.LikedRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface LikedRecordDynamicMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<LikedRecord>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, bizId, bizType, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LikedRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="biz_id", property="bizId", jdbcType=JdbcType.BIGINT),
        @Result(column="biz_type", property="bizType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LikedRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LikedRecordResult")
    Optional<LikedRecord> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, likedRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, likedRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(LikedRecord row) {
        return MyBatis3Utils.insert(this::insert, row, likedRecord, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(bizId).toProperty("bizId")
            .map(bizType).toProperty("bizType")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<LikedRecord> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, likedRecord, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(bizId).toProperty("bizId")
            .map(bizType).toProperty("bizType")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(LikedRecord row) {
        return MyBatis3Utils.insert(this::insert, row, likedRecord, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(bizId).toPropertyWhenPresent("bizId", row::getBizId)
            .map(bizType).toPropertyWhenPresent("bizType", row::getBizType)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<LikedRecord> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, likedRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<LikedRecord> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, likedRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<LikedRecord> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, likedRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<LikedRecord> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, likedRecord, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(LikedRecord row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userId).equalTo(row::getUserId)
                .set(bizId).equalTo(row::getBizId)
                .set(bizType).equalTo(row::getBizType)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LikedRecord row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(bizId).equalToWhenPresent(row::getBizId)
                .set(bizType).equalToWhenPresent(row::getBizType)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(LikedRecord row) {
        return update(c ->
            c.set(userId).equalTo(row::getUserId)
            .set(bizId).equalTo(row::getBizId)
            .set(bizType).equalTo(row::getBizType)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateTime).equalTo(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(LikedRecord row) {
        return update(c ->
            c.set(userId).equalToWhenPresent(row::getUserId)
            .set(bizId).equalToWhenPresent(row::getBizId)
            .set(bizType).equalToWhenPresent(row::getBizType)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}