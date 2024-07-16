package org.hzz.learning.infrastructure.repository.mybatis.question;

import cn.hutool.core.bean.BeanUtil;
import lombok.Setter;
import org.hzz.core.page.PageResponse;
import org.hzz.core.repository.nomapper.PageBaseRepository;
import org.hzz.learning.domain.aggregate.question.QuestionQueryAggregate;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.repository.question.InteractionQuestionRepository;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionQuestion;
import org.hzz.learning.infrastructure.dao.mapper.question.InteractionQuestionExtMapper;
import org.hzz.learning.infrastructure.dao.mapper.question.InteractionQuestionMapper;
import org.hzz.learning.infrastructure.dao.mapper.question.InteractionQuestionPageMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 问答表repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Repository
public class InteractionQuestionRepositoryImpl
        extends PageBaseRepository<InteractionQuestionPageMapper,InteractionQuestion>
        implements InteractionQuestionRepository {



    @Setter(onMethod_ = {@Autowired})
    private InteractionQuestionMapper interactionQuestionMapper;

    @Setter(onMethod_ = {@Autowired})
    private InteractionQuestionExtMapper interactionQuestionExtMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public int insertSelective(InteractionQuestionEntity entity) {
        InteractionQuestion interactionQuestion = BeanUtil.copyProperties(entity, InteractionQuestion.class);
        return interactionQuestionMapper.insertSelective(interactionQuestion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InteractionQuestionEntity selectById(Long id) {
        InteractionQuestion record = interactionQuestionMapper.selectByPrimaryKey(id);
        return Converter.INSTANCE.toEntity(record);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int deleteById(Long id) {
        return interactionQuestionMapper.deleteByPrimaryKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateSelective(InteractionQuestionEntity entity) {
        InteractionQuestion record = Converter.INSTANCE.toRecord(entity);
        return interactionQuestionMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageResponse<InteractionQuestionEntity> pageQuery(QuestionQueryAggregate aggregate) {
        PageResponse<InteractionQuestion> results = super.pageQuery(aggregate.getPageQuery());
        return PageResponse.<InteractionQuestionEntity>builder()
                .totalPages(results.getTotalPages())
                .currentPageNo(results.getCurrentPageNo())
                .total(results.getTotal())
                .list(Converter.INSTANCE.toEntities(results.getList()))
                .build();
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        List<InteractionQuestionEntity> toEntities(List<InteractionQuestion> record);

        InteractionQuestionEntity toEntity(InteractionQuestion record);

        InteractionQuestion toRecord(InteractionQuestionEntity entity);
    }
}
