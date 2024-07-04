package org.hzz.aop.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 分页查询的时候，自动添加user_id过滤条件
 * {@link org.hzz.aop.aspectj.AddUserIdFilterConditionAspect}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddUserIdFilterCondition {
    /**
     * 对应数据库中user_id，其他的可能命名不同如id.
     * @return 数据库中的字段名
     */
    String value() default "user_id";
}
