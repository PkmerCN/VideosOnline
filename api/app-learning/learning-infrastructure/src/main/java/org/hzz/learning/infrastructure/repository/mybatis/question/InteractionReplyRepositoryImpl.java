package org.hzz.learning.infrastructure.repository.mybatis.question;

import lombok.Setter;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.PageQuery;
import org.hzz.core.repository.nomapper.PageBaseRepository;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.repository.reply.InteractionReplyRepository;
import org.hzz.learning.infrastructure.dao.entity.reply.InteractionReply;
import org.hzz.learning.infrastructure.dao.entity.reply.InteractionReplyExample;
import org.hzz.learning.infrastructure.dao.mapper.reply.InteractionReplyExtMapper;
import org.hzz.learning.infrastructure.dao.mapper.reply.InteractionReplyMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
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
         extends PageBaseRepository<InteractionReplyExtMapper,InteractionReply>
        implements InteractionReplyRepository {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyExtMapper replyExtMapper;

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyMapper replyMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InteractionReplyEntity> selectBatchIds(Set<Long> ids) {
        List<Long> idList = new ArrayList<>(ids);
        InteractionReplyExample example = new InteractionReplyExample();
        example.createCriteria()
                .andIdIn(idList);
        List<InteractionReply> interactionReplies = replyMapper.selectByExample(example);
        return Converter.INSTANCE.toEntities(interactionReplies);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InteractionReplyEntity selectById(Long id) {
        InteractionReply interactionReply = replyMapper.selectByPrimaryKey(id);
        return Converter.INSTANCE.toEntity(interactionReply);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteByQuestionId(Long questionId) {
        InteractionReplyExample example = new InteractionReplyExample();
        example.createCriteria().andQuestionIdEqualTo(questionId);
        return replyMapper.deleteByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insertSelective(InteractionReplyEntity entity) {
        InteractionReply record = Converter.INSTANCE.toRecord(entity);
        int i = replyMapper.insertSelective(record);
        // 做id处理
        entity.setId(record.getId());
        return i;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int updateSelective(InteractionReplyEntity entity) {
        InteractionReply record = Converter.INSTANCE.toRecord(entity);
        return replyMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int incrReplyTimes(Long id) {
        return replyExtMapper.incrReplyTimes(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageResponse<InteractionReplyEntity> selectPage(PageQuery pageQuery){
        PageResponse<InteractionReply> interactionReplyPageResponse = super.pageQuery(pageQuery);
        return Converter.INSTANCE.convertToEntityPage(interactionReplyPageResponse);
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<InteractionReply,InteractionReplyEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }

}
