package org.hzz.ddd.core.domain.shared.command;

/**
 * 做一个兼容，方便应用层直接处理command
 * {@link org.hzz.learning.application.service.AppHandleCmdService}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
public interface CommandWithMark extends Command,Mark{
}