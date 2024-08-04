package org.hzz.points.infrastructure.dao.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.hzz.points.infrastructure.dao.plugin.support.PointsBoardTableIndexSupport;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * 动态修改积分表名
 * 因为我们做了积分赛季的一个水平拆分
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Component
@Slf4j
@Intercepts(
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
)
public class ChangePointsBoardTableNamePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Integer tableIndex = PointsBoardTableIndexSupport.getTableIndex();
        if(tableIndex == null){
            return invocation.proceed();
        }
        // 处理表名的拼接
        try{
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            String sql = statementHandler.getBoundSql().getSql();
            log.info("sql >>> {}",sql);
            return invocation.proceed();
        }finally {
            // 防止threadLocal内存泄漏直接在这里处理
            PointsBoardTableIndexSupport.clear();
        }
    }
}
