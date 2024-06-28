package org.hzz.learning.domain.aggregate;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.AggregateRoot;
import org.hzz.learning.domain.entity.LearnRecordEntity;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
public class LearningLessonRecordAggregate implements AggregateRoot {

    private Long id;
    private Long latestSectionId;

    private List<LearnRecordEntity> records;

}
