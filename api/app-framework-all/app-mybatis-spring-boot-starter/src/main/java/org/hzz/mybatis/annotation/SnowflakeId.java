package org.hzz.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于mybatis标注在po属性上
 * 使用插件{@link org.hzz.mybatis.core.SnowflakeIdPlugin}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SnowflakeId {
}
