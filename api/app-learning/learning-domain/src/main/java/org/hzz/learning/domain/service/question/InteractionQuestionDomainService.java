package org.hzz.learning.domain.service.question;

import org.hzz.core.page.PageResponse;
import org.hzz.ddd.core.domain.shared.service.DomainService;
import org.hzz.learning.domain.aggregate.question.QuestionQueryAggregate;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;

/**
 * 问答系统领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
public interface InteractionQuestionDomainService extends DomainService {

    /**
     * 新增问题
     * @param entity 问题
     */
    default void newQuestion(InteractionQuestionEntity entity){
        throw new UnsupportedOperationException("未实现newQuestion");
    }

    /**
     * 修改问题
     * @param newEntity 问题新数据
     */
    default void modifyQuestion(InteractionQuestionEntity newEntity){
        throw new UnsupportedOperationException("modifyQuestion");
    }

    /**
     * 根据id获取问题
     * @param id 问题id
     * @return entity
     */
    default InteractionQuestionEntity getEntityById(Long id){
        throw new UnsupportedOperationException("未实现getEntityById");
    }

    /**
     * 该问题下有新的回答，处理该问题下最新回答id和总回答次数
     * @param questionId 问题id
     * @param answerId 回答id
     */
    void addAnswer(Long questionId,Long answerId);

    /**
     * 删除问题
     * @param id 问题id
     */
    default void deleteQuestionById(Long id){
        throw new UnsupportedOperationException("未实现deleteQuestionById");
    }


    /**
     * 分页查询问题
     * @param aggregate 聚合根
     * @return 分页
     */
    default PageResponse<InteractionQuestionEntity> pageQueryEntity(QuestionQueryAggregate aggregate){
        throw new UnsupportedOperationException("未实现pageQueryEntity");
    }

}
