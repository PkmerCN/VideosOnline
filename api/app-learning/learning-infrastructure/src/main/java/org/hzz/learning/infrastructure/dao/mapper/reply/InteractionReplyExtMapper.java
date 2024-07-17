package org.hzz.learning.infrastructure.dao.mapper.reply;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Mapper
public interface InteractionReplyExtMapper {

    int incrReplyTimes(@Param("id") Long id);
}
