package org.hzz.learning.domain.repository.question;

import org.hzz.core.page.PageResponse;
import org.hzz.learning.domain.aggregate.question.QuestionQueryAggregate;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
public interface InteractionQuestionRepository {

    /**
     * 查询问题
     * @param id 问题id
     * @return 问题数据
     */
    default InteractionQuestionEntity selectById(Long id){
        throw new UnsupportedOperationException("未实现");
    }

    /**
     * 删除问题
     * @param id 问题id
     * @return 删除数目
     */
    default int deleteById(Long id){
        throw new UnsupportedOperationException("deleteById未实现");
    }

    /**
     * 选择性插入数据
     * @param entity 问题
     * @return 插入记录数
     */
    default int insertSelective(InteractionQuestionEntity entity){
        return 0;
    }

    /**
     * 选择性更新数据
     * @param entity 问题数据
     */
    default int updateSelective(InteractionQuestionEntity entity){
        return 0;
    }

    /**
     * 增加问题的回答次数
     * @param questionId 问题id
     * @param answerId 回答id
     */
    int incrAnswerTimes(Long questionId,Long answerId);

    /**
     * 分页查询
     * @param aggregate 聚合根
     * @return 分页
     */
    default PageResponse<InteractionQuestionEntity> pageQuery(QuestionQueryAggregate aggregate){
        throw new UnsupportedOperationException("未实现");
    }
}
