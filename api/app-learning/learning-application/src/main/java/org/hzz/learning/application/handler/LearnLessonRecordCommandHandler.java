package org.hzz.learning.application.handler;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.resp.LearnLessonRecordDto;
import org.hzz.learning.application.resp.LearnRecordDto;
import org.hzz.learning.application.command.LearnLessonRecordCommand;
import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.service.lesson.LearnLessonRecordDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理课程学习进度
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Component
public class LearnLessonRecordCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LearnLessonRecordCommand, LearnLessonRecordDto> {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonRecordDomainService learnLessonRecordDomainService;

    @Override
    public String mark() {
        return MarkConstants.LEARN_LESSON_RECORD;
    }

    @Override
    public LearnLessonRecordDto executeWithResp(LearnLessonRecordCommand command) {
        LearningLessonRecordAggregate aggregate = learnLessonRecordDomainService.queryLearnLessonRecord(
                command.getUserId(),
                command.getCourseId()
        );

        return LearnLessonRecordDtoMapper.INSTANCE.convertFrom(aggregate);
    }

    @Mapper
    interface LearnLessonRecordDtoMapper{
        LearnLessonRecordDtoMapper INSTANCE = Mappers.getMapper(LearnLessonRecordDtoMapper.class);

        @Mappings({
                @Mapping(source = "lesson.id", target = "id"),
                @Mapping(source = "lesson.latestSectionId", target = "latestSectionId")
        })
        LearnLessonRecordDto convertFrom(LearningLessonRecordAggregate source);

        @Mapping(source = "id", target = "sectionId")
        LearnRecordDto toDto(LearnRecordEntity entity);
    }
}
