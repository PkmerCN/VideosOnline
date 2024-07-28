package org.hzz.points.domain.service.points.strategy;

import org.hzz.points.domain.service.sign.impl.SignDomainServiceImpl;

import java.util.function.Supplier;

/**
 * {@link SignDomainServiceImpl}使用到了这个积分奖励策略
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
public interface PointsStrategy {

    /**
     * 代表的签到天数
     * @return 签到天数
     */
    int signDays();

    Supplier<Integer> pointsSupplier();

    /**
     * 定义一个默认的策略
     */
    public static class DefaultPointsStrategy implements PointsStrategy{

        @Override
        public int signDays() {
            return 0;
        }

        @Override
        public Supplier<Integer> pointsSupplier() {
            return () -> 0;
        }
    }
}
