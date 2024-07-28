package org.hzz.points.domain.valueobject;

import org.hzz.points.domain.service.points.strategy.PointsStrategy;

import java.util.function.Supplier;

/**
 * @deprecated 已删除，扩展请参照{@link PointsStrategy}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
public enum PointStrategyEnum implements Supplier<Integer> {
    DEFAULT(0){
        @Override
        public Integer get() {
            return 0;
        }
    },
    SEVEN(7){
        @Override
        public Integer get() {
            return 10;
        }
    },
    FOURTEEN(14){
        @Override
        public Integer get() {
            return 20;
        }
    },
    TWENTY_EIGHT(28){
        @Override
        public Integer get() {
            return 40;
        }
    };
    private final Integer signDays;
    PointStrategyEnum(Integer signDays){
        this.signDays = signDays;
    }

    public static PointStrategyEnum fromSignDays(Integer signDays){
        if(signDays == null){
            return DEFAULT;
        }

        for (PointStrategyEnum p: PointStrategyEnum.values()){
            if(p.signDays.equals(signDays)){
                return p;
            }
        }

        return DEFAULT;
    }
}
