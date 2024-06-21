package org.hzz.designpattern.strategy;

import org.hzz.springboot.starter.base.ApplicationContextHolder;
import org.hzz.springboot.starter.base.init.ApplicationInitializingEvent;
import org.springframework.context.ApplicationListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public class StrategyChoose implements ApplicationListener<ApplicationInitializingEvent> {
    private final Map<String,AbstractExecuteStrategy> abstractExecuteStrategyMap = new HashMap<>();

    @Override
    public void onApplicationEvent(ApplicationInitializingEvent event) {
        Map<String, AbstractExecuteStrategy> beansOfType = ApplicationContextHolder.getBeansOfType(AbstractExecuteStrategy.class);
        beansOfType.forEach((beanName,bean) -> {
            AbstractExecuteStrategy stragegy = abstractExecuteStrategyMap.get(bean.mark());
            if(stragegy != null){
                throw new RuntimeException(String.format("[%s] Duplicate execution policy", bean.mark()));
            }else{
                abstractExecuteStrategyMap.put(bean.mark(),bean);
            }
        });
    }
}
