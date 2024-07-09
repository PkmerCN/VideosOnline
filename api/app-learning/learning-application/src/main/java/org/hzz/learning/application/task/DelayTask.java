package org.hzz.learning.application.task;

import lombok.Getter;

import java.time.Duration;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟任务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/9
 */
public class DelayTask<D> implements Delayed {
    @Getter
    private final D data;
    private final long deadlineNanos;

    public DelayTask(D data,Duration duration){
        this.data = data;
        this.deadlineNanos = System.nanoTime() + duration.toNanos();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(Math.max(0,deadlineNanos - System.nanoTime()),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long r = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return Long.compare(r, 0);
    }

}
