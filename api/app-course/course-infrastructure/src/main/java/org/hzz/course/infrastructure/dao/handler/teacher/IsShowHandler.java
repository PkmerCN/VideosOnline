package org.hzz.course.infrastructure.dao.handler.teacher;

import org.hzz.core.handler.ByteTypeHandler;
import org.hzz.course.types.enums.teacher.IsShow;

/**
 * 处理course_teacher表中is_show tinyint
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public class IsShowHandler extends ByteTypeHandler<IsShow> {

    @Override
    protected IsShow fromValue(Byte value) {
        return IsShow.fromValue(value);
    }
}
