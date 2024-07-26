package org.hzz.learning.application.command.question;

import lombok.Data;
import org.hzz.core.page.query.FilterCondition;
import org.hzz.core.page.query.PageQuery;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.QuestionPageQueryCommandHandler;
import org.hzz.learning.types.req.question.QuestionPageQuery;
import org.hzz.security.context.AppContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题分页查询
 * {@link QuestionPageQueryCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
public class QuestionPageQueryCommand implements CommandWithMark {
    public static final String MARK = QuestionPageQueryCommand.class.getName();
    PageQuery pageQuery;

    public static QuestionPageQueryCommand commandOf(QuestionPageQuery questionPageQuery){
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPageSize(questionPageQuery.getPageSize());
        pageQuery.setPageNo(questionPageQuery.getPageNo());
        List<FilterCondition> filters = new ArrayList<>();

        // 添加过滤条件
        if(questionPageQuery.getOnlyMine()){
            // 只查看自己
            filters.add(new FilterCondition("user_id","=", AppContextHolder.userContextHolder.getUser().getId()));
        }

        if(questionPageQuery.getCourseId() != null){
            filters.add(new FilterCondition("course_id","=",questionPageQuery.getCourseId()));
        }

        if(questionPageQuery.getSectionId() != null){
            filters.add(new FilterCondition("section_id","=",questionPageQuery.getSectionId()));
        }

        // 处理隐藏的问题
        filters.add(new FilterCondition("hidden","=",false));
        pageQuery.setFilters(filters);
       return new QuestionPageQueryCommand(pageQuery);
    }

    private QuestionPageQueryCommand(PageQuery pageQuery){
        this.pageQuery = pageQuery;
    }

    @Override
    public String mark() {
        return MARK;
    }


}
