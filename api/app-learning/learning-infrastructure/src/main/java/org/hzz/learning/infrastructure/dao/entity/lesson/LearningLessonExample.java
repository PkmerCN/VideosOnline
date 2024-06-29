package org.hzz.learning.infrastructure.dao.entity.lesson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LearningLessonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LearningLessonExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
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

        public Criteria andWeekFreqIsNull() {
            addCriterion("week_freq is null");
            return (Criteria) this;
        }

        public Criteria andWeekFreqIsNotNull() {
            addCriterion("week_freq is not null");
            return (Criteria) this;
        }

        public Criteria andWeekFreqEqualTo(Byte value) {
            addCriterion("week_freq =", value, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqNotEqualTo(Byte value) {
            addCriterion("week_freq <>", value, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqGreaterThan(Byte value) {
            addCriterion("week_freq >", value, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqGreaterThanOrEqualTo(Byte value) {
            addCriterion("week_freq >=", value, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqLessThan(Byte value) {
            addCriterion("week_freq <", value, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqLessThanOrEqualTo(Byte value) {
            addCriterion("week_freq <=", value, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqIn(List<Byte> values) {
            addCriterion("week_freq in", values, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqNotIn(List<Byte> values) {
            addCriterion("week_freq not in", values, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqBetween(Byte value1, Byte value2) {
            addCriterion("week_freq between", value1, value2, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andWeekFreqNotBetween(Byte value1, Byte value2) {
            addCriterion("week_freq not between", value1, value2, "weekFreq");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNull() {
            addCriterion("plan_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("plan_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(Byte value) {
            addCriterion("plan_status =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(Byte value) {
            addCriterion("plan_status <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(Byte value) {
            addCriterion("plan_status >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("plan_status >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(Byte value) {
            addCriterion("plan_status <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(Byte value) {
            addCriterion("plan_status <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<Byte> values) {
            addCriterion("plan_status in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<Byte> values) {
            addCriterion("plan_status not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(Byte value1, Byte value2) {
            addCriterion("plan_status between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("plan_status not between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsIsNull() {
            addCriterion("learned_sections is null");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsIsNotNull() {
            addCriterion("learned_sections is not null");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsEqualTo(Integer value) {
            addCriterion("learned_sections =", value, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsNotEqualTo(Integer value) {
            addCriterion("learned_sections <>", value, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsGreaterThan(Integer value) {
            addCriterion("learned_sections >", value, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("learned_sections >=", value, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsLessThan(Integer value) {
            addCriterion("learned_sections <", value, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsLessThanOrEqualTo(Integer value) {
            addCriterion("learned_sections <=", value, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsIn(List<Integer> values) {
            addCriterion("learned_sections in", values, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsNotIn(List<Integer> values) {
            addCriterion("learned_sections not in", values, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsBetween(Integer value1, Integer value2) {
            addCriterion("learned_sections between", value1, value2, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLearnedSectionsNotBetween(Integer value1, Integer value2) {
            addCriterion("learned_sections not between", value1, value2, "learnedSections");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdIsNull() {
            addCriterion("latest_section_id is null");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdIsNotNull() {
            addCriterion("latest_section_id is not null");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdEqualTo(Long value) {
            addCriterion("latest_section_id =", value, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdNotEqualTo(Long value) {
            addCriterion("latest_section_id <>", value, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdGreaterThan(Long value) {
            addCriterion("latest_section_id >", value, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("latest_section_id >=", value, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdLessThan(Long value) {
            addCriterion("latest_section_id <", value, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdLessThanOrEqualTo(Long value) {
            addCriterion("latest_section_id <=", value, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdIn(List<Long> values) {
            addCriterion("latest_section_id in", values, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdNotIn(List<Long> values) {
            addCriterion("latest_section_id not in", values, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdBetween(Long value1, Long value2) {
            addCriterion("latest_section_id between", value1, value2, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestSectionIdNotBetween(Long value1, Long value2) {
            addCriterion("latest_section_id not between", value1, value2, "latestSectionId");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeIsNull() {
            addCriterion("latest_learn_time is null");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeIsNotNull() {
            addCriterion("latest_learn_time is not null");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeEqualTo(LocalDateTime value) {
            addCriterion("latest_learn_time =", value, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeNotEqualTo(LocalDateTime value) {
            addCriterion("latest_learn_time <>", value, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeGreaterThan(LocalDateTime value) {
            addCriterion("latest_learn_time >", value, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("latest_learn_time >=", value, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeLessThan(LocalDateTime value) {
            addCriterion("latest_learn_time <", value, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("latest_learn_time <=", value, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeIn(List<LocalDateTime> values) {
            addCriterion("latest_learn_time in", values, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeNotIn(List<LocalDateTime> values) {
            addCriterion("latest_learn_time not in", values, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("latest_learn_time between", value1, value2, "latestLearnTime");
            return (Criteria) this;
        }

        public Criteria andLatestLearnTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("latest_learn_time not between", value1, value2, "latestLearnTime");
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

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(LocalDateTime value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(LocalDateTime value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(LocalDateTime value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(LocalDateTime value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<LocalDateTime> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<LocalDateTime> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
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