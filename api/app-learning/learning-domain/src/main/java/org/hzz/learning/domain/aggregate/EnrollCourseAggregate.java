package org.hzz.learning.domain.aggregate;

import lombok.Builder;
import lombok.Data;
import org.hzz.course.domain.entity.CourseSimpleInfoDto;
import org.hzz.ddd.core.domain.shared.AggregateRoot;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Data
@Builder
public class EnrollCourseAggregate implements AggregateRoot {
    private Long id;
    private Long userId;
    List<CourseSimpleInfoDto> courses;
}
