package org.hzz.course.application.command.category;

import lombok.Data;
import org.hzz.course.application.handler.category.GetAllTreeCategoryCommandHandler;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;

/**
 * 获取所有的分类，以Tree分层的形式
 * {@link GetAllTreeCategoryCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@Data
public class GetAllTreeCategoryCommand implements CommandWithMark {
    public static final String MARK = GetAllTreeCategoryCommand.class.getName();
    Boolean isAdmin;

    @Override
    public String mark() {
        return MARK;
    }
}
