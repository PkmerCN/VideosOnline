package org.hzz.learning.infrastructure.repository.mybatis.question;

import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.repository.question.InteractionReplyRepository;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionReply;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionReplyExample;
import org.hzz.learning.infrastructure.dao.mapper.question.InteractionReplyMapper;
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


    @Mapper
    interface Converter {
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        List<InteractionReplyEntity> toEntities(List<InteractionReply> records);

        InteractionReplyEntity toEntity(InteractionReply record);

        InteractionReply toRecord(InteractionReplyEntity entity);
    }
}
