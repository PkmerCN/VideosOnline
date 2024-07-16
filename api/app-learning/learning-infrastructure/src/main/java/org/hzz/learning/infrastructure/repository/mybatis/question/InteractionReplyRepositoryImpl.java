package org.hzz.learning.infrastructure.repository.mybatis.question;

import org.hzz.common.tree.BaseConverter;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.repository.question.InteractionReplyRepository;
import org.hzz.learning.infrastructure.dao.entity.reply.InteractionReply;
import org.hzz.learning.infrastructure.dao.entity.reply.InteractionReplyExample;
import org.hzz.learning.infrastructure.dao.mapper.reply.InteractionReplyMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Repository
public class InteractionReplyRepositoryImpl
        extends BaseRepository<InteractionReplyMapper>
        implements InteractionReplyRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InteractionReplyEntity> selectBatchIds(Set<Long> ids) {
        List<Long> idList = new ArrayList<>(ids);
        InteractionReplyExample example = new InteractionReplyExample();
        example.createCriteria()
                .andIdIn(idList);
        List<InteractionReply> interactionReplies = mapper.selectByExample(example);
        return Converter.INSTANCE.toEntities(interactionReplies);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteByQuestionId(Long questionId) {
        InteractionReplyExample example = new InteractionReplyExample();
        example.createCriteria().andQuestionIdEqualTo(questionId);
        return mapper.deleteByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(InteractionReplyEntity entity) {
        InteractionReply record = Converter.INSTANCE.toRecord(entity);
        return mapper.insertSelective(record);
    }


    @Mapper
    interface Converter extends RecordAndEntityConverter<InteractionReply,InteractionReplyEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
