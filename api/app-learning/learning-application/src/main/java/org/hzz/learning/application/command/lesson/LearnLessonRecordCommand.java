package org.hzz.learning.application.command.lesson;

import lombok.Data;
import lombok.Value;

/**
 * 用户学习记录command
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Value(staticConstructor = "commandOf")
public class LearnLessonRecordCommand {
    Long userId;
    Long courseId;
}
