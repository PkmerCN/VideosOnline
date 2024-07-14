package org.hzz.course.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hzz.ddd.core.domain.shared.AggregateRoot;

import java.util.List;
/**
 * course
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseIdAggregate implements AggregateRoot {

    /**
     * 三级分类id列表
     */
    List<Long> thirdCataIds;
    /**
     * 课程ids
     */
    List<Long> ids;
}
