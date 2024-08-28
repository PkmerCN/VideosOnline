package io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon;

import io.gitee.pkmer.coupon.infrastructure.dao.model.coupon.CouponScope;
import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
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

import static io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon.CouponScopeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface CouponDynamicScopeMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CouponScope>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, type, couponId, bizId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CouponScopeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.BIGINT),
        @Result(column="biz_id", property="bizId", jdbcType=JdbcType.BIGINT)
    })
    List<CouponScope> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CouponScopeResult")
    Optional<CouponScope> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, couponScope, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, couponScope, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(CouponScope row) {
        return MyBatis3Utils.insert(this::insert, row, couponScope, c ->
            c.map(id).toProperty("id")
            .map(type).toProperty("type")
            .map(couponId).toProperty("couponId")
            .map(bizId).toProperty("bizId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<CouponScope> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, couponScope, c ->
            c.map(id).toProperty("id")
            .map(type).toProperty("type")
            .map(couponId).toProperty("couponId")
            .map(bizId).toProperty("bizId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(CouponScope row) {
        return MyBatis3Utils.insert(this::insert, row, couponScope, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(type).toPropertyWhenPresent("type", row::getType)
            .map(couponId).toPropertyWhenPresent("couponId", row::getCouponId)
            .map(bizId).toPropertyWhenPresent("bizId", row::getBizId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CouponScope> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, couponScope, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CouponScope> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, couponScope, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CouponScope> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, couponScope, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CouponScope> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, couponScope, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(CouponScope row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(type).equalTo(row::getType)
                .set(couponId).equalTo(row::getCouponId)
                .set(bizId).equalTo(row::getBizId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CouponScope row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(type).equalToWhenPresent(row::getType)
                .set(couponId).equalToWhenPresent(row::getCouponId)
                .set(bizId).equalToWhenPresent(row::getBizId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(CouponScope row) {
        return update(c ->
            c.set(type).equalTo(row::getType)
            .set(couponId).equalTo(row::getCouponId)
            .set(bizId).equalTo(row::getBizId)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(CouponScope row) {
        return update(c ->
            c.set(type).equalToWhenPresent(row::getType)
            .set(couponId).equalToWhenPresent(row::getCouponId)
            .set(bizId).equalToWhenPresent(row::getBizId)
            .where(id, isEqualTo(row::getId))
        );
    }
}