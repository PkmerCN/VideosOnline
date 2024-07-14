package org.hzz.ddd.core.domain.shared.service;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.design.pattern.strategy.StrategyChoose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 使用策略模式统一处理{@link CommandWithMark}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
public abstract class CmdService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

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
     * @param command 命令
     * @return R
     * @param <R> 返回结果
     */
    public <R> R handleComandWithResult(CommandWithMark command){
        log.info("执行：{}",command.getClass().getSimpleName());
        return strategyChoose.<CommandWithMark,R>chooseAndExecuteWithResp(command.mark(),
                command);
    }
}
