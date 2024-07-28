package org.hzz.points.domain.service.impl;

import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.repository.SignRecordRedisRepository;
import org.hzz.points.domain.service.SignDomainService;
import org.hzz.points.types.resp.SignResultVo;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Service
public class SignDomainServiceImpl
        extends BaseDomainService<SignRecordRedisRepository>
        implements SignDomainService {


    /**
     * {@inheritDoc}
     */
    @Override
    public SignResultVo addSignRecord(Long userId) {
        Boolean result = repository.addSignRecord(userId);;
        if(Boolean.TRUE.equals(result)){
            // 重复签到
            throw new BadRequestException(AppStatusImpl.REPEAT_SIGN_OPERATION);
        }

        return null;
    }
}
