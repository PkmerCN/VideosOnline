package org.hzz.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hzz.aop.annotations.AddUserIdFilterCondition;
import org.hzz.core.page.query.PageQuery;

/**
 * 自动添加过滤user_id处理
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Aspect
public class AddUserIdFilterConditionAspect {

    @Pointcut("@annotation(addUserIdFilterCondition) && args(pageQuery,..)")
    public void pointcut(AddUserIdFilterCondition addUserIdFilterCondition, PageQuery pageQuery){}

    @Before(value = "pointcut(addUserIdFilterCondition, pageQuery)", argNames = "joinPoint,addUserIdFilterCondition,pageQuery")
    public void beforeMethodWithAddUserIdFilterCondition(JoinPoint joinPoint,
                                                         AddUserIdFilterCondition addUserIdFilterCondition,
                                                         PageQuery pageQuery) {
        System.out.println("Before method: " + joinPoint.getSignature());
        System.out.println("PageQuery: " + pageQuery);
    }
}
