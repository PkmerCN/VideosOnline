package org.hzz.course.infrastructure.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(Byte value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(Byte value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(Byte value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(Byte value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<Byte> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<Byte> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(Byte value1, Byte value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNull() {
            addCriterion("cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNotNull() {
            addCriterion("cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlEqualTo(String value) {
            addCriterion("cover_url =", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotEqualTo(String value) {
            addCriterion("cover_url <>", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThan(String value) {
            addCriterion("cover_url >", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_url >=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThan(String value) {
            addCriterion("cover_url <", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("cover_url <=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLike(String value) {
            addCriterion("cover_url like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotLike(String value) {
            addCriterion("cover_url not like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIn(List<String> values) {
            addCriterion("cover_url in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotIn(List<String> values) {
            addCriterion("cover_url not in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlBetween(String value1, String value2) {
            addCriterion("cover_url between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotBetween(String value1, String value2) {
            addCriterion("cover_url not between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdIsNull() {
            addCriterion("first_cate_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdIsNotNull() {
            addCriterion("first_cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdEqualTo(Long value) {
            addCriterion("first_cate_id =", value, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdNotEqualTo(Long value) {
            addCriterion("first_cate_id <>", value, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdGreaterThan(Long value) {
            addCriterion("first_cate_id >", value, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("first_cate_id >=", value, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdLessThan(Long value) {
            addCriterion("first_cate_id <", value, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdLessThanOrEqualTo(Long value) {
            addCriterion("first_cate_id <=", value, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdIn(List<Long> values) {
            addCriterion("first_cate_id in", values, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdNotIn(List<Long> values) {
            addCriterion("first_cate_id not in", values, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdBetween(Long value1, Long value2) {
            addCriterion("first_cate_id between", value1, value2, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andFirstCateIdNotBetween(Long value1, Long value2) {
            addCriterion("first_cate_id not between", value1, value2, "firstCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdIsNull() {
            addCriterion("second_cate_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdIsNotNull() {
            addCriterion("second_cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdEqualTo(Long value) {
            addCriterion("second_cate_id =", value, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdNotEqualTo(Long value) {
            addCriterion("second_cate_id <>", value, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdGreaterThan(Long value) {
            addCriterion("second_cate_id >", value, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("second_cate_id >=", value, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdLessThan(Long value) {
            addCriterion("second_cate_id <", value, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdLessThanOrEqualTo(Long value) {
            addCriterion("second_cate_id <=", value, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdIn(List<Long> values) {
            addCriterion("second_cate_id in", values, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdNotIn(List<Long> values) {
            addCriterion("second_cate_id not in", values, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdBetween(Long value1, Long value2) {
            addCriterion("second_cate_id between", value1, value2, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andSecondCateIdNotBetween(Long value1, Long value2) {
            addCriterion("second_cate_id not between", value1, value2, "secondCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdIsNull() {
            addCriterion("third_cate_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdIsNotNull() {
            addCriterion("third_cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdEqualTo(Long value) {
            addCriterion("third_cate_id =", value, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdNotEqualTo(Long value) {
            addCriterion("third_cate_id <>", value, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdGreaterThan(Long value) {
            addCriterion("third_cate_id >", value, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("third_cate_id >=", value, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdLessThan(Long value) {
            addCriterion("third_cate_id <", value, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdLessThanOrEqualTo(Long value) {
            addCriterion("third_cate_id <=", value, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdIn(List<Long> values) {
            addCriterion("third_cate_id in", values, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdNotIn(List<Long> values) {
            addCriterion("third_cate_id not in", values, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdBetween(Long value1, Long value2) {
            addCriterion("third_cate_id between", value1, value2, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andThirdCateIdNotBetween(Long value1, Long value2) {
            addCriterion("third_cate_id not between", value1, value2, "thirdCateId");
            return (Criteria) this;
        }

        public Criteria andFreeIsNull() {
            addCriterion("free is null");
            return (Criteria) this;
        }

        public Criteria andFreeIsNotNull() {
            addCriterion("free is not null");
            return (Criteria) this;
        }

        public Criteria andFreeEqualTo(Byte value) {
            addCriterion("free =", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeNotEqualTo(Byte value) {
            addCriterion("free <>", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeGreaterThan(Byte value) {
            addCriterion("free >", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeGreaterThanOrEqualTo(Byte value) {
            addCriterion("free >=", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeLessThan(Byte value) {
            addCriterion("free <", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeLessThanOrEqualTo(Byte value) {
            addCriterion("free <=", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeIn(List<Byte> values) {
            addCriterion("free in", values, "free");
            return (Criteria) this;
        }

        public Criteria andFreeNotIn(List<Byte> values) {
            addCriterion("free not in", values, "free");
            return (Criteria) this;
        }

        public Criteria andFreeBetween(Byte value1, Byte value2) {
            addCriterion("free between", value1, value2, "free");
            return (Criteria) this;
        }

        public Criteria andFreeNotBetween(Byte value1, Byte value2) {
            addCriterion("free not between", value1, value2, "free");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNull() {
            addCriterion("template_type is null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIsNotNull() {
            addCriterion("template_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeEqualTo(Byte value) {
            addCriterion("template_type =", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotEqualTo(Byte value) {
            addCriterion("template_type <>", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThan(Byte value) {
            addCriterion("template_type >", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("template_type >=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThan(Byte value) {
            addCriterion("template_type <", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("template_type <=", value, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeIn(List<Byte> values) {
            addCriterion("template_type in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotIn(List<Byte> values) {
            addCriterion("template_type not in", values, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeBetween(Byte value1, Byte value2) {
            addCriterion("template_type between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("template_type not between", value1, value2, "templateType");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlIsNull() {
            addCriterion("template_url is null");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlIsNotNull() {
            addCriterion("template_url is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlEqualTo(String value) {
            addCriterion("template_url =", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlNotEqualTo(String value) {
            addCriterion("template_url <>", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlGreaterThan(String value) {
            addCriterion("template_url >", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("template_url >=", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlLessThan(String value) {
            addCriterion("template_url <", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlLessThanOrEqualTo(String value) {
            addCriterion("template_url <=", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlLike(String value) {
            addCriterion("template_url like", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlNotLike(String value) {
            addCriterion("template_url not like", value, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlIn(List<String> values) {
            addCriterion("template_url in", values, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlNotIn(List<String> values) {
            addCriterion("template_url not in", values, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlBetween(String value1, String value2) {
            addCriterion("template_url between", value1, value2, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andTemplateUrlNotBetween(String value1, String value2) {
            addCriterion("template_url not between", value1, value2, "templateUrl");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeIsNull() {
            addCriterion("purchase_start_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeIsNotNull() {
            addCriterion("purchase_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeEqualTo(Date value) {
            addCriterion("purchase_start_time =", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeNotEqualTo(Date value) {
            addCriterion("purchase_start_time <>", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeGreaterThan(Date value) {
            addCriterion("purchase_start_time >", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_start_time >=", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeLessThan(Date value) {
            addCriterion("purchase_start_time <", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_start_time <=", value, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeIn(List<Date> values) {
            addCriterion("purchase_start_time in", values, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeNotIn(List<Date> values) {
            addCriterion("purchase_start_time not in", values, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_start_time between", value1, value2, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_start_time not between", value1, value2, "purchaseStartTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeIsNull() {
            addCriterion("purchase_end_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeIsNotNull() {
            addCriterion("purchase_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeEqualTo(Date value) {
            addCriterion("purchase_end_time =", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeNotEqualTo(Date value) {
            addCriterion("purchase_end_time <>", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeGreaterThan(Date value) {
            addCriterion("purchase_end_time >", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_end_time >=", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeLessThan(Date value) {
            addCriterion("purchase_end_time <", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_end_time <=", value, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeIn(List<Date> values) {
            addCriterion("purchase_end_time in", values, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeNotIn(List<Date> values) {
            addCriterion("purchase_end_time not in", values, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_end_time between", value1, value2, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_end_time not between", value1, value2, "purchaseEndTime");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Byte value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Byte value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Byte value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Byte value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Byte value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Byte value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Byte> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Byte> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Byte value1, Byte value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Byte value1, Byte value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andMediaDurationIsNull() {
            addCriterion("media_duration is null");
            return (Criteria) this;
        }

        public Criteria andMediaDurationIsNotNull() {
            addCriterion("media_duration is not null");
            return (Criteria) this;
        }

        public Criteria andMediaDurationEqualTo(Integer value) {
            addCriterion("media_duration =", value, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationNotEqualTo(Integer value) {
            addCriterion("media_duration <>", value, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationGreaterThan(Integer value) {
            addCriterion("media_duration >", value, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("media_duration >=", value, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationLessThan(Integer value) {
            addCriterion("media_duration <", value, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationLessThanOrEqualTo(Integer value) {
            addCriterion("media_duration <=", value, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationIn(List<Integer> values) {
            addCriterion("media_duration in", values, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationNotIn(List<Integer> values) {
            addCriterion("media_duration not in", values, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationBetween(Integer value1, Integer value2) {
            addCriterion("media_duration between", value1, value2, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andMediaDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("media_duration not between", value1, value2, "mediaDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationIsNull() {
            addCriterion("valid_duration is null");
            return (Criteria) this;
        }

        public Criteria andValidDurationIsNotNull() {
            addCriterion("valid_duration is not null");
            return (Criteria) this;
        }

        public Criteria andValidDurationEqualTo(Integer value) {
            addCriterion("valid_duration =", value, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationNotEqualTo(Integer value) {
            addCriterion("valid_duration <>", value, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationGreaterThan(Integer value) {
            addCriterion("valid_duration >", value, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid_duration >=", value, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationLessThan(Integer value) {
            addCriterion("valid_duration <", value, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationLessThanOrEqualTo(Integer value) {
            addCriterion("valid_duration <=", value, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationIn(List<Integer> values) {
            addCriterion("valid_duration in", values, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationNotIn(List<Integer> values) {
            addCriterion("valid_duration not in", values, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationBetween(Integer value1, Integer value2) {
            addCriterion("valid_duration between", value1, value2, "validDuration");
            return (Criteria) this;
        }

        public Criteria andValidDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("valid_duration not between", value1, value2, "validDuration");
            return (Criteria) this;
        }

        public Criteria andSectionNumIsNull() {
            addCriterion("section_num is null");
            return (Criteria) this;
        }

        public Criteria andSectionNumIsNotNull() {
            addCriterion("section_num is not null");
            return (Criteria) this;
        }

        public Criteria andSectionNumEqualTo(Integer value) {
            addCriterion("section_num =", value, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumNotEqualTo(Integer value) {
            addCriterion("section_num <>", value, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumGreaterThan(Integer value) {
            addCriterion("section_num >", value, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("section_num >=", value, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumLessThan(Integer value) {
            addCriterion("section_num <", value, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumLessThanOrEqualTo(Integer value) {
            addCriterion("section_num <=", value, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumIn(List<Integer> values) {
            addCriterion("section_num in", values, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumNotIn(List<Integer> values) {
            addCriterion("section_num not in", values, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumBetween(Integer value1, Integer value2) {
            addCriterion("section_num between", value1, value2, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andSectionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("section_num not between", value1, value2, "sectionNum");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNull() {
            addCriterion("dep_id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(Long value) {
            addCriterion("dep_id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(Long value) {
            addCriterion("dep_id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(Long value) {
            addCriterion("dep_id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dep_id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(Long value) {
            addCriterion("dep_id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(Long value) {
            addCriterion("dep_id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<Long> values) {
            addCriterion("dep_id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<Long> values) {
            addCriterion("dep_id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(Long value1, Long value2) {
            addCriterion("dep_id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(Long value1, Long value2) {
            addCriterion("dep_id not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andPublishTimesIsNull() {
            addCriterion("publish_times is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimesIsNotNull() {
            addCriterion("publish_times is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimesEqualTo(Integer value) {
            addCriterion("publish_times =", value, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesNotEqualTo(Integer value) {
            addCriterion("publish_times <>", value, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesGreaterThan(Integer value) {
            addCriterion("publish_times >", value, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("publish_times >=", value, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesLessThan(Integer value) {
            addCriterion("publish_times <", value, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesLessThanOrEqualTo(Integer value) {
            addCriterion("publish_times <=", value, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesIn(List<Integer> values) {
            addCriterion("publish_times in", values, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesNotIn(List<Integer> values) {
            addCriterion("publish_times not in", values, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesBetween(Integer value1, Integer value2) {
            addCriterion("publish_times between", value1, value2, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("publish_times not between", value1, value2, "publishTimes");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNull() {
            addCriterion("creater_id is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNotNull() {
            addCriterion("creater_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdEqualTo(Long value) {
            addCriterion("creater_id =", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotEqualTo(Long value) {
            addCriterion("creater_id <>", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThan(Long value) {
            addCriterion("creater_id >", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("creater_id >=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThan(Long value) {
            addCriterion("creater_id <", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThanOrEqualTo(Long value) {
            addCriterion("creater_id <=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIn(List<Long> values) {
            addCriterion("creater_id in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotIn(List<Long> values) {
            addCriterion("creater_id not in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdBetween(Long value1, Long value2) {
            addCriterion("creater_id between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotBetween(Long value1, Long value2) {
            addCriterion("creater_id not between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNull() {
            addCriterion("updater_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNotNull() {
            addCriterion("updater_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdEqualTo(Long value) {
            addCriterion("updater_id =", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotEqualTo(Long value) {
            addCriterion("updater_id <>", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThan(Long value) {
            addCriterion("updater_id >", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("updater_id >=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThan(Long value) {
            addCriterion("updater_id <", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThanOrEqualTo(Long value) {
            addCriterion("updater_id <=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIn(List<Long> values) {
            addCriterion("updater_id in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotIn(List<Long> values) {
            addCriterion("updater_id not in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdBetween(Long value1, Long value2) {
            addCriterion("updater_id between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotBetween(Long value1, Long value2) {
            addCriterion("updater_id not between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Byte value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Byte value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Byte value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Byte value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Byte> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Byte> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Byte value1, Byte value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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