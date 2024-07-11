package org.hzz.learning.infrastructure.dao.mapper.question;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionReply;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionReplyExample;

public interface InteractionReplyMapper {
    long countByExample(InteractionReplyExample example);

    int deleteByExample(InteractionReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InteractionReply row);

    int insertSelective(InteractionReply row);

    List<InteractionReply> selectByExample(InteractionReplyExample example);

    InteractionReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") InteractionReply row, @Param("example") InteractionReplyExample example);

    int updateByExample(@Param("row") InteractionReply row, @Param("example") InteractionReplyExample example);

    int updateByPrimaryKeySelective(InteractionReply row);

    int updateByPrimaryKey(InteractionReply row);
}