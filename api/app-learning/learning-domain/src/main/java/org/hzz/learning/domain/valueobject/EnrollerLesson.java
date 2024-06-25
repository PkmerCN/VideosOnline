package org.hzz.learning.domain.valueobject;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.ValueObject;

import java.time.LocalDateTime;

/**
 * 订购课程值对象
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Data
public class EnrollerLesson implements ValueObject {
    private Long userId;
    private Long courseId;
    private LocalDateTime expireTime;
}
