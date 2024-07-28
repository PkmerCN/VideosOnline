package org.hzz.points.domain.service.impl;

import jakarta.annotation.PostConstruct;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.repository.SignRecordRedisRepository;
import org.hzz.points.domain.service.SignDomainService;
import org.hzz.points.domain.valueobject.PointStrategyEnum;
import org.hzz.points.types.resp.SignResultVo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Service
public class SignDomainServiceImpl
        extends BaseDomainService<SignRecordRedisRepository>
        implements SignDomainService {

    private Map<Integer, Supplier<Integer>> pointsRewardStrategy;
    private final Supplier<Integer> defaultPointRewardStrategy = () -> 0;

    @PostConstruct
    public void init() {
        pointsRewardStrategy = new HashMap<>();


    }


    /**
     * {@inheritDoc}
     */
    @Override
    public SignResultVo addSignRecord(Long userId) {
        SignResultVo vo = new SignResultVo();

        Boolean result = repository.addSignRecord(userId);
        ;
        if (Boolean.TRUE.equals(result)) {
            // 重复签到
            throw new BadRequestException(AppStatusImpl.REPEAT_SIGN_OPERATION);
        }


        // 连续签到的天数，奖励的积分
        int signDays = countSignDaysForToday(userId);
        Integer rewardPoints = calcRewardPoints(signDays);

        vo.setSignDays(signDays);
        vo.setRewardPoints(rewardPoints);
        return vo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int countSignDays(Long userId, int endDay) {
        return repository.count(userId, 0, endDay);
    }

    /**
     * 以今天开始往之前的天数开始计算用户本月连续签到的天数
     *
     * @param userId 用户id
     * @return 本月最新连续签到天数
     */
    @Override
    public int countSignDaysForToday(Long userId) {
        int endDay = LocalDateTime.now().getDayOfMonth();
        return repository.count(userId, 0, endDay);
    }

    /**
     * 计算奖励积分
     *
     * @param signDays 连续签到天数
     * @return 积分
     */
    private Integer calcRewardPoints(Integer signDays) {

        /**
         * 原始方案
         */
//        Integer rewardPoints = switch (signDays) {
//            case 7 -> 10;
//            case 14 -> 20;
//            case 28 -> 40;
//            default -> 0;
//        };

        /**
         * 枚举方案
         */
        Integer rewardPoints = PointStrategyEnum.fromSignDays(signDays).get();

        return rewardPoints;
    }
}
