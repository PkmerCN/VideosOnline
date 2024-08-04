package org.hzz.points.infrastructure.dao.plugin;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.hzz.common.util.ReflectionUtils;
import org.hzz.points.infrastructure.dao.plugin.support.PointsBoardTableIndexSupport;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.pointsBoard;

/**
 * 动态修改积分表名
 * 因为我们做了积分赛季的一个水平拆分
 * todo 可以考虑使用dynamic sql的方案
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

    private final String logicTableName = pointsBoard.tableNameAtRuntime();


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Integer tableIndex = PointsBoardTableIndexSupport.getTableIndex();
        if(tableIndex == null){
            return invocation.proceed();
        }
        // 处理表名的拼接
        try{
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            // 获取 BoundSql 对象
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();

            if(isPointsBoardTable(sql)){
                String modifiedSql = processTableName(sql,tableIndex);
                // 通过反射设置修改后的 SQL
                ReflectionUtils.setField(boundSql, "sql", modifiedSql);
            }
            return invocation.proceed();
        }finally {
            // 防止threadLocal内存泄漏直接在这里处理
            PointsBoardTableIndexSupport.clear();
        }
    }

    private boolean isPointsBoardTable(String sql){
        return sql != null && sql.toLowerCase().contains(logicTableName.toLowerCase());
    }

    private String processTableName(String sql,Integer index){
        log.info("sql >>> {}",sql);
        // 定义表名的正则表达式，不区分大小写
        Pattern pattern = Pattern.compile(logicTableName,Pattern.CASE_INSENSITIVE);
        // 替换表名
        Matcher matcher = pattern.matcher(logicTableName + "_" + index);
        String realSql = matcher.replaceAll(sql);
        log.info("修改后的sql >>> {}",realSql);
        return realSql;
    }



    public static void main(String[] args) {
        // points_board
        String tablename = pointsBoard.tableNameAtRuntime();
        System.out.println(tablename);
        // 定义表名的正则表达式，不区分大小写
        Pattern pattern = Pattern.compile(tablename,Pattern.CASE_INSENSITIVE);

        // 替换表名
        Matcher matcher = pattern.matcher(tablename + "_" + 1);
        String orginalLowCaseSql = "select * from points_board";
        String orginalCapitalSql = "select * from POINTS_BOARD";

        // 测试小写
        System.out.println(matcher.replaceAll(orginalLowCaseSql));
        // 测试小写
        System.out.println(matcher.replaceAll(orginalCapitalSql));
    }
}
