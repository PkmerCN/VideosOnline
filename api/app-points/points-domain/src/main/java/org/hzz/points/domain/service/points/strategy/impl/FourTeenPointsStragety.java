package org.hzz.points.domain.service.points.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import org.hzz.points.domain.service.points.strategy.PointsStrategy;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * 14天注册积分奖励
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
@Component
@Slf4j
public class FourTeenPointsStragety implements PointsStrategy {
    private final Integer signDays = 14;
    private final Integer points = 20;
    @Override
    public int signDays() {
        return signDays;
    }

    @Override
    public Supplier<Integer> pointsSupplier() {
        log.info("注册{}天，奖励积分{}",signDays,points);
        return () -> points;
    }
}
