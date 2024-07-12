package org.hzz.learning.infrastructure.repository.mybatis;

import org.hzz.core.page.PageResponse;
import org.hzz.core.repository.withmapper.PageBaseRepository;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.repository.LearnLessonPageRepository;
import org.hzz.learning.infrastructure.converter.LearnLessonAggregateConverter;
import org.hzz.learning.infrastructure.dao.entity.lesson.LearningLesson;
import org.hzz.learning.infrastructure.dao.mapper.lesson.LearningLessonPageMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Repository
public class LearnLessonPageRepositoryImpl extends PageBaseRepository<LearningLessonPageMapper,
        LearningLesson,
        LearnLessonAggregateConverter> implements LearnLessonPageRepository {


    @Override
    public PageResponse<LearningLessonAggregate> selectPage(LearningLessonAggregate aggregate) {
        PageResponse<LearningLesson> results = super.pageQuery(aggregate.getPageQuery());
        List<LearningLessonAggregate> learningLessonAggregates = converter.mapToAggregateList(results.getList());

        return PageResponse.<LearningLessonAggregate>builder()
                .totalPages(results.getTotalPages())
                .currentPageNo(results.getCurrentPageNo())
                .total(results.getTotal())
                .list(learningLessonAggregates).build();

    }
}
