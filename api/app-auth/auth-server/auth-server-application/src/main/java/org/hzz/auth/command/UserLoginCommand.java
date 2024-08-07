package org.hzz.auth.command;

import lombok.Data;
import lombok.Value;
import org.hzz.ddd.core.domain.shared.command.Command;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
@Data
@Value(staticConstructor = "commandOf")
public class UserLoginCommand implements Command {
    String email;
    String password;
}
