package org.hzz.learning.domain.service.question;

import org.hzz.ddd.core.domain.shared.service.DomainService;
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

}
