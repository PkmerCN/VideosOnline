package org.hzz.course.infrastructure.dao.handler.teacher;

import org.hzz.core.enums.delete.Deleted;
import org.hzz.core.handler.ByteTypeHandler;

/**
 * 处理course_teacher表中deleted tinyint
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public class TeacherDeletedHandler extends ByteTypeHandler<Deleted> {
    @Override
    protected Deleted fromValue(Byte value) {
        return Deleted.fromValue(value);
    }
}
