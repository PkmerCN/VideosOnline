package org.hzz.design.pattern.strategy;

import org.hzz.springboot.starter.base.ApplicationContextHolder;
import org.hzz.springboot.starter.base.init.ApplicationInitializingEvent;
import org.springframework.context.ApplicationListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public class StrategyChoose implements ApplicationListener<ApplicationInitializingEvent> {
    private final Map<String,AbstractExecuteStrategy> abstractExecuteStrategyMap = new HashMap<>();

    public AbstractExecuteStrategy choose(String mark){
        return Optional.ofNullable(abstractExecuteStrategyMap.get(mark))
                .orElseThrow(() -> new RuntimeException(String.format("[%s] 策略未定义", mark)));
    }

    public <T> void chooseAndExecute(String mark,T command){
        AbstractExecuteStrategy strategy = choose(mark);
        strategy.execute(command);
    }

    public <T,R> R chooseAndExecuteWithResp(String mark,T command){
        AbstractExecuteStrategy strategy = choose(mark);
        return (R)strategy.executeWithResp(command);
    }


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
