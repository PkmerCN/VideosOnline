package org.hzz.points.domain.service.points.strategy;

import java.util.function.Supplier;

/**
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
