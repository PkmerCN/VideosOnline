package org.hzz.learning.infrastructure.repository.mybatis.question;

import cn.hutool.core.bean.BeanUtil;
import lombok.Setter;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.repository.question.InteractionQuestionRepository;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionQuestion;
import org.hzz.learning.infrastructure.dao.mapper.question.InteractionQuestionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 问答表repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Repository
public class InteractionQuestionRepositoryImpl implements InteractionQuestionRepository {

    @Setter(onMethod_ = {@Autowired})
    private InteractionQuestionMapper interactionQuestionMapper;

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
    public int updateSelective(InteractionQuestionEntity entity) {
        InteractionQuestion record = Converter.INSTANCE.toRecord(entity);
        return interactionQuestionMapper.updateByPrimaryKeySelective(record);
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        InteractionQuestionEntity toEntity(InteractionQuestion record);

        InteractionQuestion toRecord(InteractionQuestionEntity entity);
    }
}
