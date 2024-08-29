package org.hzz.coupon.infrastructure.dao.model.coupon;

import org.hzz.promotions.types.enums.coupon.CouponStatus;
import org.hzz.promotions.types.enums.coupon.DiscountType;
import org.hzz.promotions.types.enums.coupon.ObtainWay;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNull() {
            addCriterion("discount_type is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNotNull() {
            addCriterion("discount_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeEqualTo(DiscountType value) {
            addCriterion("discount_type =", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotEqualTo(DiscountType value) {
            addCriterion("discount_type <>", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThan(DiscountType value) {
            addCriterion("discount_type >", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThanOrEqualTo(DiscountType value) {
            addCriterion("discount_type >=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThan(DiscountType value) {
            addCriterion("discount_type <", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThanOrEqualTo(DiscountType value) {
            addCriterion("discount_type <=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIn(List<DiscountType> values) {
            addCriterion("discount_type in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotIn(List<DiscountType> values) {
            addCriterion("discount_type not in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeBetween(DiscountType value1, DiscountType value2) {
            addCriterion("discount_type between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotBetween(DiscountType value1, DiscountType value2) {
            addCriterion("discount_type not between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andSpecificIsNull() {
            addCriterion("`specific` is null");
            return (Criteria) this;
        }

        public Criteria andSpecificIsNotNull() {
            addCriterion("`specific` is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificEqualTo(Boolean value) {
            addCriterion("`specific` =", value, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificNotEqualTo(Boolean value) {
            addCriterion("`specific` <>", value, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificGreaterThan(Boolean value) {
            addCriterion("`specific` >", value, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`specific` >=", value, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificLessThan(Boolean value) {
            addCriterion("`specific` <", value, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificLessThanOrEqualTo(Boolean value) {
            addCriterion("`specific` <=", value, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificIn(List<Boolean> values) {
            addCriterion("`specific` in", values, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificNotIn(List<Boolean> values) {
            addCriterion("`specific` not in", values, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificBetween(Boolean value1, Boolean value2) {
            addCriterion("`specific` between", value1, value2, "specific");
            return (Criteria) this;
        }

        public Criteria andSpecificNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`specific` not between", value1, value2, "specific");
            return (Criteria) this;
        }

        public Criteria andDiscountValueIsNull() {
            addCriterion("discount_value is null");
            return (Criteria) this;
        }

        public Criteria andDiscountValueIsNotNull() {
            addCriterion("discount_value is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountValueEqualTo(Integer value) {
            addCriterion("discount_value =", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueNotEqualTo(Integer value) {
            addCriterion("discount_value <>", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueGreaterThan(Integer value) {
            addCriterion("discount_value >", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_value >=", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueLessThan(Integer value) {
            addCriterion("discount_value <", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueLessThanOrEqualTo(Integer value) {
            addCriterion("discount_value <=", value, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueIn(List<Integer> values) {
            addCriterion("discount_value in", values, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueNotIn(List<Integer> values) {
            addCriterion("discount_value not in", values, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueBetween(Integer value1, Integer value2) {
            addCriterion("discount_value between", value1, value2, "discountValue");
            return (Criteria) this;
        }

        public Criteria andDiscountValueNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_value not between", value1, value2, "discountValue");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountIsNull() {
            addCriterion("threshold_amount is null");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountIsNotNull() {
            addCriterion("threshold_amount is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountEqualTo(Integer value) {
            addCriterion("threshold_amount =", value, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountNotEqualTo(Integer value) {
            addCriterion("threshold_amount <>", value, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountGreaterThan(Integer value) {
            addCriterion("threshold_amount >", value, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("threshold_amount >=", value, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountLessThan(Integer value) {
            addCriterion("threshold_amount <", value, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountLessThanOrEqualTo(Integer value) {
            addCriterion("threshold_amount <=", value, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountIn(List<Integer> values) {
            addCriterion("threshold_amount in", values, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountNotIn(List<Integer> values) {
            addCriterion("threshold_amount not in", values, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountBetween(Integer value1, Integer value2) {
            addCriterion("threshold_amount between", value1, value2, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andThresholdAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("threshold_amount not between", value1, value2, "thresholdAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIsNull() {
            addCriterion("max_discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIsNotNull() {
            addCriterion("max_discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountEqualTo(Integer value) {
            addCriterion("max_discount_amount =", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotEqualTo(Integer value) {
            addCriterion("max_discount_amount <>", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountGreaterThan(Integer value) {
            addCriterion("max_discount_amount >", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_discount_amount >=", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountLessThan(Integer value) {
            addCriterion("max_discount_amount <", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountLessThanOrEqualTo(Integer value) {
            addCriterion("max_discount_amount <=", value, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountIn(List<Integer> values) {
            addCriterion("max_discount_amount in", values, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotIn(List<Integer> values) {
            addCriterion("max_discount_amount not in", values, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountBetween(Integer value1, Integer value2) {
            addCriterion("max_discount_amount between", value1, value2, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andMaxDiscountAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("max_discount_amount not between", value1, value2, "maxDiscountAmount");
            return (Criteria) this;
        }

        public Criteria andObtainWayIsNull() {
            addCriterion("obtain_way is null");
            return (Criteria) this;
        }

        public Criteria andObtainWayIsNotNull() {
            addCriterion("obtain_way is not null");
            return (Criteria) this;
        }

        public Criteria andObtainWayEqualTo(ObtainWay value) {
            addCriterion("obtain_way =", value, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayNotEqualTo(ObtainWay value) {
            addCriterion("obtain_way <>", value, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayGreaterThan(ObtainWay value) {
            addCriterion("obtain_way >", value, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayGreaterThanOrEqualTo(ObtainWay value) {
            addCriterion("obtain_way >=", value, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayLessThan(ObtainWay value) {
            addCriterion("obtain_way <", value, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayLessThanOrEqualTo(ObtainWay value) {
            addCriterion("obtain_way <=", value, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayIn(List<ObtainWay> values) {
            addCriterion("obtain_way in", values, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayNotIn(List<ObtainWay> values) {
            addCriterion("obtain_way not in", values, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayBetween(ObtainWay value1, ObtainWay value2) {
            addCriterion("obtain_way between", value1, value2, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andObtainWayNotBetween(ObtainWay value1, ObtainWay value2) {
            addCriterion("obtain_way not between", value1, value2, "obtainWay");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeIsNull() {
            addCriterion("issue_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeIsNotNull() {
            addCriterion("issue_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeEqualTo(LocalDateTime value) {
            addCriterion("issue_begin_time =", value, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeNotEqualTo(LocalDateTime value) {
            addCriterion("issue_begin_time <>", value, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeGreaterThan(LocalDateTime value) {
            addCriterion("issue_begin_time >", value, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("issue_begin_time >=", value, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeLessThan(LocalDateTime value) {
            addCriterion("issue_begin_time <", value, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("issue_begin_time <=", value, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeIn(List<LocalDateTime> values) {
            addCriterion("issue_begin_time in", values, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeNotIn(List<LocalDateTime> values) {
            addCriterion("issue_begin_time not in", values, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("issue_begin_time between", value1, value2, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueBeginTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("issue_begin_time not between", value1, value2, "issueBeginTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeIsNull() {
            addCriterion("issue_end_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeIsNotNull() {
            addCriterion("issue_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeEqualTo(LocalDateTime value) {
            addCriterion("issue_end_time =", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeNotEqualTo(LocalDateTime value) {
            addCriterion("issue_end_time <>", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeGreaterThan(LocalDateTime value) {
            addCriterion("issue_end_time >", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("issue_end_time >=", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeLessThan(LocalDateTime value) {
            addCriterion("issue_end_time <", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("issue_end_time <=", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeIn(List<LocalDateTime> values) {
            addCriterion("issue_end_time in", values, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeNotIn(List<LocalDateTime> values) {
            addCriterion("issue_end_time not in", values, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("issue_end_time between", value1, value2, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("issue_end_time not between", value1, value2, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andTermDaysIsNull() {
            addCriterion("term_days is null");
            return (Criteria) this;
        }

        public Criteria andTermDaysIsNotNull() {
            addCriterion("term_days is not null");
            return (Criteria) this;
        }

        public Criteria andTermDaysEqualTo(Integer value) {
            addCriterion("term_days =", value, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysNotEqualTo(Integer value) {
            addCriterion("term_days <>", value, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysGreaterThan(Integer value) {
            addCriterion("term_days >", value, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("term_days >=", value, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysLessThan(Integer value) {
            addCriterion("term_days <", value, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysLessThanOrEqualTo(Integer value) {
            addCriterion("term_days <=", value, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysIn(List<Integer> values) {
            addCriterion("term_days in", values, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysNotIn(List<Integer> values) {
            addCriterion("term_days not in", values, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysBetween(Integer value1, Integer value2) {
            addCriterion("term_days between", value1, value2, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("term_days not between", value1, value2, "termDays");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeIsNull() {
            addCriterion("term_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeIsNotNull() {
            addCriterion("term_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeEqualTo(LocalDateTime value) {
            addCriterion("term_begin_time =", value, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeNotEqualTo(LocalDateTime value) {
            addCriterion("term_begin_time <>", value, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeGreaterThan(LocalDateTime value) {
            addCriterion("term_begin_time >", value, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("term_begin_time >=", value, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeLessThan(LocalDateTime value) {
            addCriterion("term_begin_time <", value, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("term_begin_time <=", value, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeIn(List<LocalDateTime> values) {
            addCriterion("term_begin_time in", values, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeNotIn(List<LocalDateTime> values) {
            addCriterion("term_begin_time not in", values, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("term_begin_time between", value1, value2, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermBeginTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("term_begin_time not between", value1, value2, "termBeginTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeIsNull() {
            addCriterion("term_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeIsNotNull() {
            addCriterion("term_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeEqualTo(LocalDateTime value) {
            addCriterion("term_end_time =", value, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeNotEqualTo(LocalDateTime value) {
            addCriterion("term_end_time <>", value, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeGreaterThan(LocalDateTime value) {
            addCriterion("term_end_time >", value, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("term_end_time >=", value, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeLessThan(LocalDateTime value) {
            addCriterion("term_end_time <", value, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("term_end_time <=", value, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeIn(List<LocalDateTime> values) {
            addCriterion("term_end_time in", values, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeNotIn(List<LocalDateTime> values) {
            addCriterion("term_end_time not in", values, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("term_end_time between", value1, value2, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andTermEndTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("term_end_time not between", value1, value2, "termEndTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(CouponStatus value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(CouponStatus value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(CouponStatus value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(CouponStatus value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(CouponStatus value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(CouponStatus value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<CouponStatus> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<CouponStatus> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(CouponStatus value1, CouponStatus value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(CouponStatus value1, CouponStatus value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("total_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("total_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("total_num =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("total_num <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("total_num >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_num >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("total_num <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_num <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<Integer> values) {
            addCriterion("total_num in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<Integer> values) {
            addCriterion("total_num not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("total_num between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_num not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumIsNull() {
            addCriterion("issue_num is null");
            return (Criteria) this;
        }

        public Criteria andIssueNumIsNotNull() {
            addCriterion("issue_num is not null");
            return (Criteria) this;
        }

        public Criteria andIssueNumEqualTo(Integer value) {
            addCriterion("issue_num =", value, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumNotEqualTo(Integer value) {
            addCriterion("issue_num <>", value, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumGreaterThan(Integer value) {
            addCriterion("issue_num >", value, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_num >=", value, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumLessThan(Integer value) {
            addCriterion("issue_num <", value, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumLessThanOrEqualTo(Integer value) {
            addCriterion("issue_num <=", value, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumIn(List<Integer> values) {
            addCriterion("issue_num in", values, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumNotIn(List<Integer> values) {
            addCriterion("issue_num not in", values, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumBetween(Integer value1, Integer value2) {
            addCriterion("issue_num between", value1, value2, "issueNum");
            return (Criteria) this;
        }

        public Criteria andIssueNumNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_num not between", value1, value2, "issueNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumIsNull() {
            addCriterion("used_num is null");
            return (Criteria) this;
        }

        public Criteria andUsedNumIsNotNull() {
            addCriterion("used_num is not null");
            return (Criteria) this;
        }

        public Criteria andUsedNumEqualTo(Integer value) {
            addCriterion("used_num =", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotEqualTo(Integer value) {
            addCriterion("used_num <>", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumGreaterThan(Integer value) {
            addCriterion("used_num >", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("used_num >=", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumLessThan(Integer value) {
            addCriterion("used_num <", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumLessThanOrEqualTo(Integer value) {
            addCriterion("used_num <=", value, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumIn(List<Integer> values) {
            addCriterion("used_num in", values, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotIn(List<Integer> values) {
            addCriterion("used_num not in", values, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumBetween(Integer value1, Integer value2) {
            addCriterion("used_num between", value1, value2, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUsedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("used_num not between", value1, value2, "usedNum");
            return (Criteria) this;
        }

        public Criteria andUserLimitIsNull() {
            addCriterion("user_limit is null");
            return (Criteria) this;
        }

        public Criteria andUserLimitIsNotNull() {
            addCriterion("user_limit is not null");
            return (Criteria) this;
        }

        public Criteria andUserLimitEqualTo(Integer value) {
            addCriterion("user_limit =", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotEqualTo(Integer value) {
            addCriterion("user_limit <>", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitGreaterThan(Integer value) {
            addCriterion("user_limit >", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_limit >=", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitLessThan(Integer value) {
            addCriterion("user_limit <", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitLessThanOrEqualTo(Integer value) {
            addCriterion("user_limit <=", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitIn(List<Integer> values) {
            addCriterion("user_limit in", values, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotIn(List<Integer> values) {
            addCriterion("user_limit not in", values, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitBetween(Integer value1, Integer value2) {
            addCriterion("user_limit between", value1, value2, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("user_limit not between", value1, value2, "userLimit");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(Long value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(Long value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(Long value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(Long value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(Long value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(Long value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<Long> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<Long> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(Long value1, Long value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(Long value1, Long value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("updater is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("updater is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(Long value) {
            addCriterion("updater =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(Long value) {
            addCriterion("updater <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(Long value) {
            addCriterion("updater >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(Long value) {
            addCriterion("updater >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(Long value) {
            addCriterion("updater <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(Long value) {
            addCriterion("updater <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<Long> values) {
            addCriterion("updater in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<Long> values) {
            addCriterion("updater not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(Long value1, Long value2) {
            addCriterion("updater between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(Long value1, Long value2) {
            addCriterion("updater not between", value1, value2, "updater");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}