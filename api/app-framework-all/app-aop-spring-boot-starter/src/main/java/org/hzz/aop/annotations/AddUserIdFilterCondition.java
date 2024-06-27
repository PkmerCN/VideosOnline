package org.hzz.aop.annotations;

import java.lang.annotation.*;

/**
 * 分页查询的时候，自动添加user_id过滤条件
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddUserIdFilterCondition {
}
