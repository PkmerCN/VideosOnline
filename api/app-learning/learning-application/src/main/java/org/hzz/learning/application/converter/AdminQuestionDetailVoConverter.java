package org.hzz.learning.application.converter;

import org.hzz.common.tree.BaseConverter;
import org.hzz.learning.application.handler.question.admin.AdminGetQuestionDetailCommandHandler;
import org.hzz.learning.application.handler.question.admin.AdminQuestionPageQueryCommandHandler;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.mapstruct.Mapper;

/**
 * {@link AdminGetQuestionDetailCommandHandler}
 * {@link AdminQuestionPageQueryCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Mapper(componentModel = "spring")
public interface AdminQuestionDetailVoConverter
        extends BaseConverter<AdminQuestionDetailVo, InteractionQuestionEntity> {
}
