package org.hzz.learning.application.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.design.pattern.strategy.StrategyChoose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 统一注册CommandWithMark
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Service
@Slf4j
public class AppHandleCmdService {

    @Setter(onMethod_ = @Autowired)
    private StrategyChoose strategyChoose;

    /**
     * 统一处理command
     * @param command
     */
    public void handleCommand(CommandWithMark command){
        log.info("执行：{}",command.getClass().getSimpleName());
        strategyChoose.chooseAndExecute(command.mark(),
                command);
    }

    /**
     * 统一处理处理Command，有返回值
     * @param command
     * @return
     * @param <R> 返回结果
     */
    public <R> R handleComandWithResult(CommandWithMark command){
        log.info("执行：{}",command.getClass().getSimpleName());
        return strategyChoose.<CommandWithMark,R>chooseAndExecuteWithResp(command.mark(),
                command);
    }
}
