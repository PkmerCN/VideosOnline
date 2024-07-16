package org.hzz.course.infrastructure.dao.model.catalogue;

import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.types.enums.catalogue.CatalogueType;
import org.hzz.course.types.enums.catalogue.TrailerType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseCatalogueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseCatalogueExample() {
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

        public Criteria andTrailerIsNull() {
            addCriterion("trailer is null");
            return (Criteria) this;
        }

        public Criteria andTrailerIsNotNull() {
            addCriterion("trailer is not null");
            return (Criteria) this;
        }

        public Criteria andTrailerEqualTo(TrailerType value) {
            addCriterion("trailer =", value, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerNotEqualTo(TrailerType value) {
            addCriterion("trailer <>", value, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerGreaterThan(TrailerType value) {
            addCriterion("trailer >", value, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerGreaterThanOrEqualTo(TrailerType value) {
            addCriterion("trailer >=", value, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerLessThan(TrailerType value) {
            addCriterion("trailer <", value, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerLessThanOrEqualTo(TrailerType value) {
            addCriterion("trailer <=", value, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerIn(List<TrailerType> values) {
            addCriterion("trailer in", values, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerNotIn(List<TrailerType> values) {
            addCriterion("trailer not in", values, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerBetween(TrailerType value1, TrailerType value2) {
            addCriterion("trailer between", value1, value2, "trailer");
            return (Criteria) this;
        }

        public Criteria andTrailerNotBetween(TrailerType value1, TrailerType value2) {
            addCriterion("trailer not between", value1, value2, "trailer");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(CatalogueType value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(CatalogueType value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(CatalogueType value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(CatalogueType value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(CatalogueType value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(CatalogueType value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<CatalogueType> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<CatalogueType> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(CatalogueType value1, CatalogueType value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(CatalogueType value1, CatalogueType value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdIsNull() {
            addCriterion("parent_catalogue_id is null");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdIsNotNull() {
            addCriterion("parent_catalogue_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdEqualTo(Long value) {
            addCriterion("parent_catalogue_id =", value, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdNotEqualTo(Long value) {
            addCriterion("parent_catalogue_id <>", value, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdGreaterThan(Long value) {
            addCriterion("parent_catalogue_id >", value, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_catalogue_id >=", value, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdLessThan(Long value) {
            addCriterion("parent_catalogue_id <", value, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_catalogue_id <=", value, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdIn(List<Long> values) {
            addCriterion("parent_catalogue_id in", values, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdNotIn(List<Long> values) {
            addCriterion("parent_catalogue_id not in", values, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdBetween(Long value1, Long value2) {
            addCriterion("parent_catalogue_id between", value1, value2, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andParentCatalogueIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_catalogue_id not between", value1, value2, "parentCatalogueId");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNull() {
            addCriterion("media_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNotNull() {
            addCriterion("media_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaIdEqualTo(Long value) {
            addCriterion("media_id =", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotEqualTo(Long value) {
            addCriterion("media_id <>", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThan(Long value) {
            addCriterion("media_id >", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("media_id >=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThan(Long value) {
            addCriterion("media_id <", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThanOrEqualTo(Long value) {
            addCriterion("media_id <=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdIn(List<Long> values) {
            addCriterion("media_id in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotIn(List<Long> values) {
            addCriterion("media_id not in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdBetween(Long value1, Long value2) {
            addCriterion("media_id between", value1, value2, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotBetween(Long value1, Long value2) {
            addCriterion("media_id not between", value1, value2, "mediaId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(Long value) {
            addCriterion("video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(Long value) {
            addCriterion("video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(Long value) {
            addCriterion("video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(Long value) {
            addCriterion("video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(Long value) {
            addCriterion("video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<Long> values) {
            addCriterion("video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<Long> values) {
            addCriterion("video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(Long value1, Long value2) {
            addCriterion("video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(Long value1, Long value2) {
            addCriterion("video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNull() {
            addCriterion("video_name is null");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNotNull() {
            addCriterion("video_name is not null");
            return (Criteria) this;
        }

        public Criteria andVideoNameEqualTo(String value) {
            addCriterion("video_name =", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotEqualTo(String value) {
            addCriterion("video_name <>", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThan(String value) {
            addCriterion("video_name >", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThanOrEqualTo(String value) {
            addCriterion("video_name >=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThan(String value) {
            addCriterion("video_name <", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThanOrEqualTo(String value) {
            addCriterion("video_name <=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLike(String value) {
            addCriterion("video_name like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotLike(String value) {
            addCriterion("video_name not like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameIn(List<String> values) {
            addCriterion("video_name in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotIn(List<String> values) {
            addCriterion("video_name not in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameBetween(String value1, String value2) {
            addCriterion("video_name between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotBetween(String value1, String value2) {
            addCriterion("video_name not between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeIsNull() {
            addCriterion("living_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeIsNotNull() {
            addCriterion("living_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeEqualTo(LocalDateTime value) {
            addCriterion("living_start_time =", value, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeNotEqualTo(LocalDateTime value) {
            addCriterion("living_start_time <>", value, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeGreaterThan(LocalDateTime value) {
            addCriterion("living_start_time >", value, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("living_start_time >=", value, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeLessThan(LocalDateTime value) {
            addCriterion("living_start_time <", value, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("living_start_time <=", value, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeIn(List<LocalDateTime> values) {
            addCriterion("living_start_time in", values, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeNotIn(List<LocalDateTime> values) {
            addCriterion("living_start_time not in", values, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("living_start_time between", value1, value2, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingStartTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("living_start_time not between", value1, value2, "livingStartTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeIsNull() {
            addCriterion("living_end_time is null");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeIsNotNull() {
            addCriterion("living_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeEqualTo(LocalDateTime value) {
            addCriterion("living_end_time =", value, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeNotEqualTo(LocalDateTime value) {
            addCriterion("living_end_time <>", value, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeGreaterThan(LocalDateTime value) {
            addCriterion("living_end_time >", value, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("living_end_time >=", value, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeLessThan(LocalDateTime value) {
            addCriterion("living_end_time <", value, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("living_end_time <=", value, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeIn(List<LocalDateTime> values) {
            addCriterion("living_end_time in", values, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeNotIn(List<LocalDateTime> values) {
            addCriterion("living_end_time not in", values, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("living_end_time between", value1, value2, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andLivingEndTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("living_end_time not between", value1, value2, "livingEndTime");
            return (Criteria) this;
        }

        public Criteria andPlayBackIsNull() {
            addCriterion("play_back is null");
            return (Criteria) this;
        }

        public Criteria andPlayBackIsNotNull() {
            addCriterion("play_back is not null");
            return (Criteria) this;
        }

        public Criteria andPlayBackEqualTo(Byte value) {
            addCriterion("play_back =", value, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackNotEqualTo(Byte value) {
            addCriterion("play_back <>", value, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackGreaterThan(Byte value) {
            addCriterion("play_back >", value, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackGreaterThanOrEqualTo(Byte value) {
            addCriterion("play_back >=", value, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackLessThan(Byte value) {
            addCriterion("play_back <", value, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackLessThanOrEqualTo(Byte value) {
            addCriterion("play_back <=", value, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackIn(List<Byte> values) {
            addCriterion("play_back in", values, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackNotIn(List<Byte> values) {
            addCriterion("play_back not in", values, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackBetween(Byte value1, Byte value2) {
            addCriterion("play_back between", value1, value2, "playBack");
            return (Criteria) this;
        }

        public Criteria andPlayBackNotBetween(Byte value1, Byte value2) {
            addCriterion("play_back not between", value1, value2, "playBack");
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

        public Criteria andCIndexIsNull() {
            addCriterion("c_index is null");
            return (Criteria) this;
        }

        public Criteria andCIndexIsNotNull() {
            addCriterion("c_index is not null");
            return (Criteria) this;
        }

        public Criteria andCIndexEqualTo(Integer value) {
            addCriterion("c_index =", value, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexNotEqualTo(Integer value) {
            addCriterion("c_index <>", value, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexGreaterThan(Integer value) {
            addCriterion("c_index >", value, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_index >=", value, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexLessThan(Integer value) {
            addCriterion("c_index <", value, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexLessThanOrEqualTo(Integer value) {
            addCriterion("c_index <=", value, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexIn(List<Integer> values) {
            addCriterion("c_index in", values, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexNotIn(List<Integer> values) {
            addCriterion("c_index not in", values, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexBetween(Integer value1, Integer value2) {
            addCriterion("c_index between", value1, value2, "cIndex");
            return (Criteria) this;
        }

        public Criteria andCIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("c_index not between", value1, value2, "cIndex");
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

        public Criteria andDeletedEqualTo(Deleted value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Deleted value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Deleted value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Deleted value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Deleted value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Deleted value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Deleted> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Deleted> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Deleted value1, Deleted value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Deleted value1, Deleted value2) {
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