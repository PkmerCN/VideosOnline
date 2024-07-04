package org.hzz.learning.application.command;

import lombok.Data;
import lombok.Value;
import org.hzz.core.page.query.PageQuery;
import org.hzz.ddd.core.domain.shared.command.Command;

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
