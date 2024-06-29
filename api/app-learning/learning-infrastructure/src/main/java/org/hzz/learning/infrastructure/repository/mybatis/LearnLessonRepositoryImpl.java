package org.hzz.learning.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.domain.repository.LearnLessonRepository;
import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.hzz.learning.infrastructure.converter.EnrollerLessonConverter;
import org.hzz.learning.infrastructure.converter.LearningLessonEntityConverter;
import org.hzz.learning.infrastructure.dao.entity.LearningLesson;
import org.hzz.learning.infrastructure.dao.entity.LearningLessonExample;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonBatchMapper;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Repository
public class LearnLessonRepositoryImpl implements LearnLessonRepository {

    @Setter(onMethod_ = @Autowired)
    private LearningLessonMapper learningLessonMapper;
    @Setter(onMethod_ = @Autowired)
    private LearningLessonBatchMapper learningLessonBatchMapper;

    @Setter(onMethod_ = @Autowired)
    private EnrollerLessonConverter enrollerLessonConverter;

    @Setter(onMethod_ = @Autowired)
    private LearningLessonEntityConverter lessonEntityConverter;

    @Override
    public void saveBath(List<EnrollerLesson> lessonList) {
        List<LearningLesson> learningLessons = enrollerLessonConverter.mapToLearningLessonList(lessonList);
        learningLessonBatchMapper.saveBatch(learningLessons);
    }

    @Override
    public int updateLearnLesson(LearningLessonEntity entity) {
        LearningLesson learningLesson = lessonEntityConverter.mapToDo(entity);
        return learningLessonMapper.updateByPrimaryKey(learningLesson);
    }

    @Override
    public LearningLessonEntity getLearningLesson(Long userId, Long courseId) {
        LearningLessonExample example = new LearningLessonExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andCourseIdEqualTo(courseId);
        List<LearningLesson> lessons = learningLessonMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(lessons)){
            return lessonEntityConverter.mapToEntity(lessons.get(0));
        }
        return null;
    }

    /**
     * 根据课程id获取课程数据
     * @param lessonId 课程id
     * @return 课程
     */
    @Override
    public LearningLessonEntity getLearningLesson(Long lessonId) {
        LearningLesson learningLesson = learningLessonMapper.selectByPrimaryKey(lessonId);
        return lessonEntityConverter.mapToEntity(learningLesson);
    }
}
