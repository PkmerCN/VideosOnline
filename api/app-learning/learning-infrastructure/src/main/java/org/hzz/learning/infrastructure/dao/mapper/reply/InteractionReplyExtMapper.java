package org.hzz.learning.infrastructure.dao.mapper.reply;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.core.mapper.PageMapper;
import org.hzz.learning.infrastructure.dao.entity.reply.InteractionReply;
import org.hzz.learning.infrastructure.repository.mybatis.question.InteractionReplyRepositoryImpl;

import java.util.List;

/**
 * {@link InteractionReplyRepositoryImpl}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Mapper
public interface InteractionReplyExtMapper extends PageMapper<InteractionReply> {

    int incrReplyTimes(@Param("id") Long id);


    /**
     * 目前只有likedTimes的批量更新。
     * 以后有其他字段的批量再进行更改
     * @param list
     * @return
     */
    int updateBatchByPrimarySelective(@Param("list") List<InteractionReply> list);
}
