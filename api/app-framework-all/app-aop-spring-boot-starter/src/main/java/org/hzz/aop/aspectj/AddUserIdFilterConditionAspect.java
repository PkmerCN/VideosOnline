package org.hzz.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hzz.aop.annotations.AddUserIdFilterCondition;
import org.hzz.core.page.query.FilterCondition;
import org.hzz.core.page.query.PageQuery;
import org.hzz.security.context.AppContextHolder;

import java.lang.reflect.Method;

/**
 * 自动添加过滤user_id处理
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Aspect
@Slf4j
public class AddUserIdFilterConditionAspect {

    @Pointcut("@annotation(addUserIdFilterCondition) && args(pageQuery,..)")
    public void pointcut(AddUserIdFilterCondition addUserIdFilterCondition, PageQuery pageQuery){}

    @Before(value = "pointcut(addUserIdFilterCondition, pageQuery)", argNames = "joinPoint,addUserIdFilterCondition,pageQuery")
    public void beforeMethodWithAddUserIdFilterCondition(JoinPoint joinPoint,
                                                         AddUserIdFilterCondition addUserIdFilterCondition,
                                                         PageQuery pageQuery) {
        log.info("切面添加用户id过滤条件 Before method: {}" ,joinPoint.getSignature());
        Long id = AppContextHolder.userContextHolder.getUser().getId();
        String columnName = addUserIdFilterCondition.value();

        FilterCondition filterCondition = new FilterCondition();
        filterCondition.setField(columnName);
        filterCondition.setOperator("=");
        filterCondition.setValue(id);
        log.info("添加用户id过滤条件{}",filterCondition.toString());
        pageQuery.getFilters().add(filterCondition);
    }
}
