package org.hzz.learning.infrastructure.dao.mapper.lesson;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.learning.infrastructure.dao.entity.lesson.LearningLesson;
import org.hzz.learning.infrastructure.dao.entity.lesson.LearningLessonExample;

import java.util.List;

@Mapper
public interface LearningLessonMapper {
    long countByExample(LearningLessonExample example);

    int deleteByExample(LearningLessonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LearningLesson row);

    int insertSelective(LearningLesson row);

    List<LearningLesson> selectByExample(LearningLessonExample example);

    LearningLesson selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") LearningLesson row, @Param("example") LearningLessonExample example);

    int updateByExample(@Param("row") LearningLesson row, @Param("example") LearningLessonExample example);

    int updateByPrimaryKeySelective(LearningLesson row);

    int updateByPrimaryKey(LearningLesson row);
}