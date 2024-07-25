package org.hzz.remark.domain.service.impl;

import lombok.Setter;
import org.hzz.core.service.BaseDomainService;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.hzz.remark.domain.repository.LikedRecordRepository;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.hzz.remark.types.BizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Service
public class LikedRecordDomainServiceImpl
        extends BaseDomainService<LikedRecordRepository>
        implements LikedRecordDomainService {

    @Setter(onMethod_ = @Autowired)
    private RabbitMQHelper rabbitMQHelper;

    @Override
    public void like(Long userId, Long bizId, BizType bizType) {

    }

    @Override
    public void cancel(Long userId, Long bizId) {

    }
}
