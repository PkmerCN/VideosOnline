package org.hzz.points.domain.service.sign.impl;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.repository.SignRecordRedisRepository;
import org.hzz.points.domain.service.points.strategy.PointsStrategy;
import org.hzz.points.domain.service.sign.SignDomainService;
import org.hzz.points.types.dto.PointsRewardDto;
import org.hzz.points.types.enums.PointsType;
import org.hzz.points.types.resp.SignResultVo;
import org.hzz.rabbitmq.constants.rabbitmq.video.PointsMqConstants;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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

    @Setter(onMethod_ = @Autowired)
    private RabbitMQHelper rabbitMQHelper;
    /**
     * 默认积分策略
     */
    private final Supplier<Integer> defaultPointsSupplier = new PointsStrategy.DefaultPointsStrategy().pointsSupplier();

    /**
     * 积分策略
     */
    private final Map<Integer, Supplier<Integer>> pointsRewardStrategy;

    public SignDomainServiceImpl(List<PointsStrategy> list){
        pointsRewardStrategy = new HashMap<>();
        if(CollUtil.isNotEmpty(list)){
            logger.info("检测到{}个积分策略PointsStrategy",list.size());
            for (PointsStrategy s: list){
                pointsRewardStrategy.put(s.signDays(),s.pointsSupplier());
            }
        }
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

        // 发送积分消息
        rabbitMQHelper.sendAsync(
                PointsMqConstants.Exchange.POINTS_EXCHANGE,
                PointsMqConstants.Key.SIGN_IN,
                PointsRewardDto.of(userId,rewardPoints + vo.getSignPoints(),
                        PointsType.SIGN_EVERYDAY,LocalDateTime.now())
        );

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
     * {@inheritDoc}
     * @param userId 用户id
     * @return 数组，值为0和1,0 代表未签到，1 代表签到
     */
    @Override
    public int[] querySignRecordsForToday(Long userId) {
        final int start = 0;
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        logger.info("今天是这个月的第{}天",dayOfMonth);
        return repository.querySignRecords(userId,start,dayOfMonth);
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
        //Integer rewardPoints = PointStrategyEnum.fromSignDays(signDays).get();

        /**
         * map方案
         */
        Supplier<Integer> pointsSupplier = pointsRewardStrategy
                .getOrDefault(signDays, defaultPointsSupplier);
        return pointsSupplier.get();
    }

}
