package io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */

import static io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon.CouponDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import io.gitee.pkmer.coupon.infrastructure.dao.model.coupon.Coupon;
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
public interface CouponDynamicMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Coupon>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, type, discountType, specific, discountValue, thresholdAmount, maxDiscountAmount, obtainWay, issueBeginTime, issueEndTime, termDays, termBeginTime, termEndTime, status, totalNum, issueNum, usedNum, userLimit, createTime, updateTime, creater, updater, extParam);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CouponResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="discount_type", property="discountType", jdbcType=JdbcType.TINYINT),
            @Result(column="specific", property="specific", jdbcType=JdbcType.BIT),
            @Result(column="discount_value", property="discountValue", jdbcType=JdbcType.INTEGER),
            @Result(column="threshold_amount", property="thresholdAmount", jdbcType=JdbcType.INTEGER),
            @Result(column="max_discount_amount", property="maxDiscountAmount", jdbcType=JdbcType.INTEGER),
            @Result(column="obtain_way", property="obtainWay", jdbcType=JdbcType.TINYINT),
            @Result(column="issue_begin_time", property="issueBeginTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="issue_end_time", property="issueEndTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="term_days", property="termDays", jdbcType=JdbcType.INTEGER),
            @Result(column="term_begin_time", property="termBeginTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="term_end_time", property="termEndTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
            @Result(column="total_num", property="totalNum", jdbcType=JdbcType.INTEGER),
            @Result(column="issue_num", property="issueNum", jdbcType=JdbcType.INTEGER),
            @Result(column="used_num", property="usedNum", jdbcType=JdbcType.INTEGER),
            @Result(column="user_limit", property="userLimit", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="creater", property="creater", jdbcType=JdbcType.BIGINT),
            @Result(column="updater", property="updater", jdbcType=JdbcType.BIGINT),
            @Result(column="ext_param", property="extParam", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Coupon> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CouponResult")
    Optional<Coupon> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, coupon, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, coupon, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Coupon row) {
        return MyBatis3Utils.insert(this::insert, row, coupon, c ->
                c.map(id).toProperty("id")
                        .map(name).toProperty("name")
                        .map(type).toProperty("type")
                        .map(discountType).toProperty("discountType")
                        .map(specific).toProperty("specific")
                        .map(discountValue).toProperty("discountValue")
                        .map(thresholdAmount).toProperty("thresholdAmount")
                        .map(maxDiscountAmount).toProperty("maxDiscountAmount")
                        .map(obtainWay).toProperty("obtainWay")
                        .map(issueBeginTime).toProperty("issueBeginTime")
                        .map(issueEndTime).toProperty("issueEndTime")
                        .map(termDays).toProperty("termDays")
                        .map(termBeginTime).toProperty("termBeginTime")
                        .map(termEndTime).toProperty("termEndTime")
                        .map(status).toProperty("status")
                        .map(totalNum).toProperty("totalNum")
                        .map(issueNum).toProperty("issueNum")
                        .map(usedNum).toProperty("usedNum")
                        .map(userLimit).toProperty("userLimit")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
                        .map(creater).toProperty("creater")
                        .map(updater).toProperty("updater")
                        .map(extParam).toProperty("extParam")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Coupon> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, coupon, c ->
                c.map(id).toProperty("id")
                        .map(name).toProperty("name")
                        .map(type).toProperty("type")
                        .map(discountType).toProperty("discountType")
                        .map(specific).toProperty("specific")
                        .map(discountValue).toProperty("discountValue")
                        .map(thresholdAmount).toProperty("thresholdAmount")
                        .map(maxDiscountAmount).toProperty("maxDiscountAmount")
                        .map(obtainWay).toProperty("obtainWay")
                        .map(issueBeginTime).toProperty("issueBeginTime")
                        .map(issueEndTime).toProperty("issueEndTime")
                        .map(termDays).toProperty("termDays")
                        .map(termBeginTime).toProperty("termBeginTime")
                        .map(termEndTime).toProperty("termEndTime")
                        .map(status).toProperty("status")
                        .map(totalNum).toProperty("totalNum")
                        .map(issueNum).toProperty("issueNum")
                        .map(usedNum).toProperty("usedNum")
                        .map(userLimit).toProperty("userLimit")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
                        .map(creater).toProperty("creater")
                        .map(updater).toProperty("updater")
                        .map(extParam).toProperty("extParam")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Coupon row) {
        return MyBatis3Utils.insert(this::insert, row, coupon, c ->
                c.map(id).toPropertyWhenPresent("id", row::getId)
                        .map(name).toPropertyWhenPresent("name", row::getName)
                        .map(type).toPropertyWhenPresent("type", row::getType)
                        .map(discountType).toPropertyWhenPresent("discountType", row::getDiscountType)
                        .map(specific).toPropertyWhenPresent("specific", row::getSpecific)
                        .map(discountValue).toPropertyWhenPresent("discountValue", row::getDiscountValue)
                        .map(thresholdAmount).toPropertyWhenPresent("thresholdAmount", row::getThresholdAmount)
                        .map(maxDiscountAmount).toPropertyWhenPresent("maxDiscountAmount", row::getMaxDiscountAmount)
                        .map(obtainWay).toPropertyWhenPresent("obtainWay", row::getObtainWay)
                        .map(issueBeginTime).toPropertyWhenPresent("issueBeginTime", row::getIssueBeginTime)
                        .map(issueEndTime).toPropertyWhenPresent("issueEndTime", row::getIssueEndTime)
                        .map(termDays).toPropertyWhenPresent("termDays", row::getTermDays)
                        .map(termBeginTime).toPropertyWhenPresent("termBeginTime", row::getTermBeginTime)
                        .map(termEndTime).toPropertyWhenPresent("termEndTime", row::getTermEndTime)
                        .map(status).toPropertyWhenPresent("status", row::getStatus)
                        .map(totalNum).toPropertyWhenPresent("totalNum", row::getTotalNum)
                        .map(issueNum).toPropertyWhenPresent("issueNum", row::getIssueNum)
                        .map(usedNum).toPropertyWhenPresent("usedNum", row::getUsedNum)
                        .map(userLimit).toPropertyWhenPresent("userLimit", row::getUserLimit)
                        .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
                        .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
                        .map(creater).toPropertyWhenPresent("creater", row::getCreater)
                        .map(updater).toPropertyWhenPresent("updater", row::getUpdater)
                        .map(extParam).toPropertyWhenPresent("extParam", row::getExtParam)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Coupon> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, coupon, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Coupon> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, coupon, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Coupon> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, coupon, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Coupon> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, coupon, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Coupon row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(type).equalTo(row::getType)
                .set(discountType).equalTo(row::getDiscountType)
                .set(specific).equalTo(row::getSpecific)
                .set(discountValue).equalTo(row::getDiscountValue)
                .set(thresholdAmount).equalTo(row::getThresholdAmount)
                .set(maxDiscountAmount).equalTo(row::getMaxDiscountAmount)
                .set(obtainWay).equalTo(row::getObtainWay)
                .set(issueBeginTime).equalTo(row::getIssueBeginTime)
                .set(issueEndTime).equalTo(row::getIssueEndTime)
                .set(termDays).equalTo(row::getTermDays)
                .set(termBeginTime).equalTo(row::getTermBeginTime)
                .set(termEndTime).equalTo(row::getTermEndTime)
                .set(status).equalTo(row::getStatus)
                .set(totalNum).equalTo(row::getTotalNum)
                .set(issueNum).equalTo(row::getIssueNum)
                .set(usedNum).equalTo(row::getUsedNum)
                .set(userLimit).equalTo(row::getUserLimit)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(creater).equalTo(row::getCreater)
                .set(updater).equalTo(row::getUpdater)
                .set(extParam).equalTo(row::getExtParam);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Coupon row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(type).equalToWhenPresent(row::getType)
                .set(discountType).equalToWhenPresent(row::getDiscountType)
                .set(specific).equalToWhenPresent(row::getSpecific)
                .set(discountValue).equalToWhenPresent(row::getDiscountValue)
                .set(thresholdAmount).equalToWhenPresent(row::getThresholdAmount)
                .set(maxDiscountAmount).equalToWhenPresent(row::getMaxDiscountAmount)
                .set(obtainWay).equalToWhenPresent(row::getObtainWay)
                .set(issueBeginTime).equalToWhenPresent(row::getIssueBeginTime)
                .set(issueEndTime).equalToWhenPresent(row::getIssueEndTime)
                .set(termDays).equalToWhenPresent(row::getTermDays)
                .set(termBeginTime).equalToWhenPresent(row::getTermBeginTime)
                .set(termEndTime).equalToWhenPresent(row::getTermEndTime)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(totalNum).equalToWhenPresent(row::getTotalNum)
                .set(issueNum).equalToWhenPresent(row::getIssueNum)
                .set(usedNum).equalToWhenPresent(row::getUsedNum)
                .set(userLimit).equalToWhenPresent(row::getUserLimit)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(creater).equalToWhenPresent(row::getCreater)
                .set(updater).equalToWhenPresent(row::getUpdater)
                .set(extParam).equalToWhenPresent(row::getExtParam);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Coupon row) {
        return update(c ->
                c.set(name).equalTo(row::getName)
                        .set(type).equalTo(row::getType)
                        .set(discountType).equalTo(row::getDiscountType)
                        .set(specific).equalTo(row::getSpecific)
                        .set(discountValue).equalTo(row::getDiscountValue)
                        .set(thresholdAmount).equalTo(row::getThresholdAmount)
                        .set(maxDiscountAmount).equalTo(row::getMaxDiscountAmount)
                        .set(obtainWay).equalTo(row::getObtainWay)
                        .set(issueBeginTime).equalTo(row::getIssueBeginTime)
                        .set(issueEndTime).equalTo(row::getIssueEndTime)
                        .set(termDays).equalTo(row::getTermDays)
                        .set(termBeginTime).equalTo(row::getTermBeginTime)
                        .set(termEndTime).equalTo(row::getTermEndTime)
                        .set(status).equalTo(row::getStatus)
                        .set(totalNum).equalTo(row::getTotalNum)
                        .set(issueNum).equalTo(row::getIssueNum)
                        .set(usedNum).equalTo(row::getUsedNum)
                        .set(userLimit).equalTo(row::getUserLimit)
                        .set(createTime).equalTo(row::getCreateTime)
                        .set(updateTime).equalTo(row::getUpdateTime)
                        .set(creater).equalTo(row::getCreater)
                        .set(updater).equalTo(row::getUpdater)
                        .set(extParam).equalTo(row::getExtParam)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Coupon row) {
        return update(c ->
                c.set(name).equalToWhenPresent(row::getName)
                        .set(type).equalToWhenPresent(row::getType)
                        .set(discountType).equalToWhenPresent(row::getDiscountType)
                        .set(specific).equalToWhenPresent(row::getSpecific)
                        .set(discountValue).equalToWhenPresent(row::getDiscountValue)
                        .set(thresholdAmount).equalToWhenPresent(row::getThresholdAmount)
                        .set(maxDiscountAmount).equalToWhenPresent(row::getMaxDiscountAmount)
                        .set(obtainWay).equalToWhenPresent(row::getObtainWay)
                        .set(issueBeginTime).equalToWhenPresent(row::getIssueBeginTime)
                        .set(issueEndTime).equalToWhenPresent(row::getIssueEndTime)
                        .set(termDays).equalToWhenPresent(row::getTermDays)
                        .set(termBeginTime).equalToWhenPresent(row::getTermBeginTime)
                        .set(termEndTime).equalToWhenPresent(row::getTermEndTime)
                        .set(status).equalToWhenPresent(row::getStatus)
                        .set(totalNum).equalToWhenPresent(row::getTotalNum)
                        .set(issueNum).equalToWhenPresent(row::getIssueNum)
                        .set(usedNum).equalToWhenPresent(row::getUsedNum)
                        .set(userLimit).equalToWhenPresent(row::getUserLimit)
                        .set(createTime).equalToWhenPresent(row::getCreateTime)
                        .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                        .set(creater).equalToWhenPresent(row::getCreater)
                        .set(updater).equalToWhenPresent(row::getUpdater)
                        .set(extParam).equalToWhenPresent(row::getExtParam)
                        .where(id, isEqualTo(row::getId))
        );
    }
}