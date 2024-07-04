package org.hzz.learning.application.command;

import lombok.Data;
import lombok.Value;
import org.hzz.ddd.core.domain.shared.command.Command;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.ddd.core.domain.shared.command.Mark;

import static org.hzz.learning.application.handler.MarkConstants.LEARN_PLAN_ADD;

/**
 * 添加课程计划
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Data
@Value(staticConstructor = "commandOf")
public class LearnPlansAddCommand implements CommandWithMark {
     Long userId;
     Long courseId;
     Integer freq;

     @Override
     public String mark() {
          return LEARN_PLAN_ADD;
     }
}
