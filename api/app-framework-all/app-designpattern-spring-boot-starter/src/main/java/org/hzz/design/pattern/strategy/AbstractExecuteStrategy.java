package org.hzz.design.pattern.strategy;

/**
 * 策略执行抽象
 * @param <T>  Command
 * @param <R>  返回结果
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
public interface AbstractExecuteStrategy<T,R> {
    String mark();

    /**
     * 执行策略
     * @param t
     */
    default void execute(T t){
        throw new UnsupportedOperationException("未实现");
    }


    /**
     * 执行策略，带返回值
     * @param t
     * @return
     */
    default R executeWithResp(T t){
        throw new UnsupportedOperationException("未实现");
    }

}
