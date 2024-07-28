package org.hzz.points.domain.service.impl;

import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.repository.SignRecordRedisRepository;
import org.hzz.points.domain.service.SignDomainService;
import org.hzz.points.types.resp.SignResultVo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        // todo 连续签到的天数，奖励的积分
        int signDays = countSignDaysForToday(userId);

        SignResultVo vo = new SignResultVo();
        Integer rewardPoints = switch (signDays){
            case 7 -> 10;
            case 14 -> 20;
            case 28 -> 40;
            default -> 0;
        };

        vo.setSignDays(signDays);
        vo.setRewardPoints(rewardPoints);
        return vo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSignDays(Long userId, int endDay) {;
        return repository.count(userId,0,endDay);
    }

    /**
     * 以今天开始往之前的天数开始计算用户本月连续签到的天数
     * @param userId 用户id
     * @return 本月最新连续签到天数
     */
    @Override
    public int countSignDaysForToday(Long userId) {
        int endDay = LocalDateTime.now().getDayOfMonth();
        return repository.count(userId,0,endDay);
    }
}
