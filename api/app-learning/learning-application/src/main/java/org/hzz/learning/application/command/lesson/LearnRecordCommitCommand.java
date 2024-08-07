package org.hzz.learning.application.command.lesson;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.learning.types.enums.lesson.SectionType;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Accessors(chain = true)
public class LearnRecordCommitCommand {
    Long userId;
    Long lessonId;
    Long sectionId;
    SectionType sectionType;
    LocalDateTime commitTime;
    Integer duration;
    Integer moment;
}
