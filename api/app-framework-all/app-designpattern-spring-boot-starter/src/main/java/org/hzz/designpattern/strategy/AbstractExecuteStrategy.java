package org.hzz.designpattern.strategy;

/**
 * 策略执行抽象
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
    default void execute(T t){}


    /**
     * 执行策略，带返回值
     * @param t
     * @return
     */
    default R executeWithResp(T t){
        return null;
    }

}
