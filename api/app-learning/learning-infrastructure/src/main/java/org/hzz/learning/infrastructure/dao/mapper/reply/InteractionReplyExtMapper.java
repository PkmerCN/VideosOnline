package org.hzz.learning.infrastructure.dao.mapper.reply;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.core.mapper.PageMapper;
import org.hzz.learning.infrastructure.dao.entity.reply.InteractionReply;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Mapper
public interface InteractionReplyExtMapper extends PageMapper<InteractionReply> {

    int incrReplyTimes(@Param("id") Long id);
}
