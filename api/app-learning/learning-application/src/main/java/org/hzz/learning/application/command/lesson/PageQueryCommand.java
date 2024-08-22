package org.hzz.learning.application.command.lesson;

import lombok.Data;
import lombok.Value;
import io.gitee.pkmer.convention.page.query.PageQuery;
import io.gitee.pkmer.ddd.shared.command.Command;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Data
@Value(staticConstructor = "commandOf")
public class PageQueryCommand implements Command {
    PageQuery pageQuery;
}
