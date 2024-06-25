package org.hzz.course.domain.aggregate;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.AggregateRoot;

import java.util.List;
/**
 * course
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Data
public class CourseSimpleInfoListDto implements AggregateRoot {

    /**
     * 三级分类id列表
     */
    List<Long> thirdCataIds;
    /**
     * 课程ids
     */
    List<Long> ids;
}
