package org.hzz.learning.domain.repository.question;

import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
public interface InteractionQuestionRepository {

    /**
     * 选择性插入数据
     * @param entity 问题
     * @return 插入记录数
     */
    default int insertSelective(InteractionQuestionEntity entity){
        return 0;
    }
}
