package org.hzz.learning.application.handler;

import lombok.Setter;
import org.hzz.core.page.PageResponse;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.PageQueryCommand;
import org.hzz.learning.application.converter.LearnLessonDtoConverter;
import org.hzz.learning.application.resp.LearnLessonDto;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.service.LearningLessonPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 处理分页
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Component
public class PageQueryCommandHandler implements CommandHandler, AbstractExecuteStrategy<PageQueryCommand, PageResponse<LearnLessonDto>> {

    @Setter(onMethod_ = @Autowired)
    private LearningLessonPageService lessonPageService;
    @Setter(onMethod_ = @Autowired)
    private LearnLessonDtoConverter converter;

    @Override
    public String mark() {
        return MarkConstants.PAGE_QUERY;
    }

    @Override
    public PageResponse<LearnLessonDto> executeWithResp(PageQueryCommand pageQueryCommand) {
        LearningLessonAggregate aggregate = LearningLessonAggregate.builder()
                .pageQuery(pageQueryCommand.getPageQuery()).build();

        PageResponse<LearningLessonAggregate> result = lessonPageService.pageQueryLesson(aggregate);

        List<LearnLessonDto> learnLessonDtos = converter.mapToDtos(result.getList());

        return PageResponse.<LearnLessonDto>builder()
                .total(result.getTotal())
                .currentPageNo(result.getCurrentPageNo())
                .totalPages(result.getTotalPages())
                .list(learnLessonDtos)
                .build();
    }
}
