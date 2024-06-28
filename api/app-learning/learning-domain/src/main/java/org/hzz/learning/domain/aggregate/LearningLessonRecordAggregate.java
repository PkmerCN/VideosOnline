package org.hzz.learning.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hzz.ddd.core.domain.shared.AggregateRoot;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.entity.LearningLessonEntity;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LearningLessonRecordAggregate implements AggregateRoot {

    private LearningLessonEntity lesson;

    private List<LearnRecordEntity> records;

}
